package com.muditasoft.springbootgraphqlexample.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.muditasoft.springbootgraphqlexample.entity.Author;
import com.muditasoft.springbootgraphqlexample.entity.Book;
import com.muditasoft.springbootgraphqlexample.exception.BookNotFoundException;
import com.muditasoft.springbootgraphqlexample.repository.AuthorRepository;
import com.muditasoft.springbootgraphqlexample.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public Mutation(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    // newAuthor(firstName: String!, lastName: String!): Author!
    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author(firstName, lastName);
        authorRepository.save(author);
        return author;
    }

    // newBook(title: String!, isbn: String!, pageCount: Int, author: ID!): Book!
     public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book(title, isbn, pageCount);
        book.setAuthor(new Author(authorId));

        bookRepository.save(book);
        return book;
     }

     public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
     }

     public Book updateBookPageCount(Integer pageCount, Long id) {
         Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("The book to be updated was not found", id));
         book.setPageCount(pageCount);
         bookRepository.save(book);
         return book;
     }
}
