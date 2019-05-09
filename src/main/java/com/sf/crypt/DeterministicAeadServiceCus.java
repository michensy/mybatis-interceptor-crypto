package com.sf.crypt;

import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.DeterministicAead;
import com.google.crypto.tink.JsonKeysetReader;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.daead.DeterministicAeadConfig;
import com.google.crypto.tink.daead.DeterministicAeadFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

/**
 * @author Zidong
 * @date 2019/5/9 10:56 AM
 */
@Slf4j
public class DeterministicAeadServiceCus {

    private static KeysetHandle keysetHandle;

    private static final String ASSOCIATED_DATA = "landLeaf6546";

    public DeterministicAeadServiceCus() {
    }

    static {
        try {
            DeterministicAeadConfig.register();
            URL resource = DeterministicAeadServiceCus.class.getClassLoader().getResource("static/data/keyset.json");
            if (null == resource) {
                throw new Exception("未读取到keyset.json");
            }
            File file = new File(resource.getFile());
            log.info("密钥 keyset.json : {} associatedData : {} ", file.getAbsolutePath(), ASSOCIATED_DATA);
            keysetHandle = CleartextKeysetHandle.read(JsonKeysetReader.withFile(file));
        } catch (Exception var4) {
            log.error("加密工具 DeterministicAeadService init 初始化失败" + var4.getMessage(), var4);
        }
    }

    public String encode(String plaintext) {
        if (StringUtils.isBlank(plaintext)) {
            return plaintext;
        } else {
            log.info("明文待加密 Text: {}", plaintext);

            String cipherText;
            try {
                DeterministicAead daead = DeterministicAeadFactory.getPrimitive(keysetHandle);
                byte[] associatedDataBytes = Optional.ofNullable(ASSOCIATED_DATA).map((a) -> a.getBytes(StandardCharsets.UTF_8)).orElse(null);
                byte[] cipherTextBytes = daead.encryptDeterministically(plaintext.getBytes(StandardCharsets.UTF_8), associatedDataBytes);
                cipherText = new String(Base64.getEncoder().encode(cipherTextBytes));
            } catch (Exception var6) {
                log.warn("DeterministicAeadService encode 加密出错 " + var6.getMessage(), var6);
                return plaintext;
            }

            log.info("加密后密文Base64 Cipher: {}", cipherText);
            return cipherText;
        }
    }

    public String decode(String cipherText) {
        if (StringUtils.isBlank(cipherText)) {
            return cipherText;
        } else {
            log.info("密文待解密 Base64 Cipher: {}", cipherText);

            String decryptedCipherText;
            try {
                DeterministicAead daead = DeterministicAeadFactory.getPrimitive(keysetHandle);
                byte[] associatedDataBytes = Optional.ofNullable(ASSOCIATED_DATA).map((a) -> a.getBytes(StandardCharsets.UTF_8)).orElse(null);
                byte[] decryptedCipherTextBytes = daead.decryptDeterministically(Base64.getDecoder().decode(cipherText), associatedDataBytes);
                decryptedCipherText = new String(decryptedCipherTextBytes, StandardCharsets.UTF_8);
            } catch (Exception var6) {
                log.warn("DeterministicAeadService decode 解密出错 " + var6.getMessage(), var6);
                return cipherText;
            }

            log.info("解密后明文 Text: {}", decryptedCipherText);
            return decryptedCipherText;
        }
    }
}
