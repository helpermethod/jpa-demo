#!groovy

pipeline {
    agent any
    tools {
        maven 'mvn3'
        jdk 'jdk8'
    }
    stages {
        stage('Build') {
            steps {
               echo "Let's go"
               sh 'mvn -Dmaven.test.failure.ignore=true install'
            }
            post {
                success {
                    junit 'target/*-reports/**/*.xml'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying to Artifactory'
            }
        }
        stage('UAT') {
            steps {
                input 'Deploy to UAT?'
                echo 'Deploying to UAT...'
            }
        }
    }
}
