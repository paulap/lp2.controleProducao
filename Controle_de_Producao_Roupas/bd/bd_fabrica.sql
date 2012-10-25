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


INSERT INTO materiaPrima(nome, valor, unidade, quantidade, quantMin) VALUES ('Botões Vintage', 0.40, 'unidade', 80, 10);
INSERT INTO materiaPrima(nome, valor, unidade, quantidade, quantMin) VALUES ('Botões de Coração', 0.20, 'unidade', 40, 10);
INSERT INTO materiaPrima(nome, valor, unidade, quantidade, quantMin) VALUES ('Tecido Tricoline Preto', 20, 'metro', 100, 5);
INSERT INTO materiaPrima(nome, valor, unidade, quantidade, quantMin) VALUES ('Tecido Tricoline Bicicleta Vintage', 25, 'metro', 100, 5);
INSERT INTO materiaPrima(nome, valor, unidade, quantidade, quantMin) VALUES ('Zíper Invisivel Preto', 2, 'unidade', 50, 10);

INSERT INTO produtoPronto(nome, valor, quantidade, quantMin) VALUES ('Vestido Preto', 100, 300, 100);
INSERT INTO produtoPronto(nome, valor, quantidade, quantMin) VALUES ('Vestido Estapa Bicicleta', 120, 250, 50);
INSERT INTO produtoPronto(nome, valor, quantidade, quantMin) VALUES ('Camisa Botão Coração', 80, 80, 30);
INSERT INTO produtoPronto(nome, valor, quantidade, quantMin) VALUES ('Saia Vintage', 70, 100, 40);
INSERT INTO produtoPronto(nome, valor, quantidade, quantMin) VALUES ('Casaco Preto', 200, 300, 100);

INSERT INTO materiaProduto(codProdutoPronto, codMateriaPrima, quantidade) VALUES (1, 3, 2);
INSERT INTO materiaProduto(codProdutoPronto, codMateriaPrima, quantidade) VALUES (2, 4, 2);
INSERT INTO materiaProduto(codProdutoPronto, codMateriaPrima, quantidade) VALUES (2, 5, 1);
INSERT INTO materiaProduto(codProdutoPronto, codMateriaPrima, quantidade) VALUES (3, 2, 10);
INSERT INTO materiaProduto(codProdutoPronto, codMateriaPrima, quantidade) VALUES (4, 1, 5);

CREATE OR REPLACE FUNCTION fProducao(integer, integer)
  RETURNS integer AS
$BODY$
		DECLARE 
			matProd CURSOR FOR SELECT * FROM materiaProduto where codProdutoPronto = $1;
			cont INTEGER;
			status INTEGER;
			reg RECORD;
			ok boolean;
		BEGIN
			ok = true;
			cont = (select COUNT(*) from produtoPronto where codProdutoPronto = $1);
			if(cont > 0) then

				OPEN matProd;
				loop
					FETCH NEXT IN matProd INTO reg;
					EXIT WHEN NOT FOUND or ok = false;

					cont = (select quantidade from materiaPrima where codMateriaPrima = reg.codMateriaPrima);
					if((reg.quantidade * $2) <= cont) then
						status = 1;
					else
						status = 0;
						ok = false;
						RAISE NOTICE 'Materia Prima em falta  materia[%]	precisa[%]	tem[%]', reg.codMateriaPrima, reg.quantidade * $2, cont;
					end if;
				end loop;
				CLOSE matProd;

				if(ok = true) then
					
					OPEN matProd;
					loop
						FETCH NEXT IN matProd INTO reg;
						EXIT WHEN NOT FOUND;
						update materiaPrima set quantidade = quantidade - reg.quantidade * $2 where codMateriaPrima = reg.codMateriaPrima;
						update produtoPronto set quantidade = quantidade + $2 where codProdutoPronto = $1;
					end loop;
					CLOSE matProd;

					RAISE NOTICE 'Produto produzido';
				end if;
			ELSE 
				status = 0;
				RAISE NOTICE 'Produto não cadastrado';
			ENd if;
			Return status;
		END;
	$BODY$
  LANGUAGE plpgsql

--select fProducao(1, 1);

--postgres@localhost:5432 