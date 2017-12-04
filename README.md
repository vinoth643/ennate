# ennate
Ennate Coding Challenge

Prerequesties:
- Docker Installation (https://docs.docker.com/engine/installation/)
- Jar Folder under Docker Installation Folder which has the docker scripts (docker-compose, docker) 
<br />#Docker Bin Directory#/jar
  
Steps to run the application:
1. Copy sensor-emulator-0.0.1-SNAPSHOT.jar from libs folder to jar folder under docker installation as mentioned in prerequesties
2. Download the Ennate project and run the maven command to build the codechallenge-0.0.1-SNAPSHOT.jar<br />
      mvn clean install
3. Copy codechallenge-0.0.1-SNAPSHOT.jar to jar folder under docker installation as mentioned in prerequesties
4. Copy the docker-compose.yml, sensor-emulator-dockerfile.server, sensor-reciever-dockerfile.server files from dockerfiles folder to the Docker Bin Directory
5. Check the starting weight in the sensor-emulator-dockerfile.server and change accordingly
     <br />-Dbase.value=150 (Current Value)
5. Go to the Docker Bin Directory in the Terminal
6. Run the docker compose command to build the docker image
     <br />#Docker Bin Directory#: docker-compose build
7. Run the docker compose up command to start the containers for Restful API, Sensor Emulator and MongoDB Datastore. As part of this step, the sensor emulator will send the records to the sensor reciever Restful API.
     <br />#Docker Bin Directory#: docker-compose up -d
8. Run the docker compose down command to stop all the servers
     <br />#Docker Bin Directory#: docker-compose down

Post Validation:
1. Logs for individual services can be verified by the below command
    <br />#Docker Bin Directory#: docker-compose logs sensor-emulator-server/sensor-reciever-server/mongo
2. MongoDB can be accessed through the uri mongodb://localhost:27017

      
  
