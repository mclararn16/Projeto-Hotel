# Projeto-Hotel

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













