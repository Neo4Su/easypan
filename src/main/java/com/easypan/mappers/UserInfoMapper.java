package com.easypan.mappers;

import org.apache.ibatis.annotations.Param;

/**
 * 用户信息 数据库操作接口
 */
public interface UserInfoMapper<T,P> extends BaseMapper<T,P> {


	Integer updateUserSpace(@Param("userId") String userId, @Param("useSpace") Long useSpace,
							@Param("totalSpace") Long totalSpace);


	/**
	 * 根据UserId更新
	 */
	 Integer updateByUserId(@Param("bean") T t,@Param("userId") String userId);


	/**
	 * 根据UserId删除
	 */
	 Integer deleteByUserId(@Param("userId") String userId);


	/**
	 * 根据UserId获取对象
	 */
	 T selectByUserId(@Param("userId") String userId);


	/**
	 * 根据Email更新
	 */
	 Integer updateByEmail(@Param("bean") T t,@Param("email") String email);


	/**
	 * 根据Email删除
	 */
	 Integer deleteByEmail(@Param("email") String email);


	/**
	 * 根据Email获取对象
	 */
	 T selectByEmail(@Param("email") String email);


	/**
	 * 根据Nickname更新
	 */
	 Integer updateByNickname(@Param("bean") T t,@Param("nickname") String nickname);


	/**
	 * 根据Nickname删除
	 */
	 Integer deleteByNickname(@Param("nickname") String nickname);


	/**
	 * 根据Nickname获取对象
	 */
	 T selectByNickname(@Param("nickname") String nickname);


	/**
	 * 根据QqOpenId更新
	 */
	 Integer updateByQqOpenId(@Param("bean") T t,@Param("qqOpenId") String qqOpenId);


	/**
	 * 根据QqOpenId删除
	 */
	 Integer deleteByQqOpenId(@Param("qqOpenId") String qqOpenId);


	/**
	 * 根据QqOpenId获取对象
	 */
	 T selectByQqOpenId(@Param("qqOpenId") String qqOpenId);


}
