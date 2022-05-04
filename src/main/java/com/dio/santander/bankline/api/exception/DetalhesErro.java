package com.dio.santander.bankline.api.exception;

public class DetalhesErro {
    private String titulo;
    private Long status;
    private Long timestamp;
    private String menssagemDesenvolvedor;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMenssagemDesenvolvedor() {
        return menssagemDesenvolvedor;
    }

    public void setMenssagemDesenvolvedor(String menssagemDesenvolvedor) {
        this.menssagemDesenvolvedor = menssagemDesenvolvedor;
    }

    private DetalhesErro(String titulo, Long status, Long timestamp, String menssagemDesenvolvedor) {
        this.titulo = titulo;
        this.status = status;
        this.timestamp = timestamp;
        this.menssagemDesenvolvedor = menssagemDesenvolvedor;
    }
    public static class DetalhesErroBuild{
        private String titulo;
        private Long status;
        private Long timestamp;
        private String menssagemDesenvolvedor;

        public DetalhesErroBuild() {
        }
        public DetalhesErroBuild titulo(String titulo){
            this.titulo=titulo;
            return this;
        }
        public DetalhesErroBuild status(Long status){
            this.status=status;
            return this;
        }
        public DetalhesErroBuild timestamp(Long timestamp){
            this.timestamp=timestamp;
            return this;
        }
        public DetalhesErroBuild menssagemDesenvolvedor(String menssagemDesenvolvedor){
            this.menssagemDesenvolvedor=menssagemDesenvolvedor;
            return this;
        }
        public DetalhesErro create(){
            return new DetalhesErro(this.titulo,this.status,this.timestamp,this.menssagemDesenvolvedor);
        }
    }
}
