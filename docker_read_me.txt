inside each folder run

 ./gradlew clean build   
 docker build --tag=<app-name>:latest .
 
docker network create neo-net
 
docker build --tag=cloud-config-server:latest .
docker run -p 8888:8888 --name cloud-config-server --network neo-net cloud-config-server:latest
  
docker build --tag=neoin-eureka-server:latest .
docker run -p 8761:8761 --name neoin-eureka-server --network neo-net neoin-eureka-server:latest

docker build --tag=neoin-cloud-gateway:latest .
docker run -d -p 8088:8088 --name neoin-cloud-gateway --network neo-net neoin-cloud-gateway:latest

docker build --tag=neo:latest .
docker run -d -p 8081:8081 --name neo-1 -e MYSQL_HOST=mysql -e spring.profiles.active=dev --network neo-net neo:latest

docker run -d -p 8082:8082 --name neo-2 -e MYSQL_HOST=mysql --network neo-net neo:latest

docker run -d -p 8083:8083 --name neo-3 -e MYSQL_HOST=mysql --network neo-net neo:latest

docker run --name mysql -d -e MYSQL_ROOT_PASSWORD=root -v mysql:/var/lib/mysql --network neo-net mysql:8



curl -X 'POST' \
  'http://localhost:8088/neo/vendor/group' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  
  "groupName": "Zomato",
  "status": true
}'

Kibana: http://localhost:5601/
Eurekha: http://localhost:8761/
https://cassiomolin.com/2019/06/30/log-aggregation-with-spring-boot-elastic-stack-and-docker/

https://blogs.oracle.com/java/post/go-native-with-spring-boot-3-and-graalvm
https://medium.com/graalvm/using-graalvm-and-native-image-on-windows-10-9954dc071311


Graal Native Image
mvnw -Pnative spring-boot:build-image
docker run -p 8085:8080 native-app:0.0.1-SNAPSHOT