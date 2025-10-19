package br.com.produtos.services;

import br.com.produtos.exception.UsuarioNaoEncontradoException;
import br.com.produtos.model.Produto;
import br.com.produtos.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosServices {

    @Autowired
    ProdutosRepository repository;

    public List<Produto> findAll(){
        return repository.findAll();
    }

    public Produto findById(Long id){
        return repository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario Não encontrado"));
    }

    public Produto create(Produto person){
        return repository.save(person);
    }

    public Produto update(Produto product){
        Produto entity = repository.findById(product.getId()).orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario Não encontrado"));

        entity.setDescription(product.getDescription());
        entity.setValue(product.getValue());
        entity.setImagem(product.getImagem());

        return repository.save(product);
    }

    public void delete(Long id){
        Produto entity = repository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario Não encontrado"));
    }

}
