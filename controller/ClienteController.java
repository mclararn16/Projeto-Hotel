package controller;

import model.Client;
import repository.BancodeDados;
import view.MenuView;
import exception.ClienteException;

public class ClienteController {
    private BancodeDados banco;
    private MenuView view;

    public ClienteController(BancodeDados banco, MenuView view) {
        this.banco = banco;
        this.view = view;
    }

    public void cadastrarCliente() {
        view.exibirMensagem("(Digite 0 em qualquer campo para cancelar)");

        String nome;
        while (true) {
            nome = view.obterNomeCliente();
            if (nome.trim().equals("0")) {
                view.exibirMensagem("Operacao cancelada.");
                return;
            }
            if (!nome.trim().isEmpty()) break;
            view.exibirMensagem("Erro: Nome nao pode ser vazio. Tente novamente.");
        }

        String cpf;
        while (true) {
            cpf = view.obterCPFCliente();
            if (cpf.trim().equals("0")) {
                view.exibirMensagem("Operacao cancelada.");
                return;
            }
            try {
                if (cpf.trim().length() != 11 || !cpf.trim().matches("\\d+"))
                    throw new ClienteException("CPF invalido. Digite exatamente 11 digitos numericos.");
                if (banco.buscarClientePorCpf(cpf.trim()) != null)
                    throw new ClienteException("CPF ja cadastrado no sistema.");
                break;
            } catch (ClienteException e) {
                view.exibirMensagem("Erro: " + e.getMessage() + " Tente novamente.");
            }
        }

        int id = banco.getClientes().size() + 1;
        banco.salvarCliente(new Client(id, nome.trim(), cpf.trim()));
        view.exibirMensagem("Cliente cadastrado com sucesso! ID: " + id);
    }

    public void listarClientes() {
        view.listarClientes(banco.getClientes());
    }

    public void buscarClientePorCpf() {
        view.exibirMensagem("(Digite 0 para cancelar)");
        while (true) {
            String cpf = view.obterCPFCliente();
            if (cpf.trim().equals("0")) {
                view.exibirMensagem("Operacao cancelada.");
                return;
            }
            Client cliente = banco.buscarClientePorCpf(cpf.trim());
            if (cliente != null) {
                view.exibirMensagem(cliente.toString());
                return;
            }
            view.exibirMensagem("Cliente nao encontrado. Tente novamente (ou 0 para cancelar).");
        }
    }
}
