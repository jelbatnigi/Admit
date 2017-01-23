create table user_info
(
   user_id int NOT NULL AUTO_INCREMENT,
   email varchar(100) NOT NULL,
   First_name varchar(100) NOT NULL,
   Last_name varchar(100) NOT NULL,
   password varchar(100) NOT NULL,
   PRIMARY KEY (user_id)
);

insert into user_info (email, first_name,last_name, password) values("jelbatn@gmail.com","
Jamal","Elbatnigi", "pass");
insert into user_info (email, first_name,last_name,password) values("ssmith@gmail.com","
Steve","Smith","pass");
insert into user_info (email, first_name,last_name,password) values("msam@gmail.com","
Mark","Sam","pass");
insert into user_info (email, first_name,last_name,password) values("sben@gmail.com","
Sarah","Ben","pass");

create table show_category
(
   category_id int NOT NULL AUTO_INCREMENT,
   category_name varchar(100) NOT NULL,
   PRIMARY KEY (category_id)
);

insert into show_category(category_name) values("Sports");
insert into show_category(category_name) values("Music");
insert into show_category(category_name) values("Theatre");
insert into show_category(category_name) values("Family");
insert into show_category(category_name) values("Comedy");

create table shows
(
   show_id int NOT NULL AUTO_INCREMENT,
   show_name varchar(100) NOT NULL,
   category_id int NOT NULL,
   show_time DATETIME,
   PRIMARY KEY (show_id),
   FOREIGN KEY (category_id) REFERENCES admitone.show_category (category_id)
);

insert into shows (show_name, category_id, show_time) values("celtics",1,'2017-01-02 19:30:00');
insert into shows (show_name, category_id, show_time) values("bruins",1,'2017-02-11 19:30:00');
insert into shows (show_name, category_id, show_time) values("bruce bernstein","2",'2017-01-02 19:30:00');
insert into shows (show_name, category_id, show_time) values("Jason Aldean ",2,'2017-01-02 19:30:00');
insert into shows (show_name, category_id, show_time) values("celtics",1,'2017-04-22 20:30:00');
insert into shows (show_name, category_id, show_time) values("Trevor Noah",5,'2017-01-02 19:30:00');
insert into shows (show_name, category_id, show_time) values("blue man group",3,'2017-01-02 19:30:00');
insert into shows (show_name, category_id, show_time) values("Disney on ice",4,'2017-01-02 19:30:00');

create table exchange
(
   exchange_id int NOT NULL AUTO_INCREMENT,
   user_id varchar(100) NOT NULL,
   from_show_id int NOT NULL,
   to_show_id int NOT NULL,
   number_of_tickets int NOT NULL,
   PRIMARY KEY (exchange_id),
   FOREIGN KEY (from_show_id) REFERENCES admitone.shows (show_id),
   FOREIGN KEY (to_show_id) REFERENCES admitone.shows (show_id)
   
);

create table cancellation
(
   cancellation_id int NOT NULL AUTO_INCREMENT,
   user_id varchar(100) NOT NULL,
   show_id int NOT NULL,
   number_of_tickets int NOT NULL,
   exchange_id int,
   PRIMARY KEY (cancellation_id),
   FOREIGN KEY (exchange_id) REFERENCES admitone.exchange (exchange_id)
);

create table purchase
(
   purchase_id int NOT NULL AUTO_INCREMENT,
   user_id varchar(100) NOT NULL,
   show_id int NOT NULL,
   number_of_tickets int NOT NULL,
   cancellation_id int,
   PRIMARY KEY (purchase_id),
   FOREIGN KEY (cancellation_id) REFERENCES admitone.cancellation (cancellation_id)
);

insert into purchase (user_id, show_id, number_of_tickets, cancellation_id) values(1,2,4,null);
insert into purchase (user_id, show_id, number_of_tickets, cancellation_id) values(1,1,2,null);
insert into purchase (user_id, show_id, number_of_tickets, cancellation_id) values(2,5,5,null);
insert into purchase (user_id, show_id, number_of_tickets, cancellation_id) values(4,4,10,null);

