pipeline {
    agent none
    environment {
        DOCKERHUB_CREDENTIALS = credentials('dh_cred')
    }
    stages {
         stage('Checkout'){
            agent any
            steps{
                //Changez avec votre lien github
                git branch: 'main', url: 'https://github.com/HOUDIM/DevOps-Project.git'
            }
        }
        stage('Init'){
            agent any
            steps{
            sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }


         stage('Frontend') {
            agent any
             when {
                changeset "**/Dimassi_Informatique_Angular/**"
                beforeAgent true
            }

            steps {
                dir('Dimassi_Informatique_Angular'){
                    sh 'docker build -t $DOCKERHUB_CREDENTIALS_USR/frontend:$BUILD_ID .'
                    sh 'docker push $DOCKERHUB_CREDENTIALS_USR/frontend:$BUILD_ID'
                    sh 'docker rmi $DOCKERHUB_CREDENTIALS_USR/frontend:$BUILD_ID'
                    sh 'docker logout'
                }
            }
        }
        stage('Backend') {
            agent any
//            when {
  //              changeset "**/Dimassi_Informatique/**"
    //            beforeAgent true
     //       }
            steps {
                dir('Dimassi_Informatique'){
                    sh 'docker build -t $DOCKERHUB_CREDENTIALS_USR/backend:$BUILD_ID .'
                    sh 'docker push $DOCKERHUB_CREDENTIALS_USR/backend:$BUILD_ID'
                    sh 'docker rmi $DOCKERHUB_CREDENTIALS_USR/backend:$BUILD_ID'
                    sh 'docker logout'
                }
            }
        }

    }
}