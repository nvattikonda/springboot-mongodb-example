# Project Title
springboot-mongodb example

# Project Desc
springboot-mongodb-example project provides information on following

1. Connecting to multiple mongodb databases using Spring MongoTemplate
2. Exposing collections over Restful endpoints using Spring Boot

# Getting Started
Get copy of **springboot-mongodb-example** module via `git clone https://github.com/nvattikonda/springboot-mongodb-example.git`
## Prerequisites

### MongoDB Atlas setup
[Get Started with Atlas](https://docs.atlas.mongodb.com/getting-started/)
#### Loading Sample Dataset
[Load Sample Data](https://docs.atlas.mongodb.com/sample-data/)
[Available Sample Datasets](https://docs.atlas.mongodb.com/sample-data/available-sample-datasets/)

Following sample dataset should be loaded for spring-mongodb-example to work
1. `Sample Analytics Dataset`
2. `Sample Mflix Dataset`

#### Connecting to MongoDB Atlas
[Connecting to MongoDB Atlas](https://intercom.help/mongodb-atlas/en/articles/3212463-connecting-to-an-atlas-cluster)

`springboot-mongodb-example` has required drivers to connect, only appropriate
configuration is required, refer to [Configuration](#Configuration)

Following software is required to build and run the project
1. JDK (Version 1.8.x)
2. Maven (Version 3.5.x)

### Installing JDK and Maven
use `sdkman` for installing JDK and Maven
#### Installing `sdkman`
[Installing sdkman](https://sdkman.io/install)

##### Usage `sdkman`
[Using sdkman](https://sdkman.io/usage)

#### List available Java and Maven versions
1. `sdk list java`
2. `sdk list maven`

#### Available `JDK Distributions` and installing JDK
[JDK distributions supported by sdkman](https://sdkman.io/jdks)

#### Installing `Maven`
[Installing Maven](https://sdkman.io/sdks#maven)

## Building springboot-mongodb-example
**Build the project using command**

nvattikonda@nvattikonda-mbp:`cd ~/projects/personal/springboot-mongodb-example &&  mvn clean install`

### Configuration
springboot-mongodb-example configuration is located @ springboot-mongodb-example/src/main/resources** directory
1. application.yaml

Following properties need to be configured for springboot-mongodb-example to run
1. \<userName\>
2. \<password\>
3. \<host\>

sample URLs `with dummy configuration values` after above properties are configured
```
mongodb:
    mapURL:
        sample_analytics: mongodb+srv://mongorocks:mongorocks@mongorocks.mongodb.net/sample_analytics?authSource=admin&retryWrites=true&w=majority&ssl=true&ssl=true&minPoolSize=5&maxPoolSize=100&maxIdleTimeMS=900000&connectTimeoutMS=5000&socketTimeoutMS=15000&waitQueueMultiple=1&waitQueueTimeoutMS=2000&readpreference=secondaryPreferred&appName=mongorocks
        sample_mflix: mongodb+srv://mongorocks:mongorocks@mongorocks.mongodb.net/sample_mflix?authSource=admin&retryWrites=true&w=majority&ssl=true&minPoolSize=5&maxPoolSize=100&maxIdleTimeMS=900000&connectTimeoutMS=5000&socketTimeoutMS=15000&waitQueueMultiple=1&waitQueueTimeoutMS=2000&readpreference=secondaryPreferred&appName=mongorocks
```

## Running springboot-mongodb-example
nvattikonda@nvattikonda-mbp:`cd ~/projects/personal/springboot-mongodb-example &&  mvn spring-boot:run`

### Invoking API

# APIs

#### Fetching all users
```http://localhost:8080/users```

#### Fetching a user
```http://localhost:8080/users/<id>```

#### Fetching all accounts
```http://localhost:8080/accounts```

#### Fetching a account
```http://localhost:8080/accounts/<id>```

## Acknowledgments
* Thanks to anyone who's code/framework/references/examples are used

## Useful Information

[markdown intellij plugin](https://github.com/vsch/idea-multimarkdown)

[markdown cheatsheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)
