package com.chainsys.webapp.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.minproject.commonutil.ExceptionManager;
import com.chainsys.minproject.commonutil.InvalidInputDataException;
import com.chainsys.minproject.commonutil.Validators;
import com.chainsys.minproject.dao.DoctorDao;
import com.chainsys.minproject.pojo.Doctor;


/**
 * Servlet implementation class Doctors
 */
public class Doctor1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doctor1() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
        List<Doctor> doclist =DoctorDao.getAllDoctors();
		Iterator<Doctor> docItr=doclist.iterator();
		
		if(request.getParameter("input").equals("yes")) {
			response.setContentType("text/html");
			out.print("<html><head><title><Doctors</title></head><body>");
			out.print("<table border=1px bgcolor=\"DodgerBlue\" width=50%>");
			out.print( "<tr bgcolor=\"DarkSlateBlue\" align=center>");
			out.print("<th height=\"10\" width=\"90\">Doc_id:</th>");
			out.print("<th height=\"10\" width=\"90\">Name:</th>");
			out.print("<th height=\"10\" width=\"90\">Speciality:</th>");
		while(docItr.hasNext()) {
			out.print("<tr align=center>");
			Doctor doc=docItr.next();
			out.print("<td bgcolor=\"DeepSkyBlue\">"+doc.getDoctor_id()+"</td>");
			out.print("<td bgcolor=\"DeepSkyBlue\">"+doc.getDoctor_name()+"</td>");
			out.print("<td bgcolor=\"DeepSkyBlue\">"+doc.getSpeciality()+"</td>");
			out.print("</tr>");			
		}}
		else 
			out.println(" <br><h3>thank you for processing with us</h3>");
		out.print("</body></html>");
	}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("submit").equals("Add")) {
			String source="AddNewDoctor";
			String message="<h1>Error while "+source+"</h1>";
		PrintWriter out=response.getWriter();
		Doctor doc = new Doctor();
		String doc_id = request.getParameter("id");
		try {
			Validators.checkStringForParseInt(doc_id);
		}catch(InvalidInputDataException e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point 
		}
		int doctor_id=Integer.parseInt(doc_id);
		try {
			Validators.CheckNumberForGreaterThanZero(doctor_id);
		}catch(InvalidInputDataException e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point 
		}
		doc.setDoctor_id(doctor_id);
		String doc_name = request.getParameter("name");
		try {
			Validators.checkStringOnly(doc_name);
		}catch(InvalidInputDataException e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point 
		}
		doc.setDoctor_name(doc_name);
		SimpleDateFormat dobFormate = new SimpleDateFormat("dd/MM/yyyy");
		String Dob = request.getParameter("dob");
		try {
			Validators.checkDate(Dob);
			Validators.checkDOB(Dob);
		}catch(InvalidInputDataException e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point 
		}
		try {
			doc.setDob(dobFormate.parse(Dob));
		} catch (ParseException e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point 
		}
		String speciality = request.getParameter("speciality");
		try {
			Validators.checkStringOnly(speciality);
		}catch(InvalidInputDataException e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point 
		}
		doc.setSpeciality(speciality);
		String city = request.getParameter("city");
		try {
			Validators.checkStringOnly(city);
		}catch(InvalidInputDataException e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point 
		}
		doc.setCity(city);
		String phone = request.getParameter("phone_no");
		try {
			Validators.checkPhone(phone);
		}catch(InvalidInputDataException e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point 
		}
		doc.setPhone_no(Long.parseLong(phone));
		String std_fees = request.getParameter("fees");
		try {
			Validators.checkStringForParseInt(std_fees);
		}catch(InvalidInputDataException e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point 
		}
		Float fees=Float.parseFloat(std_fees);
		doc.setStandard_fees(fees);
		int result = DoctorDao.insertDoctor(doc);
		out.println(result + "row inserted");
		try {
			out.close();
		}catch(Exception e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point 
		}
		}else if(request.getParameter("submit").equals("update")) {
			doPut(request,response);
		}else if(request.getParameter("submit").equals("Delete")) {
			doDelete(request,response);
		}

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String source="AddNewDoctor";
		String message="<h1>Error while "+source+"</h1>";
		Doctor doc = new Doctor();
		String doc_id = request.getParameter("id");
		try {
			Validators.checkStringForParseInt(doc_id);
		}catch(InvalidInputDataException e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point 
			
		}
		int doctor_id=Integer.parseInt(doc_id);
		try {
			Validators.CheckNumberForGreaterThanZero(doctor_id);
		}catch(InvalidInputDataException e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point 
		}
		doc.setDoctor_id(doctor_id);
		String doc_name = request.getParameter("name");
		try {
			Validators.checkStringOnly(doc_name);
		}catch(InvalidInputDataException e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point 
		}
		doc.setDoctor_name(doc_name);
		SimpleDateFormat dobFormate = new SimpleDateFormat("dd/MM/yyyy");
		String Dob = request.getParameter("dob");
		try {
			Validators.checkDate(Dob);
			Validators.checkDOB(Dob);
		}catch(InvalidInputDataException e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point 
		}
		try {
			doc.setDob(dobFormate.parse(Dob));
		} catch (ParseException e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point 
		}
		String speciality = request.getParameter("speciality");
		try {
			Validators.checkStringOnly(speciality);
		}catch(InvalidInputDataException e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point 
		}
		doc.setSpeciality(speciality);
		String city = request.getParameter("city");
		try {
			Validators.checkStringOnly(city);
		}catch(InvalidInputDataException e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point 
		}
		doc.setCity(city);
		String phone = request.getParameter("phone_no");
		try {
			Validators.checkPhone(phone);
		}catch(InvalidInputDataException e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point 
		}
		doc.setPhone_no(Long.parseLong(phone));
		String std_fees = request.getParameter("fees");
		try {
			Validators.checkStringForParseInt(std_fees);
		}catch(InvalidInputDataException e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point 
		}
		Float fees=Float.parseFloat(std_fees);
		doc.setStandard_fees(fees);
		int result = DoctorDao.updateDoctor(doc);
		out.println(result + "row Updated");
		try {
			out.close();
		}catch(Exception e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point 
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String source="AddNewDoctor";
		String message="<h1>Error while "+source+"</h1>";
		String doc_id=request.getParameter("id");
		try {
			Validators.checkStringForParseInt(doc_id);
		}catch(InvalidInputDataException e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point
		}
		int id=Integer.parseInt(doc_id);
		int result = DoctorDao.deleteDoctor(id);
		out.println(result+"row deleted");
		try {
			out.close();
		}catch(Exception e) {
			message +=" Error in Doctor id input </p>";
			String errorPage=ExceptionManager.handleException(e, source, message);
			out.print(errorPage);
           return; // It terminates the Code execution beyond this point
	
		}
	}

}
