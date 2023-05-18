package com.example.shorturlapplication_prac.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Url{
    // id 제거
    @Id
    private String shortUrl;

    @Column
    private String longUrl;
}