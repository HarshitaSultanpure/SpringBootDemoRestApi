package com.example.restApi.controller;

import com.example.restApi.model.BfhlRequest;
import com.example.restApi.model.BfhlResponse;
import com.example.restApi.service.BfhlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/bfhl")

public class BfhlController {
	@Autowired
	private BfhlService bfhlService;

	@PostMapping
	public BfhlResponse postData(@RequestBody BfhlRequest request) {
	    return bfhlService.processData(request);
	}

	@GetMapping
	public Map<String, Integer> getData() {
	    return Map.of("operation_code", 1);
	}

}
