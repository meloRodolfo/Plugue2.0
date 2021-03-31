package com.uff.plugue.rest;

import java.util.Optional;

import com.uff.plugue.model.Professor;
import com.uff.plugue.service.ProfessorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professor")
public class ProfessorRest {

    @Autowired
    ProfessorService professorService = new ProfessorService();

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean novoProfessor(@RequestBody Professor professor) {
        
        return professorService.addProfessor(professor);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean atualizaProfessor(@PathVariable("id") int id, Professor professor) {

        return professorService.updateProfessor(id, professor);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Professor> buscaProfessor(@PathVariable("id") Integer id){
        return professorService.getProfessor(id);
    }

    @DeleteMapping(value = "/{id}")
    public void excluiProfessor(@PathVariable("id") Integer id){
        professorService.deleteProfessor(id);
    }

    /*@GetMapping(value = "/{login}/{senha}", consumes = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    public boolean loginProfessor(@PathVariable("login") String login, @PathVariable("senha") String senha) {

        return professorService.login(login, senha);
    }*/
    
    public void logoutProfessor(Professor professor) {

    }

    public void interessar() {

    }

    @PutMapping(value = "/{id}/{senha}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void alteraSenha(Integer id, String senha) {
        professorService.resetSenha(id, senha);
    }

}
