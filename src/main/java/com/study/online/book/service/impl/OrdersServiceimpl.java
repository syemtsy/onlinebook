package com.study.online.book.service.impl;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.github.pagehelper.PageHelper;
import com.study.online.book.dao.mapper.*;
import com.study.online.book.service.OrdersService;
import com.study.online.book.dao.entity.Orders;
import com.study.online.book.dao.entity.OrdersVoVo;
import com.study.online.book.dao.entity.Ordersinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service

public class OrdersServiceimpl implements OrdersService {
    @Autowired
    private InventoryMapper inventoryMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private OrdersinfoMapper ordersinfoMapper;
    @Autowired
    private ShippingaddressMapper shippingaddressMapper;

//    private static final String url = "https://openapi.alipaydev.com/gateway.do";
//    private static final String appId = "2016100100641803";
//    private static final String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmejVqwkJqreEy/DjNgMLisYDr3Baj6L7e0m8reuCR94+PfzQR6PMpI6E6QQpSJUCGJwG+1a8wtrIxy7ARMCwx3TPBRJMlB3SC/KMfifMfgnMM4QYuHPw6Kg8r/MHqxM8eNJMLeVUSVerrtRDUoyI/rWKV1zNQ9uoZ0rwmLPYLj0u5SPlpcC/tTa8HFOZ8C899BysyOiMN+rN57OuoT6B8hUetlKAo+C9UEuLQWK5q9vRezzA4/0nDDJsOUDZfQ2+6OnwZjGiIKLfMhZX3XP25KlYrsocsJp19L+05IUgkDcNHE9xJKRG/zGq5IvZYj6jm6d632E7Tm3Yro/sX7v30QIDAQAB";
//    private static final String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCEH7agbq4koGB0vQhFsraR3XXgm11f56+/r/C52+COGE3HJ7vkF2E1szIusx9M6Z3y4BPPH7rmHCSiTlnz1fDBhtGZpGKJXmPg5zV4yXj3Umz3Ls2qBW6FFpjTW66IxXHgJo3R3lzI8kLm1rViEdm7G1pQw8gGBPnw0+cT89IoQcMP76t2WANzmVPbQmciAnSc+Kt1jBOtaasWvXvyjC0v/KAP7lhdjmHywIsDApjm37PfI2yoxN/cnk3PRxYA0cjV9WoFKXKX7+jaqnOWNmc/GuRAZzJ1fJOFWhXZxIj6kOLoTV0hkhDKfuM0pUD03lTX92vwf8IRPSUnG/xmO96hAgMBAAECggEAVCmreQjoD1bF+rcLlPJhkAtFcn0lftkkP/QAYTRqF7ntmaZ67rHh74Yluk/J6YGLZtJMbA0nTjuxLl7AuC2Y/n41+CwZxK2G7BX8HuQgFVPBK7f5tItfOpIJaeGmDWPQxVtpzb1a13pTGZ69zinWy3SCFJ6SRRtYZ4tkUHZpcdB/MvYuue4i1qz1OLfh/riF0UV0DPnaTLAMGxQawC3AwCvVEbtD1Q+L5g4lEmfqQo8dehkRL4omsqQQ6Ivl7/7kEcVCMgvlFJwI/+OLbLEhBpKAT50tiEgk3bLFgZW8rzbgAxbbSjbNrzFYiYNRuELDgPyya09WNRNiGbxDn/FsEQKBgQDHVIS++pI8wCOwvH/j7ntzGMQbMb7T+MpTjKPmqZRNNo8vFpUvWESq9EpLEk6pzmcDJ1Hn265mSR82WZYdvVtVjFF7J6yITfcIgk9L270nJLljT+PqBh3T14/qrhjxRdh4Z+lTremoOrzIsOeFICQb3hS/NxQZrFCtr6Eb+0hFRQKBgQCpr9gKqMPjjdcBKLlVmtbQGsd+odhtFiPrv00pdIDt8zS2B/iymBPjBoTypAnZCpePOQhHAOJcubz304I3EFVqeL7oog3o5NPMJwA/96tbr/ptuggUmmIYk/gnD1HaSIVT1MIQvhVguxT1AtZofbouW1GBU6u60BFOxdplNXRDrQKBgHGOnPGQHq+tZqfRO6rGul2fxlkXxfdMzTc78EQAaBR0+K2C2ArY5oXeFlUeYOIsTFNnmynT5U8waS+1aegXcGkUP3dB6vDcOdgHJNW6odAjA9qoMNeqFGQTclHoTR1nBSPTTwH1GiBVFiffYIZfATM/GeK1piXaHTxVyhr+1PVhAoGAPvv8TwiRnXdapR1+nZ3ZumkWP5THhsY/ExRxCcAq0ygBGsgesfvs9cnHs2DcHunlk83xmpljbFOtJrglj1bKvbiP9D2iuB2n2BFp8FR4EJJjfDMfKLadTs4twCHZmhJtGs7QMfK8cKlAgClLeIGih+5xdHWgOrlck0axZ/vNagkCgYAIUSc6yMX3tG+9aSSVjAtIpnZshJdIsaV7WfIP69WyMtlb/RRm6HT5LYv+ZlPD4Z0coEK2/xtJhRXb7QNyVmxlDX6faFB7rr/BdiKbcghpMV19UsOa7ZGYDxp370aD6fWK+iWICRlWWDpztqUKC6/EF3M9UNl8hShfTyC9SbXXtA==";
  //    private static Logger log = (Logger) LoggerFactory.getLogger(pay.class);
    private static final String url = "https://openapi.alipay.com/gateway.do";
    /**
     * 你的私钥
     */
    private static final String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCkzP9J51ItKN9tzNqQvmKxldiRWyY/vU05rIw3GWKhpjl4fxEo3EHqjZwTR1iQTkW7l9igjGE5crYIqZ1RNcv70SK0XbOxqjNa9Pi2JLIFZ/0OjC5zedg7PxcoxEBhW3yX8S7OcIxUofVr6BeH5TgOeC9El96KVRZ0HwpgzfA2jCy6uku10JIKwAvVo3spFFP0jugEBD0uKNzUDJT/99G4iORwGH3ZKpqilJWnvHUVA/Jop8uHCwV0hgZLZbJ8I8iVBN0jdIa5hTukulmKZ1t+qpUocCrN7hAqUZCLxuzXKdTuBwirehdLmSvfDwIv8ydlx2e5qILM1Il7ThAoFieVAgMBAAECggEAY7PGCw8Qr1OYANS7snAMQ4X1dNMhS9SaAPd8COWpv0RSZqzxU7gVhPLRZvR2By/jjj+qhk8HjvrwWENNctFKLHn1NguuaCEhWrj0MzX2IcEs3v0+KQyhHg7oUviQPpZbxYzblXeP3q/xS6wpeETb6h0Z87SxpR0fLXeODszotAaXbVT+0fAOHoZ85rI1Smwbd6UeR21ccqWpldcDx/Kd7hL7g5rQWbnCaMViDX7/je5MnjsLHc8PSaMHfkaP+9etUHJhBDOPaoQM/h/55X9XWwb5WzFC99g+JTcXLI1moSn19suvyphZuLQ1T2Hc5VwwQDHzQtsg9IIuJnVijLZwIQKBgQDT+XwUedh6m0YCSvfgesH4lLEgMa624TnWSODjP8lb5gUlUKTuAGOVzL/UrC9WiRgqrgUFqESEi0cYTVLMH+O4KCpGOmG9MQoqPcz/CTeVL1oVZxDiQs8ZGO5Coc2Io85jlj6pRI5Hlblh8oXVtdGZiLsx6veC5PVMrcfIObRHfQKBgQDHB1Ij2GiDtbihvkcWSiGVhK2sKGQG7hQG9CBQTpzer9fLqGu68qyi2HrJtNMfQDRp/oyUQ8GidjzgJ2VlFskHOUK9JJzqvuT5JlQZIma/YSOfb+Xqoxsn3u8e6WvxuhWeoACvD/zf0CCdDy5fOZb74D+37FZ9znOHnlKqmedL+QKBgH6H3dkbIm2NYizcMzp8DG0l1NUy0ue3aZ7Pwe3klX2VwFyV1t16vfcdUSTR4y/0hch0N+s4li3INZf8EABoyLWUxCdHkjAspbSxTzytc9BJg6xi6WEmIBkLGK4Nh3KY1Qn9FUpU8dkpNo+RBPKcpZDQXW1epIAty38J/Mc4KrTBAoGAZDVOaRfbv3zuYhlwp0tZz3NHEigf/NFAKiQeZPC/0OtORo8c9rqaqz89y3MM3W4xNbDhTQE0bD0F94I+bgBj5QwyixL1IshMdxmSPDly7CbXjb4ET/ghgxie4rx6CfI8UmqTDZGKK5IZ6ZosKevQFi9ZRZxsC9m3l2/ihV0J9NkCgYEA0n3uaOcAduri39NMMgLSFH6eYeTxOpj7DYHwtYRYViy6Snqdttc4SPW1XIRgWlWAYwQJTRE8SPoDP5QrH+L7d4kKcqhnsxUZZzGY48Fft1+iWIFSMT2GdCA4bhUng4mJuj6TjBGDPJpJNus0GwM9yryc0ZCgNM6gjFwP0vwnRWU=";

    /**
     * 你的公钥
     */
    private static final String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAm5DG+aQf9rNRM1IgZTzFOLYYgckutJnohKH4PXqYu2/wBmZyND01/THJ69y0UWNX7PlRHPlTZWpfWmKXP6aSc6eWHxYmXmfZJH603J9eaNSkG23OWUOOlFiNlMNdYA+AFY9SYaFECiunRR/OD3tZcf7oxn8ObN0t1UkB1DbMBUL2jikKvRIh6LrvNSPvpYSg2k84cUyhEpkdWZy5WP13Q9BicU6Je1pACAl1WoziEbF5cwTfwONsex1/nluJ2sNo+qldf12So3dRHY1MCQ3gxunW4xv7wEKOTTgwM0iIyQ8/jT9I1EU3F3ywqMaVNTCZCRDiwqCo73hejSICHqwYpQIDAQAB";


    /**
     * 你的应用ID
     */
    private static final String appId = "2017022705930262";

    private static final int page_size=20;
    /**
     * 生成二维码
     //     * @param pay
     * @return
     * @throws AlipayApiException
     */


    @Override
    public String save(Long uid, List<String> info) {
        //生成16位订单号
        String id = Long.toString(System.currentTimeMillis());
        while (id.length()<16){
            id +=Integer.toString( new Random().nextInt(9));
        }
        //计算Money
        Double money = 0D;
        for (String shopinfo:info) {
            String[] infoshop = shopinfo.split("\\*");
            if (infoshop.length == 2) {
                Long isbn =Long.parseLong(infoshop[0]) ;
                int number = Integer.parseInt(infoshop[1]);
               money+= bookMapper.findByIsbn(isbn).getPrice().doubleValue()*number;
            }
        }
        Orders orders = new Orders();
        orders.setOrderid(Long.parseLong(id));
        orders.setStatus(1);
        orders.setUid(uid);
        orders.setMoney(new BigDecimal(money));
        orders.setCreateTime(new Date());
        orders.setUpdateTime(new Date());
        orders.setMessage("");
      Integer addreddid= shippingaddressMapper.selectdulfaddress(uid);
        orders.setAddressid(addreddid);
        ordersMapper.insert(orders);
        //解析订单详细信息,存入订单详情表
        for (String shopinfo:info) {

            String[] infoshop = shopinfo.split("\\*");
            if (infoshop.length == 2) {
                Long isbn =Long.parseLong(infoshop[0]) ;
                int number = Integer.parseInt(infoshop[1]);
                Ordersinfo ordersinfo = new Ordersinfo();
                ordersinfo.setOrderinfoid(Long.parseLong(id));
                ordersinfo.setIsbn(isbn);
                ordersinfo.setNumber(number);
                ordersinfoMapper.insert(ordersinfo);
                inventoryMapper.addNumber(-number, isbn);
            }
        }
        return id;

    }
    @Override
    public boolean IsPay(Long id) throws AlipayApiException {

            AlipayClient alipayClient = new DefaultAlipayClient(url, appId, privateKey, "json", "GBK", publicKey, "RSA2");
            AlipayTradeQueryRequest r = new AlipayTradeQueryRequest();
            r.setBizContent("{" +
                    "\"out_trade_no\":\"" + id + "\"" +
                    "  }");
            AlipayTradeQueryResponse response = alipayClient.execute(r);
            if (response != null && response.isSuccess() && "TRADE_SUCCESS".equals(response.getTradeStatus())) {
                ordersMapper.UpdateStatus(2,new Date(),id);

                return true;
            }
            return false;
        }

    @Override
    public List<Orders> findAllByUid(Long uid, Integer pageable)
    {
        PageHelper.startPage(pageable, page_size);
        return ordersMapper.findAllByUid(uid);
    }

    @Override
    public OrdersVoVo findByUid(Long uid, Long orderid) {
        return ordersMapper.findOrdersVoByOrderid(uid,orderid);
    }

    @Override
    public String pay(Long uid, Long orderid, String msg,Integer addressid) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(url, appId, privateKey, "json", "GBK", publicKey, "RSA2");
        AlipayTradePrecreateRequest r = new AlipayTradePrecreateRequest();
       OrdersVoVo ordersVoVo= ordersMapper.findOrdersVoByOrderid(uid, orderid);
        BigDecimal money = ordersVoVo.getMoney();
        System.out.println(money.toString());
        r.setBizContent("{" +
                "\"out_trade_no\":\""+orderid+"\"," +
                "\"total_amount\":"+money.toString()+"," +
                "\"subject\":\""+msg+"\"" +
                "  }");
        AlipayTradePrecreateResponse response = alipayClient.execute(r);
        if (!response.isSuccess()) {
            return null;
        }
        ordersMapper.updataMsgandAddressByOrderid(orderid, msg,addressid);
        return response.getQrCode()+"&money="+money+"&id="+orderid;
    }

    @Override
    public List<Orders> findAll(Integer page) {
        PageHelper.startPage(page, page_size);
        return ordersMapper.selectAll();
    }


}
