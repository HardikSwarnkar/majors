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
                // Execute demo test cases
                sh 'mvn test'
            }
            post {
                // Fail the pipeline if any of the tests fail
                failure {
                    echo 'Tests failed. Failing the pipeline.'
                    currentBuild.result = 'FAILED'
                }
            }
        }
        stage('Deployment') {
            steps {
                // Example deployment step - Replace with actual deployment script
                echo 'Deploying the application'
                // Report deployment status
                catchError {
                    sh 'deploy-script.sh' // Example deployment script
                    echo 'Deployment successful'
                }
            }
        }
        stage('Clean Up') {
            steps {
                // Clean up temporary files or resources
                sh 'cleanup-script.sh' // Example cleanup script
                echo 'Clean up completed'
            }
        }
    }

    post {
        // Notify on pipeline failure
        failure {
            echo 'Pipeline failed. Notify the team.'
            // Example of sending a notification email
            emailext (
                subject: "Pipeline Failed: ${currentBuild.fullDisplayName}",
                body: "The pipeline ${currentBuild.fullDisplayName} has failed. Please check Jenkins for details.",
                to: "team@example.com"
            )
        }
    }
}
