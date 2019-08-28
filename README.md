# spring-cloud-native-pizza

This project contains five projects: the config server, the discovery server and the three microservices teacher, student and course.

First, start the discovery server:

cd <project_root>/discoveryserver
./gradlew bootRun

and the config server:

cd <project_root>/configserver
./gradlew bootRun

Then, start each of the three microservices:

cd <project_root>/teacher
./gradlew bootRun

cd <project_root>/student
./gradlew bootRun

cd <project_root>/course
./gradlew bootRun

