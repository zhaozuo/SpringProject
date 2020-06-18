package cn.sdut.controller;

import cn.sdut.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testInterceptor")
    public String testInterceptor() {
        System.out.println("testInterceptor执行了...");
        return "success";
    }

    @RequestMapping("/testException")
    public String testException() throws SysException {
        System.out.println("testException执行了...");
        try {
            // 模拟异常
            int a = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询所有用户出现错误了...");
        }

        return "success";
    }

    @RequestMapping("/fileUpload")
    public String fileUpload1(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("SpringMVC 文件上传...");
        // 获取要上传的文件目录
        String path = request.getServletContext().getRealPath("/uploads");
        // 创建File对象，向该路径上传文件
        File file = new File(path);
        // 判断路径是否存在，如不存在则创建
        if (!file.exists()) {
            file.mkdirs();
        }
        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 把文件名称唯一化
        filename = uuid + "_" + filename;
        // 上传文件
        upload.transferTo(new File(file, filename));
        return "success";
    }
}
