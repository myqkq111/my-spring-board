package com.kitri.myspringboard.mapper;

import com.kitri.myspringboard.domain.Authorities;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthoritiesMapper {

    @Insert("INSERT INTO authorities (user_id, authority) VALUES (#{userId}, #{authority})")
    void signup(Authorities authoritie);

}
