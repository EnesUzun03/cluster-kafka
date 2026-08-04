package com.enes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dava {
    private String id;
    private String mahkeme;
    private String davaTuru;
    private List<Taraf> davacilar;
    private List<Taraf> davalilar;
    private String konu;
    private String olaylar;
    private String talep;
    private String sonuc;
    private Instant olusturmaTarihi;
}
