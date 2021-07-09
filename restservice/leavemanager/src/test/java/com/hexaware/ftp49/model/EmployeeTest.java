package com.hexaware.ftp49.model;

import com.hexaware.ftp49.persistence.EmployeeDAO;
import java.util.Date;
//import com.hexaware.ftp49.model.Employee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertNotNull;
import java.text.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.text.SimpleDateFormat;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.util.ArrayList;

/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class EmployeeTest {

  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }

  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testEmployee() {
    Employee e100 = new Employee(100);
    Employee e101 = new Employee(101);
    Date d1 = new Date();
    assertNotEquals(e100, null);
    assertNotEquals(e100, new Integer(100));
    assertEquals(e100, new Employee(100));
    assertNotEquals(e101, new Employee(100));
    assertEquals(e100.hashCode(), new Employee(100).hashCode());
    assertEquals(e100.getEmpId(), new Employee(100).getEmpId());
    e101.setEmpId(100);
    Employee e300 = new Employee(5000, "Rishabh", "Rish@gmail.com", 123456789L, d1, "HEXAVARSITY", 10, 100);
    assertEquals(e300, new Employee(5000, "Rishabh", "Rish@gmail.com", 123456789L, d1, "HEXAVARSITY", 10, 100));
    assertNotEquals(e300, null);
    assertEquals(e101, new Employee(100));
    assertEquals(new Employee(5000, "Rishabh", "Rish@gmail.com",
        123456789, d1, "HEXAVARSITY", 10, 100).hashCode(), e300.hashCode());

    assertEquals(5000, e300.getEmpId());
    e300.setEmpId(5000);
    assertEquals("Rishabh", e300.getEmpName());
    e300.setEmpName("Rishabh");
    assertEquals("Rish@gmail.com", e300.getEmpEmail());
    e300.setEmpEmail("Rish@gmail.com");
    assertEquals(123456789L, e300.getEmpPhone());
    e300.setEmpPhone(123456789L);
    assertEquals(d1, e300.getEmpDoj());
    e300.setEmpDoj(d1);
    assertEquals("HEXAVARSITY", e300.getEmpDept());
    e300.setEmpDept("HEXAVARSITY");
    assertEquals(10, e300.getEmpLeaveBal());
    e300.setEmpLeaveBal(10);
    assertEquals(100, e300.getEmpMngrId());
    e300.setEmpMngrId(100);
    //assertEquals(e300.hashCode(), new Employee(300).hashCode());
    assertEquals(e300, new Employee(5000, "Rishabh", "Rish@gmail.com", 123456789,
        d1, "HEXAVARSITY", 10, 100));

    assertEquals(" Employee Id:" + e300.getEmpId()
        + "Employee Name:" + e300.getEmpName()
        + "Employee Email:" + e300.getEmpEmail()
        + " Employee Phone:" + e300.getEmpPhone()
        + "Employee Doj:" + e300.getEmpDoj()
        + "Employee Department:" + e300.getEmpDept()
        + " Employee Leave Balance:" + e300.getEmpLeaveBal()
        + "Employee Manager Id:" + e300.getEmpMngrId(), e300.toString());
  }

  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.list(); result = new ArrayList<Employee>();
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(0, es.length);
  }

  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        ArrayList<Employee> es = new ArrayList<Employee>();
        es.add(new Employee(1));
        es.add(new Employee(10));
        es.add(new Employee(100));
        dao.list(); result = es;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(3, es.length);
    assertEquals(new Employee(1), es[0]);
    assertEquals(new Employee(10), es[1]);
    assertEquals(new Employee(100), es[2]);
  }

    /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListById(@Mocked final EmployeeDAO dao) {
    final Employee e100 = new Employee(100);
    new Expectations() {
      {
        dao.find(100); result = e100;
        dao.find(-1); result = null;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e = Employee.listById(100);
    assertEquals(e100, e);

    e = Employee.listById(-1);
    assertNull(e);
  }

  /**
   * Tests that a fetch of a specific manager works correctly.
   * @param dao mocking the dao class
   * @throws ParseException used for parsing
   */
  @Test
  public final void testListByMid(@Mocked final EmployeeDAO dao) throws ParseException {
    String s1 = "2018-05-31";
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    final Employee e201 = new Employee(3000, "VIBHOOTI", "VibutiK@hexaware.com",
            9990894561L, sf.parse(s1), "HEXAVARSITY", 9, 2000);
    new Expectations() {
      {
        dao.findd(2000);
        result = e201;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee et = Employee.listByMid(2000);
    assertEquals(new Employee(3000, "VIBHOOTI", "VibutiK@hexaware.com",
        9990894561L, sf.parse(s1), "HEXAVARSITY", 9, 2000), et);
  }
}




