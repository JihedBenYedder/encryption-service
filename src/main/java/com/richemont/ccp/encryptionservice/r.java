package com.richemont.ccp.encryptionservice;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "readiness")
public class r {

    @ReadOperation
    public String getReadiness() {
        // do a custom check for readiness
      return "f";
    }
}