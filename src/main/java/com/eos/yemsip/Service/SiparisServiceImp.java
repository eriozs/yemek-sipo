package com.eos.yemsip.Service;

import com.eos.yemsip.Entities.Siparis;
import com.eos.yemsip.Entities.SiparisDTO;
import com.eos.yemsip.Mappers;
import com.eos.yemsip.Repository.SiparisRepository;
import com.eos.yemsip.exceptions.SiparisBulunamadiException;
import com.eos.yemsip.exceptions.YemekBulunamadiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SiparisServiceImp implements SiparisService {

    private final SiparisRepository siparisRepository;
    private final Mappers mappers;
    private final YemekService yemekService;

    public List<SiparisDTO> getTumSiparisListesi(){
        if (siparisRepository!=null){
        return siparisRepository.findAll().stream()
                .map(mappers::siparisToTumSiparisDTO)
                .collect(Collectors.toList());}
        else throw new RuntimeException("Sisteme kayitli siparis bulunamadi. \n Lutfen once bir siparis olusturunuz");
    }
    public List<SiparisDTO> getSiparisListesi(String isim){
        if (!controlSiparis(isim)){
        return siparisRepository.findSiparisesByIsim(isim).stream()
                .map(mappers::siparisToTumSiparisDTO)
                .collect(Collectors.toList());}
        else throw new SiparisBulunamadiException(isim);
    }
    public SiparisDTO getSonSiparis(String isim){
        if (!controlSiparis(isim)){
        return mappers.siparisToSiparisDTO(siparisRepository.findSiparisesByIsim(isim).getLast());}
        else throw new SiparisBulunamadiException(isim);
    }
    public boolean controlSiparis(String isim){
        return siparisRepository.findSiparisesByIsim(isim).isEmpty();
    }
    public void addSiparis(SiparisDTO siparisDTO){
        if(!yemekService.controlYemek(siparisDTO.getSiparisAdi().toLowerCase())){
            Siparis siparis = mappers.siparisDtoToSiparis(siparisDTO);
            siparis.setTutar(yemekService.getFiyat(siparisDTO.getSiparisAdi().toLowerCase()));
            siparisRepository.save(siparis);}
        else throw new YemekBulunamadiException(siparisDTO.getSiparisAdi());
    }

}
