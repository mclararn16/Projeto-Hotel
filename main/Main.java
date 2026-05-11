package main;

import repository.BancodeDados;
import service.ReservaService;
import controller.ClienteController;
import controller.QuartoController;
import controller.ReservaController;
import view.MenuView;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BancodeDados banco = new BancodeDados();
    ReservaService reservaService = new ReservaService(banco);

    MenuView view = new MenuView(sc);

    ClienteController clienteController = new ClienteController(banco, view);
    QuartoController quartoController = new QuartoController(banco, view);
    ReservaController reservaController = new ReservaController(banco, reservaService, view);

    int opcao = -1;
    do {
      opcao = view.exibirMenuPrincipal();

      switch (opcao) {
        case 1:
          clienteController.cadastrarCliente();
          break;
        case 2:
          quartoController.listarQuartos();
          break;
        case 3:
          quartoController.adicionarQuartoSimples();
          break;
        case 4:
          quartoController.adicionarQuartoLuxo();
          break;
        case 5:
          reservaController.realizarReserva();
          break;
        case 0:
          view.exibirSaindo();
          break;
        default:
          if (opcao != -1) {
            view.exibirOpcaoInvalida();
          }
      }
    } while (opcao != 0);

    sc.close();
  }
}
