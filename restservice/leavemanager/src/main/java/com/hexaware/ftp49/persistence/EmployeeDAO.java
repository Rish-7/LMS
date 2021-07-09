package com.hexaware.ftp49.persistence;

import com.hexaware.ftp49.model.Employee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * The DAO class for employee.
 */
public interface EmployeeDAO  {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEE")
  @Mapper(EmployeeMapper.class)
  List<Employee> list();

  /**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee find(@Bind("empID") int empID);

/**
   * return all the details of the selected manager.
   * @param mgrId the id of the manager.
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_MANAGER_ID = :mgrId")
  @Mapper(EmployeeMapper.class)
  Employee findd(@Bind("mgrId") int mgrId);
  /**
   * return all the details of the selected employee.
   * @param empMngrId the id of the employee.
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_MANAGER_ID=:EMP_MANAGER_ID")
  @Mapper(EmployeeMapper.class)
  Employee find4(@Bind("EMP_MANAGER_ID") int empMngrId);

  /**
   * return the Name of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT EMP_NAME FROM EMPLOYEE WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee find1(@Bind("empID") int empID);

  /**
   * return all the details of the selected employee.
   * @param empid the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT EMP_LEAVE_BAL FROM EMPLOYEE WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  int find2(@Bind("empID") int empid);
}




