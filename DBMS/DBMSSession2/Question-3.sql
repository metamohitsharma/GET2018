USE storefront;

#Display Recent 50 Orders placed (Id, Order Date, Order Total).
SELECT *
FROM order_details
ORDER BY date_of_order DESC
LIMIT 50;
/*
+----------+---------------------------+-------------+---------------+------------+
| order_id | email                     | total_price | date_of_order | address_id |
+----------+---------------------------+-------------+---------------+------------+
|        1 | rsbhatra98@gmail.com      |       30000 | 2018-08-16    |          2 |
|        3 | chirag10march@gmail.com   |        1000 | 2018-07-01    |          5 |
|        2 | innovativemohit@gmail.com |       99400 | 2017-08-15    |          4 |
+----------+---------------------------+-------------+---------------+------------+
*/

#Display 10 most expensive Orders.
SELECT *
FROM order_details
ORDER BY total_price DESC
LIMIT 10;
/*
+----------+---------------------------+-------------+---------------+------------+
| order_id | email                     | total_price | date_of_order | address_id |
+----------+---------------------------+-------------+---------------+------------+
|        2 | innovativemohit@gmail.com |       99400 | 2017-08-15    |          4 |
|        1 | rsbhatra98@gmail.com      |       30000 | 2018-08-16    |          2 |
|        3 | chirag10march@gmail.com   |        1000 | 2018-07-01    |          5 |
+----------+---------------------------+-------------+---------------+------------+
*/

#Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.
SELECT * 
FROM order_details
WHERE date_of_order NOT BETWEEN DATE_SUB(NOW(), INTERVAL 10 DAY) AND NOW()
	AND order_id IN (SELECT order_id
					 FROM items_ordered
                     WHERE order_status = 'Not Shipped');
/*
+----------+-------------------------+-------------+---------------+------------+
| order_id | email                   | total_price | date_of_order | address_id |
+----------+-------------------------+-------------+---------------+------------+
|        3 | chirag10march@gmail.com |        1000 | 2018-07-01    |          5 |
+----------+-------------------------+-------------+---------------+------------+
*/

#Display list of shoppers which haven't ordered anything since last month.
SELECT user_name, email
FROM users
WHERE email NOT IN (SELECT email
					  FROM order_details
                      WHERE MONTH(date_of_order) < MONTH(CURDATE()) AND
							YEAR(date_of_order) <= YEAR(CURDATE()));
/*
+------------------+---------------------------+
| user_name        | email                     |
+------------------+---------------------------+
| mohit sharma     | innovativemohit@gmail.com |
| prakalpa rathore | prakalpa@gmail.com        |
| rahul jangid     | rs98@gmail.com            |
| rahul sharma     | rsbhatra98@gmail.com      |
| tanu mittal      | tanumittal@gmail.com      |
+------------------+---------------------------+
*/

#Display list of shopper along with orders placed by them in last 15 days.
SELECT u.user_name, u.email, i.order_id, i.product_id
FROM users u INNER JOIN order_details o INNER JOIN items_ordered i
ON u.email = o.email AND i.order_id = o.order_id
WHERE date_of_order BETWEEN DATE_SUB(NOW(), INTERVAL 15 DAY) AND NOW();
/*
+--------------+----------------------+----------+------------+
| user_name    | email                | order_id | product_id |
+--------------+----------------------+----------+------------+
| rahul sharma | rsbhatra98@gmail.com |        1 |          9 |
| rahul sharma | rsbhatra98@gmail.com |        1 |         12 |
+--------------+----------------------+----------+------------+
*/

#Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
SELECT product_name, product_id
FROM products
WHERE product_id IN (SELECT product_id
					 FROM items_ordered i
					 WHERE order_id = 2 AND
						order_status = 'Shipped'); 
/*
+----------------+------------+
| product_name   | product_id |
+----------------+------------+
| Redmi 3s Prime |          1 |
+----------------+------------+
*/

#Display list of order items along with order placed date which fall between Rs 2000 to Rs 5000 price.
SELECT product_name, product_id, date_of_order, price
FROM products, order_details
WHERE price BETWEEN 2000 AND 5000 AND
	(product_id, order_id) IN (SELECT product_id, order_id
				   FROM items_ordered);
/*
+--------------------+------------+---------------+-------+
| product_name       | product_id | date_of_order | price |
+--------------------+------------+---------------+-------+
| Timex Analog Watch |          9 | 2018-08-16    |  5000 |
+--------------------+------------+---------------+-------+
*/

#Update first 20 Order items status to “Shipped” which are placed today.
UPDATE items_ordered
SET order_status = 'Shipped'
WHERE order_id IN (SELECT order_id
				   FROM order_details
                   WHERE date_of_order = CURDATE());
SELECT * 
FROM items_ordered;
/*
+----------+------------+----------+-------+--------------+
| order_id | product_id | quantity | price | order_status |
+----------+------------+----------+-------+--------------+
|        1 |          9 |        2 | 10000 | Not Shipped  |
|        1 |         12 |        2 | 20000 | Shipped      |
|        2 |          1 |        1 |  9000 | Shipped      |
|        2 |          4 |        1 | 90400 | Cancelled    |
|        3 |          6 |        1 |   900 | Not Shipped  |
+----------+------------+----------+-------+--------------+
*/