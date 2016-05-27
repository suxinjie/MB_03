package com.sue.demo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sue.demo.mappers.StudentMapper;
import com.sue.demo.model.Student;
import com.sue.demo.util.SqlSessionFactoryUtil;

public class StudentTest {

	private SqlSession sqlSession = null;
	private StudentMapper sm = null;

	@Before
	public void setUp() throws Exception {
		sqlSession = SqlSessionFactoryUtil.openSession();
		sm = sqlSession.getMapper(StudentMapper.class);
	}

	@Test
	public void testInsertStudent(){
		Student student = new Student("xiaoming", 20);
		sm.insertStudent(student);
		sqlSession.commit();
	}
	
	@Test
	public void testUpdateStudent(){
		Student student = new Student("xiaoming-up", 21);
		student.setId(4);
		sm.updateStudent(student);
		sqlSession.commit();
	}
	
	@Test
	public void testDeleteStudentById(){
		sm.deleteStudentById(4);
		sqlSession.commit();
	}
	
	@Test
	public void testGetStudentById(){
		Student student = sm.getStudentById(3);
		System.out.println(student);
	}
	
	@Test
	public void testFindStudents(){
		List<Student> students = sm.findStudents();
		for(Student s : students){
			System.out.println(s);
		}
	}
	
	@Test
	public void testSelectStudentWithAddress(){
		Student student = sm.selectStudentWithAddress(3);
		System.out.println(student);
	}
	
	@Test
	public void testSelectStudentWithAddressAndGrade(){
		Student student = sm.selectStudentWithAddressAndGrade(1);
		System.out.println(student);
	}
	
	@After
	public void tearDown() throws Exception {
		sqlSession.close();
	}

}
