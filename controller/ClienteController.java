package controller;

import model.Client;
import repository.BancodeDados;
import view.MenuView;

public class ClienteController {
    private BancodeDados banco;
    private MenuView view;

    public ClienteController(BancodeDados banco, MenuView view) {
        this.banco = banco;
        this.view = view;
    }

    public void cadastrarCliente() {
        String nome = view.obterNomeCliente();
        String cpf = view.obterCPFCliente();

        int id = banco.getClientes().size() + 1;
        Client cliente = new Client(id, nome, cpf);
        banco.salvarCliente(cliente);

        view.exibirMensagem("Cliente cadastrado!");
    }
}
