/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lvbaoer.api.domain.ReciveAddress;

@Mapper
public interface ReciveAddressMapper {
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "ID")
	@Insert("INSERT INTO RECIVE_ADDRESS (USERID,NAME,PHONE,PROVINCE,CITY,AREA,DETAIL,CREATETIME) "
			+ "VALUES(#{userId},#{name},#{phone},#{province},#{city},#{area},#{detail},#{createTime})")
	void save(ReciveAddress reciveAddress);

	@Update("UPDATE RECIVE_ADDRESS SET NAME=#{name},PHONE=#{phone},PROVINCE=#{province},CITY=#{city},AREA=#{area},DETAIL=#{detail} WHERE ID=#{id}")
	int update(ReciveAddress reciveAddress);

	@Select("SELECT * FROM RECIVE_ADDRESS WHERE USERID=#{userId}")
	List<ReciveAddress> getAddrs(String userId);

	@Select("SELECT * FROM RECIVE_ADDRESS WHERE ID=#{id} LIMIT 1")
	ReciveAddress getAddrsById(int id);

	@Delete("DELETE FROM RECIVE_ADDRESS WHERE ID=#{id}")
	void delete(int id);
}
