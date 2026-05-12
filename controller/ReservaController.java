package controller;

import model.Client;
import model.Quarto;
import model.Reserva;
import repository.BancodeDados;
import service.ReservaService;
import view.MenuView;
import exception.ReservaException;
import exception.ClienteException;
import java.time.LocalDate;
import java.util.List;

public class ReservaController {
    private BancodeDados banco;
    private ReservaService service;
    private MenuView view;

    public ReservaController(BancodeDados banco, ReservaService service, MenuView view) {
        this.banco = banco;
        this.service = service;
        this.view = view;
    }

    public void realizarReserva() {
        view.exibirMensagem("(Digite 0 para cancelar a operacao)");

        if (banco.getClientes().isEmpty()) {
            view.exibirMensagem("Nenhum cliente cadastrado! Cadastre um cliente primeiro.");
            return;
        }

        // Loop: selecionar cliente valido
        Client cliente;
        while (true) {
            view.listarClientes(banco.getClientes());
            int idCliente = view.obterIdClienteReserva();
            if (idCliente == 0) { view.exibirMensagem("Operacao cancelada."); return; }
            cliente = banco.buscarClientePorId(idCliente);
            if (cliente != null) break;
            view.exibirMensagem("Erro: Cliente nao encontrado. Tente novamente.");
        }

        if (banco.buscarQuartoDisponivel() == null) {
            view.exibirNenhumQuartoDisponivel();
            return;
        }

        // Loop: selecionar quarto disponivel valido
        Quarto quarto;
        while (true) {
            view.listarQuartos(banco.getQuartos());
            int numeroQuarto = view.obterNumeroQuarto();
            if (numeroQuarto == 0) { view.exibirMensagem("Operacao cancelada."); return; }
            try {
                quarto = banco.buscarQuartoPorNumero(numeroQuarto);
                if (quarto == null)
                    throw new ReservaException("Quarto nao encontrado.");
                if (!quarto.isDisponivel())
                    throw new ReservaException("Quarto " + quarto.getNumero() + " esta ocupado.");
                break;
            } catch (ReservaException e) {
                view.exibirMensagem("Erro: " + e.getMessage() + " Tente novamente.");
            }
        }

        // Datas: o proprio metodo ja faz loop ate formato valido; null = cancelado
        LocalDate entrada = view.obterDataReserva("Data de Entrada (dd/MM/yyyy): ");
        if (entrada == null) { view.exibirMensagem("Operacao cancelada."); return; }

        LocalDate saida = view.obterDataReserva("Data de Saida   (dd/MM/yyyy): ");
        if (saida == null) { view.exibirMensagem("Operacao cancelada."); return; }

        // Tenta criar a reserva, loop se a data for invalida
        while (true) {
            try {
                Reserva reserva = service.realizarReserva(cliente, quarto, entrada, saida);
                view.exibirReservaSucesso(cliente.getNome(), quarto.getNumero());
                view.exibirMensagem(String.format("Total estimado: R$ %.2f (%d diarias)",
                        reserva.calcularValorTotal(), reserva.calcularDias()));
                return;
            } catch (ReservaException e) {
                view.exibirMensagem("Erro: " + e.getMessage());
                saida = view.obterDataReserva("Nova Data de Saida (dd/MM/yyyy): ");
                if (saida == null) { view.exibirMensagem("Operacao cancelada."); return; }
            } catch (ClienteException e) {
                view.exibirMensagem("Erro: " + e.getMessage());
                return;
            }
        }
    }

    public void cancelarReserva() {
        view.exibirMensagem("(Digite 0 para cancelar a operacao)");

        if (banco.getReservas().isEmpty()) {
            view.exibirMensagem("Nenhuma reserva cadastrada!");
            return;
        }

        while (true) {
            view.listarReservas(banco.getReservas());
            int idReserva = view.obterIdReserva();
            if (idReserva == 0) { view.exibirMensagem("Operacao cancelada."); return; }
            try {
                service.cancelarReserva(idReserva);
                view.exibirMensagem("Reserva cancelada com sucesso!");
                return;
            } catch (ReservaException e) {
                view.exibirMensagem("Erro: " + e.getMessage() + " Tente novamente.");
            }
        }
    }

    public void listarReservas() {
        view.listarReservas(banco.getReservas());
    }

    public void listarReservasPorCliente() {
        view.exibirMensagem("(Digite 0 para cancelar)");

        if (banco.getClientes().isEmpty()) {
            view.exibirMensagem("Nenhum cliente cadastrado!");
            return;
        }

        while (true) {
            view.listarClientes(banco.getClientes());
            int idCliente = view.obterIdClienteReserva();
            if (idCliente == 0) { view.exibirMensagem("Operacao cancelada."); return; }
            Client cliente = banco.buscarClientePorId(idCliente);
            if (cliente == null) {
                view.exibirMensagem("Erro: Cliente nao encontrado. Tente novamente.");
                continue;
            }
            List<Reserva> reservas = banco.buscarReservasPorCliente(idCliente);
            if (reservas.isEmpty()) {
                view.exibirMensagem("Nenhuma reserva para: " + cliente.getNome());
            } else {
                view.listarReservas(reservas);
            }
            return;
        }
    }
}
