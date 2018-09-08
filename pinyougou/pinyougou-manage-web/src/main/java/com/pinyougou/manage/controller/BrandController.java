package com.pinyougou.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import com.pinyougou.vo.PageResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //包含了Controller和ResponseBody
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    /**
     * 查询所有品牌信息
     * @return
     */
    @GetMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }


    /**
     * 根据分页当前页和页面大小查询品牌列表
     * @param page
     * @param rows
     * @return
     */
    @GetMapping("/testPage")
    public List<TbBrand> testPage(@RequestParam(value="page",defaultValue = "1") Integer page,
                                  @RequestParam(value="rows",defaultValue = "10") Integer rows){
        //findPage返回的是PageResult对象,.getRows为分页列表数据
        return (List<TbBrand>) brandService.findPage(page,rows).getRows();
    }

    /**
     * 根据当前页和页面大小查询品牌列表
     */
    @GetMapping("/findPage")
    public PageResult findPage(Integer page,Integer rows){
        //findPage()返回PageResult对象
        return brandService.findPage(page,rows);
    }
}
