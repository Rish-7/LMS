package com.hexaware.ftp49.model;

import com.hexaware.ftp49.persistence.DbConnection;
import com.hexaware.ftp49.persistence.EmployeeDAO;

import java.util.Objects;
import java.util.List;
import java.util.Date;


/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

  /**
   * empId to store employee id.
   * empName to store employee name.
   * empEmail to store employee email.
   * empPhone to store employee phone.
   * empDoj to store employee date of joining.
   * empDept to store employee department.
   * empLeaveBal to store employee leave balance.
   * empMngrId to store employee manager id.
   */
  private int empId;
  private String empName;
  private String empEmail;
  private long empPhone;
  private Date empDoj;
  private String empDept;
  private int empLeaveBal;
  private int empMngrId;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId)
        && Objects.equals(empName, emp.empName)
        && Objects.equals(empEmail, emp.empEmail)
        && Objects.equals(empPhone, emp.empPhone)
        && Objects.equals(empDoj, emp.empDoj)
        && Objects.equals(empDept, emp.empDept)
        && Objects.equals(empLeaveBal, emp.empLeaveBal)
        && Objects.equals(empMngrId, emp.empMngrId)) {
      return true;
    }
    return false;
  }

  /**
  toString method.
   */
  @Override
  public final String toString() {
    return " Employee Id:" + empId + "Employee Name:" + empName + "Employee Email:" + empEmail
           + " Employee Phone:" + empPhone + "Employee Doj:" + empDoj + "Employee Department:" + empDept
           + " Employee Leave Balance:" + empLeaveBal + "Employee Manager Id:" + empMngrId;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, empName, empEmail, empPhone, empDoj, empDept, empLeaveBal, empMngrId);
  }

  /**
   * @param argEmpId to initialize employee id.
   */
  public Employee(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
  * @param argEmpId to initialize employee id.
  * @param argEmpName to initialize employee name.
  * @param argEmpEmail to initialize employee email.
  * @param argEmpPhone to initialize employee phone.
  * @param argEmpDoj to initialize employee doj.
  * @param argEmpDept to initialize employee Department.
  * @param argEmpLeaveBal to initialize employee Leave balance.
  * @param argEmpMngrId to initialize employee Manager id.
   */
  public Employee(final int argEmpId, final String argEmpName, final String argEmpEmail,
           final long argEmpPhone, final Date argEmpDoj,
           final String argEmpDept, final int argEmpLeaveBal, final int argEmpMngrId) {
    this.empId = argEmpId;
    this.empName = argEmpName;
    this.empEmail = argEmpEmail;
    this.empPhone = argEmpPhone;
    this.empDoj = argEmpDoj;
    this.empDept = argEmpDept;
    this.empLeaveBal = argEmpLeaveBal;
    this.empMngrId = argEmpMngrId;
  }
  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }

  /**
   * Gets the EmployeeName.
   * @return this Employee's Name.
   */
  public final String getEmpName() {
    return empName;
  }

  /**
   *
   * @param argEmpName to set employee name.
   */
  public final void setEmpName(final String argEmpName) {
    this.empName = argEmpName;
  }

  /**
   * Gets the EmployeeEmail.
   * @return this Employee's Email.
   */
  public final String getEmpEmail() {
    return empEmail;
  }

  /**
   *
   * @param argEmpEmail to set employee Email.
   */
  public final void setEmpEmail(final String argEmpEmail) {
    this.empEmail = argEmpEmail;
  }

  /**
   * Gets the EmployeePhone.
   * @return this Employee's Phone number.
   */
  public final long getEmpPhone() {
    return empPhone;
  }

  /**
   *
   * @param argEmpPhone to set employee Phone.
   */
  public final void setEmpPhone(final long argEmpPhone) {
    this.empPhone = argEmpPhone;
  }

  /**
   * Gets the EmployeeDoj.
   * @return this Employee's doj.
   */
  public final Date getEmpDoj() {
    return empDoj;
  }

  /**
   *
   * @param argEmpDoj to set employee doj.
   */
  public final void setEmpDoj(final Date argEmpDoj) {
    this.empDoj = argEmpDoj;
  }

  /**
   * Gets the EmployeeDepartment.
   * @return this Employee's Department.
   */
  public final String getEmpDept() {
    return empDept;
  }

  /**
   *
   * @param argEmpDept to set employee department.
   */
  public final void setEmpDept(final String argEmpDept) {
    this.empDept = argEmpDept;
  }

  /**
   * Gets the EmployeeLeaveBalance.
   * @return this Employee's Leave Balance.
   */
  public final int getEmpLeaveBal() {
    return empLeaveBal;
  }

  /**
   *
   * @param argEmpLeaveBal to set employee leave balance.
   */
  public final void setEmpLeaveBal(final int argEmpLeaveBal) {
    this.empLeaveBal = argEmpLeaveBal;
  }

  /**
   * Gets the EmployeeManagerId.
   * @return this Employee's Manager ID.
   */
  public final int getEmpMngrId() {
    return empMngrId;
  }

  /**
   *
   * @param argEmpMngrId to set employee manager id.
   */
  public final void setEmpMngrId(final int argEmpMngrId) {
    this.empMngrId = argEmpMngrId;
  }

  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details.
   */
  public static Employee[] listAll() {

    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee.
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }

  /**
   * list employee details by id.
   * @param mngrId id to get employee details.
   * @return Employee.
   */

  public static Employee listempId(final int mngrId) {
    return dao().find(mngrId);
  }

  /**
   * list employee details by id.
   * @param empMngrId id to get employee details.
   * @return Employee
   */
  public static Employee listId(final int empMngrId) {
    return dao().find4(empMngrId);
  }

  /**
   * list employee details by id.
   * @param mgrId id to get employee details.
   * @return Employee
   */
  public static Employee listByMid(final int mgrId) {
    Employee emgr = Employee.dao().findd(mgrId);
    return emgr;
  }
}
