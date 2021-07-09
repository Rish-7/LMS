package com.hexaware.ftp49.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.hexaware.ftp49.model.LeaveType;
import com.hexaware.ftp49.model.LeaveStatus;
import com.hexaware.ftp49.model.LeaveDetails;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;


/**
 * Mapper class to map from result set to employee object.
import com.hexaware.ftp49.model.LeaveDetails;
import com.hexaware.ftp49.model.LeaveStatus;
import com.hexaware.ftp49.model.LeaveType;
//import java.util.Date;
/**
 * Mapper class to map from result set to leave_details object.
 */
public class LeaveDetailsMapper implements ResultSetMapper<LeaveDetails> {
/**
 * @param idx the index
 * @param rs the resultset
 * @param ctx the context
 * @return the mapped leaveDetails object
 * @throws SQLException in case there is an error in fetching data from the resultset
 */
  public final LeaveDetails map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
  /**
   * @return LeaveDetails
   */
    return new LeaveDetails(rs.getInt("EMP_ID"),
                        rs.getInt("LEAVE_ID"),
                        rs.getDate("LEAVE_APPLIED_ON"),
                        rs.getInt("LEAVE_NO_OF_DAYS"),
                        rs.getDate("LEAVE_START_DATE"),
                        rs.getDate("LEAVE_END_DATE"),
                        LeaveType.valueOf(rs.getString("LEAVE_TYPE")),
                        rs.getString("LEAVE_REASON"),
                        LeaveStatus.valueOf(rs.getString("LEAVE_STATUS")),
                        rs.getString("LEAVE_MANAGER_COMMENTS"));
  }
}

