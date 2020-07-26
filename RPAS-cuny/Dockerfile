FROM maven
COPY . /playground
WORKDIR /playground/target
RUN mvn package 
EXPOSE 8080
ENTRYPOINT [ "java","-jar","" ]
