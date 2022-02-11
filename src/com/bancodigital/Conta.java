package com.bancodigital;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 2321;
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    private boolean verificaSaldo(double valor) {
        if (saldo < valor)
            return false;
        return true;
    }

    @Override
    public void sacar(double valor) {
        if (verificaSaldo(valor)) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente!");
        }

    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado com sucesso!");
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (verificaSaldo(valor)) {
            this.saldo -= valor;
            contaDestino.depositar(valor);
            imprimirComprovanteTransferencia(valor, contaDestino);
        } else {
            System.out.println("Saldo insuficiente!");
        }

    }

    protected void dataHora() {
        System.out.println(
                "Data da operação: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }

    protected void imprimirDadosConta() {
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println("Agencia: " + this.agencia + " Conta: " + this.numero);
        System.out.println("Saldo: " + this.saldo);
    }

    private void imprimirComprovanteTransferencia(double valor, Conta contaDestino) {
        System.out.println("============= Comprovante de Transferência =============");
        dataHora();
        System.out.println("Dados da conta de origem:");
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println("Agencia: " + this.agencia + " Conta: " + this.numero);
        System.out.println("Valor: " + valor);
        System.out.println("Dados da conta de destino:");
        System.out.println("Titular: " + contaDestino.cliente.getNome());
        System.out.println("Agencia: " + contaDestino.agencia + " Conta: " + contaDestino.numero);
    }

    public String getCliente() {
        return this.cliente.getNome();
    }

}
