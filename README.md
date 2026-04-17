
# 🏨 Projeto Hotel

Um sistema simples de gerenciamento de hotel desenvolvido em Java, utilizando conceitos de Programação Orientada a Objetos (POO) como encapsulamento, herança e polimorfismo. O sistema permite cadastrar clientes, adicionar quartos, listar quartos e realizar reservas via linha de comando.

---

## 📁 Estrutura do Projeto

```
Projeto-Hotel/
├── main/           # Classe principal (Main.java)
├── model/          # Classes de domínio (Client, Quarto, Reserva, etc)
├── repository/     # Simulação de banco de dados em memória
├── service/        # Lógica de negócio (ReservaService)
└── README.md       # Este arquivo
```

---

## 🚀 Como Executar

1. Abra o terminal na pasta `Projeto-Hotel`.
2. Compile todos os arquivos Java:
   ```sh
   javac main/Main.java model/*.java repository/*.java service/*.java
   ```
3. Execute o sistema:
   ```sh
   java main.Main
   ```

---

## 🛠️ Funcionalidades

- Cadastro de clientes
- Adição de quartos (simples e luxo)
- Listagem de quartos
- Realização de reservas
- Menu interativo no console

---

## 📚 Tecnologias e Conceitos

- Java 8+
- Programação Orientada a Objetos
  - Encapsulamento
  - Herança e polimorfismo
- Estrutura modular (pacotes)
- Simulação de banco de dados em memória

---

## 📋 Diagrama UML

<details>
<summary>Clique para expandir</summary>

![UML do Projeto Hotel](DiagramaUMLHotelPOO_page-0001.jpg)

</details>

---

## 👥 Autores

- Arthur Angelo
- Davi Almeida
- Maria Clara

---

## 📄 Observações

- O sistema é executado totalmente via linha de comando (CLI).
- Não utiliza banco de dados real, apenas listas em memória.
- Estrutura e funcionamento seguem o diagrama UML fornecido.
- Sinta-se livre para contribuir!

Lógica e Regra de negócio

1\. Lógica do Sistema:
A lógica é como o sistema pensa para executar uma tarefa 
\*Para um sistema de hotel:
\-Receber a data de entrada
\-Receber a data de saída
\-Verificar se o quarto está disponível
\-Se estiver disponível ->permitir a reserva
\-Se não estiver disponível -> mostrar erro 

Em pseudocódigo:

se quartoDisponivel(dataEntrada, dataSaida) então
&#x20;   criarReserva()
senão
&#x20;   mostrarMensagem("Quarto indisponível")

2\. regra de negócio:
As regras de negócio são as regras que definem como o sistema deve funcionar de acordo com o mundo real

\*Para um sistema de hotel:
\-Um quarto não pode ter duas reservas ao mesmo tempo (mesmo período de datas)
\-A data de saída deve ser maior que a data de entrada
\-O cliente precisa estar cadastrado para fazer uma reserva
\-O pagamento deve ser feito antes do check-in

3\. Diferença entre regra e lógica do sistema:
|Lógica                             |Regra de negócio|
|-|-|
|Como o sistema resolve o problema  |O que o sistema pode ou não pode fazer|
|Passo a passo do código            |Regras do mundo real|
|Estruturas if, for, while          |Condições do sistema|

Exemplo:

Na Regra de negócio:
- "O cliente não pode reservar mais de 3 quartos"

Na Lógica (código) :

if(cliente.getQuantidadeReservas() >= 3){
   System.out.println("Limite de reservas atingido");
}













