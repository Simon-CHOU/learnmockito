package com.simon.springbootmocktest.zimug;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("/save/{content}")
    public String saveArticle(@PathVariable(name="content") String content){
        return articleService.saveArticle(content);
    }

    @PostMapping("/foo")
    public String foo(@RequestBody FooReqDTO reqDto){
        return articleService.saveArticle(reqDto.getContent());
    }
}
