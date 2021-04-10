package com.example.demo.service.impl;

import com.example.demo.constant.status.AppStatus;
import com.example.demo.service.IGPSService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GPSService implements IGPSService {
    @Override
    public AppStatus getLatestTrack() {
        return null;
    }

    @Override
    public AppStatus uploadFile(MultipartFile file) {
        return null;
    }

    @Override
    public AppStatus getGPXDetailByUserId() {
        return null;
    }
}
