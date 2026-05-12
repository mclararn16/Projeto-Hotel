package service;

import model.Client;
import model.Quarto;
import model.Reserva;
import repository.BancodeDados;
import exception.ReservaException;
import exception.ClienteException;
import java.time.LocalDate;

public class ReservaService {
    private BancodeDados banco;

    public ReservaService(BancodeDados banco) {
        this.banco = banco;
    }

    public Reserva realizarReserva(Client cliente, Quarto quarto, LocalDate entrada, LocalDate saida)
            throws ReservaException, ClienteException {

        if (cliente == null) {
            throw new ClienteException("Cliente nao encontrado.");
        }
        if (cliente.getQuantidadeReservas() >= 3) {
            throw new ClienteException("Cliente atingiu o limite de 3 reservas ativas.");
        }
        if (quarto == null) {
            throw new ReservaException("Quarto nao encontrado.");
        }
        if (!quarto.isDisponivel()) {
            throw new ReservaException("Quarto " + quarto.getNumero() + " esta indisponivel.");
        }
        if (entrada == null || saida == null) {
            throw new ReservaException("Datas invalidas.");
        }
        if (!entrada.isBefore(saida)) {
            throw new ReservaException("A data de saida deve ser posterior a data de entrada.");
        }

        Reserva reserva = new Reserva(entrada, saida, quarto, cliente);
        quarto.setDisponivel(false);
        cliente.incrementarReservas();
        banco.salvarReserva(reserva);
        return reserva;
    }

    public void cancelarReserva(int idReserva) throws ReservaException {
        Reserva reserva = banco.buscarReservaPorId(idReserva);
        if (reserva == null) {
            throw new ReservaException("Reserva #" + idReserva + " nao encontrada.");
        }
        if (!reserva.isAtiva()) {
            throw new ReservaException("Reserva #" + idReserva + " ja esta cancelada.");
        }
        reserva.cancelarReserva();
        reserva.getCliente().decrementarReservas();
    }
}
