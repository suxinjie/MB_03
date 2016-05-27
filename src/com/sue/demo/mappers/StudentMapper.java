package com.sue.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sue.demo.model.Student;


public interface StudentMapper {

	@Insert("insert into t_student(name,age) values(#{name}, #{age})")
	public int insertStudent(Student student);
	
	@Update("update t_student set name=#{name}, age=#{age} where id=#{id}")
	public int updateStudent(Student student);
	
	@Delete("delete from t_student where id=#{id}")
	public int deleteStudentById(int id);
	
	@Select("select * from t_student where id=#{id}")
	public Student getStudentById(int id);

	@Select("select * from t_student")
	@Results
	(
		{
			@Result(id=true, column="id", property="id"),
			@Result(column="name", property="name"),
			@Result(column="age", property="age"),
		}
	)
	public List<Student> findStudents();
	
	@Select("select * from t_student where id=#{id}")
	@Results
	(
		{
			@Result(id=true, column="id", property="id"),
			@Result(column="name", property="name"),
			@Result(column="age", property="age"),
			@Result(column="addressId", property="address", one=@One(select="com.sue.demo.mappers.AddressMapper.findByid"))
		}
	)
	public Student selectStudentWithAddress(int id);
	
	@Select("select * from t_student where gradeId=#{id}")
	@Results
	(
		{
			@Result(id=true, column="id", property="id"),
			@Result(column="name", property="name"),
			@Result(column="age", property="age"),
			@Result(column="addressId", property="address", one=@One(select="com.sue.demo.mappers.AddressMapper.findByid"))
		}
	)
	public Student selectStudentByGradeId(int id);
	
	@Select("select * from t_student where id=#{id}")
	@Results
	(
		{
			@Result(id=true, column="id", property="id"),
			@Result(column="name", property="name"),
			@Result(column="age", property="age"),
			@Result(column="addressId", property="address", one=@One(select="com.sue.demo.mappers.AddressMapper.findByid")),
			@Result(column="gradeId", property="grade", one=@One(select="com.sue.demo.mappers.GradeMapper.findById"))

		}
	)
	public Student selectStudentWithAddressAndGrade(int id);
	
}