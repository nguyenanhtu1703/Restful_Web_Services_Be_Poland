In Spring Boot, the new final executable JAR or WAR file with embedded server solution may not suitable in all production environments, especially the deployment team (a team with good knowledge of server optimization and monitoring skills, but lack of, the development experience), they want full control of the server, and they don’t touch code, so, we need a traditional WAR file.


This project use the traditional way of deploying project. we will build a war file and put it on a Web container.


1. How to build

- package project to war
- Configure the project. In this project, we dont use any configuration on the web.xml file. instead we will make an Initializer by extending class SpringBootServletInitializer, in servlet 3.0 evirontment SpringBootServletInitializer class will be picked up by the web container on start up, so the application can be configurated from this class.
- use mvn package to package the project



2. How to deploy

- copy war file to the webapp folder of the tomcat directory.
- start the tomcat server by running startup.bat file of the tomcat
- now we can test service of the project throught base context: http://localhost:8080/Tu_Anh_Nguyen_BePolannd_ProjectRecuitment_1_0_SNAPSHOT_war/ 
