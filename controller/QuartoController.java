package controller;

import model.Quarto;
import model.QuartoSimples;
import model.QuartoLuxo;
import repository.BancodeDados;
import view.MenuView;
import java.util.ArrayList;
import java.util.List;

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

    public void listarQuartosDisponiveis() {
        List<Quarto> disponiveis = new ArrayList<>();
        for (Quarto q : banco.getQuartos()) {
            if (q.isDisponivel()) disponiveis.add(q);
        }
        if (disponiveis.isEmpty()) {
            view.exibirMensagem("Nenhum quarto disponivel no momento.");
        } else {
            view.listarQuartos(disponiveis);
        }
    }

    public void adicionarQuartoSimples() {
        int numero = banco.getQuartos().size() + 1;
        Quarto quarto = new QuartoSimples(numero);
        banco.salvarQuarto(quarto);
        view.exibirMensagem("Quarto Simples " + numero + " adicionado! Diaria: R$ 150,00");
    }

    public void adicionarQuartoLuxo() {
        int numero = banco.getQuartos().size() + 1;
        Quarto quarto = new QuartoLuxo(numero);
        banco.salvarQuarto(quarto);
        view.exibirMensagem("Quarto Luxo " + numero + " adicionado! Diaria: R$ 350,00");
    }
}
