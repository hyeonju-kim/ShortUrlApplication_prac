package com.example.shorturlapplication_prac.repository;

import com.example.shorturlapplication_prac.domain.ShortUrlSeq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortUrlSeqRepository extends JpaRepository<ShortUrlSeq, Long> {

}
