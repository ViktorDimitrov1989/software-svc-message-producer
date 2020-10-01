pipeline {
    agent any
    stages {
        stage("Compile") {
             steps {
                sh "./gradlew compileJava"
             }
        }
        stage("Unit test") {
             steps {
                sh "./gradlew test"
             }
        }
        stage("Package") {
            steps {
                sh "./gradlew build"
            }
        }
        stage("Docker build") {
            steps {
                sh "docker build -t software-svc-message-producer ."
            }
        }
        stage("Docker push") {
            steps {
                sh "docker push localhost:5000/software-svc-message-producer:${BUILD_NUMBER}"
            }
        }
    }
    post {
        always {
            echo 'I will always say Hello again!'
        }
    }
}