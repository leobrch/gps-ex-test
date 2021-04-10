package com.example.demo.service;

import com.example.demo.constant.status.AppStatus;
import org.springframework.web.multipart.MultipartFile;

public interface IGPSService {
    AppStatus getLatestTrack();
    AppStatus uploadFile(MultipartFile file);
    AppStatus getGPXDetailByUserId();
}
