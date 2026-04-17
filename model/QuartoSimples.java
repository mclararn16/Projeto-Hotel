package model;

public class QuartoSimples extends Quarto {
    public QuartoSimples(int numero) {
        super(numero, "Simples");
    }

    @Override
    public boolean isDisponivel() {
        // Polimorfismo: pode adicionar regras específicas
        return super.isDisponivel();
    }
}
