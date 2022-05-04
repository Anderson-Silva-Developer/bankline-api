package com.dio.santander.bankline.api.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Conta {
    @Column(name = "conta_numero")
    private Long numero;
    @Column(name = "conta_saldo")
    private BigDecimal saldo;

    public Conta() {

    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public BigDecimal  getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal  saldo) {
        this.saldo = saldo;
    }

    private Conta(Long numero, BigDecimal  saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public static class ContaBuild{
        private Long numero;
        private BigDecimal  saldo;

        public ContaBuild() {
        }
        public ContaBuild numero(Long numero){
            this.numero=numero;
            return this;
        }
        public ContaBuild saldo(BigDecimal  saldo){
            this.saldo=saldo;
            return this;
        }
        public Conta create(){
            return new Conta(this.numero,this.saldo);
        }
    }
}
