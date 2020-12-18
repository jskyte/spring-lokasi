package com.jayson.lokasi.service;

import java.util.List;

import com.jayson.lokasi.dto.KecamatanDto;
import com.jayson.lokasi.entity.KecamatanEntity;

public interface KecamatanService {
	List<KecamatanEntity> getKecamatan();
	KecamatanEntity getByKodeKecamatan(String kodeKecamatan);
	KecamatanEntity addKecamatan(KecamatanDto dto);
	KecamatanEntity updateKecamatan(Integer idKecamatan, KecamatanDto dto);
	KecamatanEntity deleteKecamatan(Integer idKecamatan);
	KecamatanEntity deleteKecamatanStatus(Integer idKecamatan);
}
