<<<<<<< HEAD
#SpringBoot-MongoDB-WebService



Employees APIs

##First time POST request 
curl -v -X POST -H "Content-Type:application/json" -d'{"id" :1, "fname" : "Akshay", "lname" : "Mishra" }' http://localhost:8080/cmpe282Demo123/rest/employee

##Second time POST request 
curl -v -X POST -H "Content-Type:application/json" -d'{"id" :1, "fname" : "Akshay", "lname" : "Mishra" }' http://localhost:8080/cmpe282Demo123/rest/employee

##First time GET request
curl -v -X GET http://localhost:8080/cmpe282Demo123/rest/employee/1

##Id Update request
###First PUT request 
curl -v -X PUT -H "Content-Type:application/json" -d'{"id" :2, "fname" : "Akshay2", "lname" : "Mishra" }' http://localhost:8080/cmpe282Demo123/rest/employee/1


##Other partial Update request
###Second PUT request  
curl -v -X PUT -H "Content-Type:application/json" -d'{"id" :1, "fname" : "Akshay", "lname" : "Mishra2" }' http://localhost:8080/cmpe282Demo123/rest/employee/1

##First Delete request
curl -v -X DELETE http://localhost:8080/cmpe282Demo123/rest/employee/1

##Second Delete request
curl -v -X DELETE http://localhost:8080/cmpe282Demo123/rest/employee/1




Project APIs

#First time POST request 
curl -v -X POST -H "Content-Type:application/json" -d'{"id" :1, "name" : "Project1", "budget" : "1000.01" }' http://localhost:8080/cmpe282Demo123/rest/project

##Second time POST request 
curl -v -X POST -H "Content-Type:application/json" -d'{"id" :1, "name" : "Project1", "budget" : "1000.02" }' http://localhost:8080/cmpe282Demo123/rest/project

##First time GET request
curl -v -X GET http://localhost:8080/cmpe282Demo123/rest/project/1

##Id Update request
###First PUT request 
curl -v -X PUT -H "Content-Type:application/json" -d'{"id" :2, "name" : "Project2", "budget" : "1000.02" }' http://localhost:8080/cmpe282Demo123/rest/project/1


##Other partial Update request
###Second PUT request 
curl -v -X PUT -H "Content-Type:application/json" -d'{"id" :1, "name" : "Project2", "budget" : "1000.03" }' http://localhost:8080/cmpe282Demo123/rest/project/1


##First Delete request
curl -v -X DELETE http://localhost:8080/cmpe282Demo123/rest/project/1

##Second Delete request
curl -v -X DELETE http://localhost:8080/cmpe282Demo123/rest/project/1
=======
# This simple backend demo web services uses Spring Boot and MongoDB APIs in Java. 


# Employees APIs

## First POST request 
curl -v -X POST -H "Content-Type:application/json" -d'{"id" :1, "fname" : "Akshay", "lname" : "Mishra" }' http://localhost:8080/cmpe282Akshay673/rest/employee


## Second POST request (409 Error)
curl -v -X POST -H "Content-Type:application/json" -d'{"id" :1, "fname" : "Akshay", "lname" : "Mishra" }' http://localhost:8080/cmpe282Akshay673/rest/employee


## valid GET Single Employee request
curl -v -X GET http://localhost:8080/cmpe282Akshay673/rest/employee/1


## Invalid GET valid GET Single Employee request
curl -v -X GET http://localhost:8080/cmpe282Akshay673/rest/employee/2


## Full update
curl -v -X PUT -H "Content-Type:application/json" -d'{"id" :1, "fname" : "Akshay2", "lname" : "Mishra2" }' http://localhost:8080/cmpe282Akshay673/rest/employee/1


## Invalid Id update 
curl -v -X PUT -H "Content-Type:application/json" -d'{"id" :2, "fname" : "Akshay2", "lname" : "Mishra" }' http://localhost:8080/cmpe282Akshay673/rest/employee/1


## Partial Update request
curl -v -X PUT -H "Content-Type:application/json" -d'{"id" :1, "lname" : "Mishra3"}' http://localhost:8080/cmpe282Akshay673/rest/employee/1

curl -v -X PUT -H "Content-Type:application/json" -d'{"id" :1, "fname" : "Akshay5"}' http://localhost:8080/cmpe282Akshay673/rest/employee/1

## First Delete request
curl -v -X DELETE http://localhost:8080/cmpe282Akshay673/rest/employee/1


## Second Delete request (404 Error)
curl -v -X DELETE http://localhost:8080/cmpe282Akshay673/rest/employee/1

## Invalid GET valid GET Single Employee request (when no employee has been added earlier)
curl -v -X GET http://localhost:8080/cmpe282Akshay673/rest/employee

# Project APIs

## First POST request 
curl -v -X POST -H "Content-Type:application/json" -d'{"id" :1, "name" : "Project", "budget" : 2000.01 }' http://localhost:8080/cmpe282Akshay673/rest/project

## Second POST request (409 Error)
curl -v -X POST -H "Content-Type:application/json" -d'{"id" :1, "name" : "Project", "budget" : 2000.01 }' http://localhost:8080/cmpe282Akshay673/rest/project


## Valid Single Project GET request
curl -v -X GET http://localhost:8080/cmpe282Akshay673/rest/project/1

## Invalid Single Project GET request
curl -v -X GET http://localhost:8080/cmpe282Akshay673/rest/project/2


## Full update
curl -v -X PUT -H "Content-Type:application/json" -d'{"id" :1, "name" : "Project2", "budget" : 1000.01 }' http://localhost:8080/cmpe282Akshay673/rest/project/1


## Invalid Id update 
curl -v -X PUT -H "Content-Type:application/json" -d'{"id" :2, "name" : "Project2", "budget" : 1000.01 }' http://localhost:8080/cmpe282Akshay673/rest/project/1


## Partial Update request
curl -v -X PUT -H "Content-Type:application/json" -d'{"id" :1, "name" : "Project4"}' http://localhost:8080/cmpe282Akshay673/rest/project/1

curl -v -X PUT -H "Content-Type:application/json" -d'{"id" :1, "budget" : 6000.10}' http://localhost:8080/cmpe282Akshay673/rest/project/1


## First Delete request
curl -v -X DELETE http://localhost:8080/cmpe282Akshay673/rest/project/1


## Second Delete request (404 Error)
curl -v -X DELETE http://localhost:8080/cmpe282Akshay673/rest/project/1


## Invalid GET valid GET Single Project request (when no project has been added earlier)
curl -v -X GET http://localhost:8080/cmpe282Akshay673/rest/project
>>>>>>> 6c8a76ce2d2a290c4b0409cadfbfafcee6d55c13
