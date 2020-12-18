package com.jayson.lokasi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinsiDto {
	private Integer id;
	private String kodeProvinsi;
	private String namaProvinsi;
	private Integer status;
}
