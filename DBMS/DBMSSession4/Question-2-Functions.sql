USE storefront;

#Create a Stored procedure to retrieve average sales of each product in a month. Month and year will be input parameter to function.
DELIMITER $$
CREATE PROCEDURE average_sales (month INT, year INT)
        DETERMINISTIC
            BEGIN
                SELECT products.product_id, product_name, AVG(items_ordered.quantity)
                FROM products INNER JOIN items_ordered INNER JOIN order_details ON
                    products.product_id = items_ordered.product_id AND
                    order_details.order_id = items_ordered.order_id
                GROUP BY products.product_id;
            END$$


/*Create a stored procedure to retrieve table having order detail with status for a given period. 
Start date and end date will be input parameter. Put validation on input dates like start date is less than end date. 
If start date is greater than end date take first date of month as start date.*/
DELIMITER $$
CREATE PROCEDURE order_detail (start_date DATE, end_date DATE)
	DETERMINISTIC
		BEGIN
			IF start_date > end_date
				THEN SET start_date = CONCAT(DATE_FORMAT(end_date, '%Y-%m-'), '01');
			end if;
			SELECT order_details.order_id, product_id, quantity, price, order_status, date_of_order
            FROM order_details INNER JOIN items_ordered ON
				order_details.order_id = items_ordered.order_id
			WHERE date_of_order BETWEEN start_date AND end_date;
		END$$