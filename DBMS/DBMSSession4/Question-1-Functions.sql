USE storefront;

#Create a function to calculate number of orders in a month. Month and year will be input parameter to function.
DELIMITER $$
CREATE FUNCTION no_of_orders (month INT, year INT)
    RETURNS INT
        DETERMINISTIC
            BEGIN
                DECLARE no_of_orders int;
                SELECT COUNT(*) INTO no_of_orders
                FROM order_details
                WHERE MONTH(date_of_order) = month AND
                    YEAR(date_of_order) = year;
                RETURN(no_of_orders);
            END$$

#Create a function to return month in a year having maximum orders. Year will be input parameter.
DELIMITER $$
CREATE FUNCTION month_of_maximum_orders (year INT)
    RETURNS INT
        DETERMINISTIC
            BEGIN
                DECLARE month_of_max_orders int;
                SELECT MONTH(date_of_order) INTO month_of_max_orders
                FROM order_details
                WHERE YEAR(date_of_order) = year
                GROUP BY MONTH(date_of_order)
                ORDER BY MONTH(date_of_order) DESC
                LIMIT 1;
                RETURN(month_of_max_orders);
            END$$
