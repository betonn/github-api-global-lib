def call(Map params) {
    pipeline{
        agent('any')
        stages{
            stage('Example') {
                steps {
                sh "echo Hello world"
                    // install docke r
                    sh "sudo apt-get update"
                    sh "sudo apt-get install apt-transport-https ca-certificates curl software-properties-common"
                    sh "curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -"
                    sh "sudo add-apt-repository 'deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable'"
                    sh "sudo apt-get update"
                    sh "sudo apt-get install docker-ce"
                    sh "sudo systemctl status docker"
                    sh "sudo usermod -aG docker ${USER}"
                    sh "docker --version"
                    // build docker image
                    sh "docker build -t myapp ."
                }
            }
        }
    }
}
