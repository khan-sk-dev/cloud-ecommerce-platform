-- Create category table
create table if not exists category
(
    id integer not null primary key,
    description varchar(255),
    name varchar(255)
);

-- Create a sequence for category IDs, if using sequences
create sequence if not exists category_seq increment by 50;

-- Insert demo data into category
INSERT INTO category (id, description, name) VALUES
    (1, 'Devices for everyday use', 'Electronics'),
    (2, 'Reading material in various genres', 'Books'),
    (3, 'Wearable items', 'Clothing'),
    (4, 'Consumable food and drinks', 'Groceries'),
    (5, 'Toys and games for all ages', 'Toys');