package com.kh.boot.mappers;

import com.kh.boot.domain.vo.Attachment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;

@Mapper
public interface ThumbnailMapper {
    int selectThumbnailCount();

    ArrayList<Attachment> selectThumbnailList(RowBounds rowBounds);

    int insertThumbnail(Attachment thumbnail);
}
