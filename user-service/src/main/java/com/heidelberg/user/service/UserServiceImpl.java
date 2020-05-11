package com.heidelberg.user.service;

import com.heidelberg.user.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@RestController
public class UserServiceImpl implements UserService {
    private static final class UserMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		    return User.builder().id(rs.getString("id")).firstName(rs.getString("firstName")).lastName(rs.getString("lastName")).build();
		}
	}

    private final JdbcTemplate jdbcTemplate;
    private static final UserMapper userMapper = new UserMapper();

    @Override
    public User getUser(String id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM user WHERE id = ?", new Object[] { id }, userMapper);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public void deleteUserById(@PathVariable String id) {
        jdbcTemplate.update("DELETE FROM user WHERE id = ?", new Object[] { id });
    }

    @Override
    public void updateUser(User user) {
        jdbcTemplate.update("UPDATE user SET firstName = ? lastName = ? WHERE id = ?",
                new Object[] { user.getFirstName(), user.getLastName(), user.getId() });
    }

    @Override
    public String createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        jdbcTemplate.update("INSERT INTO user (firstName, lastName, id) VALUES (?, ?, ?)",
                new Object[] { user.getFirstName(), user.getLastName(), user.getId() });
        return user.getId();
    }

    public UserServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        jdbcTemplate.update(
                "CREATE TABLE IF NOT EXISTS user ( "
                + "id VARCHAR(64) NOT NULL PRIMARY KEY, "
                + "firstName VARCHAR(256), "
                + "lastName VARCHAR(256) )");
        User user;
        user = User.builder().firstName("Gerhard").lastName("Haupt").build();
        createUser(user);
        user = User.builder().firstName("André").lastName("Schüngel").build();
        createUser(user);
    }

    @Override
    public List<User> getUsers() {
        return jdbcTemplate.query("SELECT * FROM user", userMapper);
    }
}