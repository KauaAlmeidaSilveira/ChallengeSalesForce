# **SalesForce Console Application**

Este é um programa simula um menu da SalesForce para realizar operações de login, cadastro e listagem de informações. O programa utiliza a classe **`Repository`** para armazenar e gerenciar os dados.

## **Processo de Cadastro**

Ao escolher a opção de cadastro no menu, o usuário será guiado a fornecer informações pessoais e profissionais. Os dados incluem:

- Nome
- Cargo
- Email
- Telefone
- Nome da Empresa
- País

Essas informações são utilizadas para criar instâncias das classes **`Pessoa`**, **`Empresa`**, **`Endereco`**, e **`Conta`**. A conta é então adicionada ao **`Repository`**.

## **Processo de Login**

Ao escolher a opção de login no menu, o usuário será solicitado a fornecer seu email e senha. O programa verifica se o email está cadastrado e, em caso afirmativo, solicita a senha correspondente. Em caso de correspondência, o login é realizado com sucesso.

## **Processo de Listagem**

A opção de listar todos os cadastros exibe as informações armazenadas no repositório.

## **Exemplo de Fluxo de Uso no Console**

1. **Acessar o Menu da SalesForce:**
    
    ```
    Bem vindo, somos a SalesForce !!
    Ja possui uma conta ? (Sim/Não): Não
    
    ** Observação ** -> Aqui se a resposta for sim, ele chama o login().
    ```
    
2. **Cadastro:**
    
    ```
    Certo, vou te fazer algumas perguntas sobre seus dados !!
    Digite seu nome: John Doe
    Digite seu cargo: Desenvolvedor
    Digite seu email: john.doe@example.com
    Digite sua senha: mysecretpassword
    Digite seu telefone: (123) 456-7890
    Digite sua empresa: ABC Ltda
    Digite seu pais: Brasil
    Cadastro realizado com sucesso !!
    ```
    
3. **Login:**
    
    ```
    === Login ===
    Digite seu email: john.doe@example.com
    Digite sua senha: mysecretpassword
    
    Login realizado com sucesso !!
    ```
    
4. **Menu Principal (Após login):**
    
    ```
    Menu:
    1 - Todos nossos serviços
    2 - Assinar um serviço
    3 - Listar meus serviços
    4 - Histórico de pedidos
    5 - Listar cadastros
    
    6 - Sair
    Informe o que deseja fazer de acordo com o número das opções:
    ```
    
5. **Opção 1 do menu:**
    
    ```
    Menu:
    1 - Todos nossos serviços
    2 - Assinar um serviço
    3 - Listar meus serviços
    4 - Histórico de pedidos
    5 - Listar cadastros
    
    6 - Sair
    Informe o que deseja fazer de acordo com o número das opções: 1
    =================
    Serviço: 
    Id: 1
    Nome: IA Eistein
    Descrição: Servico de IA
    Categoria: IA
    Valor: 15800.0
    =================
    Serviço: 
    Id: 2
    Nome: Sales
    Descrição: Servico de Sales
    Categoria: Sales
    Valor: 23000.0
    ```
    
6. **Opção 2 do menu:**
    
    ```
    Menu:
    1 - Todos nossos serviços
    2 - Assinar um serviço
    3 - Listar meus serviços
    4 - Histórico de pedidos
    5 - Listar cadastros
    
    6 - Sair
    Informe o que deseja fazer de acordo com o número das opções: 2
    Todos serviços: 
    =================
    Serviço: 
    Id: 1
    Nome: IA Eistein
    Descrição: Servico de IA
    Categoria: IA
    Valor: 15800.0
    =================
    Serviço: 
    Id: 2
    Nome: Sales
    Descrição: Servico de Sales
    Categoria: Sales
    Valor: 23000.0
    
    Digite o nome do serviço que deseja assinar: ia eistein
    Certo, qual metodo de pagamento ? Crédito
    Deseja parcelar ? (Sim/Não): sim
    Em quantas vezes: 4
    Serviço assinado com sucesso, aproveite !!
    ```
    
7. **Opção 3 do menu:**
    
    ```
    Menu:
    1 - Todos nossos serviços
    2 - Assinar um serviço
    3 - Listar meus serviços
    4 - Histórico de pedidos
    5 - Listar cadastros
    
    6 - Sair
    Informe o que deseja fazer de acordo com o número das opções: 3
    Serviço: 
    Nome: IA Eistein
    Descrição: Servico de IA
    Categoria: IA
    Status= Ativo
    Data de Inicio= 30/11/2023 17:16
    Data de Termino= N/A
    ```
    
8. **Opção 4 do menu:**
    
    ```
    Menu:
    1 - Todos nossos serviços
    2 - Assinar um serviço
    3 - Listar meus serviços
    4 - Histórico de pedidos
    5 - Listar cadastros
    
    6 - Sair
    Informe o que deseja fazer de acordo com o número das opções: 4
    ID_Pedido: 1
    Proprietario da Conta: John Doe
    Servico: IA Eistein
    Data do Pedido: 30/11/2023 17:16
    Pagamento: 
    Id: 802657f1-a250-4722-a414-b6634074d0dc
    Data do Pagamento: 30/11/2023 17:16
    Valor total: 15800.0
    Metodo: Crédito
    Parcelas: 4
    Valor das Parcelas: 3950,00
    Descrição: Pagamento do serviço IA Eistein
    Status: Processando
    ```
    
9. **Opção 5 do menu:**
    
    ```
    Menu:
    1 - Todos nossos serviços
    2 - Assinar um serviço
    3 - Listar meus serviços
    4 - Histórico de pedidos
    5 - Listar cadastros
    
    6 - Sair
    Informe o que deseja fazer de acordo com o número das opções: 5
    
    Conta 
    Id: 1
    Proprietario: 2af03ef0-6672-4c52-925e-31c28092d0f7
    Usuario: kaua@force.com
    Email: kaua@
    Senha: 2011
    
    Conta 
    Id: 2
    Proprietario: 0811830f-851a-44f8-93dd-9157c5f5977e
    Usuario: nary@force.com
    Email: nary@
    Senha: 1807
    
    ** Observação ** -> Aqui o id repete pois essas duas contas são criadas logo apos a instaciação do repository para realizar os devidos testes.
    
    Conta 
    Id: 1 
    Proprietario: cbbfd113-3f19-4720-bcb2-3896d5742224
    Usuario: John Doe@force.com
    Email: john.doe@example.com
    Senha: mysecretpassword
    ```
    
10. **Encerramento:**
    
    ```
    Menu:
    1 - Todos nossos serviços
    2 - Assinar um serviço
    3 - Listar meus serviços
    4 - Histórico de pedidos
    5 - Listar cadastros
    
    6 - Sair
    Informe o que deseja fazer de acordo com o número das opções: 6
    
    Tudo bem, até a próxima! Bye
    ```
    

## Novo integrante e atualização completa da Application

Basicamente tivemos um novo integrante no grupo, o Kauã Almeida Silveira (552618) - Sim, sou eu - com a minha entrada no grupo decidimos que eu iria assumir JAVA e Banco de Dados, logo refiz TODA application tentando alinhar com o que ja era planejamento da Mariana e do Matheus juntamente a Sprint 2.