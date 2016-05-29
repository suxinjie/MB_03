package com.sue.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sue.demo.mappers.StudentModelMapper;
import com.sue.demo.model.StudentModel;
import com.sue.demo.util.SqlSessionFactoryUtil;

public class StudentModelTest {

	private SqlSession sqlSession = null;
	private StudentModelMapper sm = null;

	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionFactoryUtil.openSession();
		sm = sqlSession.getMapper(StudentModelMapper.class);
	}

	@Test
	public void testInsertStudentModel(){
		StudentModel studentModel = new StudentModel("insert", 18);
		sm.insertStudentModel(studentModel);
		sqlSession.commit();
	}
	
	@Test
	public void testUpdateStudent(){
		StudentModel studentModel = new StudentModel("insert-update", 20);
		studentModel.setId(5);
		sm.updateStudentModel(studentModel);
		sqlSession.commit();
	}
	
	@Test
	public void testDeleteStudentById(){
		sm.deleteStudentModelById(5);
		sqlSession.commit();
	}
	
	@Test
	public void testGetStudentById(){
		StudentModel studentModel = sm.getStudentModelById(1);
		System.out.println(studentModel);
	}
	
	@Test
	public void findStudentsByCondation(){
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("name", "%zhang%");
		param.put("age", 10);
		List<StudentModel> studentModels = sm.findStudentsByCondation(param);
		System.out.println(studentModels);
	}
	
	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}

}
