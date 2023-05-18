package com.example.shorturlapplication_prac.repository;

import com.example.shorturlapplication_prac.domain.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url,Long> { // <Long, Url>로 쓰니까 에러났음
    boolean existsByLongUrl(String longUrl);

    // ★추가 - 리다이렉트 위해 쇼트유알엘로 Url 찾는 로직 추가
    Url findByShortUrl(String shortUrl); // 변수명 잘써줘야지... 안그러면 못찾는다ㅠ findByLongUrl 이라했다가 못찾아서 30분 헤멤 ;;;
}


