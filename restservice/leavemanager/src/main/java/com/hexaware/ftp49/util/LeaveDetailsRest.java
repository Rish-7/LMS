// package com.hexaware.ftp49.util;
// import javax.ws.rs.POST;
// import javax.ws.rs.GET;
// //import javax.ws.rs.NotFoundException;
// import javax.ws.rs.Path;
// import javax.ws.rs.PathParam;
// import java.text.ParseException;
// import javax.ws.rs.Produces;
// import javax.ws.rs.Consumes;
// //import java.util.Date;
// import javax.ws.rs.core.MediaType;

// import com.hexaware.ftp49.model.LeaveDetails;

// /**
//  * This class provides a REST interface for the LeaveDetails entity.
//  */
// @Path("/leavedetailsrest")
// public class LeaveDetailsRest {
//     /**
//     * Returns a specific employee's leave details.
//     * @param empId the id of the employee
//     * @return the employee's leave details
//     */

//   @GET
//     @Produces (MediaType.APPLICATION_JSON)
//     @Path("/data/{empid}")
//     public final LeaveDetails[] historyData(@PathParam("empid")final int empId) {
//     LeaveDetails lv = new LeaveDetails();
//     LeaveDetails[] lvs = lv.listById(empId);
//     return lvs;
//   }

//   /**
//    * Returns pending leaves.
//    * @param empMngrId the id of the employee
//    * @return the employee details
//    */
//   @GET
//   @Path("/datafetch/{empMngrId}")
//   @Produces(MediaType.APPLICATION_JSON)
//   public final LeaveDetails[] getFetch(@PathParam("empMngrId") final int empMngrId) {
//     final LeaveDetails[] ld = LeaveDetails.pending(empMngrId);
//     return ld;
//   }

//   /**
//    * Returns a specific leave's details.
//    * @param leaveId the id of the leave
//    * @param ld the details of the leave
//    * @return the leaves status
//    */
//   @POST
//   @Consumes(MediaType.APPLICATION_JSON)
//   @Produces(MediaType.APPLICATION_JSON)
//   @Path("/update/{LEAVE_ID}")
//   public final String appUpdateData(@PathParam("LEAVE_ID")final int leaveId, final LeaveDetails ld) {
//     LeaveDetails appdny = new LeaveDetails();
//     String g = appdny.verification(leaveId, ld.getLeaveStatus(), ld.getLeaveManagerComments());
//     return g;
//   }

//    /**
//    * Updates a list of all the employees.
//    * @param empId the id of the employee
//    * @param lev updates the leavedetails
//    * @return a updation of all the employees
//    */
//   @POST
//   @Produces(MediaType.APPLICATION_JSON)
//   @Consumes(MediaType.APPLICATION_JSON)
//   @throws ParseException.
//   @Path("/Updation/{empId}")
//   public final String updateData(@PathParam("empId") final int empId, final LeaveDetails lev) throws ParseException {
//     LeaveDetails ld = new LeaveDetails();
//     String l = ld.updateDetails(empId, lev.getLeaveId(), lev.getLeaveAppliedOn(),
//         lev.getLeaveDaysLeft(), lev.getLeaveStartDate(), lev.getLeaveEndDate(), lev.getLeaveType(),
//         lev.getLeaveReason(), lev.getLeaveStatus(), lev.getLeaveManagerComments());
//     System.out.println("rest retrns:" + l);
//     return l;

//   }

//    /**
//    * Returns a list of all the LeaveDetails.
//    * @param l the enddate of the leaveapplied
//    * @throws ParseException leavedetails
//    * @return a list of all the LeaveDetails
//    */
//   @POST
//   @Produces(MediaType.APPLICATION_JSON)
//   @Consumes(MediaType.APPLICATION_JSON)
//   @Path("/insertdata")
//     public final long postgetdata(final LeaveDetails l) throws ParseException {
//     LeaveDetails lb = new LeaveDetails();
//     long lev = lb.getDates(l.getLeaveStartDate(), l.getLeaveEndDate());
//     return lev;

//   }
// }

package com.hexaware.ftp49.util;

//import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.text.ParseException;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
//import java.util.Date;
import javax.ws.rs.core.MediaType;

import com.hexaware.ftp49.model.LeaveDetails;

/**
 * This class provides a REST interface for the LeaveDetails entity.
 */
@Path("/leavedetailsrest")
public class LeaveDetailsRest {
    /**
    * Returns a specific employee's leave details.
    * @param empId the id of the employee
    * @return the employee's leave details
    */

  @GET
    @Produces (MediaType.APPLICATION_JSON)
    @Path("/data/{empId}")
    public final LeaveDetails[] historyData(@PathParam("empId")final int empId) {
    LeaveDetails lv = new LeaveDetails();
    LeaveDetails[] lvs = lv.listById(empId);
    return lvs;
  }

  /**
   * Returns pending leaves.
   * @param empMngrId the id of the employee
   * @return the employee details
   */
  @GET
  @Path("/datafetch/{empMngrId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] getFetch(@PathParam("empMngrId") final int empMngrId) {
    final LeaveDetails[] ld = LeaveDetails.pending(empMngrId);
    return ld;
  }

  /**
   * Returns a specific leave's details.
   * @param leaveId the id of the leave
   * @param ld the details of the leave
   * @return the leaves status
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/update/{LEAVE_ID}")
  public final String appUpdateData(@PathParam("LEAVE_ID")final int leaveId, final LeaveDetails ld) {
    LeaveDetails appdny = new LeaveDetails();
    String g = appdny.verification(leaveId, ld.getLeaveStatus(), ld.getLeaveManagerComments());
    return g;
  }

   /**
   * Updates a list of all the employees.
   * @param empId the id of the employee
   * @param lev updates the leavedetails
   * @return a updation of all the employees
   * @throws ParseException a .
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/Updation/{empId}")
  public final String updateData(@PathParam("empId") final int empId, final LeaveDetails lev) throws ParseException {
    LeaveDetails ld = new LeaveDetails();
    String l = ld.updateDetails(empId, lev.getLeaveId(), lev.getLeaveAppliedOn(),
        lev.getLeaveDaysLeft(), lev.getLeaveStartDate(), lev.getLeaveEndDate(), lev.getLeaveType(),
        lev.getLeaveReason(), lev.getLeaveStatus(), lev.getLeaveManagerComments());
    System.out.println("rest retrns:" + l);
    return l;

  }

   /**
   * Returns a list of all the LeaveDetails.
   * @param l the enddate of the leaveapplied
   * @throws ParseException leavedetails
   * @return a list of all the LeaveDetails
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Path("/insertdata")
    public final long postgetdata(final LeaveDetails l) throws ParseException {
    LeaveDetails lb = new LeaveDetails();
    long lev = lb.getDates(l.getLeaveStartDate(), l.getLeaveEndDate());
    return lev;

  }
}
