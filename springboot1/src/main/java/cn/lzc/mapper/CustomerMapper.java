package cn.lzc.mapper;

import cn.lzc.domain.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    public List<Customer> queryCustomerList();
}
