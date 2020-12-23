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

import com.jayson.lokasi.dto.DesaDto;
import com.jayson.lokasi.dto.StatusMessageDto;
import com.jayson.lokasi.entity.DesaEntity;
import com.jayson.lokasi.entity.KabupatenEntity;
import com.jayson.lokasi.entity.KecamatanEntity;
import com.jayson.lokasi.entity.ProvinsiEntity;
import com.jayson.lokasi.repository.DesaRepository;
import com.jayson.lokasi.repository.KabupatenRepository;
import com.jayson.lokasi.repository.KecamatanRepository;
import com.jayson.lokasi.repository.ProvinsiRepository;
import com.jayson.lokasi.service.DesaService;

@RestController
@RequestMapping("/desa")
public class DesaController {
	
	@Autowired
	DesaService desaService;
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getDesa(){
		List<DesaEntity> desaEntities = desaService.getDesa();
		return ResponseEntity.ok(desaEntities);
	}
	
	@GetMapping("/get-by-kode/{kodeDesa}")
	public ResponseEntity<?> getByKodeDesa(@PathVariable String kodeDesa) {
		DesaEntity desaEntity = desaService.getByKodeDesa(kodeDesa);
		
		if(desaEntity == null) {
			StatusMessageDto<DesaEntity> result = new StatusMessageDto<>();
			result.setStatus(HttpStatus.BAD_REQUEST.value());
			result.setMessage("Data Not Found!");
			result.setData(desaEntity);
			return ResponseEntity.badRequest().body(result);
		} else {
			return ResponseEntity.ok(desaEntity);
		}
	
	}
	
	@GetMapping("/get-all-active")
	public ResponseEntity<?> getActiveDesa(){
		List<DesaEntity> desaEntities = desaService.getActiveDesa();
		return ResponseEntity.ok(desaEntities);
	}
	
	@PostMapping("/add-desa")
	public ResponseEntity<?> addDesa(@RequestBody DesaDto dto){
		DesaEntity desaEntity = desaService.addDesa(dto);
		
			StatusMessageDto<DesaEntity> result = new StatusMessageDto<>();
			result.setStatus(HttpStatus.OK.value());
			result.setMessage("Data Inserted!");
			result.setData(desaEntity);
			return ResponseEntity.ok(result);	
			
	}
	
	@PutMapping("/update-desa/{idDesa}")
	public ResponseEntity<?> updateDesa(@PathVariable Integer idDesa, @RequestBody DesaDto dto) {
		DesaEntity desaEntity = desaService.updateDesa(idDesa, dto);
		StatusMessageDto<DesaEntity> result = new StatusMessageDto<>();
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Data Updated!");
		result.setData(desaEntity);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("delete-desa/{idDesa}")
	public ResponseEntity<?> deleteDesa(@PathVariable Integer idDesa) {
		DesaEntity desaEntity = desaService.deleteDesa(idDesa);
		StatusMessageDto<DesaEntity> result = new StatusMessageDto<>();
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Data Deleted!");
		result.setData(desaEntity);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/delete-desa-status/{idDesa}")
	public ResponseEntity<?> deleteDesaStatus(@PathVariable Integer idDesa) {
		DesaEntity desaEntity = desaService.deleteDesaStatus(idDesa);
		StatusMessageDto<DesaEntity> result = new StatusMessageDto<>();
		result.setStatus(HttpStatus.OK.value());
		result.setMessage("Data Deleted!");
		result.setData(desaEntity);
		return ResponseEntity.ok(result);
	}
	
}
