/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.lvbaoer.api.bean.CommentResult;
import com.lvbaoer.api.domain.Comment;

@Mapper
public interface CommentMapper {
	@Select("SELECT C.ID,C.CONTENT,C.CREATETIME,U.NAME,U.IMAGE FROM COMMENT C JOIN USER U ON U.ID=C.USERID WHERE C.TITLEID=#{id}  ORDER BY C.CREATETIME LIMIT #{index},#{size}")
	List<CommentResult> get(@Param("index") int index, @Param("size") int size, @Param("id") int id);

	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "ID")
	@Insert("INSERT INTO COMMENT (USERID,TITLEID,CONTENT,CREATETIME) VALUES (#{userId},#{titleId},#{content},#{createTime})")
	void insert(Comment comment);
}
