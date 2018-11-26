package com.itheima.controller;

import cn.itcast.ssm.domain.Items;
import com.itheima.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author k zhang
 * @date 2018/11/21
 **/
@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
   private ItemService itemService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        List<Items> itemsList = itemService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("itemsList",itemsList);
        mv.setViewName("itemsList");
        return mv;

    }

    @RequestMapping("/editItems.do")
    public String editItems(Items items, String id, HttpServletRequest request, MultipartFile upload) throws IOException {
// 先获取到要上传的文件目录
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        File file = new File(path);
// 判断路径是否存在，如果不存在，创建该路径
        if(!file.exists()) {
            file.mkdirs();
        }
// 获取到上传文件的名称
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
// 把文件的名称唯一化
        filename = uuid+"_"+filename;
// 上传文件
        upload.transferTo(new File(file,filename));


        itemService.editItems(items, id);
        return "redirect:findAll.do";

    }
    @RequestMapping("/findById")
    public ModelAndView findById(String id){
        Items items = itemService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("items",items);
        mv.setViewName("editItems");
        return mv;


    }

}
