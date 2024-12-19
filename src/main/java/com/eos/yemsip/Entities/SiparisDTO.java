package com.eos.yemsip.Entities;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Builder
public class SiparisDTO {

    @NotBlank(message = "Isim bos birakilamaz,lutfen isminizi giriniz")
    private String isim;
    @NotBlank(message = "Yemek ismi bos birakilamaz, lutfen siparis etmek istediginiz yemegin adini giriniz")
    private String siparisAdi;
    @Null(message = "tutar kismi bos kalmalidir,lutfen bu alani bos birakin")
    private Float tutar;
}
