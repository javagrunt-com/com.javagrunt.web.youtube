package com.javagrunt.web.views.videos;

import lombok.Data;

@Data
public class Video {
    private final String id;
    private final String link;
    private final String description;
    private final String title;
    private final String thumbnail;
    private final String date;
    private final long dateVal;
    private final String likes;
    private final String comments;
    private final String shares;
}
