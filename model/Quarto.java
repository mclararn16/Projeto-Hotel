package model;

public class Quarto {
    protected int numero;
    protected String tipo;
    protected boolean disponivel;
    protected boolean bloqueado;
    protected double precoDiaria;

    public Quarto(int numero, String tipo, double precoDiaria) {
        this.numero = numero;
        this.tipo = tipo;
        this.disponivel = true;
        this.bloqueado = false;
        this.precoDiaria = precoDiaria;
    }

    public int getNumero() { return numero; }
    public String getTipo() { return tipo; }
    public double getPrecoDiaria() { return precoDiaria; }

    public boolean isDisponivel() {
        return disponivel && !bloqueado;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isBloqueado() { return bloqueado; }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
}
