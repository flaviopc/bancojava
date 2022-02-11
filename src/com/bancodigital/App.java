package com.bancodigital;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Cliente silvio = new Cliente("Silvio Santos");
        Cliente fausto = new Cliente("Fausto Silva");
        Cliente celso = new Cliente("Celso Portioli");
        Cliente galvao = new Cliente("Galvão Bueno");
        Conta cc = new ContaCorrente(silvio);
        cc.depositar(345);
        Conta cp = new ContaPoupanca(fausto);
        cp.depositar(605);
        Conta cc2 = new ContaCorrente(celso);
        cc2.depositar(239);
        Conta cp2 = new ContaPoupanca(galvao);
        cp2.depositar(120);
        cp.transferir(123, cp2);
        cp.imprimirExtrato();
        cp2.imprimirExtrato();
        List<Conta> contas = new ArrayList<>();
        contas.add(cc);
        contas.add(cp);
        contas.add(cc2);
        contas.add(cp2);
        Banco banco = new Banco("Banco dos Famosos", contas);
        banco.imprimirContas();

    }
}
