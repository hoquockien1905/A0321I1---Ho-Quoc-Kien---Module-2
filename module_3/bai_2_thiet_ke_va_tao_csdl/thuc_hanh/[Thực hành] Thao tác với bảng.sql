USE classicmodels;
CREATE TABLE contacts (
	contact_id INT NOT NULL AUTO_INCREMENT,
	last_name VARCHAR(30) NOT NULL,
    first_name VARCHAR(25),
    birthday DATE,
    CONSTRAINT contacts_pk PRIMARY KEY (contact_id)
);

CREATE TABLE suppliers (
	suppliers_id INT NOT NULL AUTO_INCREMENT,
    suppliers_name VARCHAR(50) NOT NULL,
    account_rep VARCHAR(30) NOT NULL DEFAULT "TDB",
    CONSTRAINT suppliers_pk PRIMARY KEY (suppliers_id)
);

DROP TABLE contacts, suppliers;

ALTER TABLE contacts
	ADD address INT NOT NULL
		FIRST;
        
ALTER TABLE contacts
	MODIFY address VARCHAR(50) NOT NULL
		FIRST;
        
ALTER TABLE contacts 
	DROP COLUMN age;
    
ALTER TABLE contacts
	CHANGE COLUMN address city VARCHAR(30);
    
ALTER TABLE contacts
	RENAME TO link;
    
ALTER TABLE link
	RENAME TO contacts;










