pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Verify Tools') {
            steps {
                sh '''
                java -version
                mvn -version
                docker --version
                '''
            }
        }

        stage('Build JAR') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t moviebooking-backend:latest .'
            }
        }

        stage('Run Container') {
            steps {
                sh '''
                docker stop moviebooking-backend || true
                docker rm moviebooking-backend || true
                docker run -d -p 8080:8080 --name moviebooking-backend moviebooking-backend:latest
                '''
            }
        }
    }
}
