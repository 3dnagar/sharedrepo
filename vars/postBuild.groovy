def call(String email) {

    stage('Post Build Actions') {

        def result = currentBuild.result ?: 'SUCCESS'
        result = result.toLowerCase()

        emailext(
            subject: "${currentBuild.result}: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
            body: libraryResource("email/${result}.txt"),
            to: email
        )
    }
}
