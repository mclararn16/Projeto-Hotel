package main;

import model.Quarto;

public class Main {
    public static void main(String[] args) {
        Quarto q = new Quarto(101, "Clássico", 120.0);
        System.out.println("Testando a  Main");
        System.out.printf("Quarto %d (%s) / diária R$ %.2f, status: %s%n",
                q.getNumero(), q.getTipo(), q.getDiaria(), q.getStatus());
    }
}