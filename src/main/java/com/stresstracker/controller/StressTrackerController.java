package com.stresstracker.controller;

import com.opencsv.bean.CsvToBeanBuilder;
import com.stresstracker.entity.StressLevelCalculationEntity;
import com.stresstracker.entity.StressTrackEntity;
import com.stresstracker.entity.StressTrackMeanCanculationEntity;
import com.stresstracker.service.StressTrackerService;
import com.stresstracker.utils.StressTrackRequest;
import com.stresstracker.utils.StressTrackRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * This class act as a service controller to perform various task based on the API
 */
@RestController
@RequestMapping("/v1/stresstrack")
public class StressTrackerController {

    @Autowired
    StressTrackerService stressTrackerService;
    @Autowired
    StressTrackRequestMapper stressTrackRequestMapper;

    /**
     * This Service API to save Stress Track Details
     * @throws IOException
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE)
    public void saveStressTrackDetails() throws IOException {
        String fileLocation = "D:\\SensorsData.csv";
        List<StressTrackRequest> stressTrack = null;
        stressTrack = new CsvToBeanBuilder<StressTrackRequest>(new FileReader(fileLocation))
                .withType(StressTrackRequest.class)
                .withSkipLines(1)
                .build()
                .parse();
        List<StressTrackEntity> stressTrackEntityList= stressTrackRequestMapper.mapStressTrackData(stressTrack);
        stressTrackerService.saveStressTrackDetails(stressTrackEntityList);
    }

    /**
     * This Service API retrieve all stress track details
     * @return
     */
    @RequestMapping(value = "/getStressTrackDetails",method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public List<StressTrackEntity> getStressTrackDetails()  {
        return stressTrackerService.getStressTrackDetails();
    }

    /**
     * This Service API retrieve stress track detail based on ID
     * @param id
     * @return
     */
    @RequestMapping(value = "/getStressTrackDetails/{id}",method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public StressTrackEntity getStressTrackDetail(@PathVariable("id") String id)  {
        StressTrackEntity StressTrackEntity=null;
        Optional<StressTrackEntity> stressTrackEntity = stressTrackerService.getStressTrackDetail(id);
        if(stressTrackEntity.isPresent()){
            StressTrackEntity = stressTrackEntity.get();
        }else {
            throw new RuntimeException();
        }
        return StressTrackEntity;
    }

    /**
     * This Service API calculate mean value and save.
     */
    @RequestMapping(value = "/saveStressTrackMeanValue",method = RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE)
    public void saveStressTrackMeanValue()  {
        stressTrackerService.saveStressTrackMeanValue();
    }

    /**
     * This Service API retrieve stress track mean value based on given ID
     * @param id
     * @return
     */
    @RequestMapping(value = "/getStressTrackMeanValue/{id}",method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public StressTrackMeanCanculationEntity getStressTrackMeanValue(@PathVariable("id") String id)  {
        StressTrackMeanCanculationEntity stressTrackMeanCanculationEntity= null;
        Optional<StressTrackMeanCanculationEntity> responsevalue= stressTrackerService.getStressTrackMeanValue(id);
        if(responsevalue.isPresent()){
            stressTrackMeanCanculationEntity= responsevalue.get();
        }else {
            throw new RuntimeException();
        }
        return stressTrackMeanCanculationEntity;
    }

    /**
     * This Service API save stress level record details
     */
    @RequestMapping(value = "/saveStressLevel",method = RequestMethod.POST,produces= MediaType.APPLICATION_JSON_VALUE)
    public void saveStressLevel()  {
        stressTrackerService.saveStressLevel();
    }

    /**
     * This service api retrieve stress level details based on id
     * @param id
     * @return
     */
    @RequestMapping(value = "/getStressLevel/{id}",method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
    public StressLevelCalculationEntity getStressLevel(@PathVariable("id") String id)  {
        StressLevelCalculationEntity stressLevelCalculationEntity= null;
        Optional<StressLevelCalculationEntity> stressLevelResponse= stressTrackerService.getStressLevel(id);
        if(stressLevelResponse.isPresent()){
            stressLevelCalculationEntity= stressLevelResponse.get();
        }else {
            throw new RuntimeException();
        }
        return stressLevelCalculationEntity;
    }


}
