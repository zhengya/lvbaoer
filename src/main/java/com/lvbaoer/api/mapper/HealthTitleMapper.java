/**
 * Copyright (C) 2016 MPen, Inc. All Rights Reserved.
 */
package com.lvbaoer.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.EnumTypeHandler;

import com.lvbaoer.api.bean.TitleResult;
import com.lvbaoer.api.domain.HealthTitle;

@Mapper
public interface HealthTitleMapper {
	@Result(column = "TYPE", property = "type", typeHandler = EnumTypeHandler.class)
	@Select("SELECT ID,TITLE,IMAGE,TYPE,BROWERNUM,COMMENTNUM,CREATETIME FROM HEALTH_TITLE WHERE ISBANNER=1 ORDER BY CREATETIME")
	List<TitleResult> getBanner();

	@Result(column = "TYPE", property = "type", typeHandler = EnumTypeHandler.class)
	@Select("SELECT ID,TITLE,IMAGE,TYPE,BROWERNUM,COMMENTNUM,CREATETIME FROM HEALTH_TITLE WHERE ISBANNER=0  ORDER BY CREATETIME LIMIT #{index},#{size}")
	List<TitleResult> get(@Param("index") int index, @Param("size") int size);

	@Result(column = "TYPE", property = "type", typeHandler = EnumTypeHandler.class)
	@Select("SELECT * FROM HEALTH_TITLE WHERE ID=#{id} LIMIT 1")
	HealthTitle getById(int id);

	@Result(column = "TYPE", property = "type", typeHandler = EnumTypeHandler.class)
	@Update("UPDATE HEALTH_TITLE SET BROWERNUM=#{browerNum},COMMENTNUM=#{commentNum} WHERE ID=#{id}")
	void update(HealthTitle healthTitle);

	@Result(column = "TYPE", property = "type", typeHandler = EnumTypeHandler.class)
	@Select("SELECT DISTINCT T.ID,T.TITLE,T.IMAGE,T.TYPE,T.BROWERNUM,T.COMMENTNUM,T.CREATETIME FROM HEALTH_TITLE T JOIN COMMENT C ON C.USERID=#{id} AND C.TITLEID=T.ID ORDER BY T.CREATETIME")
	List<TitleResult> getByUserId(String id);
}
