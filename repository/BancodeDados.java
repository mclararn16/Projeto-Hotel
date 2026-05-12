package repository;

import model.Client;
import model.Quarto;
import model.Reserva;
import java.util.ArrayList;
import java.util.List;

public class BancodeDados {
    private List<Client> clientes;
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public BancodeDados() {
        clientes = new ArrayList<>();
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public List<Client> getClientes() { return clientes; }
    public List<Quarto> getQuartos() { return quartos; }
    public List<Reserva> getReservas() { return reservas; }

    public void salvarCliente(Client c) { clientes.add(c); }
    public void salvarQuarto(Quarto q) { quartos.add(q); }
    public void salvarReserva(Reserva r) { reservas.add(r); }

    public Client buscarClientePorId(int id) {
        for (Client c : clientes) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public Client buscarClientePorCpf(String cpf) {
        for (Client c : clientes) {
            if (c.getCpf().equals(cpf)) return c;
        }
        return null;
    }

    public Quarto buscarQuartoPorNumero(int numero) {
        for (Quarto q : quartos) {
            if (q.getNumero() == numero) return q;
        }
        return null;
    }

    public Quarto buscarQuartoDisponivel() {
        for (Quarto q : quartos) {
            if (q.isDisponivel()) return q;
        }
        return null;
    }

    public List<Reserva> buscarReservasPorCliente(int idCliente) {
        List<Reserva> resultado = new ArrayList<>();
        for (Reserva r : reservas) {
            if (r.getCliente().getId() == idCliente) resultado.add(r);
        }
        return resultado;
    }

    public Reserva buscarReservaPorId(int id) {
        for (Reserva r : reservas) {
            if (r.getId() == id) return r;
        }
        return null;
    }
}
