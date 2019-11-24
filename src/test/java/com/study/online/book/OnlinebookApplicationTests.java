package com.study.online.book;

import com.study.online.book.dao.mapper.ShippingaddressMapper;
import com.study.online.book.dao.entity.Shopcat;
import com.study.online.book.service.MailService;
import com.study.online.book.service.ShippingaddressService;
import com.study.online.book.service.ShopcatService;
import com.study.online.book.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OnlinebookApplicationTests {
//    @Resource
//    private InventoryDao inventoryDao;
//    @Resource
//    private BookDao bookDao;
//    @Resource
//    private UserDao userDao;
//    @Resource
//    private UserinfoDao userinfoDao;
//    @Resource
//    private OrdersDao ordersDao;
//    @Resource
//    private ShopcatDao shopcatDao;
//    @Test
//    public void contextLoads() {
//
//        System.out.println(userDao.findUserByName("wmyskxz"));
//       System.out.println(userinfoDao.findUserinfoByUid(123457L));
//        PageHelper.startPage(2, 1);
//        System.out.println(bookDao.findAllByBooknameLikeOrAuthorLike("",""));
//        System.out.println(bookDao.findBookVoByIsbn(9787547409510L));
//        System.out.println(inventoryDao.addNumber(1,9787547409510L));
//        System.out.println(ordersDao.findAllByUid(1563719585203167L));
//        System.out.println(shopcatDao.findAllByUid(123457L));
//        Userinfo userinfo = new Userinfo();
//        userinfo.setUid(1235656L);
//        userinfo.setActualname("777");
//        userinfo.setCreationtime(new Date());
//        userinfo.setEmail("777");
//        userinfo.setSelfintroduction("777");
//        userinfo.setSex("男");
//        userinfo.setTel("777");
//        userinfoDao.save(userinfo);
//    }

//    @Test
//    public void md5Test() {
//        String password  = "123456";
//        String salt = "wmyskxz";
//        int hashIterations = 2;
//
//        SimpleHash simpleHash = new SimpleHash("md5",password, ByteSource.Util.bytes(salt),hashIterations);
//
//        System.out.println(simpleHash.toHex().equals(userDao.findUserByName("wmyskxz").getPassword()));
//    }

    @Resource
    private MailService mailService;
    @Resource
    private UserService userService;
    @Test
    public void Test1() {
//        User user = userService.findByName("wmyskxz1234");
//        System.out.println(user.getId());
//        userService.save("zhangsan","123456");
        mailService.sendSimpleMail("761668578@qq.com", "来自onlinebook的邮箱验证码", String.valueOf(545));
    }

//        @Resource
//    private BookService bookService;
//    @Test
//    public void Test2() {
//        System.out.println(bookService.findAll(1));
//        System.out.println(bookService.findAllBynameOrauthor("像",0,1));
//        System.out.println(bookService.findAllBynameOrauthor("像",1,1));
//        System.out.println(bookService.findAllBynameOrauthor("像",2,1));
//        System.out.println(bookService.findBookVoByisbn(9787547409510L));
//        System.out.println(bookService.findByisbn(9787547409510L));
//
//
//}
//    @Resource
//    private OrdersMapper ordersMapper;
//    @Test
//        public void md5Test() {
//        System.out.println(ordersMapper.findAllByUid(123457L));
//        ordersMapper.UpdateStatus(2, new Date(), 1563720747549167L);
//
//    }
//    @Resource
//    private OrdersService ordersService;
//    @Test
//    public void md5Test() throws AlipayApiException {
////        System.out.println(ordersService.save(123457L,"9787547409510*1",""));
//
//       System.out.println(ordersService.IsPay(1566828346580742L));
//    }
    @Resource
    private ShopcatService shopcatService;
        @Test
        public void md5Test() {

            Shopcat shopcat = new Shopcat();
            shopcat.setUid(123457L);
            shopcat.setIsbn(9787547409480L);
            shopcat.setQuantity(5);

//            shopcatService.save(shopcat);
            System.out.println(shopcatService.findByUid(123457L,1));
//            System.out.println(shopcatService.updateByisbn(123457L,9787547409480L,11));
//            System.out.println(shopcatService.deleteByUid(123457L,9787547409480L));

            System.out.println(shopcatService.findByuidAndisbn(123457L, 9787547409480L));
    }

    @Resource
    private ShippingaddressService shippingaddressService;
    @Test
    public void testaddress() {
        System.out.println(shippingaddressService.findAllAddressByUid(123461L));
//        shippingaddressService.setDefultAddress(1,123461L);
    }

    @Resource
    private ShippingaddressMapper shippingaddressMapper;

    @Test
    public void testaddress1() {
        System.out.println(shippingaddressMapper.selectdulfaddress(123461L));
    }
}
