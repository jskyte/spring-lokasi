package com.jayson.lokasi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayson.lokasi.dto.ProvinsiDto;
import com.jayson.lokasi.dto.StatusMessageDto;
import com.jayson.lokasi.entity.ProvinsiEntity;
import com.jayson.lokasi.repository.ProvinsiRepository;
import com.jayson.lokasi.service.ProvinsiService;

@RestController
@RequestMapping("/provinsi")
//@CrossOrigin(origins = "localhost:3000")
public class ProvinsiController {
	
	@Autowired
	ProvinsiService provinsiService;
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getProvinsi(){
		List<ProvinsiEntity> provinsiEntities = provinsiService.getProvinsi();
		return ResponseEntity.ok(provinsiEntities);
	}
	
	@GetMapping("/get-by-kode/{kodeProvinsi}")
	public ResponseEntity<?> getByKodeProvinsi(@PathVariable String kodeProvinsi){
		ProvinsiEntity provinsiEntities = provinsiService.getByKodeProvins(kodeProvinsi);
		
		if (provinsiEntities == null) {
			StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Data Not Found!");
			result.setData(provinsiEntities);
			return ResponseEntity.badRequest().body(result);
		} else {
			return ResponseEntity.ok(provinsiEntities);
		}
		
	}
	
	@GetMapping("/get-by-id/{id}")
	public ResponseEntity<?> getByIdProvinsi(@PathVariable Integer id){
		ProvinsiEntity provinsiEntity = provinsiService.getByIdProvinsi(id);
		return ResponseEntity.ok(provinsiEntity);
	}
	
	@GetMapping("/get-all-active")
	public ResponseEntity<?> getActiveProvinsi(){
		List<ProvinsiEntity> provinsiEntities = provinsiService.getActiveProvinsi();
		return ResponseEntity.ok(provinsiEntities);
	}
	
	@PostMapping("/add-provinsi")
	public ResponseEntity<?> addProvinsi(@RequestBody ProvinsiDto dto) {
		ProvinsiEntity provinsiEntity = provinsiService.addProvinsi(dto);
		
			StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data Inserted!");
			result.setData(provinsiEntity);
			return ResponseEntity.ok(result);
		

	}
	
	@PutMapping("/update-provinsi/{idProvinsi}")
	public ResponseEntity<?> updateProvinsi(@PathVariable Integer idProvinsi, @RequestBody ProvinsiDto dto) {
		ProvinsiEntity provinsiEntity = provinsiService.updateProvinsi(idProvinsi, dto);
		StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Data Updated");
		result.setData(provinsiEntity);
		return ResponseEntity.ok(result);		
	}
	
	@DeleteMapping("/delete-provinsi/{idProvinsi}")
	public ResponseEntity<?> deleteProvinsi(@PathVariable Integer idProvinsi) {
		ProvinsiEntity provinsiEntity = provinsiService.deleteProvinsi(idProvinsi);
		StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Data Deleted!");
		result.setData(provinsiEntity);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/delete-provinsi-status/{idProvinsi}")
	public ResponseEntity<?> deleteProvinsiStatus(@PathVariable Integer idProvinsi) {
		ProvinsiEntity provinsiEntity = provinsiService.deleteProvinsiStatus(idProvinsi);
		StatusMessageDto<ProvinsiEntity> result = new StatusMessageDto<>();
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Data Deleted!");
		result.setData(provinsiEntity);
		return ResponseEntity.ok(result);
	}
	
}
