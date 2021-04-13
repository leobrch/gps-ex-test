package com.gpx.exchange.service;

import com.gpx.exchange.constant.status.AppStatus;
import com.gpx.exchange.domain.GPS;
import org.springframework.web.multipart.MultipartFile;

public interface IGPSService extends IService<GPS> {
    AppStatus getLatestTrack(int pageNumber, int pageSize);
    AppStatus uploadFile(MultipartFile file);
    AppStatus getGPXDetailByGPSId(Long id);
}
