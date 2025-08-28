package com.example.demo.controller;


import com.example.demo.entity.Aluno;
import com.example.demo.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
     private AlunoService alunoService;

    @GetMapping
    private List<Aluno> buscarAluno(){
        return alunoService.findAllAlunos();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Aluno> buscarAlunoPorid(@PathVariable Long id){
    return alunoService.findAlunoById(id)
            .map(aluno -> new ResponseEntity<>(aluno, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));


    }

    private Aluno crarAluno(Aluno aluno){
        return alunoService.saveAluno(aluno);
    }

    private ResponseEntity<Void> excluirAluno(@PathVariable Long id){
        alunoService.


    }
}
