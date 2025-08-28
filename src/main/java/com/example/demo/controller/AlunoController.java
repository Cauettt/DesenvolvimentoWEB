package com.example.demo.controller;

import com.example.demo.entity.Aluno;
import com.example.demo.service.AlunoService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    private List<Aluno> buscarAlunos(){
        return alunoService.findAllAluno();
    }
    @GetMapping("/{id}")
    private ResponseEntity<Aluno> buscarPorId(@PathVariable Long id){
        return alunoService.findAlunoById(id)
                .map(aluno -> new ResponseEntity<>(aluno, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    private Aluno criarAluno(@RequestBody Aluno aluno){
        return alunoService.saveAluno(aluno);
    }


}
