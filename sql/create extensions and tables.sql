DROP TABLE IF EXISTS settings, cars, completions, completions_settings, layouts, customers, purchases, users CASCADE;

DROP EXTENSION IF EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE customers
(
    id          uuid NOT NULL DEFAULT uuid_generate_v4(),
    first_name  text NOT NULL,
    middle_name text NOT NULL,
    last_name   text NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE settings
(
    id           uuid NOT NULL DEFAULT uuid_generate_v4(),
    setting_name text NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (setting_name)
);

CREATE TABLE layouts
(
    id          uuid NOT NULL DEFAULT uuid_generate_v4(),
    layout_name text NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE completions
(
    id              uuid NOT NULL DEFAULT uuid_generate_v4(),
    completion_name text NOT NULL,
    layout_id       uuid,
    PRIMARY KEY (id),
    UNIQUE (completion_name),
    FOREIGN KEY (layout_id)
        REFERENCES layouts (id) MATCH SIMPLE
        ON UPDATE CASCADE
        NOT VALID
);

CREATE TABLE completions_settings
(
    completion_id uuid,
    setting_id    uuid,
    PRIMARY KEY (setting_id, completion_id),
    FOREIGN KEY (completion_id)
        REFERENCES completions (id) MATCH SIMPLE
        ON UPDATE CASCADE
        NOT VALID,
    FOREIGN KEY (setting_id)
        REFERENCES settings (id) MATCH SIMPLE
        ON UPDATE CASCADE
        NOT VALID
);

CREATE TABLE cars
(
    id        uuid NOT NULL DEFAULT uuid_generate_v4(),
    vin       text NOT NULL,
    layout_id uuid NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (vin),
    FOREIGN KEY (layout_id)
        REFERENCES layouts (id) MATCH SIMPLE
        ON UPDATE CASCADE
        NOT VALID
);

CREATE TABLE purchases
(
    id              uuid    NOT NULL DEFAULT uuid_generate_v4(),
    purchase_number integer NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    customer_id     uuid    NOT NULL,
    car_id          uuid    NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (purchase_number),
    FOREIGN KEY (customer_id)
        REFERENCES customers (id) MATCH SIMPLE
        ON UPDATE CASCADE
        NOT VALID,
    FOREIGN KEY (car_id)
        REFERENCES cars (id) MATCH SIMPLE
        ON UPDATE CASCADE
        NOT VALID
);

CREATE TABLE users
(
    id       UUID PRIMARY KEY    NOT NULL DEFAULT uuid_generate_v4(),
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL,
    roles    VARCHAR(255)        NOT NULL
);