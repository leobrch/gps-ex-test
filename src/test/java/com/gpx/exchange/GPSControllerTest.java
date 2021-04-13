package com.gpx.exchange;

import com.gpx.exchange.constant.status.AppStatus;
import com.gpx.exchange.controller.GPSController;
import com.gpx.exchange.service.IGPSService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Collections;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = GPSController.class)
public class GPSControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IGPSService gpsService;

    @Test
    public void getLatestTrack_thenReturns200() throws Exception {
        given(this.gpsService.getLatestTrack(1, 20)).willReturn(new AppStatus(HttpStatus.OK, HttpStatus.OK.getReasonPhrase(), null));

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("pageNumber", Collections.singletonList("1"));
        params.put("pageSize", Collections.singletonList("20"));
        mockMvc.perform(MockMvcRequestBuilders.get("/gps/track/latest")
                .params(params)
                .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getLatestTrackWithPageSizeZero_thenReturns400() throws Exception {
        given(this.gpsService.getLatestTrack(1, 0)).willReturn(new AppStatus(HttpStatus.OK, HttpStatus.OK.getReasonPhrase(), null));

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.put("pageNumber", Collections.singletonList("1"));
        params.put("pageSize", Collections.singletonList("0"));
        mockMvc.perform(MockMvcRequestBuilders.get("/gps/track/latest")
                .params(params)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getLatestTrackWithoutParams_thenReturns400() throws Exception {
        given(this.gpsService.getLatestTrack(1, 20)).willReturn(new AppStatus(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase(), null));

        mockMvc.perform(MockMvcRequestBuilders.get("/gps/track/latest")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void uploadFileWithInvalidXML_thenReturns400() throws Exception {
        MockMultipartFile file = new MockMultipartFile("invalid_track.gpx", "invalid_track.gpx", "multipart/form-data",
                this.getClass().getResourceAsStream("/gpx/invalid_track.gpx"));
        given(this.gpsService.uploadFile(file)).willReturn(new AppStatus(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase(), null));

        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/gps/upload").file(file))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void uploadFileWithValidXML_thenReturns200() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "sample.gpx", "multipart/form-data",
                getClass().getResourceAsStream("/gpx/sample.gpx"));
        given(this.gpsService.uploadFile(file)).willReturn(new AppStatus(HttpStatus.OK, HttpStatus.OK.getReasonPhrase(), null));

        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/gps/upload").file(file))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void uploadFileThenGetDetailByGPSId_thenReturns200() throws Exception {
        MockMultipartFile file = new MockMultipartFile("file", "sample.gpx", "multipart/form-data",
                getClass().getResourceAsStream("/gpx/sample.gpx"));
        given(this.gpsService.uploadFile(file)).willReturn(new AppStatus(HttpStatus.OK, HttpStatus.OK.getReasonPhrase(), null));

        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/gps/upload").file(file))
                .andReturn();
    }

}
