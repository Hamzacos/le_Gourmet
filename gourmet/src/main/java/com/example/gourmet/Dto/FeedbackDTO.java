package com.example.gourmet.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDTO {
    private Long id;
    private String contenu;
    private int note;
    private PlatDTO plat;
}
