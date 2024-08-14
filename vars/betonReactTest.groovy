def call(Map params) {
    pipeline {
        agent { label 'test1node' }
        stages {
            stage('Build') {
                steps {
                    script {
                        def dockerImage = docker.build('react_test_app', '.')
                        docker.renameImage(dockerImage.id, 'betonnecmi/react_test_app:latest')
                        docker.withRegistry('https://registry.hub.docker.com') {
                            dockerImage.push('latest')
                        }
                    }
                }
            }
        }
    }
}
