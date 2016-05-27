package com.sue.demo.mappers;

import org.apache.ibatis.annotations.Select;

import com.sue.demo.model.Address;


public interface AddressMapper {
	
	@Select("select * from t_address where id=#{id}")
	public Address findByid(int id);

}
