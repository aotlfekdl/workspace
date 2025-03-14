package com.kh.boot.service;


import com.kh.boot.domain.vo.PageInfo;
import com.kh.boot.domain.vo.Attachment;
import com.kh.boot.mappers.AttachmentMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor //이게 Autowired 역할을 해줌
@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentMapper attachmentMapper;
    @Override
    public int selectAttachmentCount() {
        return attachmentMapper.selectAttachmentCount();
    }

    @Override
    public ArrayList<Attachment> selectAttachmentList(PageInfo pi) {
        int offset = (pi.getCurrentPage() - 1)*pi.getBoardLimit();
        RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());

        return attachmentMapper.selectAttachmentList(rowBounds);
    }

    @Override
    public int insertAttachment(Attachment thumbnail) {
        return attachmentMapper.insertAttachment(thumbnail);
    }

    @Override
    public ArrayList<Attachment> selectAttachment(int boardNo) {
        return attachmentMapper.selectAttachment(boardNo);
    }


}
