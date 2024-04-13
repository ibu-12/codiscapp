package com.ibrahim.codisc.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibrahim.codisc.model.Content;

public interface ContentRepository extends JpaRepository<Content, Long> {

    
    // @Query("SELECT b FROM Book b WHERE b.launchYear = :year")
    // List<Content> findBooksByYear(@Param("year") String year);

}
