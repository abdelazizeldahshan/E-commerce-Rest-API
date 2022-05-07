# E-commerce-Rest-API

E-commerce Api with 6 resources documented By [postman](https://www.postman.com/")
--------------
* [Admin](https://documenter.getpostman.com/view/20705929/UyxdL95K)
* [Customer](https://documenter.getpostman.com/view/20705929/UyxdL9P1)
* [Clerk](https://documenter.getpostman.com/view/20705929/UyxdL9Nz)
* [Product](https://documenter.getpostman.com/view/20705929/UyxdL9P4)
* [Order](https://documenter.getpostman.com/view/20705929/UyxdL9P2)
* [Categories](https://documenter.getpostman.com/view/20705929/UyxdL99q)

----------------------------------------------------------------------------
Development Tools
------------------
* [JAX-RS](https://jakarta.ee/specifications/restful-ws/) Specification and [Jersey](https://eclipse-ee4j.github.io/jersey/) implementation .
* `JPA` Specification and `Hibernate (6.0.0.Final)` implementation for Database . 
* `MySql` Database
* `Maven` for Project Configration `Pom.xml`.
* `Tomcat` WebServer.
-----------------------------------------------
Run With Maven
----------------
You can Deploy `Api` to `tomcat` With `tomcat7-maven-plugin` by Change `url` to your local host url

     ``` <plugin>
          <groupId>org.apache.tomcat.maven</groupId>
          <artifactId>tomcat7-maven-plugin</artifactId>
          <version>2.2</version>
          <configuration>
            <username>admin</username>
            <password>admin</password>
            <url>http://localhost:9595/manager/text</url>
            <path>/Ecommerce-Rest-API</path>
          </configuration>
        </plugin>```
