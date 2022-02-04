package com.richemont.ccp.encryptionservice;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EncryptionServiceAPIController {

	private EncryptionService encryptionService;

	@RequestMapping(path = "/encrypt", method = RequestMethod.POST)
	public String encrypt(final @RequestBody String str) {
	   return "ds";
	}

	@RequestMapping(path = "/decrypt", method = RequestMethod.POST)
	public String decrypt(final @RequestBody String str)  {
		return "ds";
	}
}
