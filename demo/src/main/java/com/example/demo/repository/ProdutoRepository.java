package com.example.demo.repository;

import com.example.demo.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
