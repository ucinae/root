package com.ucinae.root.dto.res;

import com.ucinae.root.model.NaverBlogItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NaverBlogResponse {
    private Date lastBuildDate;
    private Date postdate;
    private Integer total;
    private Integer start;
    private Integer display;
    private NaverBlogItem item;
    private List<NaverBlogItem> items;
}
