package br.inatel.cdg.pcs;

public class Computador {
    private final String marca;
    private final float preco;
    private final SistemaOperacional sistemaOperacional;
    private final HardwareBasico[] hardwares;
    private MemoriaUSB memoriaUSB;

    //Construtor
    public Computador(String marca, float preco, String soNome, int soTipo) {
        this.marca = marca;
        this.preco = preco;
        this.sistemaOperacional = new SistemaOperacional(soNome, soTipo);
        this.hardwares = new HardwareBasico[10];
    }

    //Associação entre Memória USB e PC
    public void addMemoriaUSB(MemoriaUSB musb) {
        this.memoriaUSB = musb;
    }

    //Permite que o Cliente calcule o total
    public float getPreco() {
        return preco;
    }

    //Metodo para preencher o array interno de Hardwares
    public void addHardware(HardwareBasico hb, int posicao) {
        if (posicao >= 0 && posicao < hardwares.length) {
            this.hardwares[posicao] = hb;
        }
    }

    //Exibir as configurações do computador
    public void mostraPCConfigs() {
        System.out.println("===========================");
        System.out.println("Marca: " + marca);
        System.out.printf("Preço: R$ %.2f\n", preco);
        System.out.println("Sistema Operacional: " + sistemaOperacional.getNome() + " (" + sistemaOperacional.getTipo() + " bits)");

        System.out.println("Hardwares Integrados:");
        for (HardwareBasico hb : hardwares) {
            if (hb != null) {
                String unidade = "";
                String nomeLower = hb.getNome().toLowerCase();

                if (nomeLower.contains("processador") || nomeLower.contains("core") || nomeLower.contains("pentium")) {
                    unidade = " MHz";
                } else {
                    unidade = " Gb";
                }

                System.out.println(" - " + hb.getNome() + ":  " + (int) hb.getCapacidade() + unidade);
            }
        }
        if (memoriaUSB != null) {
            System.out.println("Acompanha: " + memoriaUSB.getNome() + " de " + memoriaUSB.getCapacidade() + "Gb");
        }
        System.out.println("===========================");
    }
}
