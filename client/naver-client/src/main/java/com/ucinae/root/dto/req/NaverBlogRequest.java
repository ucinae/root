package com.ucinae.root.dto.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.util.UriComponentsBuilder;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NaverBlogRequest {
    private String query;
    private Integer display;
    private Integer start;
    private String sort; // ["sim", "date"]

    public String toUriString(String path) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromPath(path);

        if (ObjectUtils.isNotEmpty(path)) {
            builder.queryParam("query", query);
        }
        if (ObjectUtils.isNotEmpty(display)) {
            builder.queryParam("display", display);
        }
        if (ObjectUtils.isNotEmpty(start)) {
            builder.queryParam("start", start);
        }
        if (ObjectUtils.isNotEmpty(sort)) {
            builder.queryParam("sort", sort);
        }

        return builder.toUriString();
    }
}
