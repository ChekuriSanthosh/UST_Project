package com.bookstoreapp.service;

import com.bookstoreapp.exception.BookAlreadyExistsException;
import com.bookstoreapp.exception.BookNotFoundException;
import com.bookstoreapp.model.Book;
import com.bookstoreapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreServiceImpl implements BookstoreService{


    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();

    }

    @Override
    public Book getBookById(int id) {
        if(bookRepository.existsById(id)){
            return bookRepository.findById(id).get();
        }else{
            throw new BookNotFoundException("Book Not Found");
        }
        // check if book exists
        // if book exists return book
        // else throw exception book not found
    }

    @Override
    public Book saveBook(Book book) {
        if(bookRepository.existsById(book.getId())){
            throw new BookAlreadyExistsException("Book Alerady Exists");
        }else{
            bookRepository.save(book);
            return book;
        }

        // check if book exists
        // if book exists throw exception book already exists
        // else save book

    }

    @Override
    public Book updateBook(int id, Book book) {
        if(!bookRepository.existsById(id)){
            throw new BookNotFoundException("Book not found");
        }
        bookRepository.save(book);
        return book;

        // check if book exists
        // if book exists update book
        // else throw exception book not found


    }

    @Override
    public void deleteBook(int id) {

        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
        }else{
            throw new BookNotFoundException("Book not found");
        }

            // check if book exists
            // if book exists delete book
            // else throw exception book not found

    }


}
