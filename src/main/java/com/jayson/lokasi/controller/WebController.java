package com.jayson.lokasi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/kabupaten")
	public String kabupaten() {
		return "kabupaten";
	}
	
	@GetMapping("/kecamatan")
	public String kecamatan() {
		return "kecamatan";
	}
	
	@GetMapping("/desa")
	public String desa() {
		return "desa";
	}
	
}
