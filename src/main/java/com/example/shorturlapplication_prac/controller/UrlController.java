package com.example.shorturlapplication_prac.controller;

import com.example.shorturlapplication_prac.domain.Url;
import com.example.shorturlapplication_prac.repository.UrlRepository;
import com.example.shorturlapplication_prac.service.UrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UrlController {
    private final UrlService urlService;

    @GetMapping("/basic")
    public String index() {
        return "basic/index";
    }

    // url 입력하면 변환 처리
    @PostMapping("/basic/layout")
    public String Shortening(@RequestParam String longUrl, Model model) {
        Url generateUrl = urlService.generateUrl(longUrl);
        model.addAttribute("url", generateUrl);
        return "basic/layout";
    }

    // ★추가 - 원래 사이트로 리다이렉트 되도록 추가
    @GetMapping("/{shorty}")
    public String redirectLongUrl(@PathVariable String shorty){
        String longUrl = urlService.findLongUrl(shorty);
        return "redirect:" + longUrl;

    }
}

