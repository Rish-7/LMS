package com.hexaware.ftp49.persistence;

import  com.hexaware.ftp49.model.LeaveDetails;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
//import com.hexaware.ftp49.model.LeaveDetails;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
//import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.Date;
import java.util.List;
import com.hexaware.ftp49.model.LeaveType;
import com.hexaware.ftp49.model.LeaveStatus;

/**
 * The DAO class for LeaveDetails.
 * The DAO class for employee.
 */
public interface LeaveDetailsDAO  {
 /**
   * return all the details of the selected applied leave id.
   * @param leaveId the id of the leave.
   * @param mgrId the id of the manager.
   * @return the employee object.
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE LEAVE_ID = :leaveId "
            + "and EMP_ID IN (SELECT EMP_ID FROM EMPLOYEE WHERE EMP_MANAGER_ID = :mgrId)")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails findd(@Bind("leaveId") int leaveId, @Bind("mgrId") int mgrId);


/**
   * update the status of the applied leave.
   * @param result for leave status.
   * @param comment for manager comment.
   * @param  leaveId for LeaveId.
   * @return status updation.
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEAVE_STATUS =:result,LEAVE_MANAGER_COMMENTS =:comment where LEAVE_ID =:leaveId")
  Integer update(@Bind("leaveId")int leaveId, @Bind("result") LeaveStatus result, @Bind("comment")String comment);

  /**
   * update available leave balance.
   *@param leaveId the id of employee.
   * @return leave balance.
  */
  @SqlUpdate("UPDATE EMPLOYEE SET EMP_LEAVE_BAL = EMP_LEAVE_BAL -"
       + "(SELECT LEAVE_NO_OF_DAYS FROM LEAVE_DETAILS WHERE LEAVE_ID =:leaveId) WHERE EMP_ID"
       + " = (SELECT EMP_ID FROM LEAVE_DETAILS WHERE LEAVE_ID =:leaveId);")
  @Mapper(LeaveDetailsMapper.class)
  Integer change(@Bind("leaveId")int leaveId);

  /**
   * update available leave balance.
   *@param leaveId the id of employee.
   * @return leave balance.
  */
  @SqlUpdate("UPDATE EMPLOYEE SET EMP_LEAVE_BAL = EMP_LEAVE_BAL +"
       + "(SELECT LEAVE_NO_OF_DAYS FROM LEAVE_DETAILS WHERE LEAVE_ID =:leaveId) WHERE EMP_ID"
       + " = (SELECT EMP_ID FROM LEAVE_DETAILS WHERE LEAVE_ID =:leaveId);")
  @Mapper(LeaveDetailsMapper.class)
  Integer modified(@Bind("leaveId")int leaveId);

  /**
   * insert all the leave details of the selected employee.
   * @param empId the id of the employee.
   * @param leaveid to get leave ID.
   * @param dt to get leave applied on.
   * @param num to get number of days applied.
   * @param sd to get start date.
   * @param ed to get end date.
   * @param type to get leave type.
   * @param reason to get leave reason.
   * @param status to get leave status.
   * @param status1 to get manager comments.
   */
  @SqlUpdate("INSERT INTO LEAVE_DETAILS (EMP_ID, LEAVE_ID, LEAVE_APPLIED_ON, "
          + "LEAVE_NO_OF_DAYS, LEAVE_START_DATE, LEAVE_END_DATE, LEAVE_TYPE, "
          + "LEAVE_REASON, LEAVE_STATUS, LEAVE_MANAGER_COMMENTS)"
          + "VALUES"
          + "(:EMPID, :LEAVE_ID, :LEAVE_APPLIED_ON, :LEAVE_NO_OF_DAYS, "
          + " :LEAVE_START_DATE, :LEAVE_END_DATE, :LEAVE_TYPE, "
          + " :LEAVE_REASON, :LEAVE_STATUS, :LEAVE_MANAGER_COMMENTS)")
  @Mapper(LeaveDetailsMapper.class)
  void insertData(
          @Bind("EMPID")int empId, @Bind("LEAVE_ID")int leaveid,
          @Bind("LEAVE_APPLIED_ON")Date dt, @Bind("LEAVE_NO_OF_DAYS")long num,
          @Bind("LEAVE_START_DATE")Date sd, @Bind("LEAVE_END_DATE")Date ed,
          @Bind("LEAVE_TYPE")LeaveType type, @Bind("LEAVE_REASON")String reason,
          @Bind("LEAVE_STATUS")LeaveStatus status, @Bind("LEAVE_MANAGER_COMMENTS")String status1);

  /**
   * return all the leave start date of the employee.
   * @return the leave_details array
   * @param empId to get employee id.s
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :empId AND LEAVE_STATUS NOT LIKE 'DENIED'")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> find1(@Bind("empId") int empId);

   /**
   * return all the details of the selected employee.
   * @param empMngrId the id of the employee.
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_MANAGER_ID=:EMP_MANAGER_ID")
  @Mapper(EmployeeMapper.class)
  LeaveDetails find4(@Bind("EMP_MANAGER_ID") int empMngrId);

  /**
   * return all the details of the selected employee.
   * @param empMngrId the id of the manager.
   * @return the pending leave
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS "
      + "WHERE LEAVE_STATUS='PENDING' AND EMP_ID "
      + "IN(SELECT EMP_ID FROM EMPLOYEE WHERE EMP_MANAGER_ID=:EMP_MANAGER_ID)")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> listPendingLeave(@Bind("EMP_MANAGER_ID") int empMngrId);

  /**
   * return all the leave details of all the employee.
   * @return the leave_details array
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> listById();

  /**
   * return all the details of the selected employee.
   * @param empId the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :empId")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> find(@Bind("empId") int empId);

}
