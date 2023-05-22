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
- Add functionality for search by region code.
- Add functionality for search by region name, city, district.
- Add functionality for parse a car plate.
- Migrate Database for MySQL -> PostgreSQL.
- Add V2
- Add UI
- Add JWT
- Add one time password
- Add docker-compose
- Add unit tests. :heavy_check_mark:
- Fix Germany.

### Actuator

* http://localhost:8090/actuator
* http://localhost:8090/actuator/health
* http://localhost:8090/actuator/info

### http://localhost:8090/actuator/health

```
{
"status":"UP"
}
```

### Swagger-UI

* http://localhost:8080/swagger-ui/index.html

![](https://d.radikal.ru/d12/2202/15/403e9978bc0e.png)

### How it works. (Not correct schema)

![](https://c.radikal.ru/c08/2108/48/e78d3e2723cc.png)

### Ho w to run.

``` docker-compose up```

# API endpoints

These endpoints allow you to handle Stripe subscriptions for Publish and Analyze.

## GET

`official client only` [http://localhost:8080/api/russia?region=29](#get-)<br/>

```
{
    "description": "Архангельская область",
    "region": "29"
}
```

## GET

`official client only` [http://localhost:8080/api/allRussia](#get-)<br/>

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

## POST

`official client only` [http://localhost:8080/api/russia?description=Архангельская область](#post-) <br/>

```
{
    "description": "Архангельская область",
    "region": "29"
}
```
