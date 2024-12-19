package com.eos.yemsip.Repository;

import com.eos.yemsip.Entities.Yemek;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YemekRepository extends JpaRepository<Yemek, Long> {
    List<Yemek> findByYemekAdi(String yemekAdi);

}
