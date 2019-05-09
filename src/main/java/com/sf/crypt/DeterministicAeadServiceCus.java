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

    private static KeysetHandle handle;

    private static final String ASSOCIATED_DATA = "landLeaf6546";

    private static final String KEY_PATH = "static/data/keyset.json";

    static {
        try {
            DeterministicAeadConfig.register();
            URL resource = DeterministicAeadServiceCus.class.getClassLoader().getResource(KEY_PATH);
            if (null == resource) {
                throw new Exception("未读取到keyset.json");
            }
            File file = new File(resource.getFile());
            log.debug("密钥 keyset.json : {} associatedData : {} ", file.getAbsolutePath(), ASSOCIATED_DATA);
            handle = CleartextKeysetHandle.read(JsonKeysetReader.withFile(file));
        } catch (Exception var4) {
            log.error("加密工具 DeterministicAeadService init 初始化失败" + var4.getMessage(), var4);
        }
    }

    public String encode(String text) {
        if (StringUtils.isBlank(text)) {
            return text;
        } else {
            log.debug("明文待加密 Text: {}", text);
            String cipherText;
            try {
                DeterministicAead daead = DeterministicAeadFactory.getPrimitive(handle);
                byte[] associatedDataBytes = Optional.of(ASSOCIATED_DATA).map((a) -> a.getBytes(StandardCharsets.UTF_8)).orElse(null);
                byte[] cipherTextBytes = daead.encryptDeterministically(text.getBytes(StandardCharsets.UTF_8), associatedDataBytes);
                cipherText = new String(Base64.getEncoder().encode(cipherTextBytes));
            } catch (Exception var6) {
                log.debug("加密工具 DeterministicAeadService encode出错 " + var6.getMessage(), var6);
                return text;
            }
            log.debug("加密后密文Base64 Cipher: {}", cipherText);
            return cipherText;
        }
    }

    public String decode(String cipherText) {
        // 不合规的数据直接返回
        if (StringUtils.isBlank(cipherText) || cipherText.length() != 44) {
            return cipherText;
        } else {
            log.debug("密文待解密 Base64 Cipher: {}", cipherText);
            String text;
            try {
                DeterministicAead daead = DeterministicAeadFactory.getPrimitive(handle);
                byte[] associatedDataBytes = Optional.of(ASSOCIATED_DATA).map((a) -> a.getBytes(StandardCharsets.UTF_8)).orElse(null);
                byte[] decryptedCipherTextBytes = daead.decryptDeterministically(Base64.getDecoder().decode(cipherText), associatedDataBytes);
                text = new String(decryptedCipherTextBytes, StandardCharsets.UTF_8);
            } catch (Exception var6) {
                log.warn("加密工具 DeterministicAeadService decode出错 " + var6.getMessage(), var6);
                return cipherText;
            }
            log.debug("解密后明文 Text: {}", text);
            return text;
        }
    }
}
