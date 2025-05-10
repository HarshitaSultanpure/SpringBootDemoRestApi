package com.example.restApi.service;

import com.example.restApi.model.BfhlRequest;
import com.example.restApi.model.BfhlResponse;
import org.apache.tika.Tika;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Base64;

@Service

public class BfhlService {
	private final String email = "john@xyz.com";
	private final String roll = "ABCD123";
	private final String user_id = "john_doe_17091999";
	
	public BfhlResponse processData(BfhlRequest request) {
	    BfhlResponse response = new BfhlResponse();
	    List<String> numbers = new ArrayList<>();
	    List<String> alphabets = new ArrayList<>();
	    List<String> lowercase = new ArrayList<>();

	    boolean isPrimeFound = false;
	    
	    for (String s : request.getData()) {
	        if (s.matches("\\d+")) {
	            numbers.add(s);
	            if (isPrime(Integer.parseInt(s))) {
	                isPrimeFound = true;
	            }
	        } else if (s.matches("[a-zA-Z]")) {
	            alphabets.add(s);
	            if (s.matches("[a-z]")) {
	                lowercase.add(s);
	            }
	        }
	    }

	    // File Handling
	    boolean fileValid = false;
	    String mimeType = null;
	    String fileSizeKb = null;
	    if (request.getFile_b64() != null && !request.getFile_b64().isEmpty()) {
	        try {
	            byte[] decodedBytes = Base64.getDecoder().decode(request.getFile_b64());
	            Tika tika = new Tika();
	            mimeType = tika.detect(decodedBytes);
	            fileSizeKb = String.valueOf(decodedBytes.length / 1024);
	            fileValid = true;
	        } catch (Exception e) {
	            fileValid = false;
	        }
	    }

	    response.setIs_success(true);
	    response.setUser_id(user_id);
	    response.setEmail(email);
	    response.setRoll_number(roll);
	    response.setNumbers(numbers);
	    response.setAlphabets(alphabets);
	    response.setHighest_lowercase_alphabet(getMaxLowercase(lowercase));
	    response.setIs_prime_found(isPrimeFound);
	    response.setFile_valid(fileValid);
	    response.setFile_mime_type(mimeType);
	    response.setFile_size_kb(fileSizeKb);

	    return response;
	}

	private boolean isPrime(int num) {
	    if (num <= 1) return false;
	    for (int i = 2; i <= Math.sqrt(num); i++) {
	        if (num % i == 0) return false;
	    }
	    return true;
	}

	private List<String> getMaxLowercase(List<String> lc) {
	    if (lc.isEmpty()) return new ArrayList<>();
	    return Collections.singletonList(Collections.max(lc));
	}


	
}
