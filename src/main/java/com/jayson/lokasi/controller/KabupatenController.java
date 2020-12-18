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

import com.jayson.lokasi.dto.KabupatenDto;
import com.jayson.lokasi.dto.StatusMessageDto;
import com.jayson.lokasi.entity.KabupatenEntity;
import com.jayson.lokasi.entity.ProvinsiEntity;
import com.jayson.lokasi.repository.KabupatenRepository;
import com.jayson.lokasi.repository.ProvinsiRepository;
import com.jayson.lokasi.service.KabupatenService;

@RestController
@RequestMapping("/kabupaten")
public class KabupatenController {
	
	@Autowired
	KabupatenService kabupatenService;
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getKabupaten(){
		List<KabupatenEntity> kabupatenEntities = kabupatenService.getKabupaten();
		return ResponseEntity.ok(kabupatenEntities);
	}
	
	@GetMapping("/get-by-kode/{kodeKabupaten}")
	public ResponseEntity<?> getByKodeKabupaten(@PathVariable String kodeKabupaten) {
		KabupatenEntity kabupatenEntity = kabupatenService.getByKodeKabupaten(kodeKabupaten);
		return ResponseEntity.ok(kabupatenEntity);
	}
	
	@GetMapping("/get-all-active")
	public ResponseEntity<?> getActiveKabupaten() {
		List<KabupatenEntity> kabupatenEntity = kabupatenService.getActiveKabupaten();
		return ResponseEntity.ok(kabupatenEntity);
	}
	
	@PostMapping("/add-kabupaten")
	public ResponseEntity<?> addKabupaten(@RequestBody KabupatenDto dto){
		KabupatenEntity kabupatenEntity = kabupatenService.addKabupaten(dto);
		StatusMessageDto<KabupatenEntity> result = new StatusMessageDto<>();
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Data Inserted!");
		result.setData(kabupatenEntity);
		return ResponseEntity.ok(result);
	}
	
	
	@PutMapping("/update-kabupaten/{idKabupaten}")
	public ResponseEntity<?> updateKabupaten(@PathVariable Integer idKabupaten, @RequestBody KabupatenDto dto) {
		KabupatenEntity kabupatenEntity = kabupatenService.updateKabupaten(idKabupaten, dto);
		StatusMessageDto<KabupatenEntity> result = new StatusMessageDto<>();
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Data Updated!");
		result.setData(kabupatenEntity);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/delete-kabupaten/{idKabupaten}")
	public ResponseEntity<?> deleteKabupaten(@PathVariable Integer idKabupaten) {
		KabupatenEntity kabupatenEntity = kabupatenService.deleteKabupaten(idKabupaten);
		StatusMessageDto<KabupatenEntity> result = new StatusMessageDto<>();
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Data Deleted!");
		result.setData(kabupatenEntity);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/delete-kabupaten-status/{idKabupaten}")
	public ResponseEntity<?> deleteKabupatenStatus(@PathVariable Integer idKabupaten) {
		KabupatenEntity kabupatenEntity = kabupatenService.deleteKabupatenStatus(idKabupaten);
		StatusMessageDto<KabupatenEntity> result = new StatusMessageDto<>();
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Data Deleted!");
		result.setData(kabupatenEntity);
		return ResponseEntity.ok(result);
	}
 	
}
