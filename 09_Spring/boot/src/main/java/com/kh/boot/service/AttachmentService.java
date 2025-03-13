package com.kh.boot.service;

import com.kh.boot.domain.vo.PageInfo;
import com.kh.boot.domain.vo.Attachment;

import java.util.ArrayList;

public interface AttachmentService {
    int selectAttachmentCount();

    ArrayList<Attachment> selectAttachmentList(PageInfo pi);

    int insertAttachment(Attachment thumbnail);


}
