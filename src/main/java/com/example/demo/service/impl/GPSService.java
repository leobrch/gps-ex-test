package com.example.demo.service.impl;

import com.example.demo.constant.status.AppStatus;
import com.example.demo.constant.status.StatusFactory;
import com.example.demo.domain.jaxb2.GpxType;
import com.example.demo.exception.CustomException;
import com.example.demo.service.IGPSService;
import com.example.demo.service.IXMLConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GPSService implements IGPSService {

    @Autowired
    private IXMLConverter xmlConverter;

    @Override
    public AppStatus getLatestTrack() {
        return null;
    }

    @Override
    public AppStatus uploadFile(MultipartFile file) {

        if (file.isEmpty()) {
            throw new CustomException("File should not be empty.");
        }

        GpxType gpxType = xmlConverter.unmarshall(file);

        return StatusFactory.ofOk(gpxType);
    }

    @Override
    public AppStatus getGPXDetailByUserId(Long id) {
        return null;
    }
}
