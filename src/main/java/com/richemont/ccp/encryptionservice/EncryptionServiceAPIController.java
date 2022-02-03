package com.richemont.ccp.encryptionservice;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EncryptionServiceAPIController {

	@Autowired
	private EncryptionService encryptionService;

	@RequestMapping(path = "/encrypt", method = RequestMethod.POST)
	public ResponseEntity<String> encrypt(final String str)  {
			String encryptedVal = encryptionService.encrypt(str);
		return ResponseEntity.ok(encryptedVal);
	}

	@RequestMapping(path = "/decrypt", method = RequestMethod.POST)
	public ResponseEntity<String> decrypt(final String str)  {
            String decryptedKey = encryptionService.decrypt(str);
		return ResponseEntity.ok(decryptedKey);
	}
}
