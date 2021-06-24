## Quick Start

### STEP 1: GET KAFKA
[Download](https://kafka.apache.org/downloads) the latest Kafka release and extract it:
```
$ tar -xzf kafka_2.13-2.8.0.tgz
$ cd kafka_2.13-2.8.0
```
### STEP 2: START THE KAFKA ENVIRONMENT
Run the following commands in order to start all services in the correct order:
```
# Start the ZooKeeper service
# Note: Soon, ZooKeeper will no longer be required by Apache Kafka.
$ bin/zookeeper-server-start.sh config/zookeeper.properties
```
Open another terminal session and run:
```
# Start the Kafka broker service
$ bin/kafka-server-start.sh config/server.properties
```
### STEP 3: CREATE A TOPIC TO STORE YOUR EVENTS
So before you can write your first events, you must create a topic. Open another terminal session and run:
```
$ bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092
```
### STEP 4: WRITE SOME EVENTS INTO THE TOPIC
Run Producer class for write some events
### STEP 5: READ THE EVENTS
Run Consumer class for read the events
