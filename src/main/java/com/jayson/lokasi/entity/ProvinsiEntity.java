package com.jayson.lokasi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@RequestMapping(name = "provinsi_entity")
public class ProvinsiEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "kode_provinsi", unique = true)
	private String kodeProvinsi;
	
	@Column(name = "nama_provinsi")
	private String namaProvinsi;
	
	@Column(name = "status")
	private Integer status = 1;

}