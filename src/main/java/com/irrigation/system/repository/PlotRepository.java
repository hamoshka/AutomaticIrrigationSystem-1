package com.irrigation.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irrigation.system.model.Plot;

@Repository
public interface PlotRepository extends JpaRepository<Plot, Long> {
    // You can define custom query methods here if needed
}






