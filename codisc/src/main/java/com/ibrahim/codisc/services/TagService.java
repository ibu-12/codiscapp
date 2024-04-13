package com.ibrahim.codisc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibrahim.codisc.model.Tag;
import com.ibrahim.codisc.repository.TagRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;


    public Tag addTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag getTagById(Long id) {
        Optional<Tag> optionalTag = tagRepository.findById(id);
        return optionalTag.orElse(null);
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public boolean deleteTagById(Long id) {
        if (tagRepository.existsById(id)) {
            tagRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Tag updateTag(Long id, Tag updatedTag) {
        Optional<Tag> optionalTag = tagRepository.findById(id);
        if (optionalTag.isPresent()) {
            Tag tag = optionalTag.get();
            tag.setTagName(updatedTag.getTagName());
            tag.setRating(updatedTag.getRating());
            return tagRepository.save(tag);
        }
        return null;
    }
}
