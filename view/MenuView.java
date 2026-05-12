package view;

import model.Client;
import model.Quarto;
import model.Reserva;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class MenuView {
    private Scanner sc;
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public MenuView(Scanner sc) {
        this.sc = sc;
    }

    // ========== MENU PRINCIPAL ==========
    public int exibirMenuPrincipal() {
        System.out.println("\n========================================");
        System.out.println("         SISTEMA DE HOTEL               ");
        System.out.println("========================================");
        System.out.println(" 1. Cadastrar Cliente");
        System.out.println(" 2. Listar Clientes");
        System.out.println(" 3. Buscar Cliente por CPF");
        System.out.println("----------------------------------------");
        System.out.println(" 4. Listar Todos os Quartos");
        System.out.println(" 5. Adicionar Quarto Simples (R$ 150/dia)");
        System.out.println(" 6. Adicionar Quarto Luxo   (R$ 350/dia)");
        System.out.println("----------------------------------------");
        System.out.println(" 7. Realizar Reserva");
        System.out.println(" 8. Cancelar Reserva");
        System.out.println(" 9. Listar Todas as Reservas");
        System.out.println("10. Reservas por Cliente");
        System.out.println("----------------------------------------");
        System.out.println(" 0. Sair");
        System.out.println("========================================");
        System.out.print("Escolha uma opcao: ");

        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Entrada invalida! Digite um numero.");
            return -1;
        }
    }

    // ========== MENSAGENS ==========
    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirClienteNaoEncontrado() {
        System.out.println("Cliente nao encontrado!");
    }

    public void exibirNenhumQuartoDisponivel() {
        System.out.println("Nenhum quarto disponivel no momento!");
    }

    public void exibirQuartoNaoDisponivel() {
        System.out.println("Quarto nao disponivel!");
    }

    public void exibirReservaSucesso(String nomeCliente, int numeroQuarto) {
        System.out.println("Reserva realizada com sucesso!");
        System.out.println("  Cliente: " + nomeCliente + " | Quarto: " + numeroQuarto);
    }

    public void exibirSaindo() {
        System.out.println("Encerrando o sistema. Ate logo!");
    }

    public void exibirOpcaoInvalida() {
        System.out.println("Opcao invalida! Tente novamente.");
    }

    // ========== CLIENTE ==========
    public String obterNomeCliente() {
        System.out.print("Nome: ");
        return sc.nextLine();
    }

    public String obterCPFCliente() {
        System.out.print("CPF (somente numeros, 11 digitos): ");
        return sc.nextLine().trim();
    }

    public void listarClientes(List<Client> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        System.out.println("\n--- Clientes Cadastrados ---");
        for (Client c : clientes) {
            System.out.println("  " + c.toString());
        }
    }

    // ========== QUARTO ==========
    public void listarQuartos(List<Quarto> quartos) {
        if (quartos.isEmpty()) {
            System.out.println("Nenhum quarto cadastrado.");
            return;
        }
        System.out.println("\n--- Lista de Quartos ---");
        for (Quarto q : quartos) {
            System.out.printf("  Quarto %d | %-7s | Diaria: R$ %6.2f | Disponivel: %s%n",
                    q.getNumero(), q.getTipo(), q.getPrecoDiaria(),
                    q.isDisponivel() ? "Sim" : "Nao");
        }
    }

    public int obterNumeroQuarto() {
        System.out.print("Numero do Quarto: ");
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // ========== RESERVA ==========
    public int obterIdClienteReserva() {
        System.out.print("ID do Cliente: ");
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public int obterIdReserva() {
        System.out.print("ID da Reserva: ");
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public LocalDate obterDataReserva(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (input.equals("0")) return null;
            try {
                return LocalDate.parse(input, FMT);
            } catch (DateTimeParseException e) {
                System.out.println("Data invalida! Use o formato dd/MM/yyyy (ou 0 para cancelar).");
            }
        }
    }

    public void listarReservas(List<Reserva> reservas) {
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva encontrada.");
            return;
        }
        System.out.println("\n--- Lista de Reservas ---");
        for (Reserva r : reservas) {
            System.out.println("  " + r.toString());
        }
    }
}
