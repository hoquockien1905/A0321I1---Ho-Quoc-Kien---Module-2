SELECT * FROM classicmodels.customers;
SELECT customerName, phone, city, country FROM classicmodels.customers;

SELECT * FROM classicmodels.customers WHERE customerName = 'Atelier Graphique';

SELECT * FROM classicmodels.customers WHERE customername LIKE '%A%';

SELECT * FROM classicmodels.customers WHERE city IN ('Nantes',' Las Vegas',' Warszawa','NYC');