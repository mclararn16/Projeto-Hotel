# Projeto-Hotel

## Descrição
Este é um sistema simples de gerenciamento de hotel, desenvolvido em Java, utilizando conceitos de Programação Orientada a Objetos (POO) como encapsulamento, herança e polimorfismo. O sistema permite cadastrar clientes, adicionar quartos (simples e luxo), listar quartos e realizar reservas.

## Estrutura do Projeto
- `model/`: Classes de domínio (`Client`, `Quarto`, `QuartoSimples`, `QuartoLuxo`, `Reserva`)
- `repository/`: Classe `BancodeDados` para armazenamento em memória
- `service/`: Classe `ReservaService` para regras de negócio
- `main/`: Classe principal com menu (`Main`)

## Como Executar
1. Compile todos os arquivos Java:
   - Navegue até a pasta do projeto no terminal.
   - Execute:
	```
	javac main/Main.java model/*.java repository/*.java service/*.java
	```
2. Execute o sistema:
	```
	java main.Main
	```

## Funcionalidades
- Cadastro de clientes
- Adição de quartos simples e luxo
- Listagem de quartos
- Realização de reservas

## Observações
- O sistema utiliza apenas o console (CLI)
- Não utiliza banco de dados real, apenas listas em memória
- Estrutura e funcionamento seguem o diagrama UML fornecido