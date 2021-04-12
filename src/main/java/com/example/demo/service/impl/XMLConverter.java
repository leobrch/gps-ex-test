package com.example.demo.service.impl;

import com.example.demo.domain.jaxb2.GpxType;
import com.example.demo.exception.CustomException;
import com.example.demo.service.IXMLConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;

@Service
public class XMLConverter implements IXMLConverter {

    @Override
    public GpxType unmarshall(MultipartFile file) {

        if (file.isEmpty()) {
            throw new CustomException("File should not be empty.");
        }

        JAXBElement<GpxType> gpxType;
        try {
            if (!validateXMLSchema(file)) {
                throw new CustomException("File is invalid please check and try again later.");
            }

            JAXBContext jc = JAXBContext.newInstance(GpxType.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();
            gpxType = (JAXBElement<GpxType>) unmarshaller.unmarshal(file.getInputStream());

        } catch (JAXBException | IOException ex) {
            throw new CustomException(String.format("Unmarshall file %s failed", file.getName()));
        }
        return gpxType.getValue();
    }

    @Override
    public boolean validateXMLSchema(MultipartFile xmlFile) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(getClass().getResourceAsStream("/xsd/gpx.xsd")));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile.getInputStream()));
        } catch (IOException | SAXException e) {
            return false;
        }
        return true;
    }
}
