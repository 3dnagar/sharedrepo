def call() {

    sh 'mvn clean compile'
    sh 'mvn test'
    sh 'mvn package'

    sh '''
      WAR=$(ls target/*.war | head -n 1)
      cp "$WAR" "target/Spring3HibernateApp-${BUILD_NUMBER}.war"
    '''

    archiveArtifacts artifacts: '''
      target/Spring3HibernateApp-*.war,
      dependency-check-report.html
    ''',
    fingerprint: true
}
