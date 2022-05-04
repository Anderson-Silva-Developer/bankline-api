package com.dio.santander.bankline.api.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Conta {
    @Column(name = "conta_numero")
    private Long numero;
    @Column(name = "conta_saldo")
    private Double saldo;

    public Conta() {

    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    private Conta(Long numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public static class ContaBuild{
        private Long numero;
        private Double saldo;

        public ContaBuild() {
        }
        public ContaBuild numero(Long numero){
            this.numero=numero;
            return this;
        }
        public ContaBuild saldo(Double saldo){
            this.saldo=saldo;
            return this;
        }
        public Conta create(){
            return new Conta(this.numero,this.saldo);
        }
    }
}
