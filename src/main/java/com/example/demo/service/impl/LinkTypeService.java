package com.example.demo.service.impl;

import com.example.demo.domain.Link;
import com.example.demo.repository.LinkRepository;
import com.example.demo.service.IService;
import com.example.demo.service.IMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkTypeService implements IMetadataService, IService<Link> {

    @Autowired
    private LinkRepository linkRepository;

    @Override
    public void create(Link link) {

    }

    @Override
    public void update(Link link) {

    }

    @Override
    public void delete(Long id) {

    }
}
