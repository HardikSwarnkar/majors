pipeline {
    agent any

    stages {
      
        stage('Test') {
            steps {
                // Execute tests
                bat "mvn clean test"
            }
            post {            	
                // If Maven was able to run the tests, record the test results and archive the HTML report
                success {
                   publishHTML([
                       allowMissing: false,
                       alwaysLinkToLastBuild: false,
                       keepAll: false,
                       reportDir: 'target/surefire-reports/',
                       reportFiles: 'emailable-report.html',
                       reportName: 'HTML Report',
                       reportTitles: '',
                       useWrapperFileDirectly: true])
                }
            }
        }
        stage('Deployment') {
            steps {
                // Example deployment step - Replace with actual deployment script
                echo 'Deploying the application'
                // Report deployment status
                catchError {
                    bat 'deploy-script.bat' // Example deployment script for Windows
                    echo 'Deployment successful'
                }
            }
        }
        stage('Clean Up') {
            steps {
                // Clean up temporary files or resources
                bat 'cleanup-script.bat' // Example cleanup script for Windows
                echo 'Clean up completed'
            }
        }
    }
}
