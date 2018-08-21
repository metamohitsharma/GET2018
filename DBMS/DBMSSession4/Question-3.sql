USE storefront;

#Identify the columns require indexing in order, product, category tables and create indexes.
ALTER TABLE categories ADD INDEX index_parent_id(parent_id);
ALTER TABLE categorylink ADD INDEX index_category_id(category_id);
ALTER TABLE categorylink ADD INDEX index_product_id(product_id);
ALTER TABLE order_details ADD INDEX index_date_of_order(date_of_order);
ALTER TABLE order_details ADD INDEX index_email(email);
ALTER TABLE items_ordered ADD INDEX index_order_id(order_id);
ALTER TABLE items_ordered ADD INDEX index_items_product_id(product_id);
ALTER TABLE items_ordered ADD INDEX index_order_status(order_status);