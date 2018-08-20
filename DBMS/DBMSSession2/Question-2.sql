USE storefront;

#Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.
SELECT 	products.product_id, product_name, category_name, price 
FROM products, categories, categorylink 
WHERE products.product_id = categorylink.product_id 
	AND categories.category_id = categorylink.category_id
ORDER BY product_issue_date;
/*
+------------+------------------------------+---------------+-------+
| product_id | product_name                 | category_name | price |
+------------+------------------------------+---------------+-------+
|         12 | Peter England Suit           | Peter England | 10000 |
|         11 | Van Heusen Trouser           | Van Heusen    |  2000 |
|          1 | Redmi 3s Prime               | Redmi         |  9000 |
|          1 | Redmi 3s Prime               | Xiaomi        |  9000 |
|          8 | Fastrack Digital Watch 4hy7e | Fastrack      |  2000 |
|          6 | Kingston 16GB                | Kingston      |   900 |
|          4 | Sony Vostro Glide            | Sony          | 90400 |
|          2 | Redmi Note 4                 | Redmi         | 12500 |
|          2 | Redmi Note 4                 | Xiaomi        | 12500 |
|          5 | Dell Inspiron 5Ti3fa         | Dell          | 50000 |
|         10 | Van Heusen Shirt             | Van Heusen    |  1500 |
|          9 | Timex Analog Watch           | Timex         |  5000 |
|          3 | Dell Inspiron 4Ti6xy         | Dell          | 40000 |
|          7 | HP 64Gb                      | HP            |  2000 |
+------------+------------------------------+---------------+-------+
*/

#Display the list of products which don't have any images.
SELECT DISTINCT products.product_id, product_name, quantity, price 
FROM products 
WHERE NOT EXISTS (SELECT images.product_id 
                FROM images 
                  WHERE images.product_id = products.product_id);
/*
+------------+--------------------+----------+-------+
| product_id | product_name       | quantity | price |
+------------+--------------------+----------+-------+
|          2 | Redmi Note 4       |       50 | 12500 |
|          9 | Timex Analog Watch |       10 |  5000 |
|         11 | Van Heusen Trouser |       20 |  2000 |
+------------+--------------------+----------+-------+
*/

/*
Display all Id, Title and Parent Category Title for all the Categories listed,
sorted by Parent Category Title and then Category Title. 
(If Category is top category then Parent Category Title column should display “Top Category” as value.)
*/
SELECT child.category_id, child.category_name, 
IFNULL(parent.category_name, 'Top Category') as parent_name
FROM categories child LEFT JOIN categories parent
	ON child.parent_id = parent.category_id
ORDER BY parent_name, child.category_name;
/*
+-------------+-----------------+-----------------+
| category_id | category_name   | parent_name     |
+-------------+-----------------+-----------------+
|          13 | Watch           | Accessories     |
|           5 | Laptop          | Electronics     |
|           4 | Mobile          | Electronics     |
|           6 | USB             | Electronics     |
|          16 | Shirt           | Fashion Styling |
|          18 | Suit            | Fashion Styling |
|          17 | Trouser         | Fashion Styling |
|           9 | Dell            | Laptop          |
|          10 | Sony            | Laptop          |
|           7 | Redmi           | Mobile          |
|           8 | Xiaomi          | Mobile          |
|          19 | Van Heusen      | Shirt           |
|          21 | Peter England   | Suit            |
|           2 | Accessories     | Top Category    |
|           1 | Electronics     | Top Category    |
|           3 | Fashion Styling | Top Category    |
|          20 | Van Heusen      | Trouser         |
|          12 | HP              | USB             |
|          11 | Kingston        | USB             |
|          14 | Fastrack        | Watch           |
|          15 | Timex           | Watch           |
+-------------+-----------------+-----------------+
*/

/*
Display Id, Title, Parent Category Title of all the leaf Categories 
(categories which are not parent of any other category)
*/
SELECT leaf.category_id, leaf.category_name, parent.category_name as parent_category_name
FROM categories leaf, categories parent
WHERE parent.category_id = leaf.parent_id AND 
	NOT EXISTS(SELECT * 
			   FROM categories child 
			   WHERE leaf.category_id = child.parent_id);
/*
+-------------+---------------+----------------------+
| category_id | category_name | parent_category_name |
+-------------+---------------+----------------------+
|           7 | Redmi         | Mobile               |
|           8 | Xiaomi        | Mobile               |
|           9 | Dell          | Laptop               |
|          10 | Sony          | Laptop               |
|          11 | Kingston      | USB                  |
|          12 | HP            | USB                  |
|          14 | Fastrack      | Watch                |
|          15 | Timex         | Watch                |
|          19 | Van Heusen    | Shirt                |
|          20 | Van Heusen    | Trouser              |
|          21 | Peter England | Suit                 |
+-------------+---------------+----------------------+
*/

#Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
SELECT product_name, price, category_name
FROM products, categories, categorylink
WHERE products.product_id = categorylink.product_id 
	AND categories.category_id = categorylink.category_id;
/*
+------------------------------+-------+---------------+
| product_name                 | price | category_name |
+------------------------------+-------+---------------+
| Redmi 3s Prime               |  9000 | Redmi         |
| Redmi 3s Prime               |  9000 | Xiaomi        |
| Redmi Note 4                 | 12500 | Redmi         |
| Redmi Note 4                 | 12500 | Xiaomi        |
| Dell Inspiron 4Ti6xy         | 40000 | Dell          |
| Sony Vostro Glide            | 90400 | Sony          |
| Dell Inspiron 5Ti3fa         | 50000 | Dell          |
| Kingston 16GB                |   900 | Kingston      |
| HP 64Gb                      |  2000 | HP            |
| Fastrack Digital Watch 4hy7e |  2000 | Fastrack      |
| Timex Analog Watch           |  5000 | Timex         |
| Van Heusen Shirt             |  1500 | Van Heusen    |
| Van Heusen Trouser           |  2000 | Van Heusen    |
| Peter England Suit           | 10000 | Peter England |
+------------------------------+-------+---------------+
*/

#Display the list of Products whose Quantity on hand (Inventory) is under 50.
SELECT product_id, product_name, quantity, price 
FROM products 
WHERE quantity < 50;
/*
+------------+------------------------------+----------+-------+
| product_id | product_name                 | quantity | price |
+------------+------------------------------+----------+-------+
|          1 | Redmi 3s Prime               |       10 |  9000 |
|          3 | Dell Inspiron 4Ti6xy         |       25 | 40000 |
|          4 | Sony Vostro Glide            |       35 | 90400 |
|          5 | Dell Inspiron 5Ti3fa         |        5 | 50000 |
|          7 | HP 64Gb                      |       10 |  2000 |
|          8 | Fastrack Digital Watch 4hy7e |       30 |  2000 |
|          9 | Timex Analog Watch           |       10 |  5000 |
|         10 | Van Heusen Shirt             |       20 |  1500 |
|         11 | Van Heusen Trouser           |       20 |  2000 |
|         12 | Peter England Suit           |       15 | 10000 |
+------------+------------------------------+----------+-------+
*/

#Increase the Inventory of all the products by 100.
UPDATE products 
SET quantity = quantity + 100 ;

SELECT * 
FROM products;
/*
+------------+------------------------------+----------+-------+--------------------+
| product_id | product_name                 | quantity | price | product_issue_date |
+------------+------------------------------+----------+-------+--------------------+
|          1 | Redmi 3s Prime               |      110 |  9000 | 2016-07-01         |
|          2 | Redmi Note 4                 |      150 | 12500 | 2017-08-01         |
|          3 | Dell Inspiron 4Ti6xy         |      125 | 40000 | 2018-07-01         |
|          4 | Sony Vostro Glide            |      135 | 90400 | 2017-01-01         |
|          5 | Dell Inspiron 5Ti3fa         |      105 | 50000 | 2017-09-23         |
|          6 | Kingston 16GB                |      200 |   900 | 2016-12-12         |
|          7 | HP 64Gb                      |      110 |  2000 | 2018-08-01         |
|          8 | Fastrack Digital Watch 4hy7e |      130 |  2000 | 2016-12-01         |
|          9 | Timex Analog Watch           |      110 |  5000 | 2018-01-01         |
|         10 | Van Heusen Shirt             |      120 |  1500 | 2017-11-11         |
|         11 | Van Heusen Trouser           |      120 |  2000 | 2016-07-01         |
|         12 | Peter England Suit           |      115 | 10000 | 2014-02-12         |
+------------+------------------------------+----------+-------+--------------------+
*/