package com.jayson.lokasi.service;

import java.util.List;

import com.jayson.lokasi.dto.DesaDto;
import com.jayson.lokasi.entity.DesaEntity;

public interface DesaService {
	List<DesaEntity> getDesa();
	DesaEntity getByKodeDesa(String kodeDesa);
	DesaEntity addDesa(DesaDto dto);
	DesaEntity updateDesa(Integer idDesa, DesaDto dto);
	DesaEntity deleteDesa(Integer idDesa);
	DesaEntity deleteDesaStatus(Integer idDesa);
}
