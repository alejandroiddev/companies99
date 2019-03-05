# Company Service

Micronaut app that fetches info from fake companies and its share values and stores them. 
it also enables three endpoints to retrieve info from it. (TBD)

## Requirements

You need to have Kotlin installed. 
You also need a running postgresql data base. You can use docker to run it without installation running the following command:

    docker run --name dbname-psql \
    -p 5432:5432 \
    -e POSTGRES_DB=[database] \
    -e POSTGRES_PASSWORD=[password] \
    -d postgres

## Usage

With the application running the following endpoints can be accessed:
 
* retrieve a list of companies:[http://localhost:8080/companies](http://localhost:8080/companies)

* retrieve company details: [http://localhost:8080/companies/id](http://localhost:8080/companies/id)

### - Development 

tbd

### - Production

tbd

## Future features 

 - ...