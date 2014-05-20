package com.dream.smartrans.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.james.common.utils.dao.BasicDao;
import org.james.common.utils.dao.MultiRowMapper;
import org.james.common.utils.dao.SingleRowMapper;

import com.dream.smartrans.dao.CustomerDao;
import com.dream.smartrans.po.Customer;

public class CustomerDaoImpl extends BasicDao<Customer> implements CustomerDao {
	private static final String SQL_FIND_ALL = "SELECT * FROM customer";

	private static final String SQL_INSERT_CUSTOMER = "INSERT INTO customer(id,user_id,name,"
			+ "iden,nick_name,sex,age,cell_phone,phone,creation_time) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,now())";

	private static final String SQL_DELETE_CUSTOMER = "DELETE FROM customer WHERE id=?";

	private static final String SQL_UPDATE_CUSTOMER = "UPDATE customer SET user_id=?,name=?,"
			+ "iden=?,nick_name=?,sex=?,age=?,cell_phone=?,phone=? WHERE id=?";

	private static final String SQL_FIND_CUSTOMER_BY_ID = "SELECT * FROM customer WHERE id=?";

	private static final String SQL_FIND_BY_USER_ID = "SELECT * FROM customer WHERE user_id=?";

	private static class CustomerMultiRowMapper implements
			MultiRowMapper<Customer> {
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setId(rs.getString("id"));
			customer.setUserId(rs.getString("user_id"));
			customer.setName(rs.getString("name"));
			customer.setIden(rs.getString("iden"));
			customer.setNickName(rs.getString("nick_name"));
			customer.setSex(rs.getInt("sex"));
			customer.setAge(rs.getInt("age"));
			customer.setCellPhone(rs.getString("cell_phone"));
			customer.setPhone(rs.getString("phone"));
			customer.setCreationTime(rs.getTimestamp("creation_time"));
			return customer;
		}
	}

	private static class CustomerSingleRowMapper implements
			SingleRowMapper<Customer> {
		public Customer mapRow(ResultSet rs) throws SQLException {
			return new CustomerMultiRowMapper().mapRow(rs, 1);
		}
	}

	public List<Customer> findAll() {
		return query(SQL_FIND_ALL, new CustomerMultiRowMapper());
	}

	public String insert(Customer customer) {
		customer.setId(createId());
		if (update(SQL_INSERT_CUSTOMER, new Object[] { customer.getId(),
				customer.getUserId(), customer.getName(), customer.getIden(),
				customer.getNickName(), new Integer(customer.getSex()),
				new Integer(customer.getAge()), customer.getCellPhone(),
				customer.getPhone() }, new int[] { Types.CHAR, Types.CHAR,
				Types.VARCHAR, Types.INTEGER, Types.CHAR, Types.VARCHAR,
				Types.INTEGER, Types.INTEGER, Types.VARCHAR, Types.VARCHAR }) > 0) {
			return customer.getId();
		} else {
			return null;
		}
	}

	public String delete(String customerId) {
		if (update(SQL_DELETE_CUSTOMER, customerId) > 0) {
			return customerId;
		} else {
			return null;
		}
	}

	public String update(Customer customer) {
		if (update(
				SQL_UPDATE_CUSTOMER,
				new Object[] { customer.getUserId(), customer.getName(),
						customer.getIden(), customer.getNickName(),
						new Integer(customer.getSex()),
						new Integer(customer.getAge()),
						customer.getCellPhone(), customer.getPhone(),
						customer.getId() }, new int[] { Types.CHAR,
						Types.VARCHAR, Types.INTEGER, Types.CHAR,
						Types.VARCHAR, Types.INTEGER, Types.INTEGER,
						Types.VARCHAR, Types.VARCHAR, Types.CHAR }) > 0) {
			return customer.getId();
		} else {
			return null;
		}
	}

	public Customer findById(String customerId) {
		return (Customer) query(SQL_FIND_CUSTOMER_BY_ID, customerId,
				new CustomerSingleRowMapper());
	}

	public Customer findByUserId(String userId) {
		return (Customer) query(SQL_FIND_BY_USER_ID, userId,
				new CustomerSingleRowMapper());
	}
}
