package com.jayson.lokasi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jayson.lokasi.dto.DesaDto;
import com.jayson.lokasi.entity.DesaEntity;
import com.jayson.lokasi.entity.KabupatenEntity;
import com.jayson.lokasi.entity.KecamatanEntity;
import com.jayson.lokasi.entity.ProvinsiEntity;
import com.jayson.lokasi.repository.DesaRepository;
import com.jayson.lokasi.repository.KabupatenRepository;
import com.jayson.lokasi.repository.KecamatanRepository;
import com.jayson.lokasi.repository.ProvinsiRepository;

@Service
@Transactional
public class DesaServiceImpl implements DesaService{
	
	@Autowired
	DesaRepository desaRepository;
	
	@Autowired
	KecamatanRepository kecamatanRepository;
	
	@Autowired
	KabupatenRepository kabupatenRepository;
	
	@Autowired
	ProvinsiRepository provinsiRepository;

	@Override
	public List<DesaEntity> getDesa() {
		// TODO Auto-generated method stub
		List<DesaEntity> desaEntities = desaRepository.findAll();
		return desaEntities;
	}

	@Override
	public DesaEntity getByKodeDesa(String kodeDesa) {
		// TODO Auto-generated method stub
		DesaEntity desaEntity = desaRepository.findByKodeDesa(kodeDesa);
		return desaEntity;
	}
	
	@Override
	public List<DesaEntity> getActiveDesa() {
		// TODO Auto-generated method stub
		List<DesaEntity> desaEntities = desaRepository.getActiveDesa();
		return desaEntities;
	}

	@Override
	public DesaEntity addDesa(DesaDto dto) {
		// TODO Auto-generated method stub
		DesaEntity desaEntity = convertToDesaEntity(dto);
		
		if (dto.getKodeDesa() == desaEntity.getKodeDesa()) {
			return null;
		} else {
			KecamatanEntity kecamatanEntity = kecamatanRepository.findByKodeKecamatan(dto.getKodeKecamatan());
			KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(kecamatanEntity.getKabupatenEntity().getKodeKabupaten());
			ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(kabupatenEntity.getProvinsiEntity().getKodeProvinsi());
			desaEntity.setKecamatanEntity(kecamatanEntity);
			desaEntity.setKabupatenEntity(kabupatenEntity);
			desaEntity.setProvinsiEntity(provinsiEntity);
			desaRepository.save(desaEntity);
			return desaEntity;
		}	
	}

	@Override
	public DesaEntity updateDesa(Integer idDesa, DesaDto dto) {
		// TODO Auto-generated method stub
		DesaEntity desaEntity = desaRepository.findById(idDesa).get();
		KecamatanEntity kecamatanEntity = kecamatanRepository.findByKodeKecamatan(dto.getKodeKecamatan());
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(kecamatanEntity.getKabupatenEntity().getKodeKabupaten());
		ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(kabupatenEntity.getProvinsiEntity().getKodeProvinsi());
		desaEntity.setKodeDesa(dto.getKodeDesa());
		desaEntity.setNamaDesa(dto.getNamaDesa());
		desaEntity.setKecamatanEntity(kecamatanEntity);
		desaEntity.setKabupatenEntity(kabupatenEntity);
		desaEntity.setProvinsiEntity(provinsiEntity);
		desaRepository.save(desaEntity);
		return desaEntity;
	}

	@Override
	public DesaEntity deleteDesa(Integer idDesa) {
		// TODO Auto-generated method stub
		DesaEntity desaEntity = desaRepository.findById(idDesa).get();
//		desaRepository.delete(desaEntity);
		return desaEntity;
	}
	
	@Override
	public DesaEntity deleteDesaStatus(Integer idDesa) {
		// TODO Auto-generated method stub
		DesaEntity desaEntity = desaRepository.findById(idDesa).get();
		desaEntity.setStatus(0);
		desaRepository.save(desaEntity);
		return desaEntity;
	}
	
	public DesaEntity convertToDesaEntity(DesaDto dto) {
		DesaEntity desaEntity = new DesaEntity();
		desaEntity.setKodeDesa(dto.getKodeDesa());
		desaEntity.setNamaDesa(dto.getNamaDesa());
		return desaEntity;
	}

	


}
