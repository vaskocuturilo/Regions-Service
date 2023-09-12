## Spring Boot Service for Region Application.

[![SWUbanner](https://raw.githubusercontent.com/vshymanskyy/StandWithUkraine/main/banner2-direct.svg)](https://vshymanskyy.github.io/StandWithUkraine/)


The Spring Boot REST service for region application.

## Requirements:

- Use any *object-oriented language*.
- Use the last Spring boot version.
- Use the last MySQL database version.
- Create REST API service.
- Create docker-compose for run service.
- Provide code and clear instructions on how to run it.

**Note**: Please put your code in a public repository.

**Note**: Please send a link to this repo when you are done.

You will need the following technologies available to try it out:

* Git
* Spring Boot
* Mysql
* Gradle 3+
* JDK 8
* Docker
* IDE of your choice


## TO-DO list (ASAP):
- Will be adding functionality for search by region code. :heavy_check_mark:
- Will be adding functionality for search by region name, city, and district. :heavy_check_mark:
- Will be adding functionality for parsing a car plate from an image.
- Migrate Database for MySQL -> PostgreSQL.
- Will be adding validation fields. :heavy_check_mark:
- Will be adding V2 (one controller, one service, one repository for all countries)
- Will be adding UI (Countries field) :heavy_check_mark:
- Will be adding JWT. :heavy_check_mark:
- Will be adding API_KEY. :heavy_check_mark:
- Will be adding a one-time password. :heavy_check_mark:
- Will be adding docker-compose :heavy_check_mark:
- Will be adding integration tests for each country. :heavy_check_mark:
- Will be adding unit tests. :heavy_check_mark: 
- Will be fixing Germany country. 
- Will be fixing British country. :heavy_check_mark:
- Will be adding functionality for deployment to AWS.
- Will be adding React or Angular frameworks.
- Will be adding functionality for search diplomatic plates. :heavy_check_mark:
- Will be adding UI (diplomatic field) :heavy_check_mark:
- Will be adding positive UI automation scripts (Smoke and Sanity) :heavy_check_mark: 
- Will be adding negative UI automation scripts (Smoke and Sanity)
- Will be adding migration from Spring boot v2.5.3 to v3.1.*
- Will be adding Logging. :heavy_check_mark:
- Will be adding user controller :heavy_check_mark:
- Will be adding Jest unit testing for node JS
- Fix the UI interface
- will be adding the Google map.
- Will be adding logout timeout functionality.
- Will be adding a UI form for api_key.
  

### Actuator

* http://localhost:8090/actuator
* http://localhost:8090/actuator/health
* http://localhost:8090/actuator/info

### http://localhost:8090/actuator/health

```
{
"status": "UP"
}
```

### Swagger-UI

* http://localhost:8080/swagger-ui/index.html

![](https://d.radikal.ru/d12/2202/15/403e9978bc0e.png)

### How it works. (Not correct schema)

![](https://c.radikal.ru/c08/2108/48/e78d3e2723cc.png)

### How to run.

``` docker-compose -f "docker-compose.yml" up --detach --build```

# API endpoints

These endpoints allow you to handle Stripe subscriptions for Publish and Analyze.

## GET

`official client only` [http://localhost:8080/api/v1/poland/plates/region/wx](#get-)<br/>

```
{
   "description": "Województwo mazowieckie, Warszawa-Żoliborz",
    "region": "WX"
}
```
## GET

`official client only` [http://localhost:8080/api/v1/poland/plates/description/Warszawa-Żoliborz](#get-)<br/>

```
{
   "description": "Województwo mazowieckie, Warszawa-Żoliborz",
      "region": "WX"
}
```
## The Web site link is

http://regions-service.us-east-2.elasticbeanstalk.com/

## How it looks
![](https://i.postimg.cc/tJTGF42w/screenshot-regions-service-us-east-2-elasticbeanstalk-com-2023-08-06-13-58-44.png)

![](https://i.postimg.cc/gkJTD5m9/screenshot-regions-service-us-east-2-elasticbeanstalk-com-2023-08-06-13-59-41.png)

