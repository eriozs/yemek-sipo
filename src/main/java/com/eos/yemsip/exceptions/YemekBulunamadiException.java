package com.eos.yemsip.exceptions;

public class YemekBulunamadiException extends RuntimeException {
    public YemekBulunamadiException(String yemekAdi) {
        super(yemekAdi + " isimli yemek sistemde bulunamadi \n" + yemekAdi + " isimli yemegi eklemek icin /yemekler/ekle adresine POST requestte bulunabilirsiniz");
    }
}
