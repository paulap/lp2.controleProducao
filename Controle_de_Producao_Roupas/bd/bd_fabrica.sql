CREATE TABLE materiaPrima(
	codMateriaPrima SERIAL PRIMARY KEY,
	nome VARCHAR(40),
	valor MONEY,
	unidade VARCHAR(10),
	quantidade INTEGER,
	quantMin INTEGER
);

CREATE TABLE produtoPronto(
	codProdutoPronto SERIAL PRIMARY KEY,
	nome VARCHAR(40),
	valor MONEY,
	quantidade INTEGER,
	quantMin INTEGER
);

CREATE TABLE materiaProduto(
	codProdutoPronto INTEGER REFERENCES produtoPronto,
	codMateriaPrima INTEGER REFERENCES materiaPrima,
	quantidade INTEGER,
	PRIMARY KEY (codProdutoPronto, codMateriaPrima)
);
