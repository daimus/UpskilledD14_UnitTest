# Day 12 - Spring JWT

## Problem 1 - JWT Generatiom ✅
### Initial Credentials

| Email            | Phone         | Password |
|------------------|---------------|----------|
| johndoe@mail.com | 081234567890  | password |
| janedoe@mail.com | 087773775774  | password |

### Endpoints

| Endpoint       | HTTP Method | Request Body                                | Auth Type | Keterangan                                                                                           |
|----------------|-------------|---------------------------------------------|----------|------------------------------------------------------------------------------------------------------|
| /              | GET         |                                             | Bearer   | Jika berhasil login maka akan tampil response "Authenticated", jika tidak maka akan muncul error 403 |
| /v1/auth/login | POST        | {<br/>"phone": "",<br/>"password": ""<br/>} |          |                                                                                                      |

### Pengujian