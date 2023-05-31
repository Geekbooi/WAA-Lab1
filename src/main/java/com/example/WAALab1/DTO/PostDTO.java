package com.example.WAALab1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PostDTO {
    private long id;
    private String title;
    private String content;
    private String author;

}
