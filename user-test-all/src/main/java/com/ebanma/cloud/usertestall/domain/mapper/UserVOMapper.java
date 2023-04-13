package com.ebanma.cloud.usertestall.domain.mapper;

import com.ebanma.cloud.usertestall.domain.vo.UserVO;
import com.ebanma.cloud.usertestall.domain.vo.UserVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserVOMapper {
    long countByExample(UserVOExample example);

    int deleteByExample(UserVOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserVO record);

    int insertSelective(UserVO record);

    List<UserVO> selectByExample(UserVOExample example);

    UserVO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserVO record, @Param("example") UserVOExample example);

    int updateByExample(@Param("record") UserVO record, @Param("example") UserVOExample example);

    int updateByPrimaryKeySelective(UserVO record);

    int updateByPrimaryKey(UserVO record);
}