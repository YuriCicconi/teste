package org.example.models;

public class Empresa{

    private String nome;
    private String cnpj;
    private Double saldo;
    private Double taxas;

    public Empresa(String nome, String cnpj, Double taxas) {
        this.nome = nome;

        if (CNP.isValidCNPJ(cnpj)) {
            this.cnpj = cnpj;
        } else {
            this.cnpj = "CNPJ inválido.";
        }

        this.taxas = taxas;
        this.saldo = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public Double getSaldo() {
        return saldo / 100;
    }

    public Double getTaxas() {
        return taxas;
    }

    public void depositar(Double valor) {

        this.saldo += valor;
    }

    public void sacar(Double valor) {

        this.saldo -= valor;
    }


}
