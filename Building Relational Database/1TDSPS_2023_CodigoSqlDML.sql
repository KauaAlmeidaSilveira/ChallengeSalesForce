SELECT * FROM TB_CONTA;
DESC TB_CONTA;
SELECT * FROM TB_ENDERECO;
DESC TB_ENDERECO;
SELECT * FROM TB_EMPRESA;
DESC TB_EMPRESA;
SELECT * FROM TB_PAGAMENTO;
DESC TB_PAGAMENTO;
SELECT * FROM TB_PEDIDO;
DESC TB_PEDIDO;
SELECT * FROM TB_PESSOA;
DESC TB_PESSOA;
SELECT * FROM TB_SERVICO;
DESC TB_SERVICO;
SELECT * FROM TB_SERVICO_CONTA;
DESC TB_SERVICO_CONTA;



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
('LogiTrack', 'Opera��es', 'Log�stica', '10 a 150', '07:00:00', '16:00:00');

-- INSERT TB_ENDERECO
INSERT INTO TB_ENDERECO (RUA, CIDADE, ESTADO, CEP, PAIS) VALUES
('Rua das Flores, 123', 'S�o Paulo', 'SP', '01000-000', 'Brasil');
INSERT INTO TB_ENDERECO (RUA, CIDADE, ESTADO, CEP, PAIS) VALUES
('Avenida Paulista, 456', 'S�o Paulo', 'SP', '01310-100', 'Brasil');
INSERT INTO TB_ENDERECO (RUA, CIDADE, ESTADO, CEP, PAIS) VALUES
('Rua XV de Novembro, 789', 'Curitiba', 'PR', '80020-310', 'Brasil');
INSERT INTO TB_ENDERECO (RUA, CIDADE, ESTADO, CEP, PAIS) VALUES
('Avenida Rio Branco, 101', 'Rio de Janeiro', 'RJ', '20040-003', 'Brasil');
INSERT INTO TB_ENDERECO (RUA, CIDADE, ESTADO, CEP, PAIS) VALUES
('Rua Sete de Setembro, 202', 'Porto Alegre', 'RS', '90010-240', 'Brasil');

-- INSERT TB_PESSOA
INSERT INTO TB_PESSOA (NOME, SOBRENOME, APELIDO, TELEFONE, CELULAR, CARGO, RG, ID_ENDERECO, ID_EMPRESA) VALUES
('Fernando', 'Almeida', 'Nando', '987654326', '19987654326', 'Analista de Sistemas', '123456794', 1, 1);
INSERT INTO TB_PESSOA (NOME, SOBRENOME, APELIDO, TELEFONE, CELULAR, CARGO, RG, ID_ENDERECO, ID_EMPRESA) VALUES
('Luiza', 'Costa', 'Lu', '987654327', '19987654327', 'Gerente de RH', '123456795', 2, 2);
INSERT INTO TB_PESSOA (NOME, SOBRENOME, APELIDO, TELEFONE, CELULAR, CARGO, RG, ID_ENDERECO, ID_EMPRESA) VALUES
('Ricardo', 'Neves', 'Rick', '987654328', '19987654328', 'Auditor Financeiro', '123456796', 3, 3);
INSERT INTO TB_PESSOA (NOME, SOBRENOME, APELIDO, TELEFONE, CELULAR, CARGO, RG, ID_ENDERECO, ID_EMPRESA) VALUES
('Marina', 'Duarte', 'Mari', '987654329', '19987654329', 'Designer Gr�fico', '123456797', 4, 4);
INSERT INTO TB_PESSOA (NOME, SOBRENOME, APELIDO, TELEFONE, CELULAR, CARGO, RG, ID_ENDERECO, ID_EMPRESA) VALUES
('Bruno', 'Lima', 'Bruninho', '987654330', '19987654330', 'Coordenador de Log�stica', '123456798', 5, 5);

-- INSERT TB_PAGAMENTO
INSERT INTO TB_PAGAMENTO (DATA_PAGAMENTO, VALOR_TOTAL, FORMA_PAGAMENTO, PARCELAS, VALOR_PARCELAS, DESCRICAO, STATUS) VALUES
(TO_DATE('2024-05-01', 'YYYY-MM-DD'), 1500.00, 'Cart�o de Cr�dito', 3, 500.00, 'Pagamento de curso de TI', 'Pago');
INSERT INTO TB_PAGAMENTO (DATA_PAGAMENTO, VALOR_TOTAL, FORMA_PAGAMENTO, PARCELAS, VALOR_PARCELAS, DESCRICAO, STATUS) VALUES
(TO_DATE('2024-05-10', 'YYYY-MM-DD'), 500.00, 'Boleto', 1, 500.00, 'Pagamento de mensalidade', 'Pendente');
INSERT INTO TB_PAGAMENTO (DATA_PAGAMENTO, VALOR_TOTAL, FORMA_PAGAMENTO, PARCELAS, VALOR_PARCELAS, DESCRICAO, STATUS) VALUES
(TO_DATE('2024-05-15', 'YYYY-MM-DD'), 2000.00, 'Transfer�ncia Banc�ria', 2, 1000.00, 'Pagamento de software', 'Pago');
INSERT INTO TB_PAGAMENTO (DATA_PAGAMENTO, VALOR_TOTAL, FORMA_PAGAMENTO, PARCELAS, VALOR_PARCELAS, DESCRICAO, STATUS) VALUES
(TO_DATE('2024-05-20', 'YYYY-MM-DD'), 750.00, 'Dinheiro', 1, 750.00, 'Pagamento de material de escrit�rio', 'Pendente');
INSERT INTO TB_PAGAMENTO (DATA_PAGAMENTO, VALOR_TOTAL, FORMA_PAGAMENTO, PARCELAS, VALOR_PARCELAS, DESCRICAO, STATUS) VALUES
(TO_DATE('2024-05-25', 'YYYY-MM-DD'), 1200.00, 'Cart�o de D�bito', 4, 300.00, 'Pagamento de servi�os de marketing', 'Pago');

-- INSERT TB_SERVICO
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Customer 360', 'Plataforma de gest�o de relacionamento com o cliente.', 'CRM', 1000.00, 'https://www.salesforce.com/content/dam/web/global/svg-icons/placeholder11.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('IA', 'Intelig�ncia artificial para an�lise de dados e automa��o de processos.', 'IA', 1500.00, 'https://www.salesforce.com/content/dam/web/global/svg-icons/placeholder12.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Pequenas Empresas', 'Solu��es personalizadas para pequenas empresas.', 'SMB', 800.00, 'https://www.salesforce.com/content/dam/web/global/svg-icons/product-smb-day.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Vendas', 'Ferramentas para gest�o e automa��o de vendas.', 'CRM', 1200.00, 'https://www.salesforce.com/content/dam/web/global/svg-icons/sales-day.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Atendimento ao Cliente', 'Plataforma de atendimento ao cliente multicanal.', 'CRM', 1000.00, 'https://www.salesforce.com/content/dam/web/global/svg-icons/service-day.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Marketing', 'Ferramentas para automa��o de marketing e an�lise de campanhas.', 'Marketing', 1300.00, 'https://www.salesforce.com/content/dam/web/global/svg-icons/marketing-day.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Commerce', 'Solu��es para com�rcio eletr�nico e gest�o de lojas virtuais.', 'Commerce', 1500.00, 'https://www.salesforce.com/content/dam/web/global/svg-icons/commerce-day.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Data Cloud', 'Armazenamento e an�lise de grandes volumes de dados na nuvem.', 'Cloud', 2000.00, 'https://www.salesforce.com/content/dam/web/global/svg-icons/placeholder29.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Tableau', 'Plataforma de visualiza��o e an�lise de dados.', 'Analytics', 1800.00, 'https://www.salesforce.com/content/dam/web/global/svg-icons/placeholder1.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Mulesoft', 'Integra��o de sistemas e APIs.', 'Integration', 1700.00, 'https://www.salesforce.com/content/dam/web/global/svg-icons/integration-day.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Slack', 'Ferramenta de comunica��o empresarial.', 'Collaboration', 900.00, 'https://www.salesforce.com/content/dam/web/global/svg-icons/placeholder13.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Plataforma Einstein 1', 'Intelig�ncia artificial para an�lise preditiva e recomenda��es.', 'AI', 2000.00, 'https://www.salesforce.com/content/dam/web/global/svg-icons/platform-day.svg');
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR, IMG_URL) VALUES
('Sustentabilidade', 'Solu��es para gest�o de sustentabilidade empresarial.', 'Sustainability', 1600.00, 'https://www.salesforce.com/content/dam/web/global/icons/product/products-sustainability-day.svg');


-- INSERT TB_PEDIDO
INSERT INTO TB_PEDIDO (ID_CONTA, ID_PAGAMENTO, ID_SERVICO) VALUES
(1, 1, 1);
INSERT INTO TB_PEDIDO (ID_CONTA, ID_PAGAMENTO, ID_SERVICO) VALUES
(2, 2, 2);
INSERT INTO TB_PEDIDO (ID_CONTA, ID_PAGAMENTO, ID_SERVICO) VALUES
(3, 3, 3);
INSERT INTO TB_PEDIDO (ID_CONTA, ID_PAGAMENTO, ID_SERVICO) VALUES
(4, 4, 4);
INSERT INTO TB_PEDIDO (ID_CONTA, ID_PAGAMENTO, ID_SERVICO) VALUES
(5, 5, 5);






