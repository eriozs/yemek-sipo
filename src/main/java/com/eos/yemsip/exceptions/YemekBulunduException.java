package com.eos.yemsip.exceptions;

public class YemekBulunduException  extends RuntimeException {
    public YemekBulunduException(String yemekAdi) {
        super(yemekAdi + " isimli yemek sistemde kayitli. \n" + yemekAdi + " isimli yemegin fiyatini degistirmek icin /yemekler/degistir adresine PUT requestte bulunabilirsiniz");
    }
}
