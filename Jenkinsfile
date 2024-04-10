pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Use Maven to build the application
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                // Execute tests
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                // Print a message indicating deployment
                echo 'Deploying the application'
            }
        }
        stage('Cleanup') {
            steps {
                // Clean up temporary files/resources
                sh 'echo "Cleaning up"'
            }
        }
    }
}
