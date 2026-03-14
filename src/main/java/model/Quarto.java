package model;

public class Quarto {
    public enum Status { LIVRE, OCUPADO, MANUTENCAO }

    private final int numero;
    private final String tipo;
    private double diaria;
    private Status status = Status.LIVRE;

    public Quarto(int numero, String tipo, double diaria) {
        this.numero = numero;
        this.tipo = tipo;
        this.diaria = diaria;
    }

    public int getNumero() { return numero; }
    public String getTipo() { return tipo; }
    public double getDiaria() { return diaria; }
    public Status getStatus() { return status; }

    public void setDiaria(double diaria) { this.diaria = diaria; }
    public void ocupar()    { this.status = Status.OCUPADO; }
    public void liberar()   { this.status = Status.LIVRE; }
    public void manutencao(){ this.status = Status.MANUTENCAO; }
}