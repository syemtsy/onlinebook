package com.study.online.book.controller;

import com.study.online.book.service.ShopcatService;
import com.study.online.book.service.UserService;
import com.study.online.book.dao.entity.Shopcat;
import com.study.online.book.dao.entity.ShopcatVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class ShopCatController {
    @Autowired
    private ShopcatService shopcatService;
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/myshopcat", method = RequestMethod.GET)
    public List<ShopcatVo> getmyshopcat(@RequestParam Integer pageable, HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("name");
//        Subject subject = SecurityUtils.getSubject();
//      String name= (String) subject.getPrincipal();
        Long uid = userService.findByName(name).getUid();
        return shopcatService.findByUid(uid, pageable);
    }

    @ResponseBody
    @RequestMapping(value = "/myshopcat", method = RequestMethod.DELETE)
    public String deleteshopcat(@RequestParam Long isbn, HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("name");
        Long uid = userService.findByName(name).getUid();
        shopcatService.deleteByUid(uid, isbn);
        return "true";
    }

    @ResponseBody
    @RequestMapping(value = "/shopcat", method = RequestMethod.POST)
    public boolean addshopcat(String info, HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("name");
//        Subject subject = SecurityUtils.getSubject();
//        String name= (String) subject.getPrincipal();
        Long uid = userService.findByName(name).getUid();
        String[] shopinfo = info.split(",");
        for (String s : shopinfo) {
            String[] a = s.split("\\*");
            if (shopcatService.findByuidAndisbn(uid, Long.parseLong(a[0])) == null) {
                Shopcat shopcat = new Shopcat();
                shopcat.setUid(uid);
                shopcat.setIsbn(Long.parseLong(a[0]));
                shopcat.setQuantity(Integer.parseInt(a[1]));

                shopcatService.save(shopcat);
            } else {
                shopcatService.updateByisbn(uid, Long.parseLong(a[0]), Integer.parseInt(a[1]));
            }
        }
        return true;
    }

    @ResponseBody
    @RequestMapping(value = "/shopcat", method = RequestMethod.PUT)
    public boolean putshopcat(@RequestParam String shopinfo,HttpServletRequest request) {
        String name = (String) request.getSession().getAttribute("name");
        Long uid = userService.findByName(name).getUid();
        return shopcatService.putShopinfo(shopinfo, uid);
    }
}
