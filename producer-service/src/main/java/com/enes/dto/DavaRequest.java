package com.enes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DavaRequest {
    private String mahkeme;
    private String davaTuru;
    private List<Taraf> davacilar;
    private List<Taraf> davalilar;
    private String konu;
    private String olaylar;
    private String talep;
}
