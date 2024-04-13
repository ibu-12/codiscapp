package com.ibrahim.codisc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ibrahim.codisc.model.Content;
import com.ibrahim.codisc.repository.ContentRepository;
import com.ibrahim.codisc.repository.TagRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;


    @Autowired
    private TagRepository tagRepository;

    public Content addContent(Content content) {
        return contentRepository.save(content);
    }

    public Content getContentById(Long id) {
        Optional<Content> optionalContent = contentRepository.findById(id);
        return optionalContent.orElse(null);
    }

    public List<Content> getAllContents() {
        return contentRepository.findAll();
    }

    public boolean deleteContentById(Long id) {
        if (contentRepository.existsById(id)) {
            contentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Content updateContent(Long id, Content updatedContent) {
        Optional<Content> optionalContent = contentRepository.findById(id);
        if (optionalContent.isPresent()) {
            Content content = optionalContent.get();
            content.setContentName(updatedContent.getContentName());
            content.setDescription(updatedContent.getDescription());
            content.setCreater(updatedContent.getCreater());
            return contentRepository.save(content);
        }
        return null;
    }

    public Page<Content> getAllContentPaged(int page, int size, String sortBy) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortBy));
        return contentRepository.findAll(pageRequest);
    }

    public List<Content> getAllContentsSorted(String sortBy) {
        return contentRepository.findAll(Sort.by(sortBy));
    }

    public List<Content> findContentsByRatingGreaterThan(float rating) {
        return tagRepository.findContentsByRatingGreaterThan(rating);
    }

    
}

