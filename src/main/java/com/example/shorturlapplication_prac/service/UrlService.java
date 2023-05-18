package com.example.shorturlapplication_prac.service;

import com.example.shorturlapplication_prac.domain.ShortUrlSeq;
import com.example.shorturlapplication_prac.domain.Url;
import com.example.shorturlapplication_prac.repository.ShortUrlSeqRepository;
import com.example.shorturlapplication_prac.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;
    private final ShortUrlSeqRepository shortUrlSeqRepository;

    @Value("${portal.address}")
    private String portalAddress;

    //1.시퀀스 객체 만들기 로직
    public Integer generateSeq() {
        ShortUrlSeq nowShortUrlSeq = shortUrlSeqRepository.findById(1L).orElse(null);
        if (nowShortUrlSeq == null) {
            ShortUrlSeq shortUrlSeq = new ShortUrlSeq();
            shortUrlSeq.setId(1L);
            shortUrlSeq.setSeqVal(1);
            shortUrlSeqRepository.save(shortUrlSeq);
            return 1;
        }else {
            Integer findSeqVal = nowShortUrlSeq.getSeqVal();
            nowShortUrlSeq.setSeqVal(++findSeqVal);
            return findSeqVal;
        }
    }

    //2. 쇼트 유알엘 만들기 로직
//    @Transactional  왜 안되지;;
    public Url generateUrl(String longUrl){
        Url url = new Url();
        Integer seq = generateSeq();

        if (!urlRepository.existsByLongUrl(longUrl)) {
            url.setLongUrl(longUrl);
            url.setShortUrl(portalAddress + "srt" + seq);
            urlRepository.save(url);
            return url;
        }else {

            return url;
        }
    }
    // ★추가 - 리다이렉트 위해 긴 유알엘 가져오기
    public String findLongUrl(String shorty) {
        String shortUrl = portalAddress + shorty;
        Url findUrl = urlRepository.findByShortUrl(shortUrl);
        return findUrl.getLongUrl();
    }
}
