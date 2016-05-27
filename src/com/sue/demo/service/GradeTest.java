package com.sue.demo.service;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sue.demo.mappers.GradeMapper;
import com.sue.demo.model.Grade;
import com.sue.demo.util.SqlSessionFactoryUtil;

public class GradeTest {
	
	private SqlSession sqlSession = null;
	private GradeMapper gm = null;

	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionFactoryUtil.openSession();
		gm = sqlSession.getMapper(GradeMapper.class);
	}

	@Test
	public void testfindById(){
		Grade grade = gm.findById(1);
		System.out.println(grade);
	}
	
	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}

}
