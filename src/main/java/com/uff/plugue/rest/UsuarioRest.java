package com.uff.plugue.rest;

import javax.naming.AuthenticationException;

import com.uff.plugue.model.Usuario;
import com.uff.plugue.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuario")
@Api(value = "Usuario")
public class UsuarioRest {

    @Autowired
    UsuarioService usuarioService = new UsuarioService();
    
    @GetMapping
    @ApiOperation(value = "Login usuário")
    public Usuario login(@RequestParam("login") String login, @RequestParam("senha") String senha) {

        try {
            return usuarioService.login(login, senha);
        } catch (AuthenticationException e) {
            System.out.println("Falha na autenticação");
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Alterar senha")
    public String alteraSenha(@PathVariable("id") int id, @RequestParam("senha") String senha) {
        return usuarioService.resetSenha(id, senha);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Excluir usuario")
    public String excluiUsuario(@PathVariable("id") int id){
        return usuarioService.deleteUsuario(id);
    }
}
