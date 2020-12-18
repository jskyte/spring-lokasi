package com.jayson.lokasi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jayson.lokasi.entity.KabupatenEntity;

@Repository
public interface KabupatenRepository extends JpaRepository<KabupatenEntity, Integer> {
	
	KabupatenEntity findByKodeKabupaten(String kodeKabupaten);
	
	
}
