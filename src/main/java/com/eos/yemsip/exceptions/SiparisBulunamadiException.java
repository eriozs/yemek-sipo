package com.eos.yemsip.exceptions;

public class SiparisBulunamadiException extends RuntimeException {
    public SiparisBulunamadiException(String isim) {
        super(isim + " isimli kisi adina siparis sistemde bulunamadi ");
    }
}
