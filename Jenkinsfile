node{
    stage (' Cloning the project from Git') {
        git branch: 'main',
	credentialsId: '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',
        url: 'https://github.com/juancondorijara/Trabajo3.git'
    }
    stage('SonarQube analysis'){
        def scannerHome = tool name: 'sonarqube-scanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation';
        withSonarQubeEnv('sonarqube-scanner'){
	    sh "${scannerHome}/bin/sonar-scanner -D sonar.projectKey=sonarqube-scanner -D sonar.host.url=http://localhost:9000"
        }
    }
}
