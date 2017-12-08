package com.aixu.meeting.dao;

import com.aixu.meeting.domain.AikoLongapproom;
import com.aixu.meeting.domain.AikoLongapproomExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AikoLongapproomMapper {
    int countByExample(AikoLongapproomExample example);

    int deleteByExample(AikoLongapproomExample example);

    int deleteByPrimaryKey(String lpId);

    int insert(AikoLongapproom record);

    int insertSelective(AikoLongapproom record);

    List<AikoLongapproom> selectByExampleWithBLOBs(AikoLongapproomExample example);

    List<AikoLongapproom> selectByExample(AikoLongapproomExample example);

    AikoLongapproom selectByPrimaryKey(String lpId);

    int updateByExampleSelective(@Param("record") AikoLongapproom record, @Param("example") AikoLongapproomExample example);

    int updateByExampleWithBLOBs(@Param("record") AikoLongapproom record, @Param("example") AikoLongapproomExample example);

    int updateByExample(@Param("record") AikoLongapproom record, @Param("example") AikoLongapproomExample example);

    int updateByPrimaryKeySelective(AikoLongapproom record);

    int updateByPrimaryKeyWithBLOBs(AikoLongapproom record);

    int updateByPrimaryKey(AikoLongapproom record);
}