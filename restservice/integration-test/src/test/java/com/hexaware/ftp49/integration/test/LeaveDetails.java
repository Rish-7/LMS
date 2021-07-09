package com.hexaware.ftp49.integration.test;
import java.util.Objects;
import java.util.List;
import java.util.Date;
import java.text.ParseException;
import java.util.Calendar;

/**
 * LeaveDetails class to store personal details.
 * @author hexware
 */

public class LeaveDetails 
{ 
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
  LeaveDetails() {
    
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
}
