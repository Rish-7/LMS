package com.hexaware.ftp49.model;
import com.hexaware.ftp49.persistence.LeaveDetailsDAO;
import mockit.Mocked;
import mockit.MockUp;
import mockit.Expectations;
import java.util.ArrayList;
import mockit.Mock;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import java.text.SimpleDateFormat;

import java.text.ParseException;
import java.util.Date;

    /**
    * Test class for LeaveDetails.
    */
public class LeaveDetailsTest {
    /**
     * Tests the equals/hashcode methods of the leavedetails class.
     * @throws ParseException for parsing
     */

  @Test
  public final void testLeaveDetails() throws ParseException {
    String s1 = "2018-07-24";
    String s2 = "2018-09-23";
    String s3 = "2018-09-24";
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    Date d1 = sf.parse(s1);
    Date d2 = sf.parse(s2);
    Date d3 = sf.parse(s3);
    LeaveDetails ld200 = new LeaveDetails(5000, 123, d1, 2, d2, d3, LeaveType.EL,
        "SICK", LeaveStatus.APPROVED, "TAKE CARE");
    ld200.setEmpId(5000);
    assertEquals(5000, ld200.getEmpId());
    ld200.setLeaveId(123);
    assertEquals(123, ld200.getLeaveId());
    ld200.setLeaveAppliedOn(d1);
    assertEquals(d1, ld200.getLeaveAppliedOn());
    ld200.setLeaveDaysLeft(2);
    assertEquals(2, ld200.getLeaveDaysLeft());
    ld200.setLeaveStartDate(d2);
    assertEquals(d2, ld200.getLeaveStartDate());
    ld200.setLeaveEndDate(d3);
    assertEquals(d3, ld200.getLeaveEndDate());
    ld200.setLeaveType(LeaveType.EL);
    assertEquals(LeaveType.EL, ld200.getLeaveType());
    ld200.setLeaveReason("SICK");
    assertEquals("SICK",  ld200.getLeaveReason());
    ld200.setLeaveStatus(LeaveStatus.APPROVED);
    assertEquals(LeaveStatus.APPROVED,  ld200.getLeaveStatus());
    ld200.setLeaveManagerComments("TAKE CARE");
    assertEquals("TAKE CARE", ld200.getLeaveManagerComments());
    assertEquals("EmpId : " + ld200.getEmpId()
        + "leaveId : " + ld200.getLeaveId()
        + "Applied on : " + ld200.getLeaveAppliedOn()
        + "leave Days left : " +  ld200.getLeaveDaysLeft()
        + "leave Start Date : " + ld200.getLeaveStartDate()
        + "Leave End Date : " + ld200.getLeaveEndDate()
        + "Leave Type : " + ld200.getLeaveType()
        + "Leave Reason : " +  ld200.getLeaveReason()
        + "leave Status : " + ld200.getLeaveStatus()
        + "Leave Manager Comments : " + ld200.getLeaveManagerComments(), ld200.toString());
    assertEquals(new LeaveDetails(5000, 123, d1, 2, d2, d3, LeaveType.EL, "SICK",
        LeaveStatus.APPROVED, "TAKE CARE").hashCode(), ld200.hashCode());

  }
  /**
     * Tests the equals/hashcode methods of the leavedetails class.
     * @param dao return updateDetails.
     * @throws ParseException gg.
     */

  @Test
  public final  void testupdateDetails(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    String s1 = "27/07/2019";
    String s2 = "23/09/2019";
    String s3 = "24/09/2019";
    SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
    final Date d1 = sf.parse(s1);
    final Date d2 = sf.parse(s2);
    final Date d3 = sf.parse(s3);
    new Expectations() {
        {
          dao.insertData(1000, 100, d1, 2, d2, d3, LeaveType.EL, "Sick",
              LeaveStatus.APPROVED, "applied");
        }
    };
    new MockUp<LeaveDetails>() {
        @Mock
        LeaveDetailsDAO dao() {
            return dao;
        }
    };
    LeaveDetails ledt = new LeaveDetails(2000, 200, d1, 2, d2, d3, LeaveType.EL, "Sick",
        LeaveStatus.APPROVED, "applied");
    String s = ledt.updateDetails(1000, 100, d1, 2, d2, d3, LeaveType.EL, "Sick",
        LeaveStatus.APPROVED, "applied");
    assertEquals("LeaveDetails Updated", s);
  }

  /**
     * Tests the apply for leave method of the leavedetails class.
     * @throws ParseException gg.
     */
  @Test
  public final void testApplyForLeaveInfo() throws ParseException {
    String s1 = "01/09/2018";
    String s2 = "01/09/2018";
    String s3 = "27/09/2018";
    String s4 = "25/09/2018";
    String s5 = "27/08/2018";
    String s6 = "30/08/2018";
    SimpleDateFormat df =  new SimpleDateFormat("dd/MM/yyyy");
    Date sd = df.parse(s1);
    Date ed = df.parse(s2);
    Date sd1 = df.parse(s3);
    Date ed1 = df.parse(s4);
    Date sd2 = df.parse(s5);
    Date ed2 = df.parse(s6);
    LeaveDetails lev = new LeaveDetails();
    assertEquals(1, lev.getDates(sd, ed));
    assertEquals(2, lev.getDates(sd1, ed1));
    assertEquals(4, lev.getDates(sd2, ed2));
  }
     /**
     * Tests the apply for leave method of the leavedetails class.
     * @param dao mocking the dao class.
     * @throws ParseException hh.
     */
  @Test
  public final void testListById(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    LeaveDetails l100 = new LeaveDetails(5000);
    new Expectations() {
      {
        ArrayList<LeaveDetails> list = new ArrayList<LeaveDetails>();
        list.add(new LeaveDetails(5000));
        dao.find(5000);
        result = list;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails l = new LeaveDetails(5000);
    LeaveDetails[] lv = l.listById(5000);
    LeaveDetails[] lvs = new LeaveDetails[1];
    lvs[0] = new LeaveDetails(5000);
    assertArrayEquals(lvs, lv);
  }

   /**
     * Tests the equals/hashcode methods of the leavedetails class.
     * @throws ParseException gg.
     * @param dao mocking the dao class
     */


  @Test
  public final void testPendingLeaves(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    String s1 = "2018-07-24";
    String s2 = "2018-07-25";
    String s3 = "2018-07-27";

    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Date d1 = sf.parse(s1);
    final Date d2 = sf.parse(s2);
    final Date d3 = sf.parse(s3);

    new Expectations() {
      {
        ArrayList<LeaveDetails> list = new ArrayList<LeaveDetails>();
        list.add(new LeaveDetails(2000, 200,  d1,  3,  d2, d3, LeaveType.EL, "sick",
            LeaveStatus.PENDING, "project"));
        list.add(new LeaveDetails(2001, 300,  d1,  3,  d2, d3, LeaveType.EL, "diwali",
            LeaveStatus.PENDING, "noleave"));
        dao.listPendingLeave(1000);
        result = list;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;

      }
    };
    LeaveDetails lev = new LeaveDetails();
    LeaveDetails[] tr = lev.pending(1000);
    LeaveDetails[] t = new LeaveDetails[2];
    t[0] = new LeaveDetails(2000, 200,  d1,  3,  d2, d3, LeaveType.EL, "sick",
            LeaveStatus.PENDING, "project");
    t[1] = new LeaveDetails(2001, 300,  d1,  3,  d2, d3, LeaveType.EL, "diwali",
            LeaveStatus.PENDING, "noleave");
    assertArrayEquals(t, tr);

  }
/**
     * Tests the equals/hashcode methods of the leavedetails class.
     * @param dao mocking the dao class.
     * @throws ParseException used for parsing
     */
  @Test
  public final void testLeaveHistory(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    final Employee e300 = new Employee(300);
    String s1 = "2018-07-24";
    String s2 = "2018-09-23";
    String s3 = "2018-09-24";
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Date d1 = sf.parse(s1);
    final Date d2 = sf.parse(s2);
    final Date d3 = sf.parse(s3);

    new Expectations() {
      {
        ArrayList<LeaveDetails> list = new ArrayList<LeaveDetails>();
        list.add(new LeaveDetails(100, 200, d1, 5, d2, d3, LeaveType.EL, "sick", LeaveStatus.PENDING,
             "leave Applied"));
        list.add(new LeaveDetails(100, 201, d1, 10, d2, d3, LeaveType.EL, "not well", LeaveStatus.PENDING,
             "leave Applied"));
        list.add(new LeaveDetails(100, 202, d1, 15, d2, d3, LeaveType.EL, "Marriage", LeaveStatus.APPROVED,
             "leave Applied"));
        list.add(new LeaveDetails(100, 203, d1, 6, d2, d3, LeaveType.EL, "Headache", LeaveStatus.APPROVED,
             "leave Applied"));
        list.add(new LeaveDetails(100, 204, d1, 7, d2, d3, LeaveType.EL, "Vacation", LeaveStatus.PENDING,
             "leave Applied"));
        dao.listById();
        result = list;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
          return dao;
      }
    };

    LeaveDetails l = new LeaveDetails(100, 200, d1, 5, d2, d3, LeaveType.EL, "sick", LeaveStatus.PENDING,
         "leave Applied");
    LeaveDetails[] ld = l.fetch();
    LeaveDetails[] ls = new LeaveDetails[5];
    ls[0] = new LeaveDetails(100, 200, d1, 5, d2, d3, LeaveType.EL, "sick", LeaveStatus.PENDING,
         "leave Applied");
    ls[1] = new LeaveDetails(100, 201, d1, 10, d2, d3, LeaveType.EL, "not well", LeaveStatus.PENDING,
         "leave Applied");
    ls[2] = new LeaveDetails(100, 202, d1, 15, d2, d3, LeaveType.EL, "Marriage", LeaveStatus.APPROVED,
         "leave Applied");
    ls[3] = new LeaveDetails(100, 203, d1, 6, d2, d3, LeaveType.EL, "Headache", LeaveStatus.APPROVED,
         "leave Applied");
    ls[4] = new LeaveDetails(100, 204, d1, 7, d2, d3, LeaveType.EL, "Vacation", LeaveStatus.PENDING,
         "leave Applied");
    assertArrayEquals(ls, ld);
  }

  /**
   * Tests that a fetch of a specific manager works correctly.
   * @param dao mocking the dao class
   * @throws ParseException used for parsing
   */
  @Test
  public final void testListById1(@Mocked final LeaveDetailsDAO dao) throws ParseException {
    String s1 = "2018-07-10";
    String s2 = "2018-09-23";
    String s3 = "2018-09-24";
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final LeaveDetails e200 = new LeaveDetails(3000, 400, sf.parse(s1), 2, sf.parse(s2), sf.parse(s3),
        LeaveType.EL, "HEADACHE", LeaveStatus.DENIED, "LEAVE DENIED");
    new Expectations() {
      {
        dao.findd(400, 2000);
        result = e200;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails e = LeaveDetails.listById1(400, 2000);
    assertEquals(new LeaveDetails(3000, 400, sf.parse(s1), 2, sf.parse(s2), sf.parse(s3),
        LeaveType.EL, "HEADACHE", LeaveStatus.DENIED, "LEAVE DENIED"), e);
  }

  /**
   * Tests that a fetch of a specific manager works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testVerification(@Mocked final LeaveDetailsDAO dao)  {
    new Expectations() {
      {
        dao.update(400, LeaveStatus.APPROVED, "TAKE CARE");
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails leev = new LeaveDetails();
    String e = leev.verification(400, LeaveStatus.APPROVED, "TAKE CARE");
    assertEquals("updated", e);
  }
}
