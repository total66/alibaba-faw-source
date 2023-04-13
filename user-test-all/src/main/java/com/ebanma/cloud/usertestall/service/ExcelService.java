package com.ebanma.cloud.usertestall.service;

import com.ebanma.cloud.usertestall.domain.dto.UserQueryDTO;

/**
 * @author 于秦涛
 * @version $ Id: ExcelService, v 0.1 2023/03/29 10:44 98077 Exp $
 */
public interface ExcelService {

    void export(String filename, UserQueryDTO userQueryDTO);

    void asyncExport(String filename, UserQueryDTO userQueryDTO);

}
