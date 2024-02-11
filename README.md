
# GaragePlug Backend Assignment
### Teachnolgies used
#### Backend
 - Java
 - SpringBoot
   - Spring Data JPA
   - SpringBoot Dev Tools
   - MySQL Driver
   - Spring Web Services
   - Lombok
   
#### Version Control
 - Git


## Prerequisites
Before running the application, ensure you have the following installed on your system:

Java Development Kit (JDK)
MySQL Database

## Clone the Repository

```bash
 git clone https://github.com/prajwal-bandekar/GaragePlug
```
## Configure Backend
Navigate to the 'AmznCart' folder

- Update the application.properties file with your MySQL database configuration.


-- springboot/src/main/resources/application.properties
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name?createDatabaseIfNotExist=true
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## Usage
Run this as a Springboot App.

## Testing

#### REST API Endpoints

 Create Product:
 - POST /product

Update Product:
- PUT /product/{product_id}

Delete Product:
- DELETE /product/{product_id}


 GET Product:

To run Promotion Set A:
- GET /product?promotion=SetA&product_id={product_id}

To run Promotion Set B:
- GET /product?promotion=SetB&product_id={product_id}
