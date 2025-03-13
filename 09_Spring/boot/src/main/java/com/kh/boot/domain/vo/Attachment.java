package com.kh.boot.domain.vo;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Attachment {
    private int fileNo;
    private int refBno;
    private String fileTitle;
    private String originName;
    private String changeName;
    private String filePath;
    private String uploadPath;
    private int fileLevel;
    private String status;

}
