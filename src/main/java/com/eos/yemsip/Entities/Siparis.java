package com.eos.yemsip.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name="siparisler")
@Builder
@AllArgsConstructor
public class Siparis {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Isim bos birakilamaz,lutfen isminizi giriniz")
    @Column(name = "isim", nullable = false)
    private String isim;
    @NotBlank(message = "Yemek ismi bos birakilamaz, lutfen siparis etmek istediginiz yemegin adini giriniz")
    @Column(name = "siparis_edilen_yemek", nullable = false)
    private String siparisAdi;
    @Column(name = "tutar")
    private Float tutar;
}