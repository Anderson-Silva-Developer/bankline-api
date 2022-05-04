package com.dio.santander.bankline.api.dto;

public class CorrentistaDTO {
    private String nome;
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    private CorrentistaDTO(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    public static class CorrentistaDTOBuild{
        private String nome;
        private String cpf;

        public CorrentistaDTOBuild() {

        }
        public CorrentistaDTOBuild nome(String nome){
            this.nome=nome;
            return this;
        }
        public CorrentistaDTOBuild cpf(String cpf){
            this.cpf=cpf;
            return this;
        }
        public CorrentistaDTO create(){
            return new CorrentistaDTO(this.nome,this.cpf);
        }
    }
}
