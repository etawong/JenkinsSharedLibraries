def call(String stageName){
  
  if ("${stageName}" == "Build")
     {
       sh "mvn clean package"
     }
  else if ("${stageName}" == "SonarQube Report")
     {
       sh "mvn clean sonar:sonar"
     }
  else if ("${stageName}" == "Upload Into Nexus")
     {
       sh "mvn clean deploy"
     }
else if ("${stageName}" == "tomcat")
    {
    deploy adapters: [tomcat9(credentialsId: 'Tomcat-credentials', path: '', url: 'http://35.89.133.135:8177')], contextPath: null, war: 'target/*.war'
    sh "echo application successfully deployed into the tomcat application server"
    }
}

