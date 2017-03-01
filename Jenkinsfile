#!groovy

pipeline {
    agent none
    tools {
        maven 'mvn3'
        jdk 'jdk8'
    }
    stages {
        stage('Build') {
            agent any
            steps {
               sh 'mvn -Dmaven.test.failure.ignore=true install'
               stash includes: '**/target/*.jar', name: 'jar'
            }
            post {
                success {
                    junit 'target/*-reports/**/*.xml'
                }
            }
        }
        stage('Deploy') {
            agent any
            steps {
                unstash 'jar'
                echo 'Deploying to Artifactory'
            }
        }
        stage('UAT') {
            agent any
            steps {
                unstash 'jar'
                input 'Deploy to UAT?'
                echo 'Deploying to UAT...'
            }
        }
    }
}