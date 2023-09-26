pipeline{
    agent any
    stages{
        stage("code"){
            steps{
                git"https://github.com/rkdevops1406/PizzaOrder.git"
            }
        }
        stage("Build"){
            steps{
                sh 'mvn clean package -DskipTests'
            }
        }
        stage("Deploy to tomcat"){
            steps{
                sshagent(['9fc46ee4-5143-40f1-ae9f-7d34d0fefc4d']) {
                sh 'scp -o StrictHostKeyChecking=no /var/lib/jenkins/workspace/Pipeline-1/target/PizzaOrder-0.0.1-SNAPSHOT.jar ec2-user@18.216.219.223:/opt/apache-tomcat-9.0.80/webapps'   
    
                }
            }
        }
    }
}   
    

