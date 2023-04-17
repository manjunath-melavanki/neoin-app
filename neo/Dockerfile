FROM openjdk:11.0.7-jre-slim-buster
MAINTAINER manjunath.melavanki
LABEL "collect_logs_with_filebeat"="true"
LABEL "decode_log_event_to_json_object"="true"
COPY build/libs/neo-0.0.1.jar neo.jar
ENTRYPOINT ["java","-jar","/neo.jar"]