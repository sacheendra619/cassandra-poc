for opening into terminal this shell..
find cassandra installation path by command which cassandra
and then run cqlsh
//On Terminal
/usr/local/bin/cqlsh
//then run CQL commands, learn more here
//create keyspace needed for running the sample
CREATE KEYSPACE mykeyspace WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };
USE mykeyspace;
//CRUD operations

CREATE TABLE people ( id INT PRIMARY KEY, fullname TEXT, age INT );
INSERT INTO people (id, fullname, age) VALUES (1, 'Sacheendra Singh', 30);
SELECT * FROM people WHERE id = 1;
UPDATE people SET fullname = 'Sacheendra Mohan Singh' where id = 1;
DELETE FROM people WHERE id = 1;
DROP KEYSPACE mykeyspace;