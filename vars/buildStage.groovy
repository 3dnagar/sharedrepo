def call() {

    stage('Maven Compile') {
        sh 'mvn clean compile'
    }

    stage('Maven Test') {
        sh 'mvn test'
    }

    stage('Maven Package') {
        sh 'mvn package'
    }

    stage('Tag WAR') {
        sh '''
          WAR=$(ls target/*.war | head -n 1)
          cp "$WAR" "target/Spring3HibernateApp-${BUILD_NUMBER}.war"
        '''
    }

    stage('Archive Artifacts') {
        archiveArtifacts artifacts: '''
          target/Spring3HibernateApp-*.war,
          gitleaks-report.json,
          owasp-report/**
        ''',
        fingerprint: true
    }
}
