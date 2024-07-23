package com.kitri.myspringboard.mapper;

import com.kitri.myspringboard.domain.Board;
import com.kitri.myspringboard.provider.BoardProvider;
import lombok.Data;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("SELECT b.*, u.username FROM board b join users u ON b.user_id = u.id")
    List<Board> findAll();

    @Select("SELECT b.*, u.username FROM board b join users u ON b.user_id = u.id WHERE b.id = #{id}")
    Board findById(int id);

    @Insert("INSERT INTO board(title, content, user_id) VALUES (#{title}, #{content}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Board board);

    @Update("UPDATE board SET title=#{title}, content=#{content}, user_id=#{userId} WHERE id=#{id}")
    void update(Board board);

    @Delete("DELETE FROM board WHERE id=#{id}")
    void delete(int id);

    @SelectProvider(type = BoardProvider.class, method = "filterBoard")
    List<Board> filterBoard(String filter, String categori);

    @Select("SELECt * FROM board WHERE ORDER BY id LIMIT 5 OFFSET #{start}")
    List<Board> page(int start);

}



