package model;

public class QuartoSimples extends Quarto {
    public QuartoSimples(int numero) {
        super(numero, "Simples", 150.0);
    }

    @Override
    public boolean isDisponivel() {
        return super.isDisponivel();
    }
}
