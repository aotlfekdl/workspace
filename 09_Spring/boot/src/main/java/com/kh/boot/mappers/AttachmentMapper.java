package com.kh.boot.mappers;

import com.kh.boot.domain.vo.Attachment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;

@Mapper
public interface AttachmentMapper {
    int selectAttachmentCount();

    ArrayList<Attachment> selectAttachmentList(RowBounds rowBounds);

    int insertAttachment(Attachment thumbnail);

    ArrayList<Attachment> selectAttachment(@Param("boardNo") int boardNo);
}
