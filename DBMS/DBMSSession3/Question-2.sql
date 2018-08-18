USE storefront;

#Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
SELECT products.product_id, products.product_name, COUNT(categorylink.category_id) count_of_categories
FROM products INNER JOIN categorylink ON
    products.product_id = categorylink.product_id
GROUP BY categorylink.product_id
HAVING COUNT(categorylink.category_id) > 1;
/*
+------------+----------------+---------------------+
| product_id | product_name   | count_of_categories |
+------------+----------------+---------------------+
|          1 | Redmi 3s Prime |                   2 |
|          2 | Redmi Note 4   |                   2 |
+------------+----------------+---------------------+
*/


#Display Count of products as per below price range 0-1000,1001-5000,Above 5000
SELECT price_range, count(*) no_of_products
FROM (SELECT CASE
                WHEN price >= 0 AND price <= 1000 THEN '0-1000'
                WHEN price >= 1001 AND price <= 5000 THEN '1001-5000'
                ELSE 'Above 5000'
            END as price_range
      FROM products) as count_of_products
GROUP BY price_range;
/*
+-------------+----------------+
| price_range | no_of_products |
+-------------+----------------+
| Above 5000  |              6 |
| 0-1000      |              1 |
| 1001-5000   |              5 |
+-------------+----------------+
*/

#Display the Categories along with number of products under each category.
SELECT category_name, categories.category_id, COUNT(product_id) no_of_products
FROM categories INNER JOIN categorylink ON
	categories.category_id = categorylink.category_id
GROUP BY categories.category_id;
/*
+-----------------+-------------+----------------+
| category_name   | category_id | no_of_products |
+-----------------+-------------+----------------+
| Electronics     |           1 |              7 |
| Accessories     |           2 |              2 |
| Fashion Styling |           3 |              3 |
| Mobile          |           4 |              2 |
| Laptop          |           5 |              3 |
| USB             |           6 |              2 |
| Redmi           |           7 |              2 |
| Xiaomi          |           8 |              2 |
| Dell            |           9 |              2 |
| Sony            |          10 |              1 |
| Kingston        |          11 |              1 |
| HP              |          12 |              1 |
| Watch           |          13 |              2 |
| Fastrack        |          14 |              1 |
| Timex           |          15 |              1 |
| Shirt           |          16 |              1 |
| Trouser         |          17 |              1 |
| Suit            |          18 |              1 |
| Van Heusen      |          19 |              1 |
| Van Heusen      |          20 |              1 |
| Peter England   |          21 |              1 |
+-----------------+-------------+----------------+
*/