package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.dto.MovimentacaoDTO;
import com.dio.santander.bankline.api.enuns.MovimentacaoTipo;
import com.dio.santander.bankline.api.exception.CorrentistaNotBalance;
import com.dio.santander.bankline.api.exception.CorrentistaNotFound;
import com.dio.santander.bankline.api.exception.MovimentacaoNotSave;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimentacaoService {
    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    @Autowired
    CorrentistaRepository correntistaRepository;
    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }

    public Movimentacao save(MovimentacaoDTO movimentacaoDTO) {

        BigDecimal valor = movimentacaoDTO.getTipo()== MovimentacaoTipo.RECEITA?movimentacaoDTO.getValor():movimentacaoDTO.getValor().negate();
        Movimentacao movimentacao=new Movimentacao.MovimentacaoBuild()
                .dataHora(LocalDateTime.now())
                .descricao(movimentacaoDTO.getDescricao())
                .idConta(movimentacaoDTO.getIdConta())
                .tipo(movimentacaoDTO.getTipo())
                .valor(valor)
                .create();

        Correntista correntista=correntistaRepository
                .findById(movimentacaoDTO.getIdConta())
                .orElseThrow(()->new CorrentistaNotFound("Correntista não encontrado"));

        if(movimentacaoDTO.getTipo()==MovimentacaoTipo.DESPESA){
            if(correntista.getConta().getSaldo().compareTo(valor)>=0){
             throw new CorrentistaNotBalance("Saldo Insuficiente");
            }

        }

        correntista.getConta().setSaldo(correntista.getConta().getSaldo().add(valor));
        correntistaRepository.save(correntista);

        movimentacao =movimentacaoRepository.save(movimentacao);
        this.movimentacaoRepository.findById(movimentacao.getId())
                .orElseThrow(()->new MovimentacaoNotSave("Movimentação não salva"));

        return movimentacao;

    }
}
