DROP TABLE IF EXISTS options, cars, completions, completionsoptions, models, customers, orders CASCADE;

DROP EXTENSION IF EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE customers
(
	id UUID DEFAULT uuid_generate_v4 (),
  	firstname TEXT NOT NULL,
  	middlename TEXT NOT NULL,
  	lastname TEXT NOT NULL,
  	PRIMARY KEY (id)
);

CREATE TABLE options
(
  	id UUID DEFAULT uuid_generate_v4 (),
  	name TEXT NOT NULL UNIQUE,
  	PRIMARY KEY (id)
);

CREATE TABLE completions
(
  	id UUID DEFAULT uuid_generate_v4 (),
  	name TEXT NOT NULL UNIQUE,
  	PRIMARY KEY (id)
);

CREATE TABLE completionsoptions
(
  	idcompletion UUID,
  	idoption UUID,
  	FOREIGN KEY (idcompletion) REFERENCES completions (id) ON DELETE CASCADE,
  	FOREIGN KEY (idoption) REFERENCES options (id) ON DELETE CASCADE,
  	PRIMARY KEY (idcompletion, idoption)
);

CREATE TABLE models 
(
	id UUID DEFAULT uuid_generate_v4 (),
	name TEXT NOT NULL,
  	idcompletion UUID,
  	PRIMARY KEY (id),
  	FOREIGN KEY (idcompletion) REFERENCES completions (id) ON DELETE CASCADE
);

CREATE TABLE cars
(
	id UUID DEFAULT uuid_generate_v4 (),
  	vin TEXT NOT NULL UNIQUE,
  	idmodel UUID,
  	PRIMARY KEY (id),
  	FOREIGN KEY (idmodel) REFERENCES models (id) ON DELETE CASCADE
);

CREATE TABLE orders
(
	id UUID DEFAULT uuid_generate_v4 (),
  	number INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
  	idcustomer UUID,
  	idcar UUID,
  	PRIMARY KEY (id),
  	FOREIGN KEY (idcustomer) REFERENCES customers (id) ON DELETE CASCADE,
  	FOREIGN KEY (idcar) REFERENCES cars (id) ON DELETE CASCADE
);