pipeline {
    agent any

    environment {
        IMAGE = "arvik786/library:${BUILD_NUMBER}"
    }

    stages {

        stage('Clone') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/vikasambe786/library.git'
            }
        }

        stage('Build Java') {
            steps {
                sh 'javac -d . src/library/*.java'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t $IMAGE .'
            }
        }

        stage('Docker Login') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'docker-creds',
                    usernameVariable: 'USER',
                    passwordVariable: 'PASS')]) {

                    sh 'echo $PASS | docker login -u $USER --password-stdin'
                }
            }
        }

        stage('Docker Push') {
            steps {
                sh 'docker push $IMAGE'
            }
        }

        stage('Update K8s Image') {
            steps {
                sh """
                kubectl set image deployment/library \
                library-container=$IMAGE
                """
            }
        }
    }
}