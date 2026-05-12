package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private static int contador = 1;
    private int id;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private Quarto quarto;
    private Client cliente;
    private boolean ativa;

    public Reserva(LocalDate dataEntrada, LocalDate dataSaida, Quarto quarto, Client cliente) {
        this.id = contador++;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.quarto = quarto;
        this.cliente = cliente;
        this.ativa = true;
    }

    public int getId() { return id; }
    public LocalDate getDataEntrada() { return dataEntrada; }
    public LocalDate getDataSaida() { return dataSaida; }
    public Quarto getQuarto() { return quarto; }
    public Client getCliente() { return cliente; }
    public boolean isAtiva() { return ativa; }

    public long calcularDias() {
        return ChronoUnit.DAYS.between(dataEntrada, dataSaida);
    }

    public double calcularValorTotal() {
        return calcularDias() * quarto.getPrecoDiaria();
    }

    public void cancelarReserva() {
        this.ativa = false;
        quarto.setDisponivel(true);
    }

    public boolean validaReserva() {
        return quarto.isDisponivel() && dataEntrada.isBefore(dataSaida);
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format(
            "Reserva #%d | Cliente: %s | Quarto: %d (%s) | Entrada: %s | Saida: %s | %d dias | Total: R$ %.2f | Status: %s",
            id, cliente.getNome(), quarto.getNumero(), quarto.getTipo(),
            dataEntrada.format(fmt), dataSaida.format(fmt),
            calcularDias(), calcularValorTotal(),
            ativa ? "Ativa" : "Cancelada"
        );
    }
}
