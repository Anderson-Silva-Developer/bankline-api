package com.dio.santander.bankline.api.dto;

import com.dio.santander.bankline.api.enuns.MovimentacaoTipo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MovimentacaoDTO {
    private String descricao;
    private BigDecimal valor;
    private MovimentacaoTipo tipo;
    private Integer idConta;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal  getValor() {
        return valor;
    }

    public void setValor(BigDecimal  valor) {
        this.valor = valor;
    }

    public MovimentacaoTipo getTipo() {
        return tipo;
    }

    public void setTipo(MovimentacaoTipo tipo) {
        this.tipo = tipo;
    }

    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    private MovimentacaoDTO(String descricao, BigDecimal  valor, MovimentacaoTipo tipo,Integer idConta) {
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.idConta=idConta;
    }
    public static class MovimentacaoDTOBuild{

        private LocalDateTime dataHora;
        private String descricao;
        private BigDecimal  valor;
        private MovimentacaoTipo tipo;
        private Integer idConta;

        public MovimentacaoDTOBuild() {
        }
        public MovimentacaoDTOBuild dataHora(LocalDateTime dataHora){
            this.dataHora=dataHora;
            return this;
        }
        public MovimentacaoDTOBuild descricao(String descricao){
            this.descricao=descricao;
            return this;
        }
        public MovimentacaoDTOBuild valor(BigDecimal valor){
            this.valor=valor;
            return this;
        }
        public MovimentacaoDTOBuild tipo(MovimentacaoTipo tipo){
            this.tipo=tipo;
            return this;
        }
        public MovimentacaoDTOBuild idConta(Integer idConta){
            this.idConta=idConta;
            return this;
        }
        public MovimentacaoDTO create(){
            return new MovimentacaoDTO(this.descricao,this.valor,this.tipo,this.idConta);
        }
    }
}
