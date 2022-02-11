package com.bancodigital;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome, List<Conta> contas) {
        this.nome = nome;
        this.contas = contas;
    }

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void addConta(Conta conta) {
        this.contas.add(conta);
    }

    public void imprimirContas() {
        System.out.println("============ " + this.nome + " ============");
        System.out.println("Data: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        System.out.println("Lista de contas:");
        System.out.println("------------------------------------");
        for (Conta conta : contas) {
            conta.imprimirDadosConta();
            System.out.println("------------------------------------");
        }
    }

    public void imprimirClientes() {
        System.out.println("============ " + this.nome + " ============");
        System.out.println("Data: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        System.out.println("Lista de clientes:");
        System.out.println("------------------------------------");
        for (Conta conta : contas) {
            System.out.println("--- " + conta.getCliente());
            System.out.println("------------------------------------");
        }
    }
}
