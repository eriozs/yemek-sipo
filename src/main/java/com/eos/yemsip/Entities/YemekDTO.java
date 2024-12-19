package com.eos.yemsip.Entities;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Builder
public class YemekDTO {
    @NotBlank(message = "yemek ismi bos birakilamaz. Lutfen bir yemek adi giriniz.(orn. Tavuk doner)")
    private String yemekAdi;
    @Positive(message = "yemek fiyatinin pozitif bir deger olmasi gerekmektedir. Lutfen uygun bir fiyat giriniz.(orn. 2.5)")
    private Float fiyat;

}
