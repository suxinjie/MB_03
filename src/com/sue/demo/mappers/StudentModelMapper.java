package com.sue.demo.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.sue.demo.model.StudentModel;


public interface StudentModelMapper {

	@InsertProvider(type=StudentDynamicSqlProvider.class, method="insertStudentModel")
	public int insertStudentModel(StudentModel studentModel);
	
	@UpdateProvider(type=StudentDynamicSqlProvider.class, method="updateStudentModel")
	public int updateStudentModel(StudentModel studentModel);
	
	@DeleteProvider(type=StudentDynamicSqlProvider.class, method="deleteStudentModel")
	public int deleteStudentModelById(int id);
	
	@SelectProvider(type=StudentDynamicSqlProvider.class, method="getStudentModelById")
	public StudentModel getStudentModelById(int id);
	
	@SelectProvider(type=StudentDynamicSqlProvider.class, method="findStudentsByCondation")
	public List<StudentModel> findStudentsByCondation(Map<String, Object> param);
}