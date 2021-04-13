package com.gpx.exchange.service.impl;

import com.gpx.exchange.domain.Link;
import com.gpx.exchange.domain.Metadata;
import com.gpx.exchange.repository.MetadataRepository;
import com.gpx.exchange.service.ILinkService;
import com.gpx.exchange.service.IService;
import com.gpx.exchange.service.IMetadataService;
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
    public List<Metadata> bulkCreate(List<Metadata> metadata) {
        return metadataRepository.save(metadata);
    }
}
