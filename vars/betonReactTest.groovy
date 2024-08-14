// def call(Map params) {
//     pipeline{
//         agent('any')
//         stages{
//             stage('Example') {
//                  agent {
//                 docker {
//                     image 'docker:dind'
//                     reuseNode true
//                 }
//             }
//                 steps {
//                 sh "echo Hello world"
//                 docker.build("test")
//                 }
//             }
//         }
//     }
// }



def call(Map params) {
pipeline {
    agent {
                docker {
                    image 'dind:stable'
                    // Run the container on the node specified at the
                    // top-level of the Pipeline, in the same workspace,
                    // rather than on a new node entirely:
                    reuseNode true
                }
            }
    stages {
        stage('Build') {
            
            steps {
                sh 'docker --version'
            }
        }
    }
}
}
