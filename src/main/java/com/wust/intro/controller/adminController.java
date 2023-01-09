package com.wust.intro.controller;

import com.wust.intro.pojo.NotifyPojo;
import com.wust.intro.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class adminController {
    @Autowired
    adminService adminService;
    @RequestMapping("/toAdmin")
    public String toAdmin(){
        return "admin/admin";
    }
    @RequestMapping(value = "/notify",method = RequestMethod.POST)
    @ResponseBody
    public String notify(@RequestParam("title") String title ,@RequestParam("date") String date,@RequestParam("imgFile") MultipartFile imgFile) throws IOException {
        if (title.isEmpty()||date.isEmpty()||imgFile.isEmpty()){
            return "日期或图片未上传";
        }
        NotifyPojo notifyPojo = new NotifyPojo();
        notifyPojo.setTitle(title);
        notifyPojo.setDate(date);
        String originalFilename = imgFile.getOriginalFilename();
        String ProjectRelativelyPath=System.getProperty("user.dir");
        String[] split = ProjectRelativelyPath.split("\\\\");
        String dirStr="";
        for (int i=0;i<split.length-1;i++){
            dirStr=dirStr+split[i]+"/";
        }
        dirStr = dirStr+"/"+"img";
        File file1 = new File(dirStr);
        if (!file1.exists()){
            file1.mkdirs();
        }
        String absolutePath = file1.getAbsolutePath();
        try {
            imgFile.transferTo(new File(absolutePath+"/"+originalFilename));
            notifyPojo.setImpPath(absolutePath+"\\"+originalFilename);
            adminService.add(notifyPojo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "上传成功";
    }
}
