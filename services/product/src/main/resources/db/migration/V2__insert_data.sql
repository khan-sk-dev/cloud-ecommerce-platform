-- Create product table
create table if not exists product
(
    id integer not null primary key,
    description varchar(255),
    name varchar(255),  -- Fixed: added comma here!
    available_quantity double precision not null,
    price numeric(38, 2),
    category_id integer
        constraint fk1lasdaladkhj references category
);

-- Create a sequence for product IDs, if using sequences
create sequence if not exists product_seq increment by 50;

-- Insert demo data into product
INSERT INTO product (id, description, name, available_quantity, price, category_id) VALUES
    (1, 'Smartphone with 128GB storage', 'Smartphone X', 25, 799.99, 1),
    (2, 'Wireless noise-cancelling headphones', 'Headphones Pro', 10, 199.99, 1),
    (3, 'Best-selling science fiction novel', 'Galactic Adventures', 50, 14.99, 2),
    (4, 'Cotton crew neck t-shirt', 'T-shirt Comfort', 100, 9.99, 3),
    (5, 'Organic whole grain bread', 'Whole Grain Bread', 40, 3.49, 4),
    (6, 'Building blocks set (100 pieces)', 'Mega Blocks', 30, 24.99, 5),
    (7, 'Bluetooth Fitness Tracker', 'FitTrack', 18, 59.99, 1),
    (8, 'Fantasy epic paperback', 'Dragons of Dawn', 60, 12.50, 2),
    (9, 'Kids wearable raincoat', 'Raincoat Jr.', 20, 19.95, 3),
    (10, 'Bag of organic apples', 'Apples (1kg)', 35, 4.20, 4);