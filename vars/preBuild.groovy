def call(String repoUrl = null, String branch = 'master') {

    if (repoUrl) {
        echo "Checking out source from ${repoUrl} (${branch})"
        git branch: branch, url: repoUrl
    }

    sh 'gitleaks detect --source . --no-git || true'
    sh 'dependency-check.sh --scan . || true'
}
