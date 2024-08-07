DROP SEQUENCE cliente_sequence;
DROP TRIGGER tr_insert_id_cliente;
DROP TABLE cliente;

CREATE TABLE cliente (
  idCliente integer PRIMARY KEY NOT NULL,
  cpf varchar(12) NOT NULL,
  nome varchar(45) NOT NULL,
  telefone varchar(10) NOT NULL,
  dataNasc Date NOT NULL
);

CREATE SEQUENCE cliente_sequence START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER tr_insert_id_cliente
BEFORE INSERT ON CLIENTE FOR EACH ROW       
BEGIN
 
SELECT cliente_sequence.NEXTVAL
INTO :NEW.id
FROM DUAL;
END;
/

COMMIT;