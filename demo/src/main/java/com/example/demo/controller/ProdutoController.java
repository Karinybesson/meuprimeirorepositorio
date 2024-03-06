package com.example.demo.controller;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping (path = "/add")

    public @ResponseBody String add(
            @RequestParam String nome,
            @RequestParam String descricao,
            @RequestParam int quantidade_estoque){

        Produto produto = new Produto();
        produto.setDescricao(descricao);
        produto.setNome(nome);
        produto.setQuantidade_estoque(quantidade_estoque);
        produtoRepository.save(produto);
        return "salvou";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<com.example.demo.model.Produto> getAll(){
        return produtoRepository.findAll();

    }
}


