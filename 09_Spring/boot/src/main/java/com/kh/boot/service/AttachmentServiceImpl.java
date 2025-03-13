package com.kh.boot.service;


import com.kh.boot.domain.vo.PageInfo;
import com.kh.boot.domain.vo.Attachment;
import com.kh.boot.mappers.ThumbnailMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor //이게 Autowired 역할을 해줌
@Service
public class ThumbnailServiceImpl implements ThumbnailService {

    private final ThumbnailMapper thumbnailMapper;
    @Override
    public int selectThumbnailCount() {
        return thumbnailMapper.selectThumbnailCount();
    }

    @Override
    public ArrayList<Attachment> selectThumbnailList(PageInfo pi) {
        int offset = (pi.getCurrentPage() - 1)*pi.getBoardLimit();
        RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());

        return thumbnailMapper.selectThumbnailList(rowBounds);
    }

    @Override
    public int insertThumbnail(Attachment thumbnail) {
        return thumbnailMapper.insertThumbnail(thumbnail);
    }


}
