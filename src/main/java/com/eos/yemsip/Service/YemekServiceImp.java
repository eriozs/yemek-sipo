package com.eos.yemsip.Service;



import com.eos.yemsip.Entities.Yemek;
import com.eos.yemsip.Entities.YemekDTO;
import com.eos.yemsip.Mappers;
import com.eos.yemsip.Repository.YemekRepository;
import com.eos.yemsip.exceptions.YemekBulunamadiException;
import com.eos.yemsip.exceptions.YemekBulunduException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class YemekServiceImp implements YemekService {


    private final YemekRepository yemekRepository;
    private final Mappers mappers;


    @Override
    public List<YemekDTO> getYemekListesi() {
        if(!yemekRepository.findAll().isEmpty()) {
        return yemekRepository.findAll().stream()
                .map(mappers::yemekToYemekDTO)
                .collect(Collectors.toList());}
        else throw new RuntimeException("Yemek Listesine kayitli bir yemek bulunamadi. \n Lutfen once sisteme bir yemek kaydedin.");
    }
    @Override
    public void addYemek(YemekDTO yemekDto) {
        if (yemekRepository==null ||controlYemek(yemekDto.getYemekAdi().toLowerCase())){
        yemekRepository.save(mappers.yemekDTOToYemek(yemekDto));}
        else throw new YemekBulunduException(yemekDto.getYemekAdi());
    }
    @Override
    public void updateYemek(YemekDTO yemekDto) {
        if (!controlYemek(yemekDto.getYemekAdi().toLowerCase())){
            Yemek yemek = yemekRepository.findByYemekAdi(yemekDto.getYemekAdi().toLowerCase()).getFirst();
            yemek.setYemekAdi(yemekDto.getYemekAdi().toLowerCase());
            yemek.setFiyat(yemekDto.getFiyat());
            yemekRepository.save(yemek);
        }
        else throw new YemekBulunamadiException(yemekDto.getYemekAdi());
    }
    @Override
    public void deleteYemek(String yemekAdi){
        if (!controlYemek(yemekAdi.toLowerCase())){
        Long ID = yemekRepository.findByYemekAdi(yemekAdi.toLowerCase()).getFirst().getID();
        yemekRepository.deleteById(ID);}
        else throw new YemekBulunamadiException(yemekAdi);
    }
    @Override
    public boolean controlYemek(String yemekAdi) {
        return yemekRepository.findByYemekAdi(yemekAdi.toLowerCase()).isEmpty();
    }
    @Override
    public Float getFiyat(String yemekAdi) {
        return yemekRepository.findByYemekAdi(yemekAdi).getFirst().getFiyat();
    }

}
