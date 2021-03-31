package com.uff.plugue.controller;

import java.util.ArrayList;
import java.util.List;

import com.uff.plugue.model.Aluno;
import com.uff.plugue.model.Ideia;
import com.uff.plugue.model.Professor;
import com.uff.plugue.model.Projeto;
import com.uff.plugue.service.AlunoService;
import com.uff.plugue.service.IdeiaService;
import com.uff.plugue.service.ProfessorService;
import com.uff.plugue.service.ProjetoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /*@Autowired
    ProfessorService profService = new ProfessorService();

    @Autowired
    IdeiaService ideiaService = new IdeiaService();

    @Autowired
    AlunoService alunoService = new AlunoService();

    @Autowired
    ProjetoService projetoService = new ProjetoService();*/
    
    @GetMapping(value="/")
    public String getMethodName(){
        
        /*Ideia ideia = new Ideia();
        ideia.setTitulo("teste");
        ideia.setDescricao("teste");
        ideia.setAreaInteresse("teste");

        Professor professor = new Professor();
        List<Ideia> ideias = new ArrayList<>();
        ideias.add(ideia);
        professor.setNome("teste2");
        professor.setContato("teste2@gmail.com");
        professor.setSenha("****");
        professor.setPaginaPessoal("teste2.com.br");
        professor.setIdeias(ideias);
        
        Projeto projeto = new Projeto();
        List<Aluno> alunos = new ArrayList<>();
        projeto.setTitulo("teste");
        projeto.setDesccricao("teste");
        projeto.setAreaInteresse("teste");
        projeto.setAlunos(alunos);

        Aluno aluno = new Aluno();
        List<Projeto> projetos = new ArrayList<>();
        aluno.setNome("teste");
        aluno.setContato("teste@gmail.com");
        aluno.setCurso("teste");
        aluno.setSenha("****");
        aluno.setProjetos(projetos);

        //profService.addProfessor(professor);
        //ideiaService.addIdeia(ideia);
        //alunoService.addAluno(aluno);
        //projetoService.addProjeto(projeto);*/

        return "Hello Word";
    }
}
