CREATE DATABASE category_advertisement;
USE category_advertisement;
CREATE TABLE category (
                    category_id INT AUTO_INCREMENT, 
                    name VARCHAR(50) NOT NULL UNIQUE,
                    PRIMARY KEY(category_id)
                    );
CREATE TABLE advertisement (
                    advertisement_id INT AUTO_INCREMENT,
                    title VARCHAR(50) NOT NULL,
                    description VARCHAR(200),
                    category_id int NOT NULL,
                    PRIMARY KEY(advertisement_id),
                    FOREIGN KEY(category_id) REFERENCES category(category_id)
                    );
                    
        

