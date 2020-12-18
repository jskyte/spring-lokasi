package com.jayson.lokasi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jayson.lokasi.entity.KecamatanEntity;

@Repository
public interface KecamatanRepository extends JpaRepository<KecamatanEntity, Integer>  {
	KecamatanEntity findByKodeKecamatan(String kodeKecamatan);
}
