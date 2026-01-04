def call() {

    stage('GitLeaks Scan') {
        sh '''
          gitleaks detect \
          --source . \
          --report-format json \
          --report-path gitleaks-report.json \
          --no-git || true
        '''
    }

    stage('OWASP Dependency Check') {
        sh '''
          dependency-check.sh \
          --scan . \
          --format HTML \
          --out owasp-report || true
        '''
    }
}
