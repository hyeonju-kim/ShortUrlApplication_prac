package com.example.shorturlapplication_prac.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Getter
@Setter
public class ShortUrlSeq {
    @Id
    @Column(name = "SEQ_ID")
    private Long id;

    @Column(name = "SEQ_VAL")
    private Integer seqVal;
}
