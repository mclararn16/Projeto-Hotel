package controller;

import model.Client;
import model.Quarto;
import model.Reserva;
import model.BancodeDados;
import model.ReservaException;
import model.ClienteException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReservaService {
    private static final Logger logger = Logger.getLogger(ReservaService.class.getName());

    private BancodeDados banco;

    public ReservaService(BancodeDados banco) {
        this.banco = banco;
    }

    public Reserva realizarReserva(Client cliente, Quarto quarto, LocalDate entrada, LocalDate saida)
            throws ReservaException, ClienteException {

        if (cliente == null) {
            throw new ClienteException("O cliente nao foi encontrado");
        }
        if (cliente.getQuantidadeReservas() >= 3) {
            throw new ClienteException("O cliente atingiu o limite de 3 reservas ativas");
        }
        if (quarto == null) {
            throw new ReservaException("O Quarto nao encontrado");
        }
        if (!quarto.isDisponivel()) {
            throw new ReservaException("Quarto " + quarto.getNumero() + " esta indisponivel");
        }
        if (entrada == null || saida == null) {
            throw new ReservaException("Datas invalidas");
        }
        if (!entrada.isBefore(saida)) {
            throw new ReservaException("A data de saida deve ser posterior a data de entrada");
        }

        Reserva reserva = new Reserva(entrada, saida, quarto, cliente);

        
        try {
            quarto.setDisponivel(false);
            cliente.incrementarReservas();
            banco.salvarReserva(reserva);
            return reserva;
        } catch (RuntimeException ex) {
            
            logger.log(Level.SEVERE, "Erro salvar reserva", ex);
            throw new ReservaException("Erro interno ao salvar reserva. Tente novamente mais tarde.");
        }
    }

    public void cancelarReserva(int idReserva) throws ReservaException {
        Reserva reserva = banco.buscarReservaPorId(idReserva);
        //if (reserva == null) {
          //  throw new ReservaException("Reserva #" + idReserva + " nao encontrada.");
        //}
        if (!reserva.isAtiva()) {
           throw new ReservaException("Reserva #" + idReserva + " ja esta cancelada.");
        }
        try {
            reserva.cancelarReserva();
            reserva.getCliente().decrementarReservas();
        } catch (RuntimeException ex) {
            logger.log(Level.SEVERE, "Erro ao cancelar reserva", ex);
            throw new ReservaException("Erro ao cancelar reserva. Mais tarde tente novamente.");
        }
    }
}