node{
    stage (' Cloning the project from Git') {
        git branch: 'main',
	credentialsId: '7e3f1e42f6b3eb0cb6f7c8cfbfdf37498b3d5aa0',
        url: 'https://github.com/juancondorijara/Trabajo3.git'
    }
    stage('SonarQube analysis'){
        def scannerHome = tool name: 'sonarqubetest', type: 'hudson.plugins.sonar.SonarRunnerInstallation';
        withSonarQubeEnv('sonarqubetest'){
	    sh "${scannerHome}/bin/sonar-scanner -D sonar.projectKey=sonarqube-scanner -D sonar.host.url=http://localhost:9000"
        }
    }
}
