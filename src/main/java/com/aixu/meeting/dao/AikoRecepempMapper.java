package com.aixu.meeting.dao;

import com.aixu.meeting.domain.AikoRecepemp;
import com.aixu.meeting.domain.AikoRecepempExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AikoRecepempMapper {
    int countByExample(AikoRecepempExample example);

    int deleteByExample(AikoRecepempExample example);

    int deleteByPrimaryKey(String rempId);

    int insert(AikoRecepemp record);

    int insertSelective(AikoRecepemp record);

    List<AikoRecepemp> selectByExample(AikoRecepempExample example);

    AikoRecepemp selectByPrimaryKey(String rempId);

    int updateByExampleSelective(@Param("record") AikoRecepemp record, @Param("example") AikoRecepempExample example);

    int updateByExample(@Param("record") AikoRecepemp record, @Param("example") AikoRecepempExample example);

    int updateByPrimaryKeySelective(AikoRecepemp record);

    int updateByPrimaryKey(AikoRecepemp record);
}