package com.example.demo.service;

import com.example.demo.constant.status.AppStatus;
import com.example.demo.domain.GPS;
import org.springframework.web.multipart.MultipartFile;

public interface IGPSService extends IService<GPS> {
    AppStatus getLatestTrack(int pageNumber, int pageSize);
    AppStatus uploadFile(MultipartFile file);
    AppStatus getGPXDetailByGPSId(Long id);
}
