package com.paf.repository.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paf.model.vehicle;

public interface VehicleRepository extends JpaRepository<vehicle, String> {

}
