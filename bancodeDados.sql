CREATE TABLE gastos (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    valor NUMERIC(10, 2) NOT NULL,
    categoria VARCHAR(100) NOT NULL
);
