package com.stresstracker.utils;

import com.opencsv.bean.CsvToBeanBuilder;
import com.stresstracker.entity.OxygenLevelEntity;
import com.stresstracker.entity.PulseRateEntity;
import com.stresstracker.entity.StressTrackEntity;
import com.stresstracker.entity.TemperatureEntity;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class StressTrackRequestMapper {

    public List<StressTrackEntity> mapStressTrackData(List<StressTrackRequest> stressTrackRequest){

        List<StressTrackEntity> stressTrackEntityList= new ArrayList<>();
        for(StressTrackRequest requestList:stressTrackRequest) {

            StressTrackEntity stressTrackEntity = new StressTrackEntity();
            stressTrackEntity.setId(requestList.getId());
            stressTrackEntity.setAge(requestList.getAge());
            stressTrackEntity.setGender(requestList.getGender());
            stressTrackEntity.setName(requestList.getName());

            OxygenLevelEntity oxygenLevelEntity = new OxygenLevelEntity();
            oxygenLevelEntity.setId(requestList.getId());
            List<String> oxygenLevelList = Arrays.asList(requestList.getOxygenLevel());
            oxygenLevelEntity.setOxygenLevel(oxygenLevelList);

            List<OxygenLevelEntity> oxygenLevelEntityList = new ArrayList();
            oxygenLevelEntityList.add(oxygenLevelEntity);
            stressTrackEntity.setOxygenLevel(oxygenLevelEntityList);

            TemperatureEntity temperatureEntity = new TemperatureEntity();
            temperatureEntity.setId(requestList.getId());

            List<String> temperatureList = Arrays.asList(requestList.getTemperature());
            temperatureEntity.setTemperature(temperatureList);

            List<TemperatureEntity> temperatureEntityList = new ArrayList();
            temperatureEntityList.add(temperatureEntity);
            stressTrackEntity.setTemperature(temperatureEntityList);

            PulseRateEntity pulseRateEntity = new PulseRateEntity();
            pulseRateEntity.setId(requestList.getId());

            List<String> pulseRateList = Arrays.asList(requestList.getPulseRate());
            pulseRateEntity.setPulseRate(pulseRateList);


            List<PulseRateEntity> pulseRateEntityList = new ArrayList();
            pulseRateEntityList.add(pulseRateEntity);
            stressTrackEntity.setPulseRate(pulseRateEntityList);

            stressTrackEntityList.add(stressTrackEntity);
        }
        return stressTrackEntityList;
    }
}
