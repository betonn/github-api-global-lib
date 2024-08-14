def call(Map params) {
    pipeline {
        agent { label 'test1node' }
        stages {
            stage('Build') {
                steps {
                    script {
                        def dockerImage = docker.build('betonnecmi/react_test_app:latest', '.')
                        docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {
                            dockerImage.push('latest')
                        }
                    }
                }
            }
        }
    }
}
