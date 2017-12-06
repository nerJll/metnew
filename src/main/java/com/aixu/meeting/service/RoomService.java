package com.aixu.meeting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aixu.meeting.dao.AixuAudioinfoMapper;
import com.aixu.meeting.dao.AixuMeetingroomMapper;
import com.aixu.meeting.domain.AixuAudioinfo;
import com.aixu.meeting.domain.AixuAudioinfoExample;
import com.aixu.meeting.domain.AixuMeetingroom;
import com.aixu.meeting.domain.AixuMeetingroomExample;
import com.aixu.meeting.utils.IDUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author RenBowen
 * @date 2017/10/26 9:52:36
 * @since 1.0.0
 * @meeting
 */
@Service
public class RoomService {
	
	@Autowired
	private AixuMeetingroomMapper roomDAO;
	
	@Autowired
	private AixuAudioinfoMapper aaiDao;
	
	/**
	 * 根据Id查询会议室
	 * @param id 会议室Id
	 * @return 会议室Obj
	 */
	public AixuMeetingroom getRoomById(String id) {
		return roomDAO.selectByPrimaryKey(id);
	}
	
	/**
	 * 条件查询会议室
	 * @param example 查询条件
	 * @return 会议室list集合
	 */
	public List<AixuMeetingroom> listRoom(AixuMeetingroomExample example) {
		return roomDAO.selectByExample(example);
	}
	
	/**
	 * 添加会议室
	 * @param room 会议室Obj
	 */
	@Transactional
	public void saveRoom(AixuMeetingroom room) {
		String id = IDUtils.getUuid(true);
		room.setMeetRoomId(id);
		room.setMeetRoomState("空闲");
		roomDAO.insertSelective(room);
	}
	
	/**
	 * 条件更新会议室
	 * @param room 会议室Obj
	 */
	@Transactional
	public void updateRoom(AixuMeetingroom room) {
		roomDAO.updateByPrimaryKeySelective(room);
	}
	
	/**
	 * 删除会议室
	 * @param id 会议室Id
	 */
	@Transactional
	public void deleteRoom(String id) {
		roomDAO.deleteByPrimaryKey(id);
	}

	/**
	 * @desc 返回视频号及视频会议室信息
	 * @param type
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageInfo<?> getRoomAndSp(String type, int currentPage, int pageSize) {
		PageHelper.startPage(currentPage,pageSize);
		if(type.equals("端口")) {
			AixuMeetingroomExample exp = new AixuMeetingroomExample();
			exp.setOrderByClause("MEET_ROOM_NAME ASC");
			exp.createCriteria().andMeetRoomNameLike("%"+"00"+"%");
			List<AixuMeetingroom> rooms = listRoom(exp);
			return new PageInfo<AixuMeetingroom>(rooms);
		}else {
			AixuAudioinfoExample exp = new AixuAudioinfoExample();
			exp.setOrderByClause("AU_ACCOUNT ASC");
			List<AixuAudioinfo> aads = aaiDao.selectByExample(exp);
			return new PageInfo<AixuAudioinfo>(aads);
		}
	}

	/**
	 * @desc 更新视频号或端口的密码
	 * @param type
	 * @param account
	 * @param password
	 */
	public void updateRas(String type, String account, String password) {
		if(type.equals("端口")) {
			AixuMeetingroomExample exp = new AixuMeetingroomExample();
			exp.createCriteria().andMeetRoomNameEqualTo(account);
			AixuMeetingroom meetRoom = roomDAO.selectByExample(exp).get(0);
			meetRoom.setResOne(password);
			roomDAO.updateByExampleSelective(meetRoom, exp);
		}else if(type.equals("视频号")){
			AixuAudioinfoExample exp = new AixuAudioinfoExample();
			exp.createCriteria().andAuAccountEqualTo(account);
			AixuAudioinfo aai = aaiDao.selectByExample(exp).get(0);
			String[] pas = password.split(",");
			aai.setAuPassword(pas[0]);
			aai.setAuResone(pas[1]);
			aaiDao.updateByExampleSelective(aai, exp);
		}
	}
	
}
