package com.eos.yemsip.Service;


import com.eos.yemsip.Entities.YemekDTO;


import java.util.List;


public interface YemekService {

    List<YemekDTO> getYemekListesi();
    void addYemek(YemekDTO yemekDto);
    void updateYemek(YemekDTO yemekDto);
    void deleteYemek(String yemekAdi);
    boolean controlYemek(String yemekAdi);
    Float getFiyat(String yemekAdi);
}
