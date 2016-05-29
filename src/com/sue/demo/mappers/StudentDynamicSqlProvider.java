package com.sue.demo.mappers;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.sue.demo.model.StudentModel;

public class StudentDynamicSqlProvider {
	
	public String insertStudentModel(final StudentModel studentModel){
		
		return new SQL(){
			{
				INSERT_INTO("t_student");
				if(studentModel.getName() != null){
					VALUES("name", "#{name}");
				}
				if(studentModel.getAge() != null){
					VALUES("age", "#{age}");
				}
			}
		}.toString();
	}
	
	public String updateStudentModel(final StudentModel studentModel){
		
		return new SQL(){
			{
				UPDATE("t_student");
				if(studentModel.getName() != null){
					SET("name=#{name}");
				}
				if(studentModel.getAge() !=null){
					SET("age=#{age}");
				}
				WHERE("id=#{id}");
			}
		}.toString();
	}

	public String deleteStudentModel(){
		
		return new SQL(){
			{
				DELETE_FROM("t_student");
				WHERE("id=#{id}");
			}
		}.toString();
	}
	
	public String getStudentModelById(){
		
		return new SQL(){
			{
				SELECT("*");
				FROM("t_student");
				WHERE("id=#{id}");
			}
		}.toString();
	}
	
	public String findStudentsByCondation(final Map<String, Object> param){

		return new SQL(){
			{
				SELECT("*");
				FROM("t_student");
				
				StringBuffer sb = new StringBuffer();
				if(param.get("name") != null){
					sb.append(" and name like '" + param.get("name") + "'");
				}
				if(param.get("age") != null){
					sb.append(" and age = " + param.get("age"));
				}
				WHERE(sb.toString().replaceFirst("and", ""));
			}
		}.toString();
	}
	
}
