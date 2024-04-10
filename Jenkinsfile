pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Add build steps here
                echo 'Building...'
            }
        }
        // Define additional stages as needed
    }

    post {
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
