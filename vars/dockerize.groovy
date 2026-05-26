// this is file make build with docker as component / shared library 
// this stage of build was do in jenkins file 
//inpust needed
    // name of credentials id , to get his username & password and login and after build push to docker hub
    // give us name of image or tag want name image with 
    // 


// stage("build docker image") {
//             steps {
//                     // sh 'newgrp docker'

//                     // sh 'docker version'
// //fetch username from cerdentials and put it in variable called DOCKER_USERNAME & password fetch from cerdentials and put it in variable called DOCKER_PASSWORD
//                     withCredentials([usernamePassword(
//                         credentialsId: 'dockerhub-credential-id',
//                         usernameVariable: 'DOCKER_USERNAME',
//                         passwordVariable: 'DOCKER_PASSWORD'
//                     )]) {
//                         sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
//                     }

//                     sh '''
//                         docker build -t youssef11gaber10/jenkins-nodeapp:latest .
//                         docker push youssef11gaber10/jenkins-nodeapp:latest
//                     '''
//             }
// }


// is groovy function  must named call
def call (String repo_name="youssef11gaber10/jenkins-nodeapp",String tag="latest", String credentialsId="dockerhub-credential-id"){  // make your input and this is default value


     withCredentials([usernamePassword(
                        credentialsId: credentialsId,
                        usernameVariable: 'DOCKER_USERNAME',
                        passwordVariable: 'DOCKER_PASSWORD'
                    )]) {
                        sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                    }

                    sh """
                        docker build -t ${repo_name}:${tag} .
                        docker push ${repo_name}:${tag}
                    """


        
}
