package com.ebanma.cloud.unittest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

@Service
public class UserService {
    /** 服务相关 */
    /** 用户DAO */
    @Autowired
    private UserDAO userDAO;
    /** 标识生成器 */
    @Autowired
    private IdGenerator idGenerator;

    /** 参数相关 */
    /** 可以修改 */
    @Value("${userService.canModify}")
    private Boolean canModify;

    /**
     * 保存用户
     * 
     * @param userSave 用户保存
     * @return 用户标识
     */
    public Long saveUser(UserVO userSave) {
        // 获取用户标识
        Long userId = userDAO.getIdByName(userSave.getName());

        // 根据存在处理
        // 根据存在处理: 不存在则创建
        if (Objects.isNull(userId)) {
            userId = idGenerator.next();
            UserDO userCreateDO = new UserDO();
            userCreateDO.setId(userId);
            userCreateDO.setName(userSave.getName());
            userDAO.create(userCreateDO);
        }
        // 根据存在处理: 已存在可修改
        else if (Boolean.TRUE.equals(canModify)) {
            UserDO userModifyDO = new UserDO();
            userModifyDO.setId(userId);
            userModifyDO.setName(userSave.getName());
            userDAO.modify(userModifyDO);
        }
        // 根据存在处理: 已存在禁修改
        else {
            throw new UnsupportedOperationException("不支持修改");
        }

        // 返回用户标识
        return userId;
    }
}