-- INSERT TB_EMPRESA
INSERT INTO TB_EMPRESA (NOME, DEPARTAMENTO, DIVISAO, NUM_FUNCIONARIO, INICIO_JORNADA, FIM_JORNADA) VALUES
('Tech Solutions', 'TI', 'Desenvolvimento', 100, TIME '08:00:00', TIME '17:00:00');
INSERT INTO TB_EMPRESA (NOME, DEPARTAMENTO, DIVISAO, NUM_FUNCIONARIO, INICIO_JORNADA, FIM_JORNADA) VALUES
('Global HR', 'RH', 'Recrutamento', 50, TIME '09:00:00', TIME '18:00:00');
INSERT INTO TB_EMPRESA (NOME, DEPARTAMENTO, DIVISAO, NUM_FUNCIONARIO, INICIO_JORNADA, FIM_JORNADA) VALUES
('FinanceCorp', 'Financeiro', 'Contabilidade', 200, TIME '08:30:00', TIME '17:30:00');
INSERT INTO TB_EMPRESA (NOME, DEPARTAMENTO, DIVISAO, NUM_FUNCIONARIO, INICIO_JORNADA, FIM_JORNADA) VALUES
('MarketGenius', 'Marketing', 'Publicidade', 75, TIME '10:00:00', TIME '19:00:00');
INSERT INTO TB_EMPRESA (NOME, DEPARTAMENTO, DIVISAO, NUM_FUNCIONARIO, INICIO_JORNADA, FIM_JORNADA) VALUES
('LogiTrack', 'Operações', 'Logística', 150, TIME '07:00:00', TIME '16:00:00');

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
INSERT INTO TB_PESSOA (NOME, APELIDO, TELEFONE, CELULAR, CARGO, RG, ID_ENDERECO, ID_EMPRESA) VALUES
('Fernando Almeida', 'Nando', '987654326', '19987654326', 'Analista de Sistemas', '123456794', 1, 1);
INSERT INTO TB_PESSOA (NOME, APELIDO, TELEFONE, CELULAR, CARGO, RG, ID_ENDERECO, ID_EMPRESA) VALUES
('Luiza Costa', 'Lu', '987654327', '19987654327', 'Gerente de RH', '123456795', 2, 2);
INSERT INTO TB_PESSOA (NOME, APELIDO, TELEFONE, CELULAR, CARGO, RG, ID_ENDERECO, ID_EMPRESA) VALUES
('Ricardo Neves', 'Rick', '987654328', '19987654328', 'Auditor Financeiro', '123456796', 3, 3);
INSERT INTO TB_PESSOA (NOME, APELIDO, TELEFONE, CELULAR, CARGO, RG, ID_ENDERECO, ID_EMPRESA) VALUES
('Marina Duarte', 'Mari', '987654329', '19987654329', 'Designer Gráfico', '123456797', 4, 4);
INSERT INTO TB_PESSOA (NOME, APELIDO, TELEFONE, CELULAR, CARGO, RG, ID_ENDERECO, ID_EMPRESA) VALUES
('Bruno Lima', 'Bruninho', '987654330', '19987654330', 'Coordenador de Logística', '123456798', 5, 5);

-- INSERT TB_SERVICO
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR) VALUES
('Customer 360', 'Plataforma de gestão de relacionamento com o cliente.', 'CRM', 1000.00);
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR) VALUES
('IA', 'Inteligência artificial para análise de dados e automação de processos.', 'IA', 1500.00);
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR) VALUES
('Pequenas Empresas', 'Soluções personalizadas para pequenas empresas.', 'SMB', 800.00);
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR) VALUES
('Vendas', 'Ferramentas para gestão e automação de vendas.', 'CRM', 1200.00);
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR) VALUES
('Atendimento ao Cliente', 'Plataforma de atendimento ao cliente multicanal.', 'CRM', 1000.00);
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR) VALUES
('Marketing', 'Ferramentas para automação de marketing e análise de campanhas.', 'Marketing', 1300.00);
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR) VALUES
('Commerce', 'Soluções para comércio eletrônico e gestão de lojas virtuais.', 'Commerce', 1500.00);
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR) VALUES
('Data Cloud', 'Armazenamento e análise de grandes volumes de dados na nuvem.', 'Cloud', 2000.00);
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR) VALUES
('Tableau', 'Plataforma de visualização e análise de dados.', 'Analytics', 1800.00);
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR) VALUES
('Mulesoft', 'Integração de sistemas e APIs.', 'Integration', 1700.00);
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR) VALUES
('Slack', 'Ferramenta de comunicação empresarial.', 'Collaboration', 900.00);
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR) VALUES
('Plataforma Einstein 1', 'Inteligência artificial para análise preditiva e recomendações.', 'AI', 2000.00);
INSERT INTO TB_SERVICO (NOME, DESCRICAO, CATEGORIA, VALOR) VALUES
('Sustentabilidade', 'Soluções para gestão de sustentabilidade empresarial.', 'Sustainability', 1600.00);
