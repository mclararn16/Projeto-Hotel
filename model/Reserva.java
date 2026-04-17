package model;

import java.util.Date;

public class Reserva {
    private Date dataEntrada;
    private Date dataSaida;
    private Quarto quarto;
    private Client cliente;

    public Reserva(Date dataEntrada, Date dataSaida, Quarto quarto, Client cliente) {
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.quarto = quarto;
        this.cliente = cliente;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public Client getCliente() {
        return cliente;
    }

    public void cancelarReserva() {
        quarto.setDisponivel(true);
    }

    public boolean validaReserva() {
        return quarto.isDisponivel();
    }
}
