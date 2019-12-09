package com.muditasoft.springbootgraphqlexample.repository;

import com.muditasoft.springbootgraphqlexample.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
