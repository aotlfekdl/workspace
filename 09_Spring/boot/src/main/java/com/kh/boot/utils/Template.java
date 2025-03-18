package com.kh.boot.utils;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class Template {
    public static String saveFile(MultipartFile file, HttpSession session, String path) {
        //파일 원본명
        String originName = file.getOriginalFilename();

        //확장자
        String ext = originName.substring(originName.lastIndexOf("."));

        //년, 월, 일 시분초
        String currentTime = String.valueOf(System.currentTimeMillis());

        int random = (int) (Math.random() * 10000);

        //첨부파일의 이름이 같을 수 있기 때문에 저장할때 이름을 변경함
        String changeName = "kh_" + currentTime + random + ext;

        //첨부파일을 저장할 폴더의 물리적 경로
        String savePath = session.getServletContext().getRealPath(path);

        try {
            file.transferTo(new File(savePath + changeName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return changeName;


    }
}
