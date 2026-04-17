package service;

import model.Reserva;
import model.Quarto;
import repository.BancodeDados;
import java.util.Date;

public class ReservaService {
    private BancodeDados banco;

    public ReservaService(BancodeDados banco) {
        this.banco = banco;
    }

    public boolean verificaDisponibilidade(Quarto quarto, Date entrada, Date saida) {
        // Simples: verifica se o quarto está disponível
        return quarto.isDisponivel();
    }

    public void realizarReserva(Reserva reserva) {
        reserva.getQuarto().setDisponivel(false);
    }
}


