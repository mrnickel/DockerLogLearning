FROM java:8

COPY target/test-docker-proj-1.0-SNAPSHOT-jar-with-dependencies.jar /usr/local/sbin/TestDockerProj.jar
WORKDIR /usr/local/sbin/
CMD java -jar TestDockerProj.jar