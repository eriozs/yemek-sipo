package com.eos.yemsip.Repository;

import com.eos.yemsip.Entities.Siparis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SiparisRepository extends JpaRepository<Siparis, Long> {

    List<Siparis> findSiparisesByIsim(String isim);
}
