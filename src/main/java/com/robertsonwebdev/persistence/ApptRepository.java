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

    public void createNewAppointment(Appointment appt) throws SQLException {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql//sunshadersinstance.c9lfyx2a2tne.us-east-1.rds.amazonaws.com:3306/sunshaders?user=mrober23&password=mediline");
            Statement stmt = conn.createStatement()){
            String sql = String.format("INSERT INTO appointments (firstname, lastname, scheduled, created) VALUES ('%s', '%s', '%s', NOW());", appt.getFirstname(), appt.getLastname(), appt.getScheduled());
            stmt.execute(sql);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public void appointmentQuery() throws SQLException{
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://sunshadersinstance.c9lfyx2a2tne.us-east-1.rds.amazonaws.com:3306/sunshaders?user=mrober23&password=mediline");
            Statement stmt = conn.createStatement()){
            String sql = "SELECT * from sunshaders.appointments";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                String firstname = rs.getString(2);
                String lastname = rs.getString(3);
                String scheduled = rs.getString(4);
                Appointment appt = new Appointment(firstname, lastname, scheduled);
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
        try(Connection conn = DriverManager.getConnection("jdbc:mysql//sunshadersinstance.c9lfyx2a2tne.us-east-1.rds.amazonaws.com:3306/sunshaders?user=mrober23&password=mediline");
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
