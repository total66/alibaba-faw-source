package com.ebanma.cloud.usertestall.controller;

import com.ebanma.cloud.usertestall.domain.common.Result;
import com.ebanma.cloud.usertestall.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 * @author 于秦涛
 * @version $ Id: FileController, v 0.1 2023/03/29 10:11 98077 Exp $
 */
@RestController
@RequestMapping("/api/file")
public class FileController {

    @Resource(name = "localFileService")
    private FileService fileService;

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @RequestMapping("/upload")
    public Result<String> upload(@NotNull MultipartFile file) throws IOException {
        fileService.upload(file.getInputStream(),file.getOriginalFilename());
        return Result.success(file.getOriginalFilename());
    }

}

