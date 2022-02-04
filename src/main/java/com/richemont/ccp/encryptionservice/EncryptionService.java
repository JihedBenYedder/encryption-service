package com.richemont.ccp.encryptionservice;

import org.springframework.stereotype.Component;

@Component
public class EncryptionService {

    private AesEncryptor aesEncryptor;

    public EncryptionService(AesEncryptor aesEncryptor) {
        this.aesEncryptor = aesEncryptor;
    }

    public String encrypt(final String val) {
/*
        VaultOperations vaultOps = BeanUtil.getBean(VaultOperations.class);
        Plaintext plaintext = Plaintext.of(val);
        String cipherText = vaultOps.opsForTransit().encrypt("customer", plaintext).getCiphertext();
        return cipherText;
*/
        return aesEncryptor.encrypt(val);
    }

    public String decrypt(final String val) {
        /*
        VaultOperations vaultOps = BeanUtil.getBean(VaultOperations.class);
        Ciphertext ciphertext = Ciphertext.of(customer);
        String plaintext = vaultOps.opsForTransit().decrypt("customer", ciphertext).asString();
        return plaintext;
         */
        return aesEncryptor.decrypt(val);
    }
}
