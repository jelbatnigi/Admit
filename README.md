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

