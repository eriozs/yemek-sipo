package com.eos.yemsip;

import com.eos.yemsip.Entities.Siparis;
import com.eos.yemsip.Entities.SiparisDTO;
import com.eos.yemsip.Entities.Yemek;
import com.eos.yemsip.Entities.YemekDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface Mappers {
    @Mapping(target = "ID", ignore = true)
    @Mapping(target = "yemekAdi", expression ="java(yemekDto.getYemekAdi() != null ? yemekDto.getYemekAdi().toLowerCase() : null)" )
    Yemek yemekDTOToYemek(YemekDTO yemekDto);

    YemekDTO yemekToYemekDTO(Yemek yemek);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tutar", ignore = true)
    Siparis siparisDtoToSiparis(SiparisDTO siparisDto);

    @Mapping(target = "siparisAdi", ignore = true)
    SiparisDTO siparisToSiparisDTO(Siparis siparis);

    SiparisDTO siparisToTumSiparisDTO(Siparis siparis);
}
