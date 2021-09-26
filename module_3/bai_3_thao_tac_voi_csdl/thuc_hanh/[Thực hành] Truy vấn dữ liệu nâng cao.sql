USE sales_management;
SELECT id, product_name, quantity_in_stock, buy_price 
FROM products
WHERE buy_price > 56.76 AND quantity_in_stock > 10;

SELECT products.id, product_name, quantity_in_stock, buy_price
FROM products
INNER JOIN product_line ON products.product_line_id = product_line.id
WHERE buy_price > 56.76 AND buy_price < 95.59;

SELECT products.id, product_name, quantity_in_stock, product_ventor, product_line.decription
FROM products, product_line
WHERE product_line.decription = "bb" OR product_ventor = "Germany";