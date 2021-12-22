package com.stresstracker.service;

import com.stresstracker.entity.*;
import com.stresstracker.repository.StressLevelCalculationRepository;
import com.stresstracker.repository.StressTrackMeanCanculationRepository;
import com.stresstracker.repository.StressTrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class handle business logic
 */
@Service
public class StressTrackerService {

    @Autowired
    StressTrackerRepository stressTrackerRepository;

    @Autowired
    StressTrackMeanCanculationRepository stressTrackMeanCanculationRepository;

    @Autowired
    StressLevelCalculationRepository stressLevelCalculationRepository;

    /**
     * Service method to save StressTrackDetails
     * @param stressTrackEntityList
     */
    public void saveStressTrackDetails(List<StressTrackEntity> stressTrackEntityList) {
        stressTrackerRepository.saveAll(stressTrackEntityList);
    }

    /**
     * Service method to get StressTrackDetails
     * @return
     */
    public List<StressTrackEntity> getStressTrackDetails() {
        return stressTrackerRepository.findAll();
    }

    /**
     * Service method to get getStressTrackDetail based on id
     * @param id
     * @return
     */
    public Optional<StressTrackEntity> getStressTrackDetail(String id) {
        return stressTrackerRepository.findById(id);
    }

    /**
     * Service method to save StressTrackMeanValue
     */
    public void saveStressTrackMeanValue() {

        long  pulseRateCount =0 ;
        long  oxygenLevelCount = 0;
        long  temperatureCount = 0 ;
        double  pulseRateMeanValue =0.0 ;
        double  oxygenLevelMeanValue = 0.0;
        double  temperatureMeanValue = 0.0 ;
        int  pulseRateSum =0 ;
        int  oxygenLevelSum = 0;
        int  temperatureSum = 0 ;

        String id= null;

        List<StressTrackEntity> stressTrackEntityList = stressTrackerRepository.findAll();
        for(StressTrackEntity stressTrackEntity: stressTrackEntityList){
            id= stressTrackEntity.getId();
            List<PulseRateEntity> pulseRateEntityList= stressTrackEntity.getPulseRate();
            for(PulseRateEntity pulseRateEntity: pulseRateEntityList){
                pulseRateSum= pulseRateEntity.getPulseRate().stream().map(Integer::valueOf)
                        .mapToInt(value -> value)
                        .sum();
                pulseRateCount= pulseRateEntity.getPulseRate().stream().count();
                pulseRateMeanValue = pulseRateSum/pulseRateCount;
            }

            List<OxygenLevelEntity> oxygenLevelEntityList= stressTrackEntity.getOxygenLevel();
            for(OxygenLevelEntity oxygenLevelEntity: oxygenLevelEntityList){
                oxygenLevelSum= oxygenLevelEntity.getOxygenLevel().stream().map(Integer::valueOf)
                        .mapToInt(value -> value)
                        .sum();
                oxygenLevelCount= oxygenLevelEntity.getOxygenLevel().stream().count();
                oxygenLevelMeanValue= oxygenLevelSum/oxygenLevelCount;
            }

            List<TemperatureEntity> temperatureEntityList= stressTrackEntity.getTemperature();
            for(TemperatureEntity temperatureEntity: temperatureEntityList){
                temperatureSum= temperatureEntity.getTemperature().stream().map(Integer::valueOf)
                        .mapToInt(value -> value)
                        .sum();
                temperatureCount= temperatureEntity.getTemperature().stream().count();
                temperatureMeanValue = temperatureSum/temperatureCount;
            }

            StressTrackMeanCanculationEntity stressTrackMeanCalculation=new StressTrackMeanCanculationEntity();
            stressTrackMeanCalculation.setId(id);
            stressTrackMeanCalculation.setOxygenLevelMeanValue(oxygenLevelMeanValue);
            stressTrackMeanCalculation.setPulseRateMeanValue(pulseRateMeanValue);
            stressTrackMeanCalculation.setTemperatureMeanValue(temperatureMeanValue);
            stressTrackMeanCanculationRepository.save(stressTrackMeanCalculation);
        }
    }

    /**
     * Service method to get StressTrackMeanValue
     * @param id
     * @return
     */
    public Optional<StressTrackMeanCanculationEntity> getStressTrackMeanValue(String id) {
        return stressTrackMeanCanculationRepository.findById(id);
    }

    /**
     * Service method to get StressLevel based on ID
     * @param id
     * @return
     */
    public Optional<StressLevelCalculationEntity> getStressLevel(String id) {
        return stressLevelCalculationRepository.findById(id);
    }

    /**
     * Service method to save StressLevel
     */
    public void saveStressLevel() {

        String id= null;
        List<StressTrackMeanCanculationEntity> stressTrackMeanCanculationList= stressTrackMeanCanculationRepository.findAll();
        List<StressTrackEntity> stressTrackDetailsList= stressTrackerRepository.findAll();
        StressLevelCalculationEntity stressLevelCalculationEntity=new StressLevelCalculationEntity();
        for(StressTrackMeanCanculationEntity stressTrackMeanCanculationEntity : stressTrackMeanCanculationList){
            id= stressTrackMeanCanculationEntity.getId();
            for(StressTrackEntity stressTrackEntity: stressTrackDetailsList){

                if(stressTrackEntity.getGender().equalsIgnoreCase("Male")){
                   //write condition to check stress level
                    //then set the value
                    stressLevelCalculationEntity.setStressLevel("TestData");
                } else{
                    //write condition to check stress level
                    //then set the value
                    stressLevelCalculationEntity.setStressLevel("TestData");
                }
            }

            stressLevelCalculationEntity.setId(id);
            stressLevelCalculationRepository.save(stressLevelCalculationEntity);
        }

    }
}
