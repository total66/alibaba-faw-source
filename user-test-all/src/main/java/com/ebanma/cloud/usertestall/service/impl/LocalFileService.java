package com.ebanma.cloud.usertestall.service.impl;

import com.ebanma.cloud.usertestall.controller.FileController;
import com.ebanma.cloud.usertestall.domain.common.ErrorCode;
import com.ebanma.cloud.usertestall.exception.BusinessException;
import com.ebanma.cloud.usertestall.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * @author 于秦涛
 * @version $ Id: LocalFileService, v 0.1 2023/03/29 10:16 98077 Exp $
 * todo:此处可以通过命名来确保controller层调用无问题
 */
@Service("localFileService")
public class LocalFileService implements FileService {

    private static final Logger logger = LoggerFactory.getLogger(LocalFileService.class);

    private static final String BUCKET = "uploads";

    @Override
    public void upload(InputStream inputStream, String filename) {

        //拼接文件上传路径
        String path = BUCKET + "/" + filename;

        //定义输入、输出流（TWR）
        try (
                InputStream innerInputStream = inputStream;
                FileOutputStream fileOutputStream = new FileOutputStream(new File(path))
        ) {
            //定义缓冲区
            byte[] buffer = new byte[1024];
            int length;

            while ((length = innerInputStream.read(buffer))>0){
                fileOutputStream.write(buffer, 0, length);
            }
            fileOutputStream.flush();
        } catch (Exception e) {
            logger.error("文件上传失败！", e);
            throw new BusinessException(ErrorCode.FILE_UPLOAD_FAILURE);
        }

    }

    @Override
    public void upload(File file) {
        try {
            upload(Files.newInputStream(file.toPath()), file.getName());
        } catch (IOException e) {
            logger.error("文件上传失败！", e);
            throw new BusinessException(ErrorCode.FILE_UPLOAD_FAILURE);
        }
    }
}

