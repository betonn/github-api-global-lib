@Library("beton-shared") _
pipeline{
    agent('any')
    stages{
        stage('Example') {
            steps {
               sh "echo Hello world"
            }
        }
    }
}
