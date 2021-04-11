package com.example.demo.service;

import com.example.demo.domain.jaxb2.GpxType;
import org.springframework.web.multipart.MultipartFile;

public interface IXMLConverter{
    GpxType unmarshall(MultipartFile file);
}
