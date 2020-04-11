## Development Environment

### platform
* Windows 10 WSL Ubuntu 18.04

### Installing nodejs

> curl -sL https://deb.nodesource.com/setup_10.x | sudo -E bash -

> sudo apt-get install -y nodejs

```
node -v
v10.17.0
```
```
npm -v
6.11.3
```

in case of error while running *npm -v* add this to *.bashrc*
> alias npm="/usr/bin/npm"

### Installing Java

> required version : *java-11-openjdk-amd64*

> sudo apt install openjdk-11-jdk

> sudo apt install maven

check version

```
java -version

openjdk version "11.0.4" 2019-07-16
OpenJDK Runtime Environment (build 11.0.4+11-post-Ubuntu-1ubuntu218.04.3)
OpenJDK 64-Bit Server VM (build 11.0.4+11-post-Ubuntu-1ubuntu218.04.3, mixed mode, sharing)
```

in case of multiple java versions

> sudo update-alternatives --config java

### building

> mvn clean install -U

in case of symbol error add this to *.bashrc*

> export JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF8

### dev run

frontend

> cd frontend

> npm run serve

backend

> cd backend

> mvn clean install

> jav -jar target/backend-{VERSION}.jar
