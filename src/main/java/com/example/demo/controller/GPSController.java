package com.example.demo.controller;

import com.example.demo.service.IGPSService;
import com.example.demo.utils.RequestUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/gps")
public class GPSController {

    private final IGPSService gpsService;

    public GPSController(IGPSService gpsService) {
        this.gpsService = gpsService;
    }

    @GetMapping(path = "/track/latest")
    public ResponseEntity<Object> getLatestTrack() {
        return RequestUtils.getResponse(gpsService.getLatestTrack());
    }

    @PostMapping(path = "/upload")
    public ResponseEntity<Object> uploadFile(@RequestPart("file") MultipartFile file) {
        return RequestUtils.getResponse(gpsService.uploadFile(file));
    }

    @GetMapping(path = "/detail/{id}")
    public ResponseEntity<Object> getTrackDetailByTrackId(@PathVariable("id") Long id) {
        return RequestUtils.getResponse(gpsService.getGPXDetailByUserId(id));
    }
}
