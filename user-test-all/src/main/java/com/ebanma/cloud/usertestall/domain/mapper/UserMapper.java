package com.ebanma.cloud.usertestall.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ebanma.cloud.usertestall.domain.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 于秦涛
 * @version $ Id: UserMapper, v 0.1 2023/03/15 15:26 98077 Exp $
 */

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
