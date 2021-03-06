package com.dio.santander.bankline.api.model;

import com.dio.santander.bankline.api.enuns.MovimentacaoTipo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Table(name = "tab_movimentacao")
public class Movimentacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "data_hora")
    private LocalDateTime dataHora;
    private String descricao;
    private BigDecimal valor;
    @Enumerated(EnumType.STRING)
    private MovimentacaoTipo tipo;
    @Column(name = "id_conta")
    private Integer idConta;

    public Movimentacao() {

    }
    public Integer getId() {
        return id;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
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

    private Movimentacao(LocalDateTime dataHora, String descricao, BigDecimal valor, MovimentacaoTipo tipo,Integer idConta) {
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.idConta=idConta;
    }
    public static class MovimentacaoBuild{

        private LocalDateTime dataHora;
        private String descricao;
        private BigDecimal  valor;
        private MovimentacaoTipo tipo;

        private Integer idConta;

        public MovimentacaoBuild() {
        }
        public MovimentacaoBuild dataHora(LocalDateTime dataHora){
            this.dataHora=dataHora;
            return this;
        }
        public MovimentacaoBuild descricao(String descricao){
            this.descricao=descricao;
            return this;
        }
        public MovimentacaoBuild valor(BigDecimal  valor){
            this.valor=valor;
            return this;
        }
        public MovimentacaoBuild tipo(MovimentacaoTipo tipo){
            this.tipo=tipo;
            return this;
        }
        public MovimentacaoBuild idConta(Integer idConta){
            this.idConta=idConta;
            return this;
        }
        public Movimentacao create(){
            return new Movimentacao(this.dataHora,this.descricao,this.valor,this.tipo,this.idConta);
        }
    }
}
