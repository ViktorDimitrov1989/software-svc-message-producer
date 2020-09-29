# Message producer app
Part of a microservice architecture, this microservice is an event queue producer.

# Run mongoDB container
    docker pull mongo
    docker run --name mongoDB -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=secret mongo    

# Run rabbitMQ container
    docker pull rabbitMQ
    docker run -d -p 15672:15672 -p 5672:5672 --name rabbit-mq-instance rabbitmq:3-management
        - rabbit management localhost url - http://localhost:15672/ (guest:guest)