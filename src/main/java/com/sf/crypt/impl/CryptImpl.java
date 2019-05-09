package com.sf.crypt.impl;

import com.sf.crypt.Crypt;
import com.sf.crypt.DeterministicAeadServiceCus;
import com.sf.hd.util.DeterministicAeadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Zidong
 * @date 2019/5/9 9:43 AM
 */
@Slf4j
public class CryptImpl implements Crypt {

    @Autowired
    DeterministicAeadService deterministicAeadService;

    @Override
    public String encrypt(String plain) {
        return new DeterministicAeadServiceCus().encode(plain);
    }

    @Override
    public String decrypt(String cipher) {
        return new DeterministicAeadServiceCus().decode(cipher);
    }
}
