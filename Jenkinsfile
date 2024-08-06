pipeline {
    environment {
        AWS_ACCOUNT_ID = '099199746132'
        AWS_DEFAULT_REGION = 'eu-west-1'
        ECR_REPOSITORY = 'java-app-repo-for-testing'
    }
    agent any

    stages {
        stage('Checkout') {
            steps {
               
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Building the jar file"
                sh 'mvn clean package'  // Build the Spring Boot application using Maven
            }
        }

        stage('Build and Tag Docker Image') {
            steps {
                script {
                     
                    IMAGE_URI = "${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com/${ECR_REPOSITORY}:latest"
                                
                    
                    sh "docker build -t ${IMAGE_URI} ."
                }
            }
        }

        stage('Push to ECR') {
            steps {
                script {
                    
                    sh "aws ecr get-login-password --region ${AWS_DEFAULT_REGION} | docker login --username AWS --password-stdin ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com"

                    
                    sh "docker push ${IMAGE_URI}"

                    
                }
            }
        }

       
    }

    post {
        always {
    
            echo 'Build completed'
        }
    }
}
