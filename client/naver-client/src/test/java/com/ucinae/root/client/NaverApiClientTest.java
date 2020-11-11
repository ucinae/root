package com.ucinae.root.client;

import com.ucinae.root.CommonTest;
import com.ucinae.root.dto.req.NaverBlogRequest;
import com.ucinae.root.dto.res.NaverBlogResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class NaverApiClientTest extends CommonTest {

    @Autowired
    private NaverApiClient naverApiClient;

    @Test
    public void getBlogTest() {
        NaverBlogRequest naverBlogRequest = NaverBlogRequest.builder()
                .query("naver")
                .build();

        NaverBlogResponse naverBlog = naverApiClient.getNaverBlog(naverBlogRequest);

        log.info("naverBlog response = {}", naverBlog);
    }

}