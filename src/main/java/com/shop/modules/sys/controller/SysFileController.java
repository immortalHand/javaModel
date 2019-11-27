package com.shop.modules.sys.controller;

import com.alibaba.fastjson.JSON;
import com.shop.common.utils.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * @Desc 文件操作接口 crossOrigin 解决前后端分离跨域问题
 * @Author sinosoft-an
 * @Date 2019/2/24 13:37
 */
@RestController
@RequestMapping("/upload")
@CrossOrigin
public class SysFileController {

    private Logger logger = LoggerFactory.getLogger(SysFileController.class);

    //@Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;

    @PostMapping("/singlefile")
    public Object singleFileUpload(MultipartFile file) {
        logger.debug("传入的文件参数：{}", JSON.toJSONString(file, true));
        if (Objects.isNull(file) || file.isEmpty()) {
            logger.error("文件为空");
            return "文件为空，请重新上传";
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER+file.getOriginalFilename());
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(UPLOAD_FOLDER));
            }
            //文件写入指定路径
            Files.write(path, bytes);
            logger.debug("文件写入成功...");
            return "文件上传成功";
        } catch (IOException e) {
            logger.info(ExceptionUtils.getExceptionStackTraceString(e));
            return "后端异常...";
        }
    }
}
