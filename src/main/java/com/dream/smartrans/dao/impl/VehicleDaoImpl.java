package com.dream.smartrans.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.james.common.utils.dao.BasicDao;
import org.james.common.utils.dao.MultiRowMapper;
import org.james.common.utils.dao.SingleRowMapper;

import com.dream.smartrans.dao.VehicleDao;
import com.dream.smartrans.dict.CarType;
import com.dream.smartrans.po.Vehicle;

@SuppressWarnings("unused")
public class VehicleDaoImpl extends BasicDao<Vehicle> implements VehicleDao {
	
private static final String SQL_FIND_BY_VEHICLE_ID = "SELECT * FROM vehicle_location WHERE vehicle_id=?";
	
	private static final String SQL_FIND_ALL = "SELECT * FROM vehicle";
	
	private static class VehicleMultiRowMapper implements MultiRowMapper<Vehicle> {
		public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Vehicle v = new Vehicle();
			v.setId(rs.getString("id"));
			v.setName(rs.getString("name"));
			v.setType(CarType.valueOf(rs.getInt("type")));
			v.setCreationTime(rs.getTimestamp("creation_time"));
			v.setLastUpdate(rs.getTimestamp("last_update"));
			return v;
		}
	}
	
	private static class VehicleSingleRowMapper implements SingleRowMapper<Vehicle> {
		public Vehicle mapRow(ResultSet rs) throws SQLException {
			return new VehicleMultiRowMapper().mapRow(rs, 1);
		}
	}

	public List<Vehicle> findAll() {
		return query(SQL_FIND_ALL, new VehicleMultiRowMapper());
	}
}
