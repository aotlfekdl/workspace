package com.kh.boot.domain.vo;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Thumbnail {
    private int thumbnailNo;
    private String boardWriter;
    private String thumbnailTitle;
    private String thumbnailContent;
    private int refBno;
    private String originName;
    private String changeName;
    private int count;
    private String filePath;
    private String uploadDate;
    private String createDate;
    private int fileLevel;
    private String status;


}
