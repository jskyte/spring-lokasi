package com.jayson.lokasi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DesaDto {
	private Integer id;
	private String kodeDesa;
	private String namaDesa;
	private String kodeKecamatan;
	private String kodeKabupaten;
	private String kodeProvinsi;
	private Integer status;
}
