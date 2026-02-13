def call(String imageName, String imageTag) {
  echo "Building Docker image..."
  sh "docker build -t ${imageName}:${imageTag} ."
}
