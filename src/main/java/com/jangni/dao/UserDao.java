package com.jangni.dao;

import com.jangni.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description:
 * @Autor: Jangni
 * @Date: Created in  2018/2/25/025 17:20
 */
@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int getUserCount() {
        return jdbcTemplate.queryForObject("select count(*) from user ", Integer.class);
    }

    public int getUserCountByDepart(int departId) {
        return jdbcTemplate.queryForObject("select count(*) from user where department_id = ?",
                Integer.class, departId);
    }

    public User getUser(int id) {
        String sql = "select * from user where id = ? ";
        User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
        return user;
    }

    public List<User> getUserList() {
        String sql = "select * from user ";
        List<User> userList = jdbcTemplate.query(sql, new UserRowMapper());
        return userList;
    }

    public void updateInfo(User user) {
        String sql = "update user set name=? , department_id=? where id = ?";
        jdbcTemplate.update(sql, user.getName(), user.getDepartmentId(), user.getId());
    }
    public Integer insertUser(final User user) {
        final String sql = "insert into user (name, department_id ,create_time) values (?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql, new String[] { "id" });
                ps.setString(1, user.getName());
                ps.setInt(2, user.getDepartmentId());
                ps.setDate(3,user.getCreateTime());
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }
    static class UserRowMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setDepartmentId(rs.getInt("department_id"));
            return user;
        }
    }


}
