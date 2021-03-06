package com.dio.santander.bankline.api.model;

import javax.persistence.*;

@Entity
@Table(name = "tab_correntista")
public class Correntista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 20)
    private String cpf;
    @Column(length = 60)
    private String nome;
    @Embedded
    private Conta conta;

    public Correntista() {

    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Integer getId() {
        return id;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private Correntista(String cpf, String nome,Conta conta) {
        this.cpf = cpf;
        this.nome = nome;
        this.conta=conta;
    }

    public static class CorrentistaBuild {
        private String cpf;
        private String nome;
        private Conta conta;
        public CorrentistaBuild() {

        }
        public CorrentistaBuild cpf(String cpf){
            this.cpf=cpf;
            return this;
        }
        public CorrentistaBuild nome(String nome){
            this.nome=nome;
            return this;
        }
        public CorrentistaBuild conta(Conta conta){
            this.conta=conta;
            return this;
        }
        public Correntista create(){
            return new Correntista(this.cpf,this.nome,this.conta);
        }

    }


}
