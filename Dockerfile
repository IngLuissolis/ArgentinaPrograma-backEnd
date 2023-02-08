
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

#FROM alpine:latest

FROM amazoncorretto:11-alpine-jdk
MAINTAINER LUIS_SOLIS //quien es el dueño
COPY target/proyectointegradorv1-0.0.1-SNAPSHOT.jar LES-app.jar
ENTRYPOINT ["java","-jar","/LES-app.jar"]

#CMD ["/bin/sh"]
