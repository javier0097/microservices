-- Create user Marcelo Martins
insert into account_table (accountid, accountstate, avatarid, createddate) values(1, 'ACTIVATED', '111a', NOW());
insert into user_table (userid, email, password, usertype, createddate, accountid) values (2, 'm.martins@gmail.com', '1234', 'PERSON', NOW(), 1);
insert into person_table (firstname, lastname, personid) values ('Marcelo', 'Martins', 2);

-- -- Create user Henry Vaca
insert into account_table (accountid, accountstate, avatarid, createddate) values(3, 'ACTIVATED', '222b', NOW());
insert into user_table (userid, email, password, usertype, createddate, accountid) values (4, 'h.vaca@gmail.com', '1234', 'PERSON', NOW(), 3);
insert into person_table (firstname, lastname, personid) values ('Henry', 'Vaca', 4);
-- --
-- -- -- Create user Ramiro Vaca
insert into account_table (accountid, accountstate, avatarid, createddate) values(5, 'ACTIVATED', '333c', NOW());
insert into user_table (userid, email, password, usertype, createddate, accountid) values (6, 'r.vaca@gmail.com', '1234', 'PERSON', NOW(), 5);
insert into person_table (firstname, lastname, personid) values ('Ramiro', 'Vaca', 6);
--
-- -- -- Create user Ramiro Vaca 2
insert into account_table (accountid, accountstate, avatarid, createddate) values(7, 'ACTIVATED', '444d', NOW());
insert into user_table (userid, email, password, usertype, createddate, accountid) values (8, 'r.vaca2@gmail.com', '1234', 'PERSON', NOW(), 7);
insert into person_table (firstname, lastname, personid) values ('Ramiro', 'Vaca', 8);
