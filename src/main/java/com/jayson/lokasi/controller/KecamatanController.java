package com.jayson.lokasi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayson.lokasi.dto.KecamatanDto;
import com.jayson.lokasi.dto.StatusMessageDto;
import com.jayson.lokasi.entity.KabupatenEntity;
import com.jayson.lokasi.entity.KecamatanEntity;
import com.jayson.lokasi.entity.ProvinsiEntity;
import com.jayson.lokasi.repository.KabupatenRepository;
import com.jayson.lokasi.repository.KecamatanRepository;
import com.jayson.lokasi.repository.ProvinsiRepository;
import com.jayson.lokasi.service.KecamatanService;

@RestController
@RequestMapping("/kecamatan")
public class KecamatanController {
	
	@Autowired
	KecamatanService kecamatanService;
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getKecamatan(){
		List<KecamatanEntity> kecamatanEntities = kecamatanService.getKecamatan();
		return ResponseEntity.ok(kecamatanEntities);
	}
	
	@GetMapping("/get-by-kode/{kodeKecamatan}")
	public ResponseEntity<?> getByKodeKecamatan(@PathVariable String kodeKecamatan) {
		KecamatanEntity kecamatanEntity = kecamatanService.getByKodeKecamatan(kodeKecamatan);
		
		if (kecamatanEntity == null) {
			StatusMessageDto<KecamatanEntity> result = new StatusMessageDto<>();
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Data Not Found!");
			result.setData(kecamatanEntity);
			return ResponseEntity.badRequest().body(result);
		} else {
			return ResponseEntity.ok(kecamatanEntity);
		}
		
	}
	
	@GetMapping("/get-all-active")
	public ResponseEntity<?> getActiveKecamatan(){
		List<KecamatanEntity> kecamatanEntities = kecamatanService.getActiveKecamatan();
		return ResponseEntity.ok(kecamatanEntities);
	}
	
	@PostMapping("/add-kecamatan")
	public ResponseEntity<?> addKecamatan(@RequestBody KecamatanDto dto) {
		KecamatanEntity kecamatanEntity = kecamatanService.addKecamatan(dto);
		
		if (kecamatanEntity == null) {
			StatusMessageDto<KecamatanEntity> result = new StatusMessageDto<>();
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Duplicate entry for Kode Kecamatan!");
			result.setData(null);
			return ResponseEntity.badRequest().body(result);
		} else {
			StatusMessageDto<KecamatanEntity> result = new StatusMessageDto<>();
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data Inserted!");
			result.setData(kecamatanEntity);
			return ResponseEntity.ok(result);	
		}	
	}
	
	@PutMapping("/update-kecamatan/{idKecamatan}")
	public ResponseEntity<?> updateKecamatan(@PathVariable Integer idKecamatan, @RequestBody KecamatanDto dto) {
		KecamatanEntity kecamatanEntity = kecamatanService.updateKecamatan(idKecamatan, dto);
		StatusMessageDto<KecamatanEntity> result = new StatusMessageDto<>();
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Data Updated!");
		result.setData(kecamatanEntity);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/delete-kecamatan/{idKecamatan}")
	public ResponseEntity<?> deleteKecamatan(@PathVariable Integer idKecamatan) {
		KecamatanEntity kecamatanEntity = kecamatanService.deleteKecamatan(idKecamatan);
		StatusMessageDto<KecamatanEntity> result = new StatusMessageDto<>();
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Data Deleted!");
		result.setData(kecamatanEntity);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/delete-kecamatan-status/{idKecamatan}")
	public ResponseEntity<?> deleteKecamatanStatus(@PathVariable Integer idKecamatan) {
		KecamatanEntity kecamatanEntity = kecamatanService.deleteKecamatanStatus(idKecamatan);
		StatusMessageDto<KecamatanEntity> result = new StatusMessageDto<>();
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Data Deleted!");
		result.setData(kecamatanEntity);
		return ResponseEntity.ok(result);
	}
	
}
