package com.jayson.lokasi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jayson.lokasi.dto.ProvinsiDto;
import com.jayson.lokasi.dto.StatusMessageDto;
import com.jayson.lokasi.entity.ProvinsiEntity;
import com.jayson.lokasi.repository.ProvinsiRepository;

@Service
@Transactional
public class ProvinsiServiceImpl implements ProvinsiService{
	@Autowired
	ProvinsiRepository provinsiRepository;
	
	@Override
	public List<ProvinsiEntity> getProvinsi() {
		// TODO Auto-generated method stub
		List<ProvinsiEntity> provinsiEntities = provinsiRepository.findAll();
		return provinsiEntities;
	}
	
	@Override
	public ProvinsiEntity getByKodeProvins(String kodeProvinsi) {
		// TODO Auto-generated method stub
		ProvinsiEntity provinsiEntities = provinsiRepository.findByKodeProvinsi(kodeProvinsi);
		return provinsiEntities;
	}
	

	@Override
	public ProvinsiEntity getByIdProvinsi(Integer id) {
		// TODO Auto-generated method stub
		ProvinsiEntity provinsiEntity = provinsiRepository.findById(id).get();
		return provinsiEntity;
	}

	@Override
	public ProvinsiEntity addProvinsi(ProvinsiDto dto) {
		// TODO Auto-generated method stub
		ProvinsiEntity provinsiEntity = convertToProvinsiEntity(dto);
			provinsiRepository.save(provinsiEntity);
			return provinsiEntity;
		
	}
	
	@Override
	public ProvinsiEntity updateProvinsi(Integer idProvinsi, ProvinsiDto dto) {
		// TODO Auto-generated method stub
		ProvinsiEntity provinsiEntity = provinsiRepository.findById(idProvinsi).get();
		provinsiEntity.setKodeProvinsi(dto.getKodeProvinsi());
		provinsiEntity.setNamaProvinsi(dto.getNamaProvinsi());
		provinsiRepository.save(provinsiEntity);
		return provinsiEntity;
	}
	
	@Override
	public ProvinsiEntity deleteProvinsi(Integer idProvinsi) {
		// TODO Auto-generated method stub
		ProvinsiEntity provinsiEntity = provinsiRepository.findById(idProvinsi).get();
//		provinsiRepository.delete(provinsiEntity);
		return provinsiEntity;
	}
	
	@Override
	public ProvinsiEntity deleteProvinsiStatus(Integer idProvinsi) {
		// TODO Auto-generated method stub
		ProvinsiEntity provinsiEntity = provinsiRepository.findById(idProvinsi).get();
		provinsiEntity.setStatus(0);
		provinsiRepository.save(provinsiEntity);
		return provinsiEntity;
	}
	
	public ProvinsiEntity convertToProvinsiEntity(ProvinsiDto dto) {
		ProvinsiEntity provinsiEntity = new ProvinsiEntity();
		provinsiEntity.setKodeProvinsi(dto.getKodeProvinsi());
		provinsiEntity.setNamaProvinsi(dto.getNamaProvinsi());
		return provinsiEntity;
	}

	@Override
	public List<ProvinsiEntity> getActiveProvinsi() {
		// TODO Auto-generated method stub
		List<ProvinsiEntity> provinsiEntities = provinsiRepository.getActiveProvinsi();
		return provinsiEntities;
	}


	
	
}
