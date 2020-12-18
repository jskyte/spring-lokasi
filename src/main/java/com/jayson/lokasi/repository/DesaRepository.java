package com.jayson.lokasi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jayson.lokasi.entity.DesaEntity;

@Repository
public interface DesaRepository extends JpaRepository<DesaEntity, Integer> {
	DesaEntity findByKodeDesa(String kodeDesa);
}
