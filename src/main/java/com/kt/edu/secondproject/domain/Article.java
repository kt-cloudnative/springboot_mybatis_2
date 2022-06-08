package com.kt.edu.secondproject.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "게시물 DTO")
public class Article {
    @Schema(description = "순서")
    private Long id;
    @Schema(description = "게시물 제목")
    private String title;
    @Schema(description = "게시물 내용")
    private String content;
}
