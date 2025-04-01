def call(String dockerHubUsername, String imageName) {
    // Build the Docker image
    sh "docker build --build-arg REACT_APP_RAPID_API_KEY=89ee7a5929msh2ce87d27bbfa7d5p176d9ajsn124e054afcf0 -t ${imageName} ."
     // Tag the Docker image
    sh "docker tag ${imageName} ${dockerHubUsername}/${imageName}:latest"
    // Push the Docker image
    withDockerRegistry([url: 'https://index.docker.io/v1/', credentialsId: 'docker-creds']) {
        sh "docker push ${dockerHubUsername}/${imageName}:latest"
    }
}