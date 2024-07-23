package com.kitri.myspringboard.mapper;

import com.kitri.myspringboard.domain.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("SELECT c.*, u.username FROM comment c join users u on c.user_id = u.id WHERE board_id = #{id}")
    public List<Comment> selectAll(int id);

    @Insert("INSERT INTO comment (content, user_id, board_id) VALUES (#{content}, #{userId}, #{boardId})")
    public void add(Comment comment);

}
