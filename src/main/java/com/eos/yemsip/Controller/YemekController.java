package com.eos.yemsip.Controller;

import com.eos.yemsip.Entities.YemekDTO;
import com.eos.yemsip.Service.YemekService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class YemekController {

    @Autowired
    private final YemekService yemekService;

    @GetMapping("/yemekler")
    public ResponseEntity<List<YemekDTO>> getYemekListesi(){
        List<YemekDTO> yemekList = yemekService.getYemekListesi();
        return new ResponseEntity<>(yemekList, HttpStatus.OK);
    }
    @PostMapping("/yemekler/ekle")
    public ResponseEntity<String> addYemek(@Valid @RequestBody YemekDTO yemekDto){
        yemekService.addYemek(yemekDto);
        return new ResponseEntity<>("yemek basarili sekilde kaydedildi",HttpStatus.CREATED);
    }
    @DeleteMapping("/yemekler/sil")
    public ResponseEntity<String> deleteYemek(@RequestBody String yemekAdi) {
        yemekService.deleteYemek(yemekAdi);
        return new ResponseEntity<>("yemek basarili bir sekilde silindi",HttpStatus.OK);
    }
    @PutMapping("/yemekler/degistir")
    public ResponseEntity<String> updateYemek(@Valid @RequestBody YemekDTO yemekDto) {
        yemekService.updateYemek(yemekDto);
        return new ResponseEntity<>("yemek basarili bir sekilde duzenlendi",HttpStatus.OK);
    }

}
