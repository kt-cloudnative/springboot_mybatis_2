package com.kt.edu.secondproject.controller;


import com.kt.edu.secondproject.domain.Article;
import com.kt.edu.secondproject.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "posts", description = "게시물 API")
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    @Operation(summary ="게시물 전체 조회",description="제목과 내용 전체를 조회 합니다.")
    public List<Article> findAll() {
        return this.articleService.findAll();
    }

    //@ApiResponses(value = {
    //        @ApiResponse(responseCode = "200", description = "게시글 조회 성공", content = @Content(schema = @Schema(implementation = Article.class))),
    //        @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근", content = @Content(schema = @Schema(implementation = ErrorResponse.class))) })
    @Operation(summary ="게시물 단건 조회",description="특정 게시물 단건에 대해서 제목과 내용을 조회 합니다.")
    @GetMapping("/{id}")
    public Article findById(@PathVariable Long id) {
        return articleService.findById(id);
    }

   /* @GetMapping("/active")
    public List<Article> findAllActive() {
        return this.articleService.findAllActive();
    }

    @GetMapping("/inactive")
    public List<Article> findAllInactive() {
        return this.articleService.findAllInactive();
    }*/

    @PostMapping
    @Operation(summary ="게시물 등록",description="게시물을 등록합니다.")
    public Article create(@RequestBody Article article) {
        return this.articleService.create(article);
    }

    /*@DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.articleService.delete(id);
    }*/
}