package repository;

import model.Client;
import model.Quarto;
import java.util.ArrayList;
import java.util.List;

public class BancodeDados {
  private List<Client> clientes;
  private List<Quarto> quartos;

  public BancodeDados() {
    clientes = new ArrayList<>();
    quartos = new ArrayList<>();
  }

  public List<Client> getClientes() {
    return clientes;
  }

  public List<Quarto> getQuartos() {
    return quartos;
  }

  public void salvarCliente(Client c) {
    clientes.add(c);
  }

  public void salvarQuarto(Quarto q) {
    quartos.add(q);
  }

  public Quarto buscarQuartoDisponivel() {
    for (Quarto q : quartos) {
      if (q.isDisponivel()) {
        return q;
      }
    }
    return null;
  }
}

