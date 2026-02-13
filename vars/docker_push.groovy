def call(String imageName, String imageTag, String dockerhubuser) {
    withCredentials([usernamePassword(
        credentialsId: "dockerHubCred",
        passwordVariable: "dockerHubPass",
        usernameVariable: "dockerHubUser"
    )]) {
        sh """
        docker login -u ${dockerHubUser} -p ${dockerHubPass}
        docker tag ${imageName}:${imageTag} ${dockerhubuser}/${imageName}:${imageTag}
        docker push ${dockerhubuser}/${imageName}:${imageTag}
        """
    }
}
