pipeline {
    agent any

    environment {
        PATH = "${env.MAVEN_HOME}\\bin;${env.PATH}"
    }

    stages {
        stage('Build') {
            steps {
                // Use Maven to build the application
                bat '"%MAVEN_HOME%\\bin\\mvn" clean package'
            }
        }
        stage('Test') {
            steps {
                // Execute tests
                bat '"%MAVEN_HOME%\\bin\\mvn" clean test'
            }
            post {            	
                // If Maven was able to run the tests, record the test results and archive the HTML report
                success {
                   junit '**/target/surefire-reports/*.xml' // Record test results
                   publishHTML([ // Archive HTML report
                       allowMissing: false,
                       alwaysLinkToLastBuild: false,
                       keepAll: false,
                       reportDir: 'target/surefire-reports/',
                       reportFiles: 'emailable-report.html',
                       reportName: 'HTML Report',
                       reportTitles: '',
                       useWrapperFileDirectly: true
                   ])
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
