package com.teste.primeiro_exemplo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.primeiro_exemplo.model.Cliente;
import com.teste.primeiro_exemplo.model.Produto;
import com.teste.primeiro_exemplo.services.ClienteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> obterTodos(){
        return clienteService.obterTodos();
    }   

    @PostMapping
    public Cliente adionar(@RequestBody Cliente cliente){
        return clienteService.adicionar(cliente);
    }

    @GetMapping("/{id}")
    public Optional<Cliente> ObterPorId(@PathVariable Integer id){
        return clienteService.obterPorId(id);
    }
   
     @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
        clienteService.deletar(id);
        return "Produto com id: " + id +" foi deletado";
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@RequestBody Cliente cliente, @PathVariable Integer id){
        return clienteService.atualizar(id, cliente);
    }



}
