package com.dio.santander.bankline.api.controllers;

import com.dio.santander.bankline.api.dto.CorrentistaDTO;
import com.dio.santander.bankline.api.dto.MovimentacaoDTO;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.service.CorrentistaService;
import com.dio.santander.bankline.api.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    MovimentacaoService movimentacaoService;
    @GetMapping
    public ResponseEntity<List<Movimentacao>> findAll(){
        return ResponseEntity.ok(movimentacaoService.findAll());
    }
    @PostMapping
    public ResponseEntity<Movimentacao> save(@RequestBody MovimentacaoDTO movimentacaoDTO){
        Movimentacao movimentacao = this.movimentacaoService.save(movimentacaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacao);
    }
}
