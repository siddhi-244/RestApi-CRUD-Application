# Restful API that performs CRUD Applications on database
A CRUD Application that uses the concepts of REST API to perform operations on database.

### Tools and Libraries needed
- JDK
- Dropwizard
- JDBI 3
- Postman (to send requests to server)
- PgAdmin (For postgresql)
- Intellij IDEA (For initializing dropwizard projects using maven archetype)

### Table Structure
table name - book 
#### columns

- id - (pk) - character varying (40)
- book_name - character varying (100)
- book_author - character varying (100)
- price - integer

table name - book_review
#### columns

- book_id (fk) - character varying (40)
- review - text
- rating - integer
- copies_sold - integer 

Port to send requests - 8080