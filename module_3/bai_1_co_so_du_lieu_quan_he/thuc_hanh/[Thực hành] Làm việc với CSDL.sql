SELECT * 
FROM classicmodels.customers
WHERE customerName = "Atelier graphique"
LIMIT 0,30;

SELECT * 
FROM classicmodels.customers
WHERE customerName LIKE "%A%"
LIMIT 0,30;

SELECT *
FROM classicmodels.customers
WHERE city
IN (
	"Nantes", "Las Vegas", "Warszawa", "NYC"
)
LIMIT 0,30;