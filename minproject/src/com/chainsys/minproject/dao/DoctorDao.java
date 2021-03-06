package com.chainsys.minproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.chainsys.minproject.pojo.Doctor;
import com.chainsys.minproject.pojo.Doctor;
import com.chainsys.minproject.pojo.Doctor;
import com.chainsys.minproject.pojo.Doctor;
import com.chainsys.minproject.pojo.Doctor;

public class DoctorDao {
	/**
	     * getConnection
	     * insertEmployee(Employee newemp)
	     * getEmployeeById(int id)
	     * getAllEmployees()
	     * updateEmployee(Employee newemp)
	     * deleteEmployee(int id)
	     * 
	     */
	
	
	
	    /**
	     * getConnection() insertEmployee(Employee newemp) getEmployeeById(int id)
	     * getAllEmployees() updateEmployee(Employee newemp) deleteEmployee(int id)
	     */
	
	
	private static Connection getconnection() {
		Connection con = null;
		String drivername="oracle.jdbc.OracleDriver";
		String dburl="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="oracle";
		try {
			Class.forName(drivername);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(dburl,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public static java.sql.Date utiltoSqlConvert(java.util.Date date){
		return new java.sql.Date(date.getTime());
	}
	public static java.util.Date sqltoUtilconvert(java.sql.Date date){
		return new java.util.Date(date.getTime());
	}
	public static int insertDoctor(Doctor newdoc) {
		String insertquery = "insert into doctor(Doctor_id,Doctor_name,Dob,Speciality,City,Phone_no,Standard_fees) values(?,?,?,?,?,?,?)";
		Connection mycon = getconnection();
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			pstmt = mycon.prepareStatement(insertquery);
			pstmt.setInt(1, newdoc.getDoctor_id());
			pstmt.setString(2, newdoc.getDoctor_name());
			pstmt.setDate(3, utiltoSqlConvert(newdoc.getDob()));
			pstmt.setString(4, newdoc.getSpeciality());
			pstmt.setString(5, newdoc.getCity());
			pstmt.setLong(6, newdoc.getPhone_no());
			pstmt.setFloat(7, newdoc.getStandard_fees());
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				mycon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	public static Doctor getDoctorById(int id) {
		Connection mycon = getconnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Doctor doc=null;
		try {
			pstmt = mycon.prepareStatement("select Doctor_id,Doctor_name,Dob,Speciality,City,Phone_no,Standard_fees from Doctor where doctor_id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			doc=new Doctor();
			if(rs.next()) {
				doc.setDoctor_id(rs.getInt(1));
				doc.setDoctor_name(rs.getString(2));
				doc.setDob(sqltoUtilconvert(rs.getDate(3)));
				doc.setSpeciality(rs.getString(4));
				doc.setCity(rs.getString(5));
				doc.setPhone_no(rs.getLong(6));
				doc.setStandard_fees(rs.getInt(7));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				mycon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return doc;
	}
	public static List<Doctor> getAllDoctors() {
		List<Doctor>listOfDoctors =new ArrayList<Doctor>();
		Connection mycon = getconnection();
		Statement stmt = null;
		ResultSet rs = null;
		Doctor doc;
		try {
			stmt = mycon.createStatement();
			rs = stmt.executeQuery("select Doctor_id,Doctor_name,Dob,Speciality,City,Phone_no,Standard_fees from Doctor");
			
			while(rs.next()) {
				doc=new Doctor();
				doc.setDoctor_id(rs.getInt(1));
				doc.setDoctor_name(rs.getString(2));
				doc.setDob(sqltoUtilconvert(rs.getDate(3)));
				doc.setSpeciality(rs.getString(4));
				doc.setCity(rs.getString(5));
				doc.setPhone_no(rs.getLong(6));
				doc.setStandard_fees(rs.getInt(0));
				listOfDoctors.add(doc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				mycon.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listOfDoctors;
	}
	public static int updateDoctor(Doctor newdoc) {

		Connection mycon = getconnection();
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			pstmt = mycon.prepareStatement("update doctor set Doctor_name=?,Dob=?,Speciality=?,City=?,Phone_no=?,Standard_fees=? where Doctor_id=?");
			pstmt.setString(1, newdoc.getDoctor_name());
			pstmt.setDate(2, utiltoSqlConvert(newdoc.getDob()));
			pstmt.setString(3, newdoc.getSpeciality());
			pstmt.setString(4, newdoc.getCity());
			pstmt.setLong(5, newdoc.getPhone_no());
			pstmt.setFloat(6, newdoc.getStandard_fees());
			pstmt.setInt(7, newdoc.getDoctor_id());
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	public static int deleteDoctor(int id) {
		Connection mycon = getconnection();
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			pstmt = mycon.prepareStatement("delete Doctor where Doctor_id=?");
			pstmt.setInt(1, id);
			row = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	public static int updateDoctorName(int id,String docname) {
        String updatequery = "update Doctor set Doctor_name=? where Doctor_id=?";
        Connection con = null;
        int rows = 0;
        PreparedStatement ps = null;
        try {
            con = getconnection();
            ps = con.prepareStatement(updatequery);
            ps.setString(1, docname);
            ps.setInt(2, id);
            ps.executeUpdate();
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rows;
    }public static int updateStandardFees(int id, float fees) {
        String updatequery = "update Doctor set Standard_fees=? where Doctor_id=?";
        Connection con = null;
        int rows = 0;
        PreparedStatement ps = null;
        try {
            con = getconnection();
            ps = con.prepareStatement(updatequery);
            ps.setDouble(1, fees );
            ps.setInt(2, id);
            ps.executeUpdate();
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rows;
    }


	}

