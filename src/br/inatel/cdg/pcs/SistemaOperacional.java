package br.inatel.cdg.pcs;

public class SistemaOperacional {
    private String nome;
    private int tipo;

    //Construtor explícito recebendo parâmetros
    public SistemaOperacional(String soNome, int soTipo) {
        this.nome = soNome;
        this.tipo = soTipo;
    }

    public String getNome() {
        return nome;
    }

    public int getTipo() {
        return tipo;
    }
}
