# Day 13 - Spring Boot Swagger

## Problem 1 - Buat CRUD Product ✅
### Product Entity
- Long id
- String name
- String description
- int stock
- int price

### Endpoints

| Endpoint       | HTTP Method | Keterangan                      |
|----------------|-------------|---------------------------------|
| /products      | GET         | Get all products                |
| /products/:id  | GET         | Get product with specific id    |
| /products      | POST        | Create new product              |
| /products/:id  | PATCH       | Update product with specific id |
| /products/:id  | DELETE      | Delete product with specific id |

## Problem 2 - Integrasi Swagger ✅

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)