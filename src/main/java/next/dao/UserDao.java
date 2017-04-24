package next.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.jdbc.ConnectionManager;
import next.model.User;

public class UserDao {
    public void insert(User user) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        PreparedStatementSetter pss = pstmt -> {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());

        };

        jdbcTemplate.update("INSERT INTO USERS VALUES (?, ?, ?, ?)", pss);
    }

    public void update(User user) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        PreparedStatementSetter pss = pstmt -> {
            pstmt.setString(1, user.getPassword());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getUserId());

        };

        jdbcTemplate.update("UPDATE USERS SET password=?, name=?, email=? WHERE userId=?", pss);
    }

    public List<User> findAll() throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        PreparedStatementSetter pss = pstmt -> {
        };

        RowMapper<User> rowMapper = rs -> new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email"));

        return jdbcTemplate.query("SELECT userId, password, name, email FROM USERS", pss, rowMapper);
    }

    public User findByUserId(String userId) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        PreparedStatementSetter pss = pstmt -> {
            pstmt.setString(1, userId);
        };

        RowMapper<User> rowMapper = rs -> new User(rs.getString("userId"), rs.getString("password"), rs.getString("name"), rs.getString("email"));
        return jdbcTemplate.queryForObject("SELECT userId, password, name, email FROM USERS WHERE userid=?", pss, rowMapper);
    }
}
