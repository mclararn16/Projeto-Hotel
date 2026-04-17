package main;

import model.*;
import repository.BancodeDados;
import service.ReservaService;
import java.util.Date;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BancodeDados banco = new BancodeDados();
    ReservaService reservaService = new ReservaService(banco);
    int opcao = -1;
    do {
      System.out.println("--- Menu Hotel ---");
      System.out.println("1. Cadastrar Cliente");
      System.out.println("2. Listar Quartos");
      System.out.println("3. Adicionar Quarto Simples");
      System.out.println("4. Adicionar Quarto Luxo");
      System.out.println("5. Realizar Reserva");
      System.out.println("0. Sair");
      System.out.print("Escolha uma opção: ");
      if (sc.hasNextInt()) {
        opcao = sc.nextInt();
        sc.nextLine();
      } else {
        System.out.println("Entrada inválida! Digite um número.");
        sc.nextLine();
        continue;
      }
      switch (opcao) {
        case 1:
          System.out.print("Nome: ");
          String nome = sc.nextLine();
          System.out.print("CPF: ");
          String cpf = sc.nextLine();
          int id = banco.getClientes().size() + 1;
          banco.salvarCliente(new Client(id, nome, cpf));
          System.out.println("Cliente cadastrado!");
          break;
        case 2:
          for (Quarto q : banco.getQuartos()) {
            System.out.println("Quarto " + q.getNumero() + " - " + q.getTipo() + " - Disponível: " + q.isDisponivel());
          }
          break;
        case 3:
          int numSimples = banco.getQuartos().size() + 1;
          banco.salvarQuarto(new QuartoSimples(numSimples));
          System.out.println("Quarto Simples adicionado!");
          break;
        case 4:
          int numLuxo = banco.getQuartos().size() + 1;
          banco.salvarQuarto(new QuartoLuxo(numLuxo));
          System.out.println("Quarto Luxo adicionado!");
          break;
        case 5:
          System.out.print("ID do Cliente: ");
          int idCliente = sc.nextInt();
          sc.nextLine();
          Client cliente = null;
          for (Client c : banco.getClientes()) {
            if (c.getId() == idCliente) {
              cliente = c;
              break;
            }
          }
          if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            break;
          }
          Quarto quarto = banco.buscarQuartoDisponivel();
          if (quarto == null) {
            System.out.println("Nenhum quarto disponível!");
            break;
          }
          Reserva reserva = new Reserva(new Date(), new Date(), quarto, cliente);
          if (reservaService.verificaDisponibilidade(quarto, new Date(), new Date())) {
            reservaService.realizarReserva(reserva);
            cliente.incrementarReservas();
            System.out.println("Reserva realizada para o cliente " + cliente.getNome() + " no quarto " + quarto.getNumero());
          } else {
            System.out.println("Quarto não disponível!");
          }
          break;
        case 0:
          System.out.println("Saindo...");
          break;
        default:
          System.out.println("Opção inválida!");
      }
    } while (opcao != 0);
    sc.close();
  }
}
