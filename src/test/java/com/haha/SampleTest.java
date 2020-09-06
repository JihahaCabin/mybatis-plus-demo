package com.haha;

import com.haha.entity.User;
import com.haha.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        System.out.println(("----- insert method test ------"));
        User user = new User();
        user.setAge(12);
        user.setName("haha");
        user.setEmail("haha@123.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        System.out.println(("----- update method test ------"));
        //只更新有赋值的字段，通过条件自动拼接sql
        User user = new User();
        user.setId(1L);
        user.setName("haha2");
        int insert = userMapper.updateById(user);
        System.out.println(insert);
        System.out.println(user);
    }
}