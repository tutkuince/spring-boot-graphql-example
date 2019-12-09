package com.muditasoft.springbootgraphqlexample.repository;

import com.muditasoft.springbootgraphqlexample.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
