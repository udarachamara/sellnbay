package com.paf.repository.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paf.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

}
