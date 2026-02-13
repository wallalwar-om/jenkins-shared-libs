def call(String imageName, String imageTag) {
  withCredentials([usernamePassword(
            credentialsId: "dockerHubCred",
            passwordVariable: "dockerHubPass",
            usernameVariable: "dockerHubUser"
    )]) {
        sh """
        docker login -u ${dockerHubUser} -p ${dockerHubPass}
        docker tag ${imageName}:latest ${dockerHubUser}/${imageName}:latest
        docker push ${dockerHubUser}/${imageName}:${ImageTag}
        """
    }
}
