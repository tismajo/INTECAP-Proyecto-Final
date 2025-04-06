package com.INTECAP.finalProject.Repository;

import com.INTECAP.finalProject.Model.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleModel, Integer> {
    List<VehicleModel> findByExitTimeIsNull();
}

