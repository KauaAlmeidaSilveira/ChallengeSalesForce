-- Kaua Almeida Silveira - RM 552618
-- Matheus Alexandre Benites Scotti - RM 553073
-- Mariana Spinola - RM 553476

DELETE FROM TB_CONTA;
DELETE FROM TB_ENDERECO;
DELETE FROM TB_EMPRESA;
DELETE FROM TB_PESSOA;
DELETE FROM TB_SERVICO;
DELETE FROM TB_SERVICO_CONTA;

--------------------- INSERTS ---------------------

-- INSERT TB_EMPRESA
INSERT INTO TB_EMPRESA (NOME, DEPARTAMENTO, DIVISAO, NUM_FUNCIONARIO, INICIO_JORNADA, FIM_JORNADA) VALUES
('Tech Solutions', 'TI', 'Desenvolvimento', '10 a 100', '08:00:00', '17:00:00');
INSERT INTO TB_EMPRESA (NOME, DEPARTAMENTO, DIVISAO, NUM_FUNCIONARIO, INICIO_JORNADA, FIM_JORNADA) VALUES
('Global HR', 'RH', 'Recrutamento', '10 a 50', '09:00:00', '18:00:00');
INSERT INTO TB_EMPRESA (NOME, DEPARTAMENTO, DIVISAO, NUM_FUNCIONARIO, INICIO_JORNADA, FIM_JORNADA) VALUES
('FinanceCorp', 'Financeiro', 'Contabilidade', '10 a 200', '08:30:00', '17:30:00');
INSERT INTO TB_EMPRESA (NOME, DEPARTAMENTO, DIVISAO, NUM_FUNCIONARIO, INICIO_JORNADA, FIM_JORNADA) VALUES
('MarketGenius', 'Marketing', 'Publicidade', '10 a 75', '10:00:00', '19:00:00');
INSERT INTO TB_EMPRESA (NOME, DEPARTAMENTO, DIVISAO, NUM_FUNCIONARIO, INICIO_JORNADA, FIM_JORNADA) VALUES
('LogiTrack', 'Operações', 'Logística', '10 a 150', '07:00:00', '16:00:00');

-- INSERT TB_ENDERECO
INSERT INTO TB_ENDERECO (RUA, CIDADE, ESTADO, CEP, PAIS) VALUES
('Rua das Flores, 123', 'São Paulo', 'SP', '01000-000', 'Brasil');
INSERT INTO TB_ENDERECO (RUA, CIDADE, ESTADO, CEP, PAIS) VALUES
('Avenida Paulista, 456', 'São Paulo', 'SP', '01310-100', 'Brasil');
INSERT INTO TB_ENDERECO (RUA, CIDADE, ESTADO, CEP, PAIS) VALUES
('Rua XV de Novembro, 789', 'Curitiba', 'PR', '80020-310', 'Brasil');
INSERT INTO TB_ENDERECO (RUA, CIDADE, ESTADO, CEP, PAIS) VALUES
('Avenida Rio Branco, 101', 'Rio de Janeiro', 'RJ', '20040-003', 'Brasil');
INSERT INTO TB_ENDERECO (RUA, CIDADE, ESTADO, CEP, PAIS) VALUES
('Rua Sete de Setembro, 202', 'Porto Alegre', 'RS', '90010-240', 'Brasil');

-- INSERT TB_PESSOA
INSERT INTO TB_PESSOA (NOME, SOBRENOME, APELIDO, TELEFONE, CELULAR, CARGO, RG, ID_ENDERECO, ID_EMPRESA) VALUES
('Teste', 'teste', 'testinho', '987654326', '19987654326', 'Analista de teste', '123456794', 1, 1);
INSERT INTO TB_PESSOA (NOME, SOBRENOME, APELIDO, TELEFONE, CELULAR, CARGO, RG, ID_ENDERECO, ID_EMPRESA) VALUES
('Luiza', 'Costa', 'Lu', '987654327', '19987654327', 'Gerente de RH', '123456795', 2, 2);
INSERT INTO TB_PESSOA (NOME, SOBRENOME, APELIDO, TELEFONE, CELULAR, CARGO, RG, ID_ENDERECO, ID_EMPRESA) VALUES
('Ricardo', 'Neves', 'Rick', '987654328', '19987654328', 'Auditor Financeiro', '123456796', 3, 3);
INSERT INTO TB_PESSOA (NOME, SOBRENOME, APELIDO, TELEFONE, CELULAR, CARGO, RG, ID_ENDERECO, ID_EMPRESA) VALUES
('Marina', 'Duarte', 'Mari', '987654329', '19987654329', 'Designer Gráfico', '123456797', 4, 4);
INSERT INTO TB_PESSOA (NOME, SOBRENOME, APELIDO, TELEFONE, CELULAR, CARGO, RG, ID_ENDERECO, ID_EMPRESA) VALUES
('Bruno', 'Lima', 'Bruninho', '987654330', '19987654330', 'Coordenador de Logística', '123456798', 5, 5);

-- INSERT TB_SERVICO
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Customer 360', 'Plataforma de gestão de relacionamento com o cliente.', 'CRM', 999.50, 'https://www.salesforce.com/content/dam/web/global/svg-icons/placeholder11.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('IA', 'Inteligência artificial para análise de dados e automação de processos.', 'IA', 1499.20, 'https://www.salesforce.com/content/dam/web/global/svg-icons/placeholder12.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Pequenas Empresas', 'Soluções personalizadas para pequenas empresas.', 'SMB', 799.60, 'https://www.salesforce.com/content/dam/web/global/svg-icons/product-smb-day.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Vendas', 'Ferramentas para gestão e automação de vendas.', 'CRM', 1199.30, 'https://www.salesforce.com/content/dam/web/global/svg-icons/sales-day.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Atendimento ao Cliente', 'Plataforma de atendimento ao cliente multicanal.', 'CRM', 999.80, 'https://www.salesforce.com/content/dam/web/global/svg-icons/service-day.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Marketing', 'Ferramentas para automação de marketing e análise de campanhas.', 'Marketing', 1299.70, 'https://www.salesforce.com/content/dam/web/global/svg-icons/marketing-day.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Commerce', 'Soluções para comércio eletrônico e gestão de lojas virtuais.', 'Commerce', 1499.30, 'https://www.salesforce.com/content/dam/web/global/svg-icons/commerce-day.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Data Cloud', 'Armazenamento e análise de grandes volumes de dados na nuvem.', 'Cloud', 1999.00, 'https://www.salesforce.com/content/dam/web/global/svg-icons/placeholder29.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Tableau', 'Plataforma de visualização e análise de dados.', 'Analytics', 1799.40, 'https://www.salesforce.com/content/dam/web/global/svg-icons/placeholder1.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Mulesoft', 'Integração de sistemas e APIs.', 'Integration', 1699.10, 'https://www.salesforce.com/content/dam/web/global/svg-icons/integration-day.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Slack', 'Ferramenta de comunicação empresarial.', 'Collaboration', 899.90, 'https://www.salesforce.com/content/dam/web/global/svg-icons/placeholder13.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Plataforma Einstein 1', 'Inteligência artificial para análise preditiva e recomendações.', 'AI', 1999.20, 'https://www.salesforce.com/content/dam/web/global/svg-icons/platform-day.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Sustentabilidade', 'Soluções para gestão de sustentabilidade empresarial.', 'Sustainability', 1599.10, 'https://www.salesforce.com/content/dam/web/global/icons/product/products-sustainability-day.svg');

-- INSERT TB_CONTA
INSERT INTO TB_CONTA (USUARIO, EMAIL, SENHA, STATUS, DATA_REGISTRO, ULTIMO_ACESSO, ID_PESSOA) 
VALUES ('Teste.teste', 'teste@gmail.com', '$2a$10$X0/hhoivbg79BRZQfbtAZOJ1hsVDXmpWa0zdjHA2sVtexoRdzNzWa', 'Ativo', SYSDATE, SYSTIMESTAMP, 1);

-- INSERT TB_SERVICO_CONTA
INSERT INTO TB_SERVICO_CONTA (ID_SERVICO, ID_CONTA, STATUS, DATA_INICIO, DATA_TERMINO) VALUES
(1, 1,'Ativo', TO_DATE('2024-05-20', 'YYYY-MM-DD'),  TO_DATE('2024-12-31', 'YYYY-MM-DD'));

INSERT INTO TB_SERVICO_CONTA (ID_SERVICO, ID_CONTA, STATUS, DATA_INICIO, DATA_TERMINO) VALUES
(2, 1,'Ativo', TO_DATE('2024-05-20', 'YYYY-MM-DD'),  TO_DATE('2024-12-31', 'YYYY-MM-DD'));

INSERT INTO TB_SERVICO_CONTA (ID_SERVICO, ID_CONTA, STATUS, DATA_INICIO, DATA_TERMINO) VALUES
(3, 1,'Ativo', TO_DATE('2024-05-20', 'YYYY-MM-DD'),  TO_DATE('2024-12-31', 'YYYY-MM-DD'));

--------------------- UPDATES ---------------------

UPDATE tb_pessoa
SET apelido = 'Silveira'
WHERE id_pessoa = 3;

UPDATE tb_servico
SET categoria = 'IA'
WHERE nome = 'Plataforma Einstein 1';

UPDATE tb_empresa
SET nome = 'Start Solução', departamento = 'TI'
where id_empresa = 5;

--------------------- DELETES ---------------------

DELETE tb_pessoa
WHERE id_pessoa = 2;

DELETE tb_endereco 
WHERE id_endereco = 2;

DELETE tb_empresa 
WHERE id_empresa = 2;

--------------------- RELATORIOS - CONSULTA DE DADOS ---------------------

// Ordenado pelo valor de forma decrescente
SELECT * 
FROM tb_servico tb
ORDER BY tb.valor DESC;

// Selecionando todos os servicos, trazendo
// apenas o nome e os valores arredondados
SELECT tb.nome, ROUND(tb.valor) as Valor_Arrendondado
FROM tb_servico tb;

// Contando cada serviço por categoria
SELECT tb.categoria, COUNT(*) as QUANTIDADE 
from tb_servico tb
GROUP BY tb.categoria;

// Selecionando todos os servicos, trazendo
// apenas o nome e os valores arredondados
// ordenando de forma decrescente
SELECT Nome_Servico, Valor_Arrendondado
FROM (
    SELECT tb.nome as Nome_Servico, ROUND(tb.valor) as Valor_Arrendondado
    FROM tb_servico tb
)
ORDER BY Valor_Arrendondado DESC;


// Selecionando todas as pessoas, trazendo
// seu nome e sobrenome, a rua onde moram
// e o nome da empresa em que trabalham
SELECT p.nome, p.sobrenome, end.rua, emp.nome as Nome_Empresa
FROM tb_pessoa p
INNER JOIN tb_endereco end
ON p.id_endereco = end.id_endereco
INNER JOIN tb_empresa emp
ON p.id_empresa = emp.id_empresa;


SELECT * FROM TB_CONTA;
DESC TB_CONTA;
SELECT * FROM TB_ENDERECO;
DESC TB_ENDERECO;
SELECT * FROM TB_EMPRESA;
DESC TB_EMPRESA;
SELECT * FROM TB_PESSOA;
DESC TB_PESSOA;
SELECT * FROM TB_SERVICO;
DESC TB_SERVICO;
SELECT * FROM TB_SERVICO_CONTA;
DESC TB_SERVICO_CONTA;







