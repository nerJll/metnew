package com.aixu.meeting.dao;

import com.aixu.meeting.domain.AixuAudioinfo;
import com.aixu.meeting.domain.AixuAudioinfoExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AixuAudioinfoMapper {
    int countByExample(AixuAudioinfoExample example);

    int deleteByExample(AixuAudioinfoExample example);

    int deleteByPrimaryKey(String auId);

    int insert(AixuAudioinfo record);

    int insertSelective(AixuAudioinfo record);

    List<AixuAudioinfo> selectByExample(AixuAudioinfoExample example);

    AixuAudioinfo selectByPrimaryKey(String auId);

    int updateByExampleSelective(@Param("record") AixuAudioinfo record, @Param("example") AixuAudioinfoExample example);

    int updateByExample(@Param("record") AixuAudioinfo record, @Param("example") AixuAudioinfoExample example);

    int updateByPrimaryKeySelective(AixuAudioinfo record);

    int updateByPrimaryKey(AixuAudioinfo record);
}