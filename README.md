# Getting Started

###Docker steps 

For docker image build, go to root folder of project and run command :

$ **docker build --build-arg JAR_FILE=target/\*.jar -t studentapi-docker:latest .**

To verify image :

$ **docker image ls**

Run image in container:

$ **docker run --name studentapi-docker -d -p 8080:8080 studentapi-docker:latest**


###Swagger

http://192.168.99.100:8080/swagger-ui.html

