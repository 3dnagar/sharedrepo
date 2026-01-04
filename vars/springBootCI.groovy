def call(String email, String repoUrl, String branch = 'master') {

    preBuild(repoUrl, branch)
    buildStage()
    postBuild(email)
}
