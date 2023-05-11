package com.ebanma.cloud.user.api;

import com.ebanma.cloud.user.api.dto.UserInfoDTO;
import com.ebanma.cloud.user.api.result.ApiResult;

import java.util.List;

public interface UserApi {
    /**
     * 添加人员
     * @param userInfoDTO
     * @return
     */
    ApiResult<UserInfoDTO> saveUser(UserInfoDTO userInfoDTO);

    /**
     * 获取人员列表
     *
     * @return
     */
    ApiResult<List> getUserLits();
}
