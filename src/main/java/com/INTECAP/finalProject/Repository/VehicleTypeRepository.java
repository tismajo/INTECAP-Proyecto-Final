package com.INTECAP.finalProject.Repository;

import com.INTECAP.finalProject.Model.TypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeRepository extends JpaRepository<TypeModel, Integer> {
}
