package com.jayson.lokasi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KecamatanDto {
	private Integer id;
	private String kodeKecamatan;
	private String namaKecamatan;
	private String kodeKabupaten;
	private String kodeProvinsi;
	private Integer status;
}
