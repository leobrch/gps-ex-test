package com.example.demo.service.impl;

import com.example.demo.domain.jaxb2.GpxType;
import com.example.demo.exception.CustomException;
import com.example.demo.service.IXMLConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.*;
import java.io.IOException;

@Service
public class XMLConverter implements IXMLConverter {

    @Override
    public GpxType unmarshall(MultipartFile file) {
        JAXBElement<GpxType> gpxType;
        try {
            JAXBContext jc = JAXBContext.newInstance(GpxType.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            gpxType = (JAXBElement<GpxType>) unmarshaller.unmarshal(file.getInputStream());

        } catch (JAXBException | IOException ex) {
            throw new CustomException(String.format("Unmarshall file %s failed", file.getName()));
        }
        return gpxType.getValue();
    }
}
