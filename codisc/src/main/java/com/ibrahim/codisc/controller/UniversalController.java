package com.ibrahim.codisc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ibrahim.codisc.model.Content;
import com.ibrahim.codisc.services.UniversalService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UniversalController {

    @Autowired
    private UniversalService universalService;


    //pagination and sorting
    @GetMapping("/contents")
    public ResponseEntity<Page<Content>> getContents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "contentId") String sortBy) {

        Page<Content> contentPage = universalService.getAllContentsPaged(page, size, sortBy);

        return ResponseEntity.ok(contentPage);
    }

    @GetMapping("/sortedContents")
    public ResponseEntity<List<Content>> getSortedContents(@RequestParam String sortBy) {
        List<Content> sortedContents = universalService.getAllContentsSorted(sortBy);
        return ResponseEntity.ok(sortedContents);
    }
}
