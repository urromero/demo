DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

INSERT INTO customers (name) VALUES
  ('Aliko'),
  ('Bill'),
  ('Folrunsho');