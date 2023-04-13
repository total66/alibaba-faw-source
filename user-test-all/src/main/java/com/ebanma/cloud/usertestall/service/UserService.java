package com.ebanma.cloud.usertestall.service;  
  
import java.util.List;  
  
import com.ebanma.cloud.usertestall.domain.common.PageQuery;  
import com.ebanma.cloud.usertestall.domain.common.PageResult;  
import com.ebanma.cloud.usertestall.domain.dto.UserDTO;  
import com.ebanma.cloud.usertestall.domain.dto.UserQueryDTO;  
  
public interface UserService {  
  
    /**  
     * 新增  
     * @param userDTO  
     * @return  
     */  
    int save(UserDTO userDTO);  
  
    /**  
     * 更新  
     * @param id  
     * @param userDTO  
     * @return  
     */  
    int update(Long id, UserDTO userDTO);  
  
    /**  
     * 删除  
     * @param id  
     * @return  
     */  
    int delete(Long id);  
  
    /**  
     * 分页查询  
     * @param pageQuery  
     * @return  
     */  
    PageResult<List<UserDTO>> query(PageQuery<UserQueryDTO> pageQuery);  
}