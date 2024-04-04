pipeline {
    environment {
        AWS_ACCOUNT_ID = '099199746132'
        AWS_DEFAULT_REGION = 'eu-west-1'
        ECR_REPOSITORY = 'the-repository-for-demo-java-app'
        ECS_CLUSTER_NAME = 'the-Demo-Java-App-Cluster'
        ECS_SERVICE_NAME = 'the-Demo-Java-App-Service'
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

                    
                    sh "aws ecs update-service --cluster ${ECS_CLUSTER_NAME} --service ${ECS_SERVICE_NAME} --force-new-deployment --region ${AWS_DEFAULT_REGION}"
                }
            }
        }

        // Include additional stages as needed
        // Include additional stages as needed
    }

    post {
        always {
    
            echo 'Build completed'
        }
    }
}