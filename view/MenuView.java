package view;

import model.*;
import java.util.List;
import java.util.Scanner;

public class MenuView {
    private Scanner sc;

    public MenuView(Scanner sc) {
        this.sc = sc;
    }

    // ========== MENU PRINCIPAL ==========
    public int exibirMenuPrincipal() {
        System.out.println("\n--- Menu Hotel ---");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Listar Quartos");
        System.out.println("3. Adicionar Quarto Simples");
        System.out.println("4. Adicionar Quarto Luxo");
        System.out.println("5. Realizar Reserva");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");

        if (sc.hasNextInt()) {
            int opcao = sc.nextInt();
            sc.nextLine();
            return opcao;
        } else {
            System.out.println("Entrada inválida! Digite um número.");
            sc.nextLine();
            return -1;
        }
    }

    // ========== CLIENTE ==========
    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public String obterNomeCliente() {
        System.out.print("Nome: ");
        return sc.nextLine();
    }

    public String obterCPFCliente() {
        System.out.print("CPF: ");
        return sc.nextLine();
    }

    // ========== QUARTO ==========
    public void listarQuartos(List<Quarto> quartos) {
        if (quartos.isEmpty()) {
            System.out.println("Nenhum quarto disponível!");
            return;
        }
        System.out.println("\n--- Lista de Quartos ---");
        for (Quarto q : quartos) {
            System.out.println("Quarto " + q.getNumero() + " - " + q.getTipo() +
                    " - Disponível: " + (q.isDisponivel() ? "Sim" : "Não"));
        }
    }

    // ========== RESERVA ==========
    public int obterIdClienteReserva() {
        System.out.print("ID do Cliente: ");
        int id = sc.nextInt();
        sc.nextLine();
        return id;
    }

    public void exibirClienteNaoEncontrado() {
        System.out.println("Cliente não encontrado!");
    }

    public void exibirNenhumQuartoDisponivel() {
        System.out.println("Nenhum quarto disponível!");
    }

    public void exibirQuartoNaoDisponivel() {
        System.out.println("Quarto não disponível!");
    }

    public void exibirReservaSucesso(String nomeCliente, int numeroQuarto) {
        System.out.println("Reserva realizada para o cliente " + nomeCliente +
                " no quarto " + numeroQuarto);
    }

    public void exibirSaindo() {
        System.out.println("Saindo...");
    }

    public void exibirOpcaoInvalida() {
        System.out.println("Opção inválida!");
    }
}
