package controller;

import model.Client;
import model.Quarto;
import model.Reserva;
import repository.BancodeDados;
import service.ReservaService;
import view.MenuView;
import java.util.Date;

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
        // Obter ID do cliente
        int idCliente = view.obterIdClienteReserva();

        // Buscar cliente
        Client cliente = buscarClientePorId(idCliente);
        if (cliente == null) {
            view.exibirClienteNaoEncontrado();
            return;
        }

        // Buscar quarto disponível
        Quarto quarto = banco.buscarQuartoDisponivel();
        if (quarto == null) {
            view.exibirNenhumQuartoDisponivel();
            return;
        }

        // Criar e validar reserva
        Reserva reserva = new Reserva(new Date(), new Date(), quarto, cliente);
        if (service.verificaDisponibilidade(quarto, new Date(), new Date())) {
            service.realizarReserva(reserva);
            cliente.incrementarReservas();
            view.exibirReservaSucesso(cliente.getNome(), quarto.getNumero());
        } else {
            view.exibirQuartoNaoDisponivel();
        }
    }

    private Client buscarClientePorId(int id) {
        for (Client c : banco.getClientes()) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
}
