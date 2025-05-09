package com.teste.primeiro_exemplo.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.primeiro_exemplo.model.Cliente;
import com.teste.primeiro_exemplo.model.Produto;

import com.teste.primeiro_exemplo.model.exception.ResourceNotFoundException;

@Repository
public class ClienteRepository_old {
    List<Cliente> clientes = new ArrayList<>();
    private Integer ultimoId = 0;

    /**
     * Método obter todos os clientes
     * @return lista de clientes
     */
    public List<Cliente> obterTodos(){
        return clientes;
    }

    /**
     * Método para obter cliente por id
     * @param id id do cliente que sera localizado
     * @return o cliente localizado
     */
    public Optional<Cliente> obterPorId(Integer id){
        return clientes
        .stream().filter(cliente -> cliente.getId() == id)
        .findFirst();
    }

    /**
     * Método para adicionar cliente a lista
     * @param cliente que sera adicionado
     * @return retornar o clinte que foi adicionado
     */
    public Cliente adicionar(Cliente cliente){
        ultimoId ++;
        cliente.setId(ultimoId);
        clientes.add(cliente);
        return cliente;
    }



    
    /**
     * Método para deletar o cleinte por id.
     * @param  id do cliente a ser deletado
     */
    public void deletar(Integer id){
        clientes.removeIf(cliente -> cliente.getId() == id);
    }
    
    /**
     * Método par atualziar o cliente na lista
     * @param cliente cliente que sera tualziado
     * @return retorna o cliente apois atualizar a lsita
     */
    public  Cliente atualizar(Cliente cliente){
        Optional <Cliente> clienteEncontrado = obterPorId(cliente.getId());

        if(clienteEncontrado.isEmpty()){
            throw new ResourceNotFoundException("Cliente não pode ser atualizado, pois não foi encontrado");
        }
       //remove o cleinte antigo da lista
        deletar(cliente.getId());

        //Adiciona o cliente atualizado na lista
        clientes.add(cliente);
        return cliente;
    }
}
