package com.gpx.exchange.service.impl;

import com.gpx.exchange.domain.Link;
import com.gpx.exchange.repository.LinkRepository;
import com.gpx.exchange.service.ILinkService;
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
    public List<Link> bulkCreate(List<Link> links) {
        return linkRepository.save(links);
    }
}
