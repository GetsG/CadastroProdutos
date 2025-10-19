package br.com.produtos.controller;

import br.com.produtos.model.Produto;
import br.com.produtos.services.ProdutosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosServices services;

    @GetMapping
    public List<Produto> listarProdutos(){
        return services.findAll();
    }

    @GetMapping(value = "/{id}")
    public Produto mostrarProdutoPorId(@PathVariable("id") Long id){
        return services.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Produto criarProduto(@RequestBody Produto produto) {
        return services.create(produto);
    }

    @PutMapping(value = "/{id}")
    public Produto atualizarProduto(@PathVariable("id") Long id, @RequestBody Produto produto){
        produto.setId(id);
        return services.update(produto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> removerProduto(@PathVariable("id") Long id){
        services.delete(id);
        return ResponseEntity.noContent().build();
    }


}
