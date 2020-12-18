package com.jayson.lokasi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jayson.lokasi.entity.KabupatenEntity;

@Repository
public interface KabupatenRepository extends JpaRepository<KabupatenEntity, Integer> {
	
	KabupatenEntity findByKodeKabupaten(String kodeKabupaten);
	
	@Query(value = "SELECT * FROM kabupaten_entity WHERE status = 1", nativeQuery = true)
	List<KabupatenEntity> getActiveKabupaten();
}
