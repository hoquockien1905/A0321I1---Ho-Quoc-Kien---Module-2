USE sales_management;

SELECT status 
FROM orders
GROUP BY status;

SELECT status, COUNT(*) AS quantity_status
FROM orders
GROUP BY status;

SELECT status, SUM(orders.quantity_order * orders.price_each) AS amount
FROM orders
INNER JOIN order_detail ON orders.id = order_detail.order_id
GROUP BY status;

SELECT orders.id AS order_id, SUM(orders.quantity_order * orders.price_each) AS total
FROM order_detail, orders
GROUP BY orders.id;

SELECT year(order_date) AS year, SUM(quantity_order * price_each) AS total
FROM orders
INNER JOIN order_detail ON orders.id = order_detail.order_id
WHERE status = ""
GROUP BY year HAVING year > 2003;



