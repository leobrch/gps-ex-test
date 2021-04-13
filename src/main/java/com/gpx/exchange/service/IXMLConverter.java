package com.gpx.exchange.service;

import com.gpx.exchange.domain.jaxb2.GpxType;
import org.springframework.web.multipart.MultipartFile;

public interface IXMLConverter{
    GpxType unmarshall(MultipartFile file);
    boolean validateXMLSchema(MultipartFile xml);
}
