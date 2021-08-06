## Development Environment

### platform

* Windows 10 WSL Ubuntu 20.04

### Installing nodejs

[Installing Node Using the Node Version Manager](https://www.digitalocean.com/community/tutorials/how-to-install-node-js-on-ubuntu-20-04)

```sh
nvm list
#default -> v14.16.1

node -v
#v14.16.1

npm -v
#6.14.12
```

### Installing Java

```sh
required version : *java-11-openjdk-amd64*

sudo apt install openjdk-11-jdk

sudo apt install maven
```

check version

```sh
java -version

openjdk version "11.0.11" 2021-04-20
OpenJDK Runtime Environment (build 11.0.11+9-Ubuntu-0ubuntu2.20.04)
OpenJDK 64-Bit Server VM (build 11.0.11+9-Ubuntu-0ubuntu2.20.04, mixed mode, sharing)
```

### Build and Run

```sh
mvn clean install -U
java -jar mafiaapi/target/mafiaapi-0.0.1-SNAPSHOT.jar
```

### dev run

frontend

```sh
cd mafiaui
npm run serve
```

backend

```sh
cd mafiaapi
mvn clean install
jav -jar target/backend-{VERSION}.jar
```