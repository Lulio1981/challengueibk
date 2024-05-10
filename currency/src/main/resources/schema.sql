CREATE TABLE IF NOT EXISTS change_currency (id SERIAL PRIMARY KEY, amount NUMBER(20,4),
change_amount NUMBER(20,4), currency_origin VARCHAR(255), fate_currency VARCHAR(255)
, exchange_rate NUMBER(20,4), rate_date VARCHAR(255), process_date TIMESTAMP);