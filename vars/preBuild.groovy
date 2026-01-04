def call(String repoUrl, String branch = 'master') {

    git branch: branch,
        url: repoUrl

    sh 'gitleaks detect --source . --no-git || true'
    sh 'dependency-check.sh --scan . || true'
}
