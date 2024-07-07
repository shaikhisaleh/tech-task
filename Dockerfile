FROM openjdk:17.0-jdk
ENV TZ="Asia/Riyadh"
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN mkdir /opt/app
COPY /target/*.jar /opt/app/app.jar
ENV SPRING_PROFILES_ACTIVE=<SPRING_PROFILES_ACTIVE>
CMD java -jar opt/app/app.jar

