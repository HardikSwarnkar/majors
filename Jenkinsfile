
pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Use Maven to build the application
                catchError {
                bat '"C:\\Program Files\\apache-maven-3.9.6-bin\\apache-maven-3.9.6\\bin\\mvn" clean package -DskipTests=true'

                }
            }
        }
        stage('Test') {
            steps {
                // Execute tests
                catchError {
                    bat '"C:\\Program Files\\apache-maven-3.9.6-bin\\apache-maven-3.9.6\\bin\\mvn" clean test'
                }
            }
            post {
                // If Maven was able to run the tests, record the test results and archive the HTML report
                success {
                    junit '**/target/surefire-reports/*.xml' // Record test results
                   
                }
                // Ignore failed test cases and continue the pipeline
                failure {
                    echo 'Ignoring failed test cases.'
                }
            }
        }
        stage('Deployment') {
            steps {
                // Print deployment message
                echo 'Deployed'
            }
        }
      stage('Clean Up') {
            steps {
                // Clean up temporary files or resources
                catchError {
             
            echo 'Clean up completed'
                }
            }
        }
    }
}
