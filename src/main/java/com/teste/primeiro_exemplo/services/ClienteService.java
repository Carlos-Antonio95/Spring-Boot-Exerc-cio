package com.teste.primeiro_exemplo.services;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiro_exemplo.model.Cliente;
import com.teste.primeiro_exemplo.repository.ClienteRepository;
import com.teste.primeiro_exemplo.repository.ClienteRepository_old;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    /**
     * Método obter todos os clientes
     * @return lista de clientes
     */
    public List<Cliente> obterTodos(){
        return clienteRepository.findAll();
    }

    /**
     * Método para obter cliente por id
     * @param id id do cliente que sera localizado
     * @return o cliente localizado
     */
    public Optional<Cliente> obterPorId(Integer id){
        return clienteRepository.findById(id);


    }

    /**
     * Método para adicionar cliente a lista
     * @param cliente que sera adicionado
     * @return retornar o clinte que foi adicionado
     */
    public Cliente adicionar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    /**
     * Método para deletar o cleinte por id.
     * @param  id do cliente a ser deletado
     */
    public void deletar(Integer id){
        clienteRepository.deleteById(id);
    }

    /**
     * Método par atualziar o cliente na lista
     * @param cliente cliente que sera tualziado
     * @return retorna o cliente apois atualizar a lsita
     */ 
     public  Cliente atualizar(Integer id, Cliente cliente){
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }
}
