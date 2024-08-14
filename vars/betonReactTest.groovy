def call(Map params) {
    pipeline {
        agent { label 'test1node' }
        stages {
            stage('Build') {
                steps {
                    script {
                        def dockerImage = docker.build("react_test_app", ".")
                    }
                }
            }
        }
    }
}
