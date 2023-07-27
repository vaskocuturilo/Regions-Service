## Spring Boot Service for Region Application.

[![SWUbanner](https://raw.githubusercontent.com/vshymanskyy/StandWithUkraine/main/banner2-direct.svg)](https://vshymanskyy.github.io/StandWithUkraine/)


The Spring Boot REST service for region application.

## Requirements:

- Use any *object-oriented language*.
- Use last Spring boot version.
- Use last MySQL database version.
- Create REST API service.
- Create docker compose for run service.
- provide code and clear instructions how to run it.

**Note**: please put your code in public repository.

**Note**: Please send link to this repo when you are done.

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
- Will be adding JWT.
- Will be adding a one-time password.
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
- Fix UI interface :heavy_check_mark:

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

`official client only` [http://localhost:8080/api/v1/russia/plates/region/29](#get-)<br/>

```
{
    "description": "Архангельская область",
    "region": "29"
}
```
## GET

`official client only` [http://localhost:8080/api/v1/russia/plates/description/Архангельская область](#get-)<br/>

```
{
    "description": "Архангельская область",
    "region": "29"
}
```

## GET

`official client only` [http://localhost:8080/api/v1/russia/plates/all](#get-)<br/>

```
   [
    {
        "region": "01",
        "description": "Республика Адыгея",
        "id": 1
    },
    {
        "region": "02",
        "description": "Республика Башкортостан",
        "id": 2
    },
    {
        "region": "102",
        "description": "Республика Башкортостан",
        "id": 3
    },
```
