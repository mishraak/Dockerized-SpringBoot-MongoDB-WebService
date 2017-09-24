#This simple backend demo web services uses Spring Boot and MongoDB APIs in Java. 


# Employees APIs

## First time POST request 
curl -v -X POST -H "Content-Type:application/json" -d'{"id" :1, "fname" : "Akshay", "lname" : "Mishra" }' http://localhost:8080/cmpe282Akshay673/rest/employee


## Second time POST request 
curl -v -X POST -H "Content-Type:application/json" -d'{"id" :1, "fname" : "Akshay", "lname" : "Mishra" }' http://localhost:8080/cmpe282Akshay673/rest/employee


## First time GET request
curl -v -X GET http://localhost:8080/cmpe282Akshay673/rest/employee/1


## Id Update request
### First PUT request 
curl -v -X PUT -H "Content-Type:application/json" -d'{"id" :2, "fname" : "Akshay2", "lname" : "Mishra" }' http://localhost:8080/cmpe282Akshay673/rest/employee/1


## Other partial Update request
### Second PUT request  
curl -v -X PUT -H "Content-Type:application/json" -d'{"id" :1, "fname" : "Akshay", "lname" : "Mishra2" }' http://localhost:8080/cmpe282Akshay673/rest/employee/1


## First Delete request
curl -v -X DELETE http://localhost:8080/cmpe282Akshay673/rest/employee/1


## Second Delete request
curl -v -X DELETE http://localhost:8080/cmpe282Akshay673/rest/employee/1



# Project APIs

## First time POST request 
curl -v -X POST -H "Content-Type:application/json" -d'{"id" :1, "name" : "Project1", "budget" : "1000.01" }' http://localhost:8080/cmpe282Akshay673/rest/project

## Second time POST request 
curl -v -X POST -H "Content-Type:application/json" -d'{"id" :1, "name" : "Project1", "budget" : "1000.02" }' http://localhost:8080/cmpe282Akshay673/rest/project


## First time GET request
curl -v -X GET http://localhost:8080/cmpe282Akshay673/rest/project/1


## Id Update request
### First PUT request 
curl -v -X PUT -H "Content-Type:application/json" -d'{"id" :2, "name" : "Project2", "budget" : "1000.02" }' http://localhost:8080/cmpe282Akshay673/rest/project/1


## Other partial Update request
### Second PUT request 
curl -v -X PUT -H "Content-Type:application/json" -d'{"id" :1, "name" : "Project2", "budget" : "1000.03" }' http://localhost:8080/cmpe282Akshay673/rest/project/1


## First Delete request
curl -v -X DELETE http://localhost:8080/cmpe282Akshay673/rest/project/1


## Second Delete request
curl -v -X DELETE http://localhost:8080/cmpe282Akshay673/rest/project/1