USE sales_management;

SELECT customers.id, customer_name, phone, payment_date, amount
FROM customers
INNER JOIN payments ON customers.id = payments.customer_id
WHERE address_id = 1;

SELECT customers.id, customer_name, orders.id AS order_id, orders.status
FROM customers
LEFT JOIN orders ON customers.id = orders.customer_id;

SELECT customers.id, customer_name, orders.id AS order_id, orders.status
FROM customers
LEFT JOIN orders ON customers.id = orders.customer_id
WHERE orders.id IS NULL;