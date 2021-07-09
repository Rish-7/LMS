package com.hexaware.ftp49.model;

import com.hexaware.ftp49.persistence.DbConnection;
import com.hexaware.ftp49.persistence.LeaveDetailsDAO;

import java.util.Objects;
import java.util.List;
import java.util.Date;
import java.text.ParseException;
import java.util.Calendar;

/**
 * LeaveDetails class to store personal details.
 * @author hexware
 */
public class LeaveDetails {
  /**
 * Default.
 */
  public LeaveDetails() {

  }
  /**
   * empId to store employee id.
   * leaveId to store leave id.
   * leaveApplyDate to store leave apply date.
   * leaveNoOfDays to store leave no of days.
   * leaveStartDate to store leave start date.
   * leaveEndDate to store leave end date.
   * leaveType to store leave type.
   * leaveReason to store leave reason.
   * leaveStatus to store leave status.
   * leaveMngrCmnts to store leave manager comments.
   */
  private int empId;
  private int leaveId;
  private Date leaveAppliedOn;
  private int leaveDaysLeft;
  private Date leaveStartDate;
  private Date leaveEndDate;
  private LeaveType leaveType;
  private String leaveReason;
  private LeaveStatus leaveStatus;
  private String leaveManagerComments;
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails lev = (LeaveDetails) obj;
    if (Objects.equals(empId, lev.empId) && Objects.equals(leaveId, lev.leaveId)
        && Objects.equals(leaveAppliedOn, lev.leaveAppliedOn)
        && Objects.equals(leaveDaysLeft, lev.leaveDaysLeft)
        && Objects.equals(leaveStartDate, lev.leaveStartDate)
        && Objects.equals(leaveEndDate, lev.leaveEndDate)
        && Objects.equals(leaveType, lev.leaveType)
        && Objects.equals(leaveReason, lev.leaveReason)
        && Objects.equals(leaveStatus, lev.leaveStatus)
        && Objects.equals(leaveManagerComments, lev.leaveManagerComments)) {
      return true;
    }
    return false;
  }

  /**
   *toString method.
   */
  @Override
  public final String toString() {
    return "EmpId : " + empId + "leaveId : " + leaveId + "Applied on : " + leaveAppliedOn
      + "leave Days left : " + leaveDaysLeft
      + "leave Start Date : " + leaveStartDate + "Leave End Date : " + leaveEndDate
      + "Leave Type : " + leaveType + "Leave Reason : " + leaveReason
      + "leave Status : " + leaveStatus + "Leave Manager Comments : " + leaveManagerComments;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, leaveId,  leaveAppliedOn, leaveDaysLeft, leaveStartDate, leaveEndDate,
     leaveType, leaveReason, leaveStatus, leaveManagerComments);
  }

  /**
   * @param argEmpId to initialize employee id.
   */
  public LeaveDetails(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   * @param argEmpId to initialize  Empid.
   * @param argLeaveId to set Leave ID.
   * @param argLeaveAppliedOn to set Leave applied On.
   * @param argLeaveDaysLeft to set Leave No of days.
   * @param argLeaveStartDate to set Leave StartDate.
   * @param argLeaveEndDate to set Leave End Date.
   * @param argLeaveType to set Leave Type.
   * @param argLeaveReason to set Leave Reason.
   * @param argLeaveStatus to set Leave Status.
   * @param argLeaveManagerComments to set Leave Manager comments.
   */
  public LeaveDetails(final int argEmpId, final int argLeaveId, final Date argLeaveAppliedOn,
      final int argLeaveDaysLeft, final Date argLeaveStartDate, final Date argLeaveEndDate,
      final LeaveType argLeaveType, final String argLeaveReason,
      final LeaveStatus argLeaveStatus, final String argLeaveManagerComments) {
    this.empId = argEmpId;
    this.leaveId = argLeaveId;
    this.leaveAppliedOn = argLeaveAppliedOn;
    this.leaveDaysLeft = argLeaveDaysLeft;
    this.leaveStartDate = argLeaveStartDate;
    this.leaveEndDate = argLeaveEndDate;
    this.leaveType = argLeaveType;
    this.leaveReason = argLeaveReason;
    this.leaveStatus = argLeaveStatus;
    this.leaveManagerComments = argLeaveManagerComments;
  }
  /**
   * Gets the employee Id.
   * @return this employee ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   * Gets the leave id.
   * @return this leave id.
   */
  public final int getLeaveId() {
    return leaveId;
  }

  /**
   * @param argLeaveId to set leave id.
   */
  public final void setLeaveId(final int argLeaveId) {
    this.leaveId = argLeaveId;
  }

  /**
   * Gets the Leave Applied On.
   * @return this Leave Applied On.
   */
  public final Date getLeaveAppliedOn() {
    return leaveAppliedOn;
  }

  /**
   * @param argLeaveAppliedOn to set Leave Applied On.
   */
  public final void setLeaveAppliedOn(final Date argLeaveAppliedOn) {
    this.leaveAppliedOn = argLeaveAppliedOn;
  }

  /**
   * Gets the Leave Days Left.
   * @return this Leave Days Left.
   */
  public final int getLeaveDaysLeft() {
    return leaveDaysLeft;
  }

  /**
   * @param argLeaveDaysLeft to set Leave Days Left.
   */
  public final void setLeaveDaysLeft(final int argLeaveDaysLeft) {
    this.leaveDaysLeft = argLeaveDaysLeft;
  }

  /**
   * Gets the Leave start date.
   * @return this Leave start date.
   */
  public final Date getLeaveStartDate() {
    return leaveStartDate;
  }

  /**
   * @param argLeaveStartDate to set Leave start date.
   */
  public final void setLeaveStartDate(final Date argLeaveStartDate) {
    this.leaveStartDate = argLeaveStartDate;
  }
  /**
   * Gets the Leave end date.
   * @return this Leave end date.
   */
  public final Date getLeaveEndDate() {
    return leaveEndDate;
  }

  /**
   * @param argLeaveEndDate to set Leave end date.
   */
  public final void setLeaveEndDate(final Date argLeaveEndDate) {
    this.leaveEndDate = argLeaveEndDate;
  }

  /**
   * Gets the Leave Type.
   * @return this Leave type.
   */
  public final LeaveType getLeaveType() {
    return leaveType;
  }

  /**
   * @param argLeaveType to set Leave type.
   */
  public final void setLeaveType(final LeaveType argLeaveType) {
    this.leaveType = argLeaveType;
  }

  /**
   * Gets the Leave reason.
   * @return this Leave reason.
   */
  public final String getLeaveReason() {
    return leaveReason;
  }

  /**
   * @param argLeaveReason to set leave Reason.
   */
  public final void setLeaveReason(final String argLeaveReason) {
    this.leaveReason = argLeaveReason;
  }

  /**
   * Gets the Leave status.
   * @return this Leave status.
   */
  public final LeaveStatus getLeaveStatus() {
    return leaveStatus;
  }

  /**
   * @param argLeaveStatus to set Leave status.
   */
  public final void setLeaveStatus(final LeaveStatus argLeaveStatus) {
    this.leaveStatus = argLeaveStatus;
  }

  /**
   * Gets the Leave mngr Cmnts.
   * @return this Leave mngr Cmnts.
   */
  public final String getLeaveManagerComments() {
    return leaveManagerComments;
  }

  /**
   * @param argLeaveManagerComments to set Leave mngr Cmnts.
   */
  public final void setLeaveManagerComments(final String argLeaveManagerComments) {
    this.leaveManagerComments = argLeaveManagerComments;
  }

  /**
   * The dao for LeaveDetails.
   */
  private static LeaveDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDetailsDAO.class);
  }

  /**
   * The fetch for LeaveDetails.
   * @return array.
   */
  public static LeaveDetails[] fetch() {
    List<LeaveDetails> es = dao().listById();
    return es.toArray(new LeaveDetails[es.size()]);
  }

  /**
   * list employee pending details.
   * @param leaveId  to update leave id.
   * @param result to update leave status.
   * @param comment to update manager comments.
   * @return updated
   */
  public static String verification(final int leaveId, final LeaveStatus result, final String comment) {
    dao().update(leaveId, result, comment);
    return "updated";
  }

  /**
   * list leaveid  details by leaveid.
   * @param leaveId id to get leavedetail.
   * @param mgrId to get manager detail.
   * @return LeaveDetail
   */
  public static LeaveDetails listById1(final int leaveId, final int mgrId) {
    return dao().findd(leaveId, mgrId);
  }

  /**
* @param empMngrId to get pending leaves.
* @return pending leave
*/
  public static LeaveDetails[] pending(final int empMngrId) {
    List<LeaveDetails> ld = dao().listPendingLeave(empMngrId);
    return ld.toArray(new LeaveDetails[ld.size()]);
  }

   /**
   * @throws ParseException date.
   * @param sd .
   * @param ed .
   * @return n
   */
  public static long getDates(final Date sd, final Date ed) throws ParseException {
    Date dt = new Date();
    long num = 0;
    if (sd.before(dt) || ed.before(dt)) {
      System.out.println("Leave Dates should be after today's Date");
    } else {
      if (sd.getTime() > ed.getTime()) {
        System.out.println("End Date comes before Start Date");
      }
      if (sd.getTime() == ed.getTime()) {
        System.out.println("Number of Day Applied : 1");
        return 1;
      }
      Calendar s = Calendar.getInstance();
      s.setTime(sd);
      Calendar e = Calendar.getInstance();
      e.setTime(ed);
      if (s.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
          && s.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
        ++num;
      }
      do {
        s.add(Calendar.DAY_OF_MONTH, 1); //excluding start date
        if (s.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
            && s.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
          ++num;
        }
      }
        while (s.getTimeInMillis() < e.getTimeInMillis());
      System.out.println("Number of Days :  " + num);
    }
    return num;

  }
  /**
  * @param empid to list all emp.
  * @param leaveid to list emp leave.
  * @param dt to get todays Date.
  * @param reason to list all reason.
  * @param type to list all type.
  * @param sd to get start date.
  * @param ed to get end date.
  * @param status to get LT.
  * @param num to get balance.
  * @param status1 to get LeaveStatus.
  * @return leavedetails updated.
  * @throws ParseException a.
  */

  public final String updateDetails(final int empid, final int leaveid, final Date dt, final long num,
       final Date sd, final Date ed, final LeaveType type,
      final String reason, final LeaveStatus status, final String status1) throws ParseException {
    long n = getDates(sd, ed);
    System.out.println("nod:" + n);
    if (empid == 1000) {
      //dao().insertData(empid, num, sd, ed, type, reason);
      dao().insertData(empid, leaveid, dt, num, sd, ed, type, reason, LeaveStatus.PENDING, status1);
    } else {
      //dao().insertData(empid, num, sd, ed, type, reason);
      dao().insertData(empid, leaveid, dt, n, sd, ed, type, reason, LeaveStatus.PENDING, status1);
    }
    return "LeaveDetails Updated";
  }

  /**
   * list all leave details.
   * @param empId id to get Leave details.
   * @return all LeaveDetails
   */
  public static LeaveDetails[] listById(final int empId) {
    List<LeaveDetails> es = dao().find(empId);
    return es.toArray(new LeaveDetails[es.size()]);
  }

  /**
   * list all leave details.
   * @return all LeaveDetails
   */
  public static LeaveDetails[] listById1() {
    List<LeaveDetails> es = dao().listById();
    return es.toArray(new LeaveDetails[es.size()]);
  }

}

