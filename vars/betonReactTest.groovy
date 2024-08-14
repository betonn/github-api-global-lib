def call(Map params) {
    pipeline{
        agent('any')
        stages{
            stage('Example') {
                 agent {
                docker {
                    image 'docker:dind'
                    reuseNode true
                }
            }
                steps {
                sh "echo Hello world"
                docker.build("test")
                }
            }
        }
    }
}
