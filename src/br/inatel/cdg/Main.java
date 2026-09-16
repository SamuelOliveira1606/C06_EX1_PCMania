package br.inatel.cdg;

import br.inatel.cdg.pagamento.*;
import br.inatel.cdg.pcs.*;

import java.util.Scanner;

public class Main {
    static void main() {
        int matricula = 1014;

        //Promoção - 1 (Apple)
        Computador promo1 = new Computador("Apple", matricula, "macOS Sequoia", 64);
        promo1.addHardware(new HardwareBasico("Pentium Core i5", 2200), 0);
        promo1.addHardware(new HardwareBasico("Memória RAM", 8), 1);
        promo1.addHardware(new HardwareBasico("HD", 500), 2);
        promo1.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));

        //Promoção - 2 (Samsung)
        Computador promo2 = new Computador("Samsung", matricula + 1, "Windows 8", 64);
        promo2.addHardware(new HardwareBasico("Pentium Core i7", 3370), 0);
        promo2.addHardware(new HardwareBasico("Memória RAM", 16), 1);
        promo2.addHardware(new HardwareBasico("HD", 1000), 2);
        promo2.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));

        //Promoção 3 (Dell)
        Computador promo3 = new Computador("Dell", matricula + 2, "Windows 10", 64);
        promo3.addHardware(new HardwareBasico("Pentium Core i7", 4500), 0);
        promo3.addHardware(new HardwareBasico("Memória RAM", 32), 1);
        promo3.addHardware(new HardwareBasico("HD", 2000), 2);
        promo3.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000));

        //Instanciar o Scanner e o Cliente
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente("Samuel Silva Oliveira", "123.456.789.00");

        int opcao = -1;

        System.out.println("=== BEM VINDO À PC MANIA!!! ===");

        //Loop de compras
        while (opcao != 0) {
        System.out.println("\nSelecione a promoção desejada:");
        System.out.println("1 - Promoção 1 (Apple)");
        System.out.println("2 - Promoção 2 (Samsung)");
        System.out.println("3 - Promoção 3 (Dell)");
        System.out.println("0 - Sair e finalizar a compra");
        System.out.println("Sua opção: ");

        opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                cliente.comprarComputador(promo1);
                System.out.println(">> Promoção 1 adicionada ao carrinho!");
                break;
            case 2:
                cliente.comprarComputador(promo2);
                System.out.println(">> Promoção 2 adicionada ao carrinho!");
                break;
            case 3:
                cliente.comprarComputador(promo3);
                System.out.println(">> Promoção  3 adicionada ao carrinho!");
                break;
            case 0:
                System.out.println(">> Finalizando o atendimento...");
                break;
            default:
                System.out.println(">> Opção inválida! Tente novamente...");
                break;
        }
        }

        //Metodo Estatico para processar pedidos
        ProcessarPedido.processar(cliente.getComputadores());

        //Dados do cliente
        System.out.println("\n=== RESUMO DA COMPRA ===");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());


        System.out.println("\n=== CARRINHO DE COMPRAS ===");
        boolean comprouAlgum = false;
        for (Computador c : cliente.getComputadores()) {
            if (c != null) {
                c.mostraPCConfigs();
                comprouAlgum = true;
            }
        }
        if (!comprouAlgum) {
            System.out.println("Nenhum computador foi comprado. :(");
        }

        System.out.printf("VALOR TOTAL DA COMPRA: R$ %.2f\n", cliente.calculaTotalCompra());

        scanner.close();
    }
}
