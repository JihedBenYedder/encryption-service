package com.richemont.ccp.encryptionservice;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.stereotype.Component;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.support.Ciphertext;
import org.springframework.vault.support.Plaintext;

@Component
public class EncryptionService {

    public String encrypt(final String val) {
        VaultOperations vaultOps = BeanUtil.getBean(VaultOperations.class);
        Plaintext plaintext = Plaintext.of(val);
        String cipherText = vaultOps.opsForTransit().encrypt("genericData", plaintext).getCiphertext();
        return cipherText;
    }

    public String decrypt(final String val) {

        VaultOperations vaultOps = BeanUtil.getBean(VaultOperations.class);
        Ciphertext ciphertext = Ciphertext.of(val);
        String plaintext = vaultOps.opsForTransit().decrypt("genericData", ciphertext).asString();
        return plaintext;
    }
}
