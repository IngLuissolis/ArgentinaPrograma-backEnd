
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

#FROM alpine:latest

FROM amazoncorretto:11-alpine-jdk
MAINTAINER LUIS_SOLIS //quien es el dueño
COPY target/proyectointegradorv1-0.0.1-SNAPSHOT.jar LS-app.jar //va a copiar el empaquetado a github
ENTRYPOINT ["java","-jar","/LS-app.jar"] //es la instruccion que se va a ejecutar primero

#CMD ["/bin/sh"]
