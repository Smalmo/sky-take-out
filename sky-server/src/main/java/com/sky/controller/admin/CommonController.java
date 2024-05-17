package com.sky.controller.admin;

import com.sky.constant.FileSavePath;
import com.sky.result.Result;
import com.sky.utils.FileUploadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 通用接口
 * @author Zhou
 * @creat 2024-05-15 22:37
 */
@RestController
@RequestMapping("/admin/common")
@Api("通用接口")
@Slf4j
public class CommonController {

    /**
     * todo 后期需修改为阿里服务
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file){/*,HttpServletRequest request 用于动态获取服务器目录*/
        log.info("文件上传:{}", file);
//            // 获取文件名称
//        file.getOriginalFilename();
//            // 获取文件类型
//        file.getContentType();
            System.out.println(System.getProperty("user.dir"));
//            // 获取WEB服务器的运行目录
//            String path = request.getServletContext().getRealPath("/upload/");
            FileUploadUtil.saveFile(file, FileSavePath.PHOTO_DISH);

        return Result.success(FileSavePath.PHOTO_DISH+file.getOriginalFilename());

    }

}
