# Dicionários para armazenar os dados do cliente e da empresa
clientes = []
empresas = []

while True:
    print("\nMenu:")
    print("1. Cadastrar Cliente")
    print("2. Mostrar dados dos clientes cadastrados")
    print("3. Sair")
    opcao = input("Escolha uma opção: ")

    if opcao == "1":
        cliente = {}
        cliente["nome"] = input("Digite seu nome:")
        cliente["sobrenome"] = input("Digite seu sobrenome:")
        cliente["email"] = input("Digite seu emial corporativo:")
        cliente["telefone"] = int(input("Digite seu Telefone:"))
        cliente["pais"] = input("Digite seu pais:")
        cliente["estado"] = input("Digite seu estado:")

        avanco = input("Deseja avançar para o cadastro da empresa? (1-sim, 0-não): ")
        if avanco == "1":
            empresa = {}
            empresa["nome"] = input("Digite o nome da empresa:")
            empresa["funcao"] = input("Qual seu cargo na empresa?:")
            empresa["tamanho"] = int(input("Digite a quantidade de funcionários:"))
            empresas.append(empresa)

        clientes.append(cliente)
        print("Cadastro realizado com sucesso!")

    elif opcao == "2":
        if len(clientes) > 0:
            for i, cliente in enumerate(clientes):
                print(f"Dados do Cliente {i + 1}:")
                print(f"Nome: {cliente['nome']}")
                print(f"Sobrenome: {cliente['sobrenome']}")
                print(f"Email corporativo: {cliente['email']}")
                print(f"Telefone comercial: {cliente['telefone']}")
                print("Dados da Empresa:")
                print(f"Pais de origem: {cliente['pais']}")
                print(f"Estado: {cliente['estado']}")
                if i < len(empresas):
                    print(f"Nome da empresa: {empresas[i]['nome']}")
                    print(f"Cargo na empresa: {empresas[i]['funcao']}")
                    print(f"Quantidade de funcionários: {empresas[i]['tamanho']}")
                print("")

        else:
            print("Nenhum cliente cadastrado ainda.")

    elif opcao == "3":
        print("Saindo do programa. Até mais!")
        break

    else:
        print("Opção inválida. Por favor, escolha uma opção válida.")
