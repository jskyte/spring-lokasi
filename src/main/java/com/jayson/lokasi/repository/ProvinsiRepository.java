package com.jayson.lokasi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jayson.lokasi.entity.ProvinsiEntity;

@Repository
public interface ProvinsiRepository extends JpaRepository<ProvinsiEntity, Integer> {

	ProvinsiEntity findByKodeProvinsi(String kodeProvinsi);
	
	@Query(value = "SELECT * FROM provinsi_entity WHERE status = 1", nativeQuery = true)
	List<ProvinsiEntity> getActiveProvinsi();
	
}
