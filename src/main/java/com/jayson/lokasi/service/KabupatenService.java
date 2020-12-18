package com.jayson.lokasi.service;

import java.util.List;

import com.jayson.lokasi.dto.KabupatenDto;
import com.jayson.lokasi.entity.KabupatenEntity;

public interface KabupatenService {
	List<KabupatenEntity> getKabupaten();
	KabupatenEntity getByKodeKabupaten(String kodeKabupaten);
	KabupatenEntity addKabupaten(KabupatenDto dto);
	KabupatenEntity updateKabupaten(Integer idKabupaten, KabupatenDto dto);
	KabupatenEntity deleteKabupaten(Integer idKabupaten);
	KabupatenEntity deleteKabupatenStatus(Integer idKabupaten);
}
