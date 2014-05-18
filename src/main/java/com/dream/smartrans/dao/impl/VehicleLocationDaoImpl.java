package com.dream.smartrans.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.james.common.utils.dao.BasicDao;
import org.james.common.utils.dao.MultiRowMapper;
import org.james.common.utils.dao.SingleRowMapper;

import com.dream.smartrans.dao.VehicleLocationDao;
import com.dream.smartrans.po.VehicleLocation;

@SuppressWarnings("unused")
public class VehicleLocationDaoImpl extends BasicDao<VehicleLocation> implements
		VehicleLocationDao {

	private static final String SQL_FIND_BY_VEHICLE_ID = "SELECT * FROM vehicle_location WHERE vehicle_id=?";

	private static final String SQL_FIND_ALL = "SELECT * FROM vehicle_location";

	private static final String SQL_INSERT = "INSERT INTO vehicle_location(id, vehicle_id, lng, lat, creation_time, last_update) VALUES(?,?,?,?,now(),now())";
	private static final String SQL_UPDATE_BY_VEHICLE_ID = "UPDATE vehicle_location SET lng=?, lat=?, last_update=now() WHERE vehicle_id=?)";

	private static class VLMultiRowMapper implements
			MultiRowMapper<VehicleLocation> {
		public VehicleLocation mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			VehicleLocation loc = new VehicleLocation();
			loc.setId(rs.getString("id"));
			loc.setVehicleId(rs.getString("vehicle_id"));
			loc.setLng(rs.getInt("lng"));
			loc.setLat(rs.getInt("lat"));
			// loc.setLngLat(rs.getString("lng_lat"));
			loc.setCreationTime(rs.getTimestamp("creation_time"));
			loc.setLastUpdate(rs.getTimestamp("last_update"));
			return loc;
		}
	}

	private static class VLSingleRowMapper implements
			SingleRowMapper<VehicleLocation> {
		public VehicleLocation mapRow(ResultSet rs) throws SQLException {
			return new VLMultiRowMapper().mapRow(rs, 1);
		}
	}

	public List<VehicleLocation> findAll() {
		return query(SQL_FIND_ALL, new VLMultiRowMapper());
	}

	public VehicleLocation findByVehicleId(String vid) {
		return query(SQL_FIND_BY_VEHICLE_ID, vid, new VLSingleRowMapper());
	}

	public String insert(VehicleLocation vl) {
		vl.setId(createId());
		if (update(SQL_INSERT,
				new Object[] { vl.getId(), vl.getVehicleId(), vl.getLng(), vl.getLat() },
				new int[] { Types.CHAR, Types.CHAR, Types.INTEGER, Types.INTEGER }) > 0) {
			return vl.getId();
		} else {
			return null;
		}
	}

	public boolean update(VehicleLocation vl) {
		return update(SQL_UPDATE_BY_VEHICLE_ID, new Object[] { vl.getLng(), vl.getLat(), vl.getVehicleId() },
				new int[] { Types.INTEGER, Types.INTEGER, Types.CHAR }) > 0;
	}
}
