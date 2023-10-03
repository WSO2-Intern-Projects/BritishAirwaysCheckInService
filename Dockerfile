FROM openjdk:17-alpine

## https://security.alpinelinux.org/vuln/CVE-2021-46848
#RUN apk add --upgrade libtasn1-progs
#
## https://security.alpinelinux.org/vuln/CVE-2022-37434
#RUN apk update && apk upgrade zlib

# Create a new user with UID 10014
RUN addgroup -g 10014 choreo && \
    adduser  --disabled-password  --no-create-home --uid 10014 --ingroup choreo choreouser
VOLUME /tmp
USER 10014
# Add Spring Boot app.jar to Container
ADD target/british-airways-check-in.jar british-airways-check-in.jar
# Expose the port your application will run on
EXPOSE 8080
# Fire up our Spring Boot app by default
#CMD [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
ENTRYPOINT ["java","-jar","/british-airways-check-in.jar"]


###############################################################################################
## Docker multi-stage build
#
##1. Building the App with Maven
#FROM maven:3.9.4-eclipse-temurin-17-alpine
#
#ADD . /java-springboot
#WORKDIR /java-springboot
#
## Just echo so we can see, if everything is there :)
#RUN ls -l
#
## Run Maven build
#RUN mvn clean install
#
## 2. Just using the build artifact and then removing the build-container
#FROM openjdk:17-alpine
#
### https://security.alpinelinux.org/vuln/CVE-2021-46848
##RUN apk add --upgrade libtasn1-progs
##
### https://security.alpinelinux.org/vuln/CVE-2022-37434
##RUN apk update && apk upgrade zlib
#
#
## Create a new user with UID 10014
#RUN addgroup -g 10014 choreo && \
#    adduser  --disabled-password  --no-create-home --uid 10014 --ingroup choreo choreouser
#
#VOLUME /tmp
#
#USER 10014
#
## Add Spring Boot app.jar to Container
#COPY --from=0 "/java-springboot/target/british-airways-check-in.jar" app.jar
#
## Expose the port your application will run on
#EXPOSE 8080
#
## Fire up our Spring Boot app by default
#CMD [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
