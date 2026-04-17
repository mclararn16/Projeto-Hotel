package model;

public class QuartoLuxo extends Quarto {
    public QuartoLuxo(int numero) {
        super(numero, "Luxo");
    }

    @Override
    public boolean isDisponivel() {
        // Polimorfismo: quartos de luxo podem ter regras diferentes
        return !this.bloqueado && this.disponivel;
    }
}
