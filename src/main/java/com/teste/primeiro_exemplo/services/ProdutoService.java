package com.teste.primeiro_exemplo.services;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiro_exemplo.model.Produto;
import com.teste.primeiro_exemplo.repository.ProdutoRepository;
import com.teste.primeiro_exemplo.repository.ProdutoRepository_old;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    
    /**
     * método para Retorna uma lista de produtos
     * @return Lista de produtos
     */
    public List<Produto> obeterTodos(){
        return produtoRepository.findAll();
    }

    /**
     * Método que retorna o produto encontrado pelo seu Id
     * @param id do produto que sera localizado
     * @return Retornar um produto caso seja encontrado.
     */
    public Optional<Produto>obterPorId(Integer id){
     return produtoRepository.findById(id);
    }

    /**
     * Método para adicionar produto a lista
     * @param produto que sera adicionado
     * @return retorna o produto que foi adcionado na lista
     */
    public Produto adicionar(Produto produto){
        //Poderia ter alguma regra de negocio aqui
        return produtoRepository.save(produto);
    }

    /**
     * Método para deletar o produto por id.
     * @param  id do produto a ser deletado
     */
    public void deletar(Integer id){
        // poderia ter logic de validação
        produtoRepository.deleteById(id);
    }

     /**
     * Método par atualziar o produto na lista
     * @param produto produto que sera tualziado
     * @return retorna o produto apois atualizar a lsita
     */
    public  Produto atualizar(Integer id, Produto produto){
        //Pode ter alguma validação no id
       produto.setId(id);
        return produtoRepository.save(produto);
    }

    

}
