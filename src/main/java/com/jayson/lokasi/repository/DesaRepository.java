package com.jayson.lokasi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jayson.lokasi.entity.DesaEntity;

@Repository
public interface DesaRepository extends JpaRepository<DesaEntity, Integer> {
	DesaEntity findByKodeDesa(String kodeDesa);
	
	@Query(value = "SELECT * FROM desa_entity WHERE status = 1", nativeQuery = true)
	List<DesaEntity> getActiveDesa();
}
