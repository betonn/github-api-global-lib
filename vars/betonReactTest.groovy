def call(Map params) {
    pipeline {
        agent { label 'test1node' }
        stages {
            stage('Build') {
                steps {
                    script {
                        dockerImage = docker.build("reacttestapp")
                    }
                }
            }
        }
    }
}
