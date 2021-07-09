package com.hexaware.ftp49.util;
import java.util.Scanner;
import com.hexaware.ftp49.model.LeaveDetails;
import com.hexaware.ftp49.model.LeaveStatus;
import com.hexaware.ftp49.model.LeaveType;
import java.util.InputMismatchException;
import java.util.Date;

import com.hexaware.ftp49.model.Employee;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  private void mainMenu() {
    System.out.println("Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. List All Employees Info");
    System.out.println("2. Display Employee Info");
    System.out.println("3. Apply For Leave Info ");
    System.out.println("4. Approval Or Denial by Manager");
    System.out.println("5. List Of Pending Applications");
    System.out.println("6. Leave History");
    System.out.println("7. Exit");
    System.out.println("Enter your choice:");
    int menuOption = option.nextInt();
    mainMenuDetails(menuOption);
  }
  private void mainMenuDetails(final int selectedOption) {
    switch (selectedOption) {
      case 1:
        listEmployeesDetails();
        break;
      case 2:
        listEmployeeDetail();
        break;
      case 3:
        applyForLeaveInfo();
        break;
      case 4:
        approvalOrDenial();
        break;
      case 5:
        listPendingLeave();
        break;
      case 6:
        listleaveHistory();
        break;
      case 7:
        // halt since normal exit throws a stacktrace due to jdbc threads not responding
        Runtime.getRuntime().halt(0);
      default:
        System.out.println("Choose your choice:");
    }
    mainMenu();
  }
  private void listEmployeeDetail() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("Sorry, No such employee");
    } else {
      System.out.println("  ");
      System.out.println(employee.getEmpId() + "   " + employee.getEmpName() + "   " + employee.getEmpEmail()
          + "   " + employee.getEmpPhone() + "   " + employee.getEmpDoj() + "   " + employee.getEmpDept()
          + "   " + employee.getEmpLeaveBal() + "   " + employee.getEmpMngrId());
      System.out.println(" ");
    }
  }
  private void listEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    for (Employee e : employee) {
      System.out.println(" ");
      System.out.println(e.getEmpId() + "   " + e.getEmpName() + "   " + e.getEmpEmail()
          + "   " + e.getEmpPhone() + "   " + e.getEmpDoj() + "   " + e.getEmpDept()
          + "   " + e.getEmpLeaveBal() + "   " + e.getEmpMngrId());
      System.out.println(" ");
    }
  }

  private void approvalOrDenial() {
    System.out.println("Enter manager id");
    int mgrId = option.nextInt();
    Employee emp = Employee.listByMid(mgrId);
    if (emp == null) {
      System.out.println("Invalid Manager Id");
    } else {
      System.out.println("enter the leave id");
      int leaveId = option.nextInt();
      LeaveDetails leavedetail = LeaveDetails.listById1(leaveId, mgrId);
      if (leavedetail == null) {
        System.out.println("No Such Leave Id");
      } else {
        System.out.println("enter Approved/Denied/Pending");
        String choice = option.next().toUpperCase();
        LeaveStatus result = LeaveStatus.valueOf(choice);
        System.out.println("enter the manager comment");
        String comment = option.next();
        LeaveDetails.verification(leaveId, result, comment);
        System.out.println("LeaveStatus changed to :" + result);
      }
    }
  }

  private void listPendingLeave() throws InputMismatchException {
    try {
      System.out.println("Enter the Manager ID: ");
      int empMngrId = option.nextInt();
      Employee employee = Employee.listId(empMngrId);
      if (employee != null) {
        LeaveDetails[] list = LeaveDetails.pending(empMngrId);
        if (list.length == 0) {
          System.out.println("No pending leave");
        } else {
          System.out.println("EmpId" + "\t" + "LeaveId" + "  " + "LeaveNoOfDays"
                + "\t" + "LeaveStartDate" + "\t" + "LeaveEndDate" + "\t" + "LeaveType"
                + "\t" + "LeaveReason" + "\t\t" + "LeaveStatus");
          for (LeaveDetails emp : list) {

            System.out.println("                       ");
            System.out.println(emp.getEmpId() + "\t" + emp.getLeaveId()
                + "\t" + emp.getLeaveDaysLeft() + "\t\t" + emp.getLeaveStartDate()
                + "\t" + emp.getLeaveEndDate() + "\t" + emp.getLeaveType()
                + "\t\t" + emp.getLeaveReason() + "    \t\t" + emp.getLeaveStatus());
            System.out.println("                       ");
          }
        }
      } else {
        System.out.println("Sorry,No such manager");
        System.out.println("  ");
      }
    } catch (InputMismatchException e) {
      System.out.println("Enter a integer");
      System.out.println("   ");
      option.nextLine();
    }
  }

  private void listleaveHistory() {

    try {
      int flag = 0;
      System.out.println("Enter an employee id : ");
      int empId = option.nextInt();
      LeaveDetails[] x = LeaveDetails.listById1();
      for (LeaveDetails employee : x) {
        if (empId == employee.getEmpId()) {
          flag++;
        }
      }
      LeaveDetails[] e = LeaveDetails.listById(empId);
      if (flag > 0) {

        System.out.println("EMP_ID" + "   " + "LEAVE_ID" + "   " + "LEAVE_APPLIED_ON"
              + "   " + "LEAVE_NO_OF_DAYS" + "   " + " LEAVE_START_DATE " + "   " + "LEAVE_END_DATE"
              + "   " + "LEAVE_TYPE" + "   " + "LEAVE_REASON" + "       " + "LEAVE_STATUS"
              + "              " + "LEAVE_MANAGER_COMMENTS");
        for (LeaveDetails employee : e) {
          System.out.println(employee.getEmpId() + "       " + employee.getLeaveId()
              + "       " + employee.getLeaveAppliedOn() + "             " + employee.getLeaveDaysLeft()
              + "               " + employee.getLeaveStartDate() + "           " + employee.getLeaveEndDate()
              + "         " + employee.getLeaveType() + "       " + employee.getLeaveReason()
              + "       " + employee.getLeaveStatus()
              + "       " + employee.getLeaveManagerComments());
          System.out.println(" ");
        }
      } else {
        System.out.println("No such employee or no such Leave history.");
      }
    } catch (InputMismatchException i) {
      System.out.println("Enter a integer.");
      option.nextLine();
    }
  }
    /**
   * Apply for Leave.
   * @throws ParseException declaration.
   */
  public final void applyForLeaveInfo() {
    try {
      System.out.println("Enter an Employee Id");
      int empid = option.nextInt();
      Employee emp = Employee.listById(empid);
      if (emp != null) {
        int leaveid = 0;
        int leavebal = emp.getEmpLeaveBal();
        System.out.println("Leave Balance : " + leavebal);
        System.out.println("Enter Start Date in dd/MM/yyyy:");
        String startdate = option.next();
        System.out.println("Enter End Date in dd/MM/yyyy:");
        String enddate = option.next();
        SimpleDateFormat df =  new SimpleDateFormat("dd/MM/yyyy");
        Date sd = df.parse(startdate);
        Date ed = df.parse(enddate);
        long dates = LeaveDetails.getDates(sd, ed);
        LeaveDetails ld = new LeaveDetails();
        LeaveDetails[] e = LeaveDetails.listById(empid);
        for (LeaveDetails l : e) {
          if (sd.getTime() < l.getLeaveEndDate().getTime()) {
            System.out.println("OverLapping not allowd");
            final CliMain mainObjx = new CliMain();
            mainObjx.mainMenu();
          }
        }
        if (dates <= leavebal && leavebal != 0 && dates != 0) {
          System.out.println("Enter Reason of Leave: ");
          String reason = option.next();
          ld.setLeaveReason(reason);
          System.out.println("Enter Type of Leave ( el / EL):  ");
          String type = option.next();
          if (type.equals("EL") || type.equals("el")) {
            String status1 = " Leave Applied!";
            System.out.println("Manager Comments:" + status1);
            LeaveDetails l = new LeaveDetails();
            Date dt = new Date();
            //Date dt = new Date();
            //long num = 0;
            l.updateDetails(empid, leaveid, dt, dates, sd, ed, LeaveType.EL, reason,
                 LeaveStatus.APPROVED, status1);
                // l.updateDetails(empid, num, sd, ed, LeaveType.EL, reason);
          } else {
            System.out.println("Enter correct leave type");
          }
        } else {
          System.out.println(" Insufficient Leave Balance ");
        }
      } else {
        System.out.println("Employee not exists");
      }
    } catch (ParseException p) {
      System.out.println("Enter Date in Correct format  ");
    } catch (InputMismatchException i) {
      System.out.println("Enter Correct Input  ");
    }
  }

  /**
   * The main entry point.
   * @param ar the list of arguments
   */
  public static void main(final String[] ar) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}

