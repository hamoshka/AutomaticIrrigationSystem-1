package com.irrigation.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.irrigation.system.model.Plot;

@Repository
public interface PlotRepository extends JpaRepository<Plot, Long> {
	
	@Modifying
	@Query("UPDATE Plot p SET p.hasSensor = :hasSensor WHERE p.no = :no")
	int updateHasSensorByNo(@Param("hasSensor") String hasSensor, @Param("no") String no);

	
	@Modifying
	@Query("UPDATE Plot p SET p.retryCount = p.retryCount + 1 WHERE p.hasSensor = 'N' AND p.isIrrigated = 'N'")
	int updateSensorRetryCount();

	@Modifying
	@Query("UPDATE Plot p SET p.isIrrigated = 'true' WHERE p.id IN (:ids)")
	Integer updateIsIrrigated(@Param("ids") List<Long> ids);

    List<Plot> findByHasSensorAndIsIrrigated(String hasSensor, String isIrrigated);

    List<Plot> findByHasSensorAndRetryCountGreaterThan(String hasSensor, int sensorRetryCount);

    
	
}






