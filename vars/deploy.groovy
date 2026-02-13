def call(String containerName, String port, String imageName, String imageTag) {
  echo "Deploying container..."
  sh """
  docker rm -f ${containerName} || true
  docker run -d \
      --name ${containerName} \
      -p ${port}:${port} \
      ${imageName}:${imageTag}
  """
}
