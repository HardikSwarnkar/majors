
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
           
                failure {
                    echo 'Ignoring failed test cases.'
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
