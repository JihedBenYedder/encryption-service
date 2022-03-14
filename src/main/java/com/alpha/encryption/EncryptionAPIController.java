package com.alpha.encryption;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class EncryptionAPIController {

	@Autowired
	private EncryptionService encryptionService;
	

	@RequestMapping(path = "/encrypt", method = RequestMethod.POST)
	public ResponseEntity<String> encrypt(final @RequestBody String str) throws JSONException {
		JSONObject jsonpObject = new JSONObject(str);
		Iterator<String> keys = jsonpObject.keys();
		JSONObject returnObject = new JSONObject();
		while (keys.hasNext()) {
			String key = keys.next();
			String encryptedVal = encryptionService.encrypt(jsonpObject.get(key).toString());
            String encryptedKey = encryptionService.encrypt(key);
            returnObject.put(encryptedKey, encryptedVal);
		}
		return ResponseEntity.of(Optional.of(returnObject.toString()));
	}

	@RequestMapping(path = "/decrypt", method = RequestMethod.POST)
	public ResponseEntity<String> decrypt(final @RequestBody String str) throws JSONException {
		JSONObject jsonpObject = new JSONObject(str);
		Iterator<String> keys = jsonpObject.keys();
		JSONObject returnObject = new JSONObject();
		while (keys.hasNext()) {
			String encryptedkey = keys.next();
            String decryptedKey = encryptionService.decrypt(encryptedkey);
			String val = encryptionService.decrypt(jsonpObject.get(encryptedkey).toString());
			returnObject.put(decryptedKey, val);
		}
		return ResponseEntity.of(Optional.of(returnObject.toString()));
	}
}
