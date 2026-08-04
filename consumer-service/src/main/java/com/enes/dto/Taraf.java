package com.enes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Taraf {
    private String ad;
    private String soyad;
    private String tcKimlikNo;
    private String adres;
}
