package com.ibrahim.codisc.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibrahim.codisc.model.Content;
import com.ibrahim.codisc.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {

    @Query("SELECT t.content FROM Tag t WHERE t.rating > :rating")
    List<Content> findContentsByRatingGreaterThan(@Param("rating") float rating);

}
