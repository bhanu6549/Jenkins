
    


node{

 
stage('SCM Checkout'){
tool 'Maven 3'
 
git 'https://github.com/bhanu6549/Jenkins'

 
}

 
stage('Compile Package'){

 
def mvnHome= tool name: 'Maven 3', type: 'maven'

 
sh "${mvnHome}/bin/mvn package"

 
}

 
}
