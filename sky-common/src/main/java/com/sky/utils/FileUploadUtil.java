package com.sky.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * todo 临时文件上传工具，后续使用阿里替换
 * @author Zhou
 * @creat 2024-05-16 15:38
 */
@Data
@Slf4j
public class FileUploadUtil {
    public static void saveFile(MultipartFile file, String path) {
        log.info("调用文件上传方法...");
//        判断存储的目录是否存在，不存在进行创建
        File dir =new File(path);
        if (!dir.exists()){
//            创建目录
            dir.mkdir();
        }

        File saveFile = new File(path + file.getOriginalFilename());
        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
