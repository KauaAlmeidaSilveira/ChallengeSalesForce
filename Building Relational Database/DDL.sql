DROP TABLE TB_CONTA;
DROP TABLE TB_PESSOA;
DROP TABLE TB_ENDERECO;
DROP TABLE TB_EMPRESA;
DROP TABLE TB_SERVICO;
DROP TABLE TB_SERVICO_CONTA;
DROP TABLE TB_PEDIDO CASCADE CONSTRAINTS;
DROP TABLE TB_PAGAMENTO  CASCADE CONSTRAINTS;


---

CREATE TABLE TB_EMPRESA (
    ID_EMPRESA NUMBER GENERATED ALWAYS AS IDENTITY,
    NOME VARCHAR2(25) NOT NULL,
    DEPARTAMENTO VARCHAR2(15),
    DIVISAO VARCHAR2(15),
    NUM_FUNCIONARIO NUMBER,
    INICIO_JORNADA TIMESTAMP DEFAULT SYSDATE,
    FIM_JORNADA TIMESTAMP DEFAULT SYSDATE
);

ALTER TABLE TB_EMPRESA
ADD CONSTRAINT PK_TB_EMPRESA_ID_EMPRESA PRIMARY KEY (ID_EMPRESA);

---

CREATE TABLE TB_ENDERECO (
    ID_ENDERECO NUMBER GENERATED ALWAYS AS IDENTITY,
    RUA VARCHAR2(50) NOT NULL,
    CIDADE VARCHAR2(30) NOT NULL,
    ESTADO VARCHAR2(50) NOT NULL,
    CEP VARCHAR2(10) NOT NULL,
    PAIS VARCHAR2(50)
);

ALTER TABLE TB_ENDERECO
ADD CONSTRAINT PK_TB_ENDERECO PRIMARY KEY (ID_ENDERECO)

---

CREATE TABLE TB_PESSOA (
    ID_PESSOA NUMBER GENERATED ALWAYS AS IDENTITY,
    NOME VARCHAR2(50) NOT NULL,
    APELIDO VARCHAR2(30),
    TELEFONE VARCHAR2(9),
    CELULAR VARCHAR2(19) NOT NULL,
    CARGO VARCHAR2(30) NOT NULL,
    RG VARCHAR2(12) NOT NULL,
    ID_ENDERECO NUMBER NOT NULL,
    ID_EMPRESA NUMBER NOT NULL
);

ALTER TABLE TB_PESSOA
ADD CONSTRAINT PK_TB_PESSOA PRIMARY KEY (ID_PESSOA)

ALTER TABLE TB_PESSOA
ADD CONSTRAINT FK_TB_PESSOA_EMPRESA
FOREIGN KEY (ID_EMPRESA)
REFERENCES TB_EMPRESA(ID_EMPRESA)

ALTER TABLE TB_PESSOA
ADD CONSTRAINT FK_TB_PESSOA_ENDERECO
FOREIGN KEY (ID_ENDERECO)
REFERENCES TB_ENDERECO(ID_ENDERECO)

---

CREATE TABLE TB_CONTA (
    ID_CONTA NUMBER GENERATED ALWAYS AS IDENTITY,
    USUARIO VARCHAR2(50),
    EMAIL VARCHAR2(50) NOT NULL,
    SENHA VARCHAR2(12) NOT NULL,
    STATUS VARCHAR2(20) NOT NULL,
    DATA_REGISTRO DATE DEFAULT SYSDATE,
    ULTIMO_ACESSO DATE DEFAULT SYSDATE,
    ID_PESSOA NUMBER NOT NULL
);

ALTER TABLE TB_CONTA
ADD CONSTRAINT PK_TB_CONTA PRIMARY KEY (ID_CONTA)

ALTER TABLE TB_CONTA
ADD CONSTRAINT FK_TB_CONTA_PESS0A
FOREIGN KEY (ID_PESSOA)
REFERENCES TB_PESSOA(ID_PESSOA)

---

CREATE TABLE TB_SERVICO (
    ID_SERVICO NUMBER GENERATED ALWAYS AS IDENTITY,
    NOME VARCHAR2(50) NOT NULL,
    DESCRICAO VARCHAR2(255),
    CATEGORIA VARCHAR2(50) NOT NULL,
    VALOR NUMBER(10, 2) NOT NULL
);

ALTER TABLE TB_SERVICO
ADD CONSTRAINT PK_TB_SERVICO PRIMARY KEY (ID_SERVICO);

---

CREATE TABLE TB_SERVICO_CONTA (
    ID_SERVICO_CONTA NUMBER GENERATED ALWAYS AS IDENTITY,
    ID_SERVICO NUMBER NOT NULL,
    ID_CONTA NUMBER NOT NULL,
    STATUS VARCHAR2(20) NOT NULL,
    DATA_INICIO DATE DEFAULT SYSDATE NOT NULL,
    DATA_TERMINO DATE DEFAULT NULL
);

ALTER TABLE TB_SERVICO_CONTA
ADD CONSTRAINT PK_TB_SERVICO_CONTA PRIMARY KEY (ID_SERVICO_CONTA);

ALTER TABLE TB_SERVICO_CONTA
ADD CONSTRAINT FK_TB_SERVICO_CONTA_SERVICO
FOREIGN KEY (ID_SERVICO)
REFERENCES TB_SERVICO(ID_SERVICO)

ALTER TABLE TB_SERVICO_CONTA
ADD CONSTRAINT FK_TB_SERVICO_CONTA_CONTA
FOREIGN KEY (ID_CONTA)
REFERENCES TB_CONTA(ID_CONTA)

---


CREATE TABLE TB_PEDIDO (
    ID_PEDIDO NUMBER GENERATED ALWAYS AS IDENTITY,
    ID_CONTA NUMBER,
    ID_PAGAMENTO NUMBER,
    ID_SERVICO NUMBER,
    DATA_PEDIDO DATE DEFAULT SYSDATE NOT NULL
);

ALTER TABLE TB_PEDIDO
ADD CONSTRAINT PK_TB_PEDIDO PRIMARY KEY (ID_PEDIDO);

ALTER TABLE TB_PEDIDO
ADD CONSTRAINT FK_TB_PEDIDO_CONTA
FOREIGN KEY (ID_CONTA)
REFERENCES TB_CONTA(ID_CONTA)

ALTER TABLE TB_PEDIDO
ADD CONSTRAINT FK_TB_PEDIDO_PAGAMENTO
FOREIGN KEY (ID_PAGAMENTO)
REFERENCES TB_PAGAMENTO(ID_PAGAMENTO)

ALTER TABLE TB_PEDIDO
ADD CONSTRAINT FK_TB_PEDIDO_SERVICO
FOREIGN KEY (ID_SERVICO)
REFERENCES TB_SERVICO(ID_SERVICO);

---

CREATE TABLE TB_PAGAMENTO (
    ID_PAGAMENTO NUMBER GENERATED ALWAYS AS IDENTITY,
    DATA_PAGAMENTO DATE DEFAULT SYSDATE NOT NULL,
    VALOR_TOTAL NUMBER NOT NULL,
    FORMA_PAGAMENTO VARCHAR2(20) NOT NULL,
    PARCELAS NUMBER NOT NULL,
    VALOR_PARCELAS NUMBER NOT NULL,
    DESCRICAO VARCHAR2(255) NOT NULL,
    STATUS VARCHAR2(20) NOT NULL
);

ALTER TABLE TB_PAGAMENTO
ADD CONSTRAINT PK_TB_PAGAMENTO PRIMARY KEY (ID_PAGAMENTO);

---
    
SELECT * FROM TB_PESSOA;
SELECT * FROM TB_CONTA;
SELECT * FROM TB_SERVICO;
SELECT * FROM TB_SERVICO_CONTA;
SELECT * FROM TB_PEDIDO;
SELECT * FROM TB_PAGAMENTO;




