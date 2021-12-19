package com.sip.ams.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.ams.entities.Book;



@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

}
