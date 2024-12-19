package com.eos.yemsip.Controller;

import com.eos.yemsip.Entities.SiparisDTO;
import com.eos.yemsip.Service.SiparisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SiparisController {
    @Autowired
    private SiparisService siparisService;

    @GetMapping("/siparisler")
    public ResponseEntity<List<SiparisDTO>> getTumSiparisListesi() {
        List<SiparisDTO> siparisList = siparisService.getTumSiparisListesi();
        return new ResponseEntity<>(siparisList, HttpStatus.OK);
    }
    @PostMapping("/siparisler/olustur")
    public ResponseEntity<String> addSiparis(@RequestBody SiparisDTO siparisDTO) {
        siparisService.addSiparis(siparisDTO);
        return new ResponseEntity<>("siparis olusturuldu \nson siparisinizin durumunuzu ogrenmek icin /siparisim adresine isminiz ile get requestte bulunabilirsiniz ",HttpStatus.CREATED);
    }

    @GetMapping("/siparislerim")
    public ResponseEntity<List<SiparisDTO>> getSiparisListesi(@RequestBody String isim) {
        List<SiparisDTO> siparislerim= siparisService.getSiparisListesi(isim);
        return new ResponseEntity<>(siparislerim,HttpStatus.OK);
    }
    @GetMapping("/siparisim")
    public ResponseEntity<String> getSonSiparis(@RequestBody String isim) {
        SiparisDTO siparisDTO = siparisService.getSonSiparis(isim);
            String musteri = siparisDTO.getIsim();
            Float fiyat = siparisDTO.getTutar();
        return new ResponseEntity<>(musteri+" siparisiniz hazirlaniyor borcunuz "+fiyat+"TL",HttpStatus.OK);
    }
}
