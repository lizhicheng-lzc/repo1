package cn.lzc.controller;

import cn.lzc.domain.Customer;
import cn.lzc.mapper.CustomerMapper;
import cn.lzc.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ConfigurationProperties(prefix = "person")
public class TestController {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @RequestMapping("/test")
    @ResponseBody
    public Object test() {
        return name;
    }

    @Autowired
    private CustomerMapper customerMapper;

    @RequestMapping("/query")
    @ResponseBody
    public List<Customer> queryCustomerList() {
        return customerMapper.queryCustomerList();
    }

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/jpa")
    @ResponseBody
    public void jpa() {
        List<Customer> list = customerRepository.findAll();
        System.out.println(list);
    }

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/redis")
    @ResponseBody
    public void redis() {
        redisTemplate.boundValueOps("a").set("a");
    }
}
