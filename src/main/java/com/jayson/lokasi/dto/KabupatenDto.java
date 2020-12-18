package com.jayson.lokasi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KabupatenDto {
	private Integer id;
	private String kodeKabupaten;
	private String namaKabupaten;
	private String kodeProvinsi;
	private Integer status;
}
