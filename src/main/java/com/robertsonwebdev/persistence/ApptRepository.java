package com.robertsonwebdev.persistence;

import com.robertsonwebdev.domain.Appointment;

import javax.servlet.SessionTrackingMode;
import java.awt.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class ApptRepository {

    private String query;
    private ArrayList<Appointment> appointments;

    public String getQuery(){
        return query;
    }

    public ArrayList<Appointment> getAppointments(){
        return appointments;
    }
    public ApptRepository(){
        appointments = new ArrayList<>();
    }

    public void createNewAppointment(String firstname, String lastname, String date, String time) {
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:./ROOT/WEB-INF/classes/appt.sqlite");
            Statement stmt = conn.createStatement()){

            Appointment appt = new Appointment(firstname, lastname, date, time);
            String values = String.format("'%s', '%s', '%s', '%s', '%s'", appt.getFirstname(), appt.getLastname(), appt.getApptDate(), appt.getApptTime(), appt.getCreated());
            String sql = "INSERT INTO schedule (firstname, lastname, apptDate, apptTime, created) VALUES (" + values + ")";
            stmt.execute(sql);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void appointmentQuery() throws SQLException{
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:./ROOT/WEB-INF/classes/appt.sqlite");
            Statement stmt = conn.createStatement()){
            String sql = "SELECT * FROM schedule";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                String firstname = rs.getString(2);
                String lastname = rs.getString(3);
                String apptDate = rs.getString(4);
                String apptTime = rs.getString(5);
                String created = rs.getString(6);
                Appointment appt = new Appointment(firstname, lastname, apptDate, apptTime, created);
                appointments.add(appt);

            }
        } catch (SQLException ex) {
            throw ex;
        }
    }


    private void createTimeString() {
        TimeZone tz = TimeZone.getTimeZone("EST");
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Long time = new Date().getTime();
        Date d = new Date(time);
        date.setTimeZone(tz);
        String dateStr = date.format(new Date());

        System.out.println("Date: " + dateStr);
        System.out.println("Time: " + d.toString());

    }

    private void connectDB(){
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:./src/main/resources/appt.sqlite");
            Statement stmt = conn.createStatement()){

            String sql = "SELECT * FROM customers";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                query = String.format("%s %s %s %s", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }

        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
