package com.backy.mybatis.prj;

import java.util.List;

public interface MapperInterface {

	public MemberVO selectOne(int id);
	public int insertMember(MemberVO mvo);
	public int deleteMember(int id);
	public int updateMember(MemberVO mvo);
	public List<MemberVO> selectAll();
}
