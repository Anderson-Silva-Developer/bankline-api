package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.dto.CorrentistaDTO;
import com.dio.santander.bankline.api.exception.CorrentistaNotSave;
import com.dio.santander.bankline.api.model.Conta;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class CorrentistaService {
    @Autowired
    CorrentistaRepository correntistaRepository;

    public Correntista save(CorrentistaDTO correntistaDTO){
        Conta conta=new Conta.ContaBuild()
                .saldo(new BigDecimal("0.00"))
                .numero(new Date().getTime())
                .create();
        Correntista correntista=new Correntista.CorrentistaBuild()
                .nome(correntistaDTO.getNome())
                .cpf(correntistaDTO.getCpf())
                .conta(conta)
                .create();
        correntista=correntistaRepository.save(correntista);
       correntistaRepository.findById(correntista.getId())
               .orElseThrow(()->new CorrentistaNotSave("Correntista não Criado"));

       return correntista;

    }

    public List<Correntista> findAll() {
        return  this.correntistaRepository.findAll();
    }
}
