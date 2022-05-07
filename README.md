# JAX-RS REST E-Commerce Web Service
### An-E-Commerce-RESTful-built-using-JAX-RS.

## 📃 Documentation
📧[Postman RESTful API Docs](https://documenter.getpostman.com/view/20483744/UyrAGxo3)

## 📦 Features
* HATEOAS
* Custom ExceptionMappers
* Content negotiation (support for both XML and JSON payloads and responses)

## ⚙ Technologies used
* JAX-RS (Jersey)
* JSON-B
* JAX-B
* Maven
* Tomcat
* Intellij IDEA Ultimate
* Postman

 ## 🛠 Run with Maven
    **Maven**
* Change the configuration of Tomcat in `pom.xml`. 
* Deploy the application using the following maven command:
 ```
mvn clean compile tomcat7:redeploy
```
* REST: change the URL in the Postman collection environment variables to match the port you chose for your Tomcat deployment


## 🏛 Database Schema
![DataBase Schema](https://user-images.githubusercontent.com/95469600/167268988-1da0ebe0-127b-470e-ab33-62650e9d85bf.jpg)

**🐬MySQL**
* Create a database schema and provide the username and password in the persistence.xml
* Hibernate will automatically create the tables for you
* Run DatabasePopulator.java to populate the database with some test data

## 👷️ Contributors
* [Abdelrahman Samy](https://github.com/A-Samyy)

   
