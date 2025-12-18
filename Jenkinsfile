pipeline {
    agent any

    tools {
        maven 'Maven_3'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/LasyaMoravineni/moviebooking-backend.git'
            }
        }

        stage('Build JAR') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        
        stage('Check Docker') {
		    steps {
		        sh 'docker --version'
		    }
		}


        stage('Build Docker Image') {
            steps {
                sh 'docker build -t moviebooking-backend .'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh '''
                docker stop moviebooking-backend || true
                docker rm moviebooking-backend || true
                docker run -d -p 8080:8080 --name moviebooking-backend moviebooking-backend
                '''
            }
        }
    }
}
