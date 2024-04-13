package com.ibrahim.codisc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ibrahim.codisc.model.Content;
import com.ibrahim.codisc.services.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @PostMapping("/addConetnt")
    public ResponseEntity<Content> addContent(@RequestBody Content content) {
        Content savedContent = contentService.addContent(content);
        return new ResponseEntity<>(savedContent, HttpStatus.CREATED);
    }

    @GetMapping("/getContentById/{id}")
    public ResponseEntity<Content> getContentById(@PathVariable Long id) {
        Content content = contentService.getContentById(id);
        if (content != null) {
            return ResponseEntity.ok(content);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAllContentss")
    public ResponseEntity<List<Content>> getAllContents() {
        List<Content> contents = contentService.getAllContents();
        return ResponseEntity.ok(contents);
    }

    @DeleteMapping("/deleteContentById/{id}")
    public ResponseEntity<String> deleteContentById(@PathVariable Long id) {
        boolean deleted = contentService.deleteContentById(id);
        if (deleted) {
            return ResponseEntity.ok("Deleted Book successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateContent/{id}")
    public ResponseEntity<Content> updateContent(@PathVariable Long id, @RequestBody Content book) {
        Content updatedContent = contentService.updateContent(id, book);
        if (updatedContent != null) {
            return ResponseEntity.ok(updatedContent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

       // @Query

       @GetMapping("/contents/rating/{rating}")
       public ResponseEntity<List<Content>> getContentssByRatingGreaterThan(@PathVariable float rating) {
           List<Content> contents = contentService.findContentsByRatingGreaterThan(rating);
           return ResponseEntity.ok(contents);
       }
   
       
}
