CREATE TABLE wallet (
user_id BIGINT PRIMARY KEY,
usdt_balance DOUBLE NOT NULL,
btc_balance DOUBLE NOT NULL,
eth_balance DOUBLE NOT NULL
);

INSERT INTO wallet (user_id, usdt_balance, btc_balance, eth_balance)
VALUES (1, 50000.0, 0.0, 0.0);