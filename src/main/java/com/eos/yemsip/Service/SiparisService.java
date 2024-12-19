package com.eos.yemsip.Service;

import com.eos.yemsip.Entities.SiparisDTO;

import java.util.List;

public interface SiparisService {
    List<SiparisDTO> getTumSiparisListesi();
    List<SiparisDTO> getSiparisListesi(String isim);
    SiparisDTO getSonSiparis(String isim);
    void addSiparis(SiparisDTO siparisDTO);
}
