package com.example.demo.service.impl;

import com.example.demo.domain.Link;
import com.example.demo.domain.Metadata;
import com.example.demo.repository.MetadataRepository;
import com.example.demo.service.ILinkService;
import com.example.demo.service.IService;
import com.example.demo.service.IMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetadataService implements IMetadataService, IService<Metadata> {

    @Autowired
    private MetadataRepository metadataRepository;

    @Autowired
    private ILinkService linkService;

    @Transactional
    @Override
    public Metadata create(Metadata metadata) {
        Metadata metadataCreated = metadataRepository.save(metadata);
        List<Link> metadataLinks = metadata.getLink().stream()
                .peek(link -> link.setMetadata(metadata))
                .collect(Collectors.toList());
        linkService.bulkCreate(metadataLinks);
        return metadataCreated;
    }

    @Override
    public void update(Metadata metadata) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Metadata> bulkCreate(List<Metadata> metadata) {
        return metadataRepository.save(metadata);
    }
}
