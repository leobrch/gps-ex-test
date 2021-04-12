package com.example.demo.service.impl;

import com.example.demo.domain.Metadata;
import com.example.demo.repository.MetadataRepository;
import com.example.demo.service.IService;
import com.example.demo.service.IMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MetadataService implements IMetadataService, IService<Metadata> {

    @Autowired
    private MetadataRepository metadataRepository;

    @Override
    public void create(Metadata metadata) {

    }

    @Override
    public void update(Metadata metadata) {

    }

    @Override
    public void delete(Long id) {

    }
}
