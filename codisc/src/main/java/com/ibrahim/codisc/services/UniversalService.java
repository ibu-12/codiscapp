package com.ibrahim.codisc.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ibrahim.codisc.model.Content;
import com.ibrahim.codisc.repository.ContentRepository;

import java.util.List;


@Service
public class UniversalService {

    @Autowired
    private ContentRepository contentRepository;


    public List<Content> getAllContentsSorted(String sortBy) {
        return contentRepository.findAll(Sort.by(sortBy));
    }

    public Page<Content> getAllContentsPaged(int page, int size, String sortBy) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortBy));
        return contentRepository.findAll(pageRequest);
    }

}
