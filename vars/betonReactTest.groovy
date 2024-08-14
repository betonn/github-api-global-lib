def call(Map params) {
    pipeline{
        agent{ label 'test1node'}
        stages{
      // stage('Example') {
      //     steps {
      //     sh "echo Hello world"
      //     docker.build("test")
      //     }
      // }
      stage('Build') {
        steps {
          script {
                dockerImage = docker.build("reacttestapp"),

          }
        }
      }

        }
    }

