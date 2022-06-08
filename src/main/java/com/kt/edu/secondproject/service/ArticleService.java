package com.kt.edu.secondproject.service;

import com.kt.edu.secondproject.domain.Article;
import com.kt.edu.secondproject.repository.ArticleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class ArticleService {

    @Autowired
    private  ArticleMapper articleMapper;

    public Article create(Article article) {
        log.info("Request to create Article : " +  article);
        articleMapper.insert(article);
        return article;
    }

    public List<Article> findAll() {
        log.info("Request to get all Articles");
        //return this.articleMapper.findAll();
        return articleMapper.findAll()
         .stream()
         .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Article findById(Long id) {
        log.debug("Request to get Article : {}", id);
        return articleMapper.findById(id).get();
    }

    /*
    public List<Article> findAllActive() {
        log.debug("Request to get all Articles");
        return this.articleMapper.findAllByEnabled(true);
    }

    public List<Article> findAllInactive() {
        log.debug("Request to get all Articles");
        return this.articleMapper.findAllByEnabled(false);
    }*/

    /*public void delete(Long id) {
        log.debug("Request to delete article : {}", id);

        Article article = this.articleMapper.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find Article with id " + id));

        article.setEnabled(false);
        this.articleMapper.update(article);
    }*/
}
