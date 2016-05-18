CREATE DATABASE MovieManagerDB;

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP, INDEX 
           ON MovieManagerDB.*
           TO spq@'%'
           IDENTIFIED BY 'spq';

GRANT ALTER, SELECT,INSERT,UPDATE,DELETE,CREATE,DROP, INDEX
           ON MovieManagerDB.*
           TO spq@localhost
           IDENTIFIED BY 'spq';