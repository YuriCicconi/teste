package org.example.models;
import org.example.models.CNP;


public class Cliente{

    private String nome;
    private String cpf;
    private Double saldo;

    public Cliente(String nome, String cpf, Double saldo){
        this.nome = nome;

        try {
            if (CNP.isValidCPF(cpf)) {
                this.cpf = cpf;
            } else {
                this.cpf = "CPF inválido.";
            }
        } catch (RuntimeException e) {
            e.getMessage();
        }


        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getSaldo() {
        return saldo / 100;
    }

    public void depositar(Double valor, Empresa empresa) {

        if (valor <=  0) {
            System.out.println("O valor deve ser maior do que 0.");
            return;
        }

        try {

            if ((this.getSaldo() * 100) >= valor) {
                this.saldo -= valor;
                empresa.depositar(valor);
            } else {
                System.out.println("Saldo insuficiente.");
            }

        } catch (RuntimeException e) {
            e.getMessage();
        }
    }

    public void sacar(Double valor, Empresa empresa) {

        if (valor <= 0) {
            System.out.println("O vaor deve ser maior do que 0.");
            return;
        }

        try {
            if ((empresa.getSaldo() * 100) >= valor) {
                this.saldo += valor * (1 - empresa.getTaxas());
                empresa.sacar(valor);
            } else {
                System.out.println("Saldo insuficiente.");
            }

        } catch (RuntimeException e) {
            e.getMessage();
        }
    }
}
