package model;

public class Client {
    private int id;
    private String nome;
    private String cpf;
    private int quantidadeReservas;

    public Client(int id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.quantidadeReservas = 0;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public int getQuantidadeReservas() { return quantidadeReservas; }

    public void incrementarReservas() { this.quantidadeReservas++; }

    public void decrementarReservas() {
        if (this.quantidadeReservas > 0) this.quantidadeReservas--;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | CPF: " + cpf + " | Reservas ativas: " + quantidadeReservas;
    }
}
