package com.example.demo.service.impl;

import com.example.demo.domain.Link;
import com.example.demo.repository.LinkRepository;
import com.example.demo.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LinkTypeService implements ILinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Transactional
    @Override
    public Link create(Link link) {
        return linkRepository.save(link);
    }

    @Override
    public void update(Link link) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Link> bulkCreate(List<Link> links) {
        return linkRepository.save(links);
    }
}
