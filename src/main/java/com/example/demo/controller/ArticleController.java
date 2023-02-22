package com.example.demo.controller;


import com.example.demo.dao.domain.Article;
import com.example.demo.dao.dto.ArticleDto;
import com.example.demo.exceptionsHandler.exceptions.ArticleNotFoundException;
import com.example.demo.service.serviceImpl.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    public ArticleController(ArticleService articleService){
        this.articleService = articleService ;
    }
    @PostMapping(value = "/save")
    public ArticleDto saveArticle(@RequestBody ArticleDto artcl) {
        return articleService.saveArticle(artcl);
    }

    @PutMapping(value = "/update/{id}")
    public ArticleDto updateArticle(@RequestBody ArticleDto artcl, @PathVariable Long id) {
        return articleService.updateArticle(artcl,id);
    }
    @DeleteMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        return articleService.deleteArticle(id);
    }
    @GetMapping(value="/getAll")
    public List<ArticleDto> findAll(){
        return articleService.findAllArticles();
    }
    @GetMapping(value="getAtricleByPage/{pageNo}/{pageSize}")
    public Page<Article> findAritclesByPage(@PathVariable Integer pageNo, @PathVariable Integer pageSize){
        return articleService.findAritclesByPage(pageNo,pageSize);
    }
    @GetMapping(value = "/{id}")
    public ArticleDto getArticle(@PathVariable("id") Long id) throws ArticleNotFoundException {
        return articleService.findOneByIdArticle(id) ;
    }
    @GetMapping(value = "/keyword/{keyword}")
    public List<ArticleDto> searchByKeywordArticle(@PathVariable String keyword){
        return articleService.searchByKeywordArticle(keyword);
    }

}

