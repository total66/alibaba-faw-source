package com.ebanma.cloud.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.ebanma.cloud.user.api.UserApi;
import com.ebanma.cloud.user.api.dto.UserInfoDTO;
import com.ebanma.cloud.user.api.result.ApiResult;
import com.ebanma.cloud.user.service.constant.MockDataConstant;

import java.util.List;

@Service(version = "${dubbo.provider.version}", application = "${dubbo.application.id}")
public class UserServiceImpl implements UserApi {
    @Override
    public ApiResult<UserInfoDTO> saveUser(UserInfoDTO userInfoDTO) {
        userInfoDTO.setId(MockDataConstant.userMockList.size() + 1L);
        MockDataConstant.userMockList.add(userInfoDTO);
        return ApiResult.success(userInfoDTO);
    }

    @Override
    public ApiResult<List> getUserLits() {
        return ApiResult.success(MockDataConstant.userMockList);
    }
}