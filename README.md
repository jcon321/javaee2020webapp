# Java EE - Web Application

A custom Java EE web application, with MVC design in mind, built with Maven. 
Persistence is done with JPA (using Hibernate) coupled with JTA transactions for CRUD operations.
A Docker container for MariaDB is utilized during development.
Communication occurs via the RESTful implementation JAX-RS (consuming and producing JSON) or by GUI via JSF. 
A master template is used to implement the view using Primefaces components with Bootstrap themes and layout.


### Todo
Authentication (maybe with OAuth2.0) - and Security Roles
docker-compose to link mariadb with payara (datasource config)
Automated testing
Additional JPA entities and relations
Additional RESTful endpoints