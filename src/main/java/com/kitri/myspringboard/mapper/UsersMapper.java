package com.kitri.myspringboard.mapper;

import com.kitri.myspringboard.domain.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UsersMapper {

    @Insert("INSERT INTO users (username, password, enabled) VALUES (#{username}, #{password}, true)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void signup(Users user);

    @Select("SELECT id FROM users WHERE username=#{username}")
    int selectId(String username);

}
