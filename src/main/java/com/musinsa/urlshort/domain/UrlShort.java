package com.musinsa.urlshort.domain;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "URLSHORT")
public class UrlShort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String url;

    @NonNull
    private Long cnt;


}
