package com.teste.primeiro_exemplo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.teste.primeiro_exemplo.model.Produto;
import com.teste.primeiro_exemplo.model.exception.ResourceNotFoundException;

@Repository
public class ProdutoRepository_old {
    //simulando o banco de dados
    private List<Produto> produtos = new ArrayList<>();
    private Integer ultimoId = 0;

    /**
     * método para Retorna uma lista de produtos
     * @return Lista de produtos
     */
    public List<Produto> obterTodos(){
        return produtos;
        
    }

    /**
     * Método que retorna o produto encontrado pelo seu Id
     * @param id do produto que sera localizado
     * @return Retornar um produto caso seja encontrado.
     */
    public Optional<Produto>obterPorId(Integer id){
        return produtos
        .stream()
        .filter(produto -> produto.getId() == id)
        .findFirst();
    }

    /**
     * Método para adicionar produto a lista
     * @param produto que sera adicionado
     * @return retorna o produto que foi adcionado na lista
     */
    public Produto adicionar(Produto produto){
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }

    /**
     * Método para deletar o produto por id.
     * @param  id do produto a ser deletado
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Método par atualziar o produto na lista
     * @param produto produto que sera tualziado
     * @return retorna o produto apois atualizar a lsita
     */
    public  Produto atualizar(Produto produto){
        Optional <Produto> produtoEncontrado = obterPorId(produto.getId());

        if(produtoEncontrado.isEmpty()){
            throw new ResourceNotFoundException("Produto não pode ser atializado, pois não existe");
        }
       //remove o produto antigo da lista
        deletar(produto.getId());

        //Adiciona o produto atualizado na lista
        produtos.add(produto);
        return produto;
    }
    
}
