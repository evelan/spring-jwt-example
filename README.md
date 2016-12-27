# spring-jwt-example
Sample application using JWT tokens


### Register new user

```
curl -X POST 
-H "Accept: application/json" 
-H "Content-Type: application/json" 
-d '{ 
  "username":"email@gmail.com", 
  "password":"123456"
}' "http://localhost:9000/auth/register"
```

### Acquire JWT token

```
curl -X POST 
-H "Content-Type: application/json"
-d '{
	"username":"email@gmail.com",
	"password":"123456"
}' "http://localhost:9000/auth/login"
```

### Access to restricted endpoint

```
curl -X GET 
-H "Authorization: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJlQGcuY29tIn0.be_KEwHWXezhOgAKGfJ35SqhAFBfqFiUjd3EZD51Suw6PM_NS_vkUSzYejEP_xKfiATV5owuViw6xum9PHeG-g" 
-H "Content-Type: application/json" 
"http://localhost:9000/api"
```


### Utils
* H2 Database console `http://localhost:9000/db`
* Swagger `http://localhost:9000/swagger-ui.html`
