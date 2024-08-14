def call(Map params) {
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
}
