package com.backy.mybatis.prj;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MainClass {

	public static void main(String[] args) {
		try {
			String resource = "com/backy/mybatis/prj/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			SqlSession session = sqlSessionFactory.openSession(true);
			System.out.println(session);
			MapperInterface mapper = session.getMapper(MapperInterface.class);
			MemberVO mvo = mapper.selectOne(00003);
			
			System.out.println(mvo);
			
//			mvo.setId(00003);
//			mvo.setName("하랄라");
//			mvo.setAddress("수원 어딘가");
//			mvo.setPhone("010-5555-7777");
//			int result = mapper.updateMember(mvo);
//			System.out.println("insert결과 :" + result );
			
			List<MemberVO> list = mapper.selectAll();
			//for(MemberVO member:list)
			System.out.println("selectAll결과 :" + list );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
