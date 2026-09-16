package br.inatel.cdg.pagamento;

import br.inatel.cdg.pcs.Computador;

public class Cliente {
    private String nome;
    private String cpf;
    private Computador[]  computadores;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.computadores = new Computador[12]; //Capacidade do carrinho de compras
    }

    //Metodo que adiciona PCs ao carrinho do cliente
    public void comprarComputador(Computador pc) {
        for (int i = 0; i < computadores.length; i++) {
            if (computadores[i] == null) {
                computadores[i] = pc;
                break;
            }
        }
    }

    //Soma o preço de todos os computadores comprados
    public float calculaTotalCompra() {
        float total =  0;
        for (Computador c : computadores) {
            if(c != null) {
                total += c.getPreco();
            }
        }
        return total;
    }

    // Getter para que o ProcessarPedido ou Main possa acessar os PCs do cliente
    public Computador[] getComputadores() {
        return computadores;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
