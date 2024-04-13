package com.ibrahim.codisc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ibrahim.codisc.model.Content;
import com.ibrahim.codisc.model.Tag;
import com.ibrahim.codisc.model.User;
import com.ibrahim.codisc.services.ContentService;
import com.ibrahim.codisc.services.TagService;
import com.ibrahim.codisc.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TagController {

    @Autowired
    private TagService tagService;

    @Autowired
    private ContentService contentService;

    @Autowired 
    private UserService userService;
    

    @PostMapping("/addTag")
    public ResponseEntity<Tag> addReview(@RequestBody Tag tag) {
        User user = userService.getUserById(tag.getUserId());
        Content content = contentService.getContentById(tag.getContentId());

        if (user == null || content == null) {
            return ResponseEntity.notFound().build();
        }

        tag.setUser(user);
        tag.setContent(content);

        Tag savedTag = tagService.addTag(tag);
        return new ResponseEntity<>(savedTag, HttpStatus.CREATED);
    }

    @GetMapping("/getTagById/{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable Long id) {
        Tag tag = tagService.getTagById(id);
        if (tag != null) {
            return ResponseEntity.ok(tag);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAllTags")
    public ResponseEntity<List<Tag>> getAllTags() {
        List<Tag> tags = tagService.getAllTags();
        return ResponseEntity.ok(tags);
    }

    @DeleteMapping("/deleteTagById/{id}")
    public ResponseEntity<String> deleteTagById(@PathVariable Long id) {
        boolean deleted = tagService.deleteTagById(id);
        if (deleted) {
            return ResponseEntity.ok("Deleted Tag successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateTag/{id}")
    public ResponseEntity<Tag> updateTag(@PathVariable Long id, @RequestBody Tag tag) {
        Tag updatedTag = tagService.updateTag(id, tag);
        if (updatedTag != null) {
            return ResponseEntity.ok(updatedTag);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
