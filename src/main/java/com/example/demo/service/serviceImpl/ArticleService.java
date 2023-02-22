
package com.example.demo.service.serviceImpl;

        import com.example.demo.dao.domain.Article;
        import com.example.demo.dao.mapper.CommentaireMapper;

        import com.example.demo.dao.dto.ArticleDto;
        import com.example.demo.dao.repository.ArticleRepository;
        import com.example.demo.dao.mapper.ArticleMapper;


        import com.example.demo.exceptionsHandler.exceptions.ArticleNotFoundException;
        import com.example.demo.service.serviceInterfaces.IArticleService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.PageRequest;
        import org.springframework.data.domain.Pageable;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;
        import java.util.stream.Collectors;

@Service
public class ArticleService implements IArticleService {

    @Autowired
    ArticleRepository articleRepository ;
    @Autowired

    ArticleMapper articleMapper ;
    @Autowired
    CommentaireService commentaireService ;
    @Autowired
    CommentaireMapper commentaireMapper ;

    @Override
    public ArticleDto saveArticle(ArticleDto art) {
        Article articleSaved = articleMapper.articleDTOToArticle(art);
        return articleMapper.articleToArticleDTO(articleRepository.save(articleSaved));
    }

    @Override
    public ArticleDto updateArticle(ArticleDto artDto , Long id) {
        Article art = articleMapper.articleDTOToArticle(artDto);
        art.setArticleId(id);
        return articleMapper.articleToArticleDTO(art);
    }

    @Override
    public String deleteArticle(Long id) {
        articleRepository.deleteById(id);
        return "Article deleted !";
    }

    @Override
    public List<ArticleDto> findAllArticles() {
        return articleMapper.mapToArticles(articleRepository.findAll());
    }
    @Override
    public Page<Article> findAritclesByPage(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Article> page = articleRepository.findAll(pageable);
        return   page ; }

    @Override
    public ArticleDto findOneByIdArticle(long id)throws ArticleNotFoundException{
        ArticleDto opt = Optional.of(articleMapper.articleToArticleDTO(articleRepository.findById(id).orElseThrow(()->new ArticleNotFoundException(id)))).get();
        return opt;
    }
    @Override
    public List<ArticleDto> searchByKeywordArticle(String keyword) {
        return articleRepository.searchByKeyword(keyword)
                .stream()
                .map(article -> articleMapper.articleToArticleDTO(article))
                .collect(Collectors.toList());
    }
}
