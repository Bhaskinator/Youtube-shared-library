def call() {
    sh 'trivy image bhaskinator/youtube:latest > trivyimage.txt'
}