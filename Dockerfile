FROM frolvlad/alpine-oraclejdk8
VOLUME /tmp
ADD build/libs/PatienceAdmin-0.0.1-SNAPSHOT.jar PatienceAdmin.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/PatienceAdmin.jar"]
