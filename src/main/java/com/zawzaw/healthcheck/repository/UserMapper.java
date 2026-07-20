package com.zawzaw.healthcheck.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zawzaw.healthcheck.model.Muser;
@Mapper
public interface UserMapper {
	/* ユーザー取得 */
	Muser findUserById(@Param("userId") String userId);
	
	/* ユーザー登録 */
	int insertUser(Muser user);
	
}
