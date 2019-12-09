package com.muditasoft.springbootgraphqlexample.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.muditasoft.springbootgraphqlexample.entity.Author;
import com.muditasoft.springbootgraphqlexample.entity.Book;
import com.muditasoft.springbootgraphqlexample.repository.AuthorRepository;
import com.muditasoft.springbootgraphqlexample.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public Query(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }

    public long countAuthors() {
        return authorRepository.count();
    }
}
