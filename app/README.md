# Vehicle Service

A standalone, runnable Java 17 Spring Boot application implementing the **Vehicle Service** REST API
(as defined by the Vehicle Service Postman Collection / OpenAPI spec). It uses an in-memory store
(`ConcurrentHashMap` + `AtomicLong`), so it runs with no external database.

## Requirements

- Java 17
- Maven 3.6+

## How to run

```bash
cd app
mvn spring-boot:run
```

The service starts on **http://localhost:5000**.

Two sample vehicles are seeded on startup.

## Endpoints

Base URL: `http://localhost:5000`

| Method | Path             | Description                       | Success | Error status codes |
|--------|------------------|-----------------------------------|---------|--------------------|
| GET    | `/vehicles`      | List all vehicles                 | 200     | 500                |
| POST   | `/vehicles`      | Create a vehicle (`vin` required) | 201     | 400, 409, 500      |
| GET    | `/vehicles/{id}` | Get a vehicle by id               | 200     | 404, 500           |
| PATCH  | `/vehicles/{id}` | Partial update (non-null fields)  | 200     | 400, 404, 500      |
| DELETE | `/vehicles/{id}` | Delete a vehicle                  | 204     | 404, 500           |

## Vehicle model

| Field    | Type    | Notes                        |
|----------|---------|------------------------------|
| id       | Long    | Auto-generated               |
| nickName | String  |                              |
| vin      | String  | Required & unique on create  |
| make     | String  |                              |
| model    | String  |                              |
| year     | String  |                              |
| miles    | Integer |                              |

## Error schema

All errors return a JSON body:

```json
{ "message": "..." }
```
