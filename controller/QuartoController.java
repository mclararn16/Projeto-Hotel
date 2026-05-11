package controller;

import model.Quarto;
import model.QuartoSimples;
import model.QuartoLuxo;
import repository.BancodeDados;
import view.MenuView;

public class QuartoController {
    private BancodeDados banco;
    private MenuView view;

    public QuartoController(BancodeDados banco, MenuView view) {
        this.banco = banco;
        this.view = view;
    }

    public void listarQuartos() {
        view.listarQuartos(banco.getQuartos());
    }

    public void adicionarQuartoSimples() {
        int numero = banco.getQuartos().size() + 1;
        Quarto quarto = new QuartoSimples(numero);
        banco.salvarQuarto(quarto);
        view.exibirMensagem("Quarto Simples adicionado!");
    }

    public void adicionarQuartoLuxo() {
        int numero = banco.getQuartos().size() + 1;
        Quarto quarto = new QuartoLuxo(numero);
        banco.salvarQuarto(quarto);
        view.exibirMensagem("Quarto Luxo adicionado!");
    }
}
