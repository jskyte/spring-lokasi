package com.jayson.lokasi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jayson.lokasi.dto.KecamatanDto;
import com.jayson.lokasi.entity.KabupatenEntity;
import com.jayson.lokasi.entity.KecamatanEntity;
import com.jayson.lokasi.entity.ProvinsiEntity;
import com.jayson.lokasi.repository.KabupatenRepository;
import com.jayson.lokasi.repository.KecamatanRepository;
import com.jayson.lokasi.repository.ProvinsiRepository;

@Service
@Transactional
public class KecamatanServiceImpl implements KecamatanService {
	
	@Autowired
	KecamatanRepository kecamatanRepository;
	
	@Autowired
	KabupatenRepository kabupatenRepository;
	
	@Autowired
	ProvinsiRepository provinsiRepository;

	@Override
	public List<KecamatanEntity> getKecamatan() {
		// TODO Auto-generated method stub
		List<KecamatanEntity> kecamatanEntities = kecamatanRepository.findAll();
		return kecamatanEntities;
	}

	@Override
	public KecamatanEntity getByKodeKecamatan(String kodeKecamatan) {
		// TODO Auto-generated method stub
		KecamatanEntity kecamatanEntity = kecamatanRepository.findByKodeKecamatan(kodeKecamatan);
		return kecamatanEntity;
	}
	
	@Override
	public List<KecamatanEntity> getActiveKecamatan() {
		// TODO Auto-generated method stub
		List<KecamatanEntity> kecamatanEntities = kecamatanRepository.getActiveKecamatan();
		return kecamatanEntities;
	}

	@Override
	public KecamatanEntity addKecamatan(KecamatanDto dto) {
		// TODO Auto-generated method stub
		KecamatanEntity kecamatanEntity = convertToKecamatanEntity(dto);
		
		if(dto.getKodeKecamatan() == kecamatanEntity.getKodeKecamatan()) {
			return null;
		} else {
			KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(dto.getKodeKabupaten());
			ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(kabupatenEntity.getProvinsiEntity().getKodeProvinsi());
			kecamatanEntity.setKabupatenEntity(kabupatenEntity);
			kecamatanEntity.setProvinsiEntity(provinsiEntity);
			kecamatanRepository.save(kecamatanEntity);
			return kecamatanEntity;
		}
	}

	@Override
	public KecamatanEntity updateKecamatan(Integer idKecamatan, KecamatanDto dto) {
		// TODO Auto-generated method stub
		KecamatanEntity kecamatanEntity = kecamatanRepository.findById(idKecamatan).get();
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(dto.getKodeKabupaten());
		ProvinsiEntity provinsiEntity = provinsiRepository.findByKodeProvinsi(kabupatenEntity.getProvinsiEntity().getKodeProvinsi());
		kecamatanEntity.setKodeKecamatan(dto.getKodeKecamatan());
		kecamatanEntity.setNamaKecamatan(dto.getNamaKecamatan());
		kecamatanEntity.setKabupatenEntity(kabupatenEntity);
		kecamatanEntity.setProvinsiEntity(provinsiEntity);
		kecamatanRepository.save(kecamatanEntity);
		return kecamatanEntity;
	}

	@Override
	public KecamatanEntity deleteKecamatan(Integer idKecamatan) {
		// TODO Auto-generated method stub
		KecamatanEntity kecamatanEntity = kecamatanRepository.findById(idKecamatan).get();
//		kecamatanRepository.delete(kecamatanEntity);
		return kecamatanEntity;
	}
	
	@Override
	public KecamatanEntity deleteKecamatanStatus(Integer idKecamatan) {
		// TODO Auto-generated method stub
		KecamatanEntity kecamatanEntity = kecamatanRepository.findById(idKecamatan).get();
		kecamatanEntity.setStatus(0);
		return kecamatanEntity;
	}
	
	public KecamatanEntity convertToKecamatanEntity(KecamatanDto dto) {
		KecamatanEntity kecamatanEntity = new KecamatanEntity();
		kecamatanEntity.setKodeKecamatan(dto.getKodeKecamatan());
		kecamatanEntity.setNamaKecamatan(dto.getNamaKecamatan());
		return kecamatanEntity;
	}

	

	

}
