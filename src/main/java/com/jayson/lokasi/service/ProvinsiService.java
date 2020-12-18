package com.jayson.lokasi.service;

import java.util.List;

import com.jayson.lokasi.dto.ProvinsiDto;
import com.jayson.lokasi.entity.ProvinsiEntity;

public interface ProvinsiService {
	List<ProvinsiEntity> getProvinsi();
	ProvinsiEntity getByKodeProvins(String kodeProvinsi);
	ProvinsiEntity addProvinsi(ProvinsiDto dto);
	ProvinsiEntity updateProvinsi(Integer idProvinsi, ProvinsiDto dto);
	ProvinsiEntity deleteProvinsi(Integer idProvinsi);
	ProvinsiEntity deleteProvinsiStatus(Integer idProvinsi);
	List<ProvinsiEntity> getActiveProvinsi();
}
