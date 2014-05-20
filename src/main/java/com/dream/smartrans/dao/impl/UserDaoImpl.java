package com.dream.smartrans.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.james.common.utils.dao.BasicDao;
import org.james.common.utils.dao.MultiRowMapper;
import org.james.common.utils.dao.SingleRowMapper;

import com.dream.smartrans.dao.UserDao;
import com.dream.smartrans.dict.UserStatus;
import com.dream.smartrans.dict.UserType;
import com.dream.smartrans.po.User;

public class UserDaoImpl extends BasicDao<User> implements UserDao {
	private static final String SQL_FIND_ALL = "SELECT * FROM users";

	private static final String SQL_INSERT_USER = "INSERT INTO users(id,username,password,"
			+ "status,type) " + "VALUES(?,?,?,?,?)";

	private static final String SQL_DELETE_USER = "DELETE FROM users WHERE id=?";

	private static final String SQL_UPDATE_USER = "UPDATE users SET username=?,"
			+ "status=?,type=? WHERE id=?";

	private static final String SQL_FIND_USER_BY_ID = "SELECT * FROM users WHERE id=?";

	private static final String SQL_FIND_BY_TYPE_USERNAME_PASSWORD = "SELECT * FROM users WHERE type=? AND username=? AND password=?";

	private static class UserMultiRowMapper implements MultiRowMapper<User> {
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getString("id"));
			user.setUsername(rs.getString("username"));
			// user.setPassword(rs.getString("password"));
			user.setStatus(UserStatus.valueOf(rs.getInt("status")));
			user.setType(UserType.valueOf(rs.getInt("type")));
			return user;
		}
	}

	private static class UserSingleRowMapper implements SingleRowMapper<User> {
		public User mapRow(ResultSet rs) throws SQLException {
			return new UserMultiRowMapper().mapRow(rs, 1);
		}
	}

	public List<User> findAll() {
		return query(SQL_FIND_ALL, new UserMultiRowMapper());
	}

	public String insert(User user) {
		user.setId(createId());
		if (update(
				SQL_INSERT_USER,
				new Object[] { user.getId(), user.getUsername(),
						user.getPassword(), new Integer(user.getStatus().getValue()),
						new Integer(user.getType().getValue()) },
				new int[] { Types.CHAR, Types.VARCHAR, Types.CHAR,
						Types.INTEGER, Types.INTEGER }) > 0) {
			return user.getId();
		} else {
			return null;
		}
	}

	public String delete(String userId) {
		if (update(SQL_DELETE_USER, userId) > 0) {
			return userId;
		} else {
			return null;
		}
	}

	public String update(User user) {
		if (update(SQL_UPDATE_USER, new Object[] { user.getUsername(),
				new Integer(user.getStatus().getValue()), new Integer(user.getType().getValue()),
				user.getId() }, new int[] { Types.VARCHAR, Types.INTEGER,
				Types.INTEGER, Types.CHAR }) > 0) {
			return user.getId();
		} else {
			return null;
		}
	}

	public User findById(String userId) {
		return (User) query(SQL_FIND_USER_BY_ID, userId,
				new UserSingleRowMapper());
	}

	public User findUser(int type, String username, String password) {
		return (User) query(SQL_FIND_BY_TYPE_USERNAME_PASSWORD, new Object[] {
				type, username, password }, new int[] { Types.INTEGER,
				Types.VARCHAR, Types.VARCHAR }, new UserSingleRowMapper());
	}
}
