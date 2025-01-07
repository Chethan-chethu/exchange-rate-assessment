Step 1 : Clone the repository from github to your local

Step 2: open the project as a maven project in an IDE

step 3: run the class Annotated with @SpringBootApplication , to start the application

step 4: the application starts at port 8080 by default eg(http://localhost:8080/api/rates?base=USD)

step 5 : access the rest end points 
GET(http://localhost:8080/api/rates?base=USD) & 
POST(http://localhost:8080/api/convert) along with request body 
{
"from": "USD",
"to": "EUR",
"amount": 100
}

NOTE : Use Rest clients like POSTMAN,Thunder-client etc to access the end points , as there is no proper ui
