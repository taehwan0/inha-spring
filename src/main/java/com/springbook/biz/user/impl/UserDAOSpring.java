package com.springbook.biz.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserDAO;
import com.springbook.biz.user.UserVO;

@Repository("userDAO")
public class UserDAOSpring implements UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertUser(UserVO vo) {
		jdbcTemplate.update(
				"INSERT INTO users (id, password, name, role) values (?, ?, ?, ?)",
				vo.getId(),
				vo.getPassword(),
				vo.getName(),
				vo.getRole()
		);
	}

	@Override
	public void updateUser(UserVO vo) {
		jdbcTemplate.update(
				"UPDATE users SET password = ?, name = ?, role = ? where id = ?",
				vo.getPassword(),
				vo.getName(),
				vo.getRole(),
				vo.getId()
		);
	}

	@Override
	public void deleteUser(UserVO vo) {
		jdbcTemplate.update(
				"DELETE FROM users WHERE id = ?",
				vo.getId()
		);
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return jdbcTemplate.queryForObject(
				"SELECT * FROM users WHERE id = ?",
				new UserRowMapper(),
				vo.getId()
		);
	}

	@Override
	public List<UserVO> getUserList() {
		return jdbcTemplate.query(
				"SELECT * FROM users",
				new UserRowMapper()
		);
	}

	@Override
	public UserVO login(UserVO vo) {
		return jdbcTemplate.queryForObject(
				"SELECT * FROM users WHERE id = ? AND password = ?",
				new UserRowMapper(),
				vo.getId(),
				vo.getPassword()
		);
	}
}

class UserRowMapper implements RowMapper<UserVO> {

	@Override
	public UserVO mapRow(ResultSet resultSet, int i) throws SQLException {
		String id = resultSet.getString("id");
		String name = resultSet.getString("name");
		String password = resultSet.getString("password");
		String role = resultSet.getString("role");

		return new UserVO(id, password, name, role);
	}
}
