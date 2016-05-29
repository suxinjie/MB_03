/**
 * 
 */
package com.sue.demo.model;

/**
 * @author sue
 * 
 */
public class StudentModel {

	private int id;
	private String name;
	private Integer age;

	public StudentModel() {
	}

	public StudentModel(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", name=" + name + ", age=" + age
				+ "]";
	}

}
