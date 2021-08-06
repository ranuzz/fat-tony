FROM openjdk:11

RUN apt-get update && apt-get install -y -q --no-install-recommends \
        build-essential \
        maven \
    && rm -rf /var/lib/apt/lists/*

COPY fattony/ /usr/src/fattony
WORKDIR /usr/src/fattony
RUN mvn clean install
CMD ["java", "-jar",  "mafiaapi/target/mafiaapi-0.0.1-SNAPSHOT.jar"]