package com.kitri.myspringboard.provider;

import org.apache.ibatis.jdbc.SQL;

public class BoardProvider {

    public String filterBoard(String filter, String categori){
        return new SQL() {{
            SELECT("b.*, u.username");
            FROM("board b");
            JOIN("users u ON b.user_id = u.id");
            switch(categori){
                case "제목":
                    WHERE("title like '%' #{filter} '%'");
                    break;
                case "작성자":
                    WHERE("username like '%' #{filter} '%'");
                    break;
                case "제목+작성자":
                    WHERE("title like '%' #{filter} '%' OR username LIKE '%' #{filter} '%'");
                    break;

            }

        }}.toString();
    }

}
