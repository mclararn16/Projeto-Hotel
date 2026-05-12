package model;

public class QuartoLuxo extends Quarto {
    public QuartoLuxo(int numero) {
        super(numero, "Luxo", 350.0);
    }

    @Override
    public boolean isDisponivel() {
        return !this.bloqueado && this.disponivel;
    }
}
