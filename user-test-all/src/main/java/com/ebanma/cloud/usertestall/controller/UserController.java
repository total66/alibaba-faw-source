package com.ebanma.cloud.usertestall.controller;

import com.ebanma.cloud.usertestall.domain.common.ErrorCode;
import com.ebanma.cloud.usertestall.domain.common.PageQuery;
import com.ebanma.cloud.usertestall.domain.common.PageResult;
import com.ebanma.cloud.usertestall.domain.common.Result;
import com.ebanma.cloud.usertestall.domain.dto.UserDTO;
import com.ebanma.cloud.usertestall.domain.dto.UserQueryDTO;
import com.ebanma.cloud.usertestall.domain.vo.UserVO;
import com.ebanma.cloud.usertestall.service.ExcelService;
import com.ebanma.cloud.usertestall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 于秦涛
 * @version $ Id: UserController, v 0.1 2023/03/15 14:49 98077 Exp $
 */
@RestController
@RequestMapping("/api/user")
@Validated
public class UserController {

    public UserController(UserService userService, ExcelService excelService) {
        this.userService = userService;
        this.excelService = excelService;
    }

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ExcelService excelService;

    /**
     * POST /api/user
     *  新增用户
     *  新增用户时使用cacheEvict清除缓存
     */
    @CacheEvict(cacheNames = "user-cache", allEntries = true)
    @PostMapping
    public Result save(@RequestBody UserDTO userDTO) {

        int save = userService.save(userDTO);

        if (save == 1) {
            return Result.success();
        } else {
            return Result.fail(ErrorCode.SYSTEM_ERROR);
        }

    }

    /**
     * PUT /api/user/{id}
     * 更新用户信息
     */
    @PutMapping("/{id}")
    public Result update(@NotNull @PathVariable("id") Long id, @RequestBody UserDTO userDTO) {

        int update = userService.update(id, userDTO);

        if (update == 1) {
            return Result.success();
        } else {
            return Result.fail(ErrorCode.SYSTEM_ERROR);
        }

    }

    /**
     * DELETE /api/user/{id}     * 删除用户信息
     */
    @DeleteMapping("/{id}")
    public Result delete(@NotNull @PathVariable("id") Long id) {

        int delete = userService.delete(id);

        if (delete == 1) {
            return Result.success();
        } else {
            return Result.fail(ErrorCode.SYSTEM_ERROR);
        }

    }

    /**
     * GET
     * 查询用户信息
     * 使用cacheable注解开启缓存。
     */
    @Cacheable(cacheNames = "user-cache" , key = "#pageNo")
    @GetMapping
    public Result<PageResult> query(Integer pageNo, Integer pageSize, UserQueryDTO queryDTO) {
        if (logger.isInfoEnabled()) {
            logger.info("未使用缓存！");
        }
        // 构造查询条件
        PageQuery<UserQueryDTO> pageQuery = new PageQuery<>();
        pageQuery.setPageNo(pageNo);
        pageQuery.setPageSize(pageSize);
        pageQuery.setQuery(queryDTO);

        // 查询
        PageResult<List<UserDTO>> pageResult =
                userService.query(pageQuery);

        // 实体转换
        List<UserVO> userVOList = Optional
                .ofNullable(pageResult.getData())
                .map(List::stream)
                .orElseGet(Stream::empty)
                .map(userDTO -> {
                    UserVO userVO = new UserVO();
                    BeanUtils.copyProperties(userDTO, userVO);
                    // 对特殊字段做处理
                    userVO.setPassword("******");
                    return userVO;
                })
                .collect(Collectors.toList());

        // 封装返回结果
        PageResult<List<UserVO>> result = new PageResult<>();
        BeanUtils.copyProperties(pageResult, result);
        result.setData(userVOList);

        return Result.success(result);
    }

    @GetMapping("/export")
    public Result<Boolean> export(@NotEmpty String filename, UserQueryDTO queryDTO){
        excelService.export(filename, queryDTO);

        return Result.success(Boolean.TRUE);
    }

}

