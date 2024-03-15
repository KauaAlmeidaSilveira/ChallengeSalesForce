INSERT INTO tb_endereco(cep, cidade, estado_provincia, numero, pais, rua) VALUES ( '56823140', 'São Paulo', 'SP', 546, 'BR', 'Rua Pedro');
INSERT INTO tb_endereco(cep, cidade, estado_provincia, numero, pais, rua) VALUES ( '48523150', 'São Paulo', 'SP', 132, 'BR', 'Rua Paula');

INSERT INTO tb_empresa(departamento, divisao, fim_jornada, inicio_jornada, nome, num_funcionario) VALUES ( 'ti', 'Tecnologia', '16:30:00', '07:30:00', 'Drummond', 250);
INSERT INTO tb_empresa(departamento, divisao, fim_jornada, inicio_jornada, nome, num_funcionario) VALUES ( 'Design', 'Tecnologia', '18:30:00', '09:30:00', 'Columbia', 750);

INSERT INTO tb_pessoa( apelido, cargo, celular, nome, rg, telefone, empresa_id, endereco_id) VALUES ('kiwi', 'Programador', '11785472350', 'Kauã Almeida', '5412495389', '', 1, 1);
INSERT INTO tb_pessoa( apelido, cargo, celular, nome, rg, telefone, empresa_id, endereco_id) VALUES ('nary', 'Designer', '11856321220', 'Naryeli Medrano', '4523651025', '', 2, 2);

INSERT INTO tb_role(authority) VALUES ('ROLE_ADMIN'); 
INSERT INTO tb_role(authority) VALUES ('ROLE_OPERATOR'); 
INSERT INTO tb_role(authority) VALUES ('ROLE_USER'); 

INSERT INTO tb_conta( data_registro, email, password, status, ultimo_acesso, usuario, pessoa_id) VALUES ('2024-12-31', 'kaua@gmail.com', '$2a$10$bLLf6oYlsxaM1WvMX43COeQi0Ebrf42UMmVH7l1immAU7ElV/F6uS', 0, '2024-12-31 12:00:00', 'kiwi', 1);
INSERT INTO tb_conta( data_registro, email, password, status, ultimo_acesso, usuario, pessoa_id) VALUES ('2024-12-31', 'naryeli@gmail.com', '$2a$10$bLLf6oYlsxaM1WvMX43COeQi0Ebrf42UMmVH7l1immAU7ElV/F6uS', 0, '2024-12-31 12:00:00', 'nary', 2);

INSERT INTO tb_conta_role(conta_id, role_id) VALUES (1, 1);
INSERT INTO tb_conta_role(conta_id, role_id) VALUES (1, 2);
INSERT INTO tb_conta_role(conta_id, role_id) VALUES (1, 3);
INSERT INTO tb_conta_role(conta_id, role_id) VALUES (2, 2);
INSERT INTO tb_conta_role(conta_id, role_id) VALUES (2, 3);


