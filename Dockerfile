FROM java:8
VOLUME /tmp
ADD target/febs.jar febs.jar
ENTRYPOINT ["java","-jar","/febs.jar"]