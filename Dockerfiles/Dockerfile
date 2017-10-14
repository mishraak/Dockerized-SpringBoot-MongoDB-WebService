FROM openjdk:8-jdk
MAINTAINER akshay.mishra@sjsu.edu
ADD cmpe282Akshay673.jar  cmpe282Akshay673.jar  
RUN sh -c 'touch /cmpe282Akshay673.jar'  
EXPOSE 8080

ENTRYPOINT ["java", "-Dmongodb.host=dbAkshay673","-Dmongodb.db=cmpe282Akshay673","-Dmongodb.port=27017","-Djava.security.egd=file:/dev/./urandom","-jar","/cmpe282Akshay673.jar"]  

#ENTRYPOINT ["sleep", "infinity"]