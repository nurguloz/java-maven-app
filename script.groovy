def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t ratalay35/my-repo:jma-3.2 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push ratalay35/my-repo:jma-3.2'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
