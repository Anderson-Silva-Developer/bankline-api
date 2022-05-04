package com.dio.santander.bankline.api.controllers;

import com.dio.santander.bankline.api.dto.CorrentistaDTO;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

    @Autowired
    CorrentistaService correntistaService;
    @GetMapping
    public ResponseEntity<List<Correntista>> findAll(){
        return   ResponseEntity.ok().body(correntistaService.findAll());
    }
    @PostMapping
    public ResponseEntity<Correntista>save(@RequestBody CorrentistaDTO correntistaDTO){
        Correntista correntista = correntistaService.save(correntistaDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body(correntista);
    }
}
