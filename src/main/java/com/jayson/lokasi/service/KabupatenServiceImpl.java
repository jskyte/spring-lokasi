package com.jayson.lokasi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jayson.lokasi.dto.KabupatenDto;
import com.jayson.lokasi.entity.KabupatenEntity;
import com.jayson.lokasi.entity.ProvinsiEntity;
import com.jayson.lokasi.repository.KabupatenRepository;
import com.jayson.lokasi.repository.ProvinsiRepository;

@Service
@Transactional
public class KabupatenServiceImpl implements KabupatenService{
	
	@Autowired
	KabupatenRepository kabupatenRepository;
	
	@Autowired
	ProvinsiRepository provinsiRepository;

	@Override
	public List<KabupatenEntity> getKabupaten() {
		// TODO Auto-generated method stub
		List<KabupatenEntity> kabupatenEntities = kabupatenRepository.findAll();
		return kabupatenEntities;
	}
	
	@Override
	public KabupatenEntity getByKodeKabupaten(String kodeKabupaten) {
		// TODO Auto-generated method stub
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(kodeKabupaten);
		return kabupatenEntity;
	}
	
	@Override
	public List<KabupatenEntity> getActiveKabupaten() {
		// TODO Auto-generated method stub
		List<KabupatenEntity> kabupatenEntity = kabupatenRepository.getActiveKabupaten();
		return kabupatenEntity;
	}
	
	@Override
	public KabupatenEntity getByIdKabupaten(Integer id) {
		// TODO Auto-generated method stub
		KabupatenEntity kabupatenEntity = kabupatenRepository.findById(id).get();
		return kabupatenEntity;
	}
	
	@Override
	public KabupatenEntity addKabupaten(KabupatenDto dto) {
		// TODO Auto-generated method stub
		KabupatenEntity kabupatenEntity = convertToKabupatenEntity(dto);
		
			ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(dto.getKodeProvinsi());
			kabupatenEntity.setProvinsiEntity(provinsiEntity);
			kabupatenRepository.save(kabupatenEntity);
			return kabupatenEntity;
		
	}
	
	@Override
	public KabupatenEntity updateKabupaten(Integer idKabupaten, KabupatenDto dto) {
		// TODO Auto-generated method stub
		KabupatenEntity kabupatenEntity = kabupatenRepository.findById(idKabupaten).get();
		ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(dto.getKodeProvinsi());
		kabupatenEntity.setKodeKabupaten(dto.getKodeKabupaten());
		kabupatenEntity.setNamaKabupaten(dto.getNamaKabupaten());
		kabupatenEntity.setProvinsiEntity(provinsiEntity);
		kabupatenRepository.save(kabupatenEntity);
		return kabupatenEntity;
	}

	@Override
	public KabupatenEntity deleteKabupaten(Integer idKabupaten) {
		// TODO Auto-generated method stub
		KabupatenEntity kabupatenEntity = kabupatenRepository.findById(idKabupaten).get();
//		kabupatenRepository.delete(kabupatenEntity);
		return kabupatenEntity;
	}
	
	@Override
	public KabupatenEntity deleteKabupatenStatus(Integer idKabupaten) {
		// TODO Auto-generated method stub
		KabupatenEntity kabupatenEntity = kabupatenRepository.findById(idKabupaten).get();
		kabupatenEntity.setStatus(0);
		kabupatenRepository.save(kabupatenEntity);
		return kabupatenEntity;
	}
	
	public KabupatenEntity convertToKabupatenEntity(KabupatenDto dto) {
		KabupatenEntity kabupatenEntity = new KabupatenEntity();
		kabupatenEntity.setKodeKabupaten(dto.getKodeKabupaten());
		kabupatenEntity.setNamaKabupaten(dto.getNamaKabupaten());
		return kabupatenEntity;
	}

	

	

	

}
