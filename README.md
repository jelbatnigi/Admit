# To run the applicaiton you need to have the following
1. MYSQL database
2. Java 8
3. Postman

#Database
to start you need to load the data into the database.
Obtain the following 2 scripts

scripts.sql -- this script contains all the schema and table create and insert statements

create_db.sh -- will load the sql script to the database

run the following script from the command line. You need to provide username and password for your mysql local instance

./create_db.sh {username} {password}

#Application
The application is a using Springboot

Get the jar file from /target/admitone-1.0-SNAPSHOT.jar

You can run the jar in the command line. You need to pass as System variables the user and password credentials for your mysql local database

run command : java -jar -Duser={user} -Dpass={password} admitone-1.0-SNAPSHOT.jar

#Application Functionality

The application Exposes 3 main restful services and can be invoked using postman:

1. Purchase service :

This service takes a userId, showId and numberOfTickets and adds a purchase order to the database.

URL:  http://localhost:8080/rest/purchase

It takes application/json as content-type header

It takes a JSON object for example:

{
   "userId":4,
   "showId":4,
   "numberOfTickets":20
}

2. Cancellation Service :

This service takes a userId, showId and numberOfTickets to be cancelled and exchangeId if the cancellation happens as a result of an exchange. It persists to the cancellation table

URL:  http://localhost:8080/rest/cancelTickets

It takes application/json as content-type header

It takes a JSON object for example:

{
   "userId”:1,
   "showId”:2,
   "numberOfTickets":3,
   "ExchangeId":null
}

3. Excahange Service :

This service takes a userId, fromShowId, toShowId and numberOfTickets to be exchanged. It persists to the exchange table

URL:  http://localhost:8080/rest/exchangeTickets

It takes application/json as content-type header

It takes a JSON object for example:

{
   "userId":4,
   "fromShowId":4,
   "toShowId":8,
   "numberOfTickets":5
}

4. login services :

by typing in the url http://localhost:8080 The user will be directed to a login page. The authentication uses Spring securtity. I have provided hardcoded user and passwords

username : user

password: password

Once the user logs in, he/she will be directed to the search page.


5. Search Service :

This service is accessed by the UI 

http://localhost:8080/search 

users must login first to access this page.

This service invokes a restful service to search by event ids. The result will display a table the order information for each curtomer.
