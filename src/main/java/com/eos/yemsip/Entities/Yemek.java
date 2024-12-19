package com.eos.yemsip.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@Data
@Table(name = "yemekler")
@NoArgsConstructor
@AllArgsConstructor
public class Yemek {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(name = "yemek_ismi")
    @NotBlank(message = "yemek ismi bos birakilamaz. Lutfen bir yemek adi giriniz.(orn. Tavuk doner)")
    private String yemekAdi;
    @Column(name = "fiyat")
    @Positive(message = "yemek fiyatinin pozitif bir deger olmasi gerekmektedir. Lutfen uygun bir fiyat giriniz.(orn. 2.5)")
    private Float fiyat;
}
