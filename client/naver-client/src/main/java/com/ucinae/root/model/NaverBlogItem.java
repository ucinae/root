package com.ucinae.root.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NaverBlogItem {
    private String title;
    private String link;
    private String description;
    private String blogername;
    private String bloggerlink;
}
