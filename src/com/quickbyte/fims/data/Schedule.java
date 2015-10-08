
package com.quickbyte.fims.data;

import java.sql.*;
import com.quickbyte.fims.data.*;
import javax.swing.JOptionPane;

public class Schedule {
    public Schedule(String studentNumber, String sessionScheduler, int[] sessionSchedule, String sessionReason){
        try{
            Connection dbConnect = DBConnect.dbConnect();
            String SQL = "INSERT INTO STUDENT_RECORDS.SESSIONS_TABLE(STUDENT_NO, SESSION_SCHEDULER, SESSION_TIME, SESSION_REASON, SESSION_ONGOING, SESSION_ID) VALUES(?, ?, ?, ?, TRUE, ?)";
            PreparedStatement queryStatement = dbConnect.prepareStatement(SQL);

            Timestamp selectedTime = new Timestamp(sessionSchedule[3]);
            selectedTime.setHours(sessionSchedule[3]);
            selectedTime.setMinutes(0);
            selectedTime.setSeconds(0);
            selectedTime.setNanos(0);
            selectedTime.setDate(sessionSchedule[2]);
            selectedTime.setMonth(sessionSchedule[1]-1);
            selectedTime.setYear(sessionSchedule[0] - 1900);
            
            queryStatement.setString(1, studentNumber);
            queryStatement.setString(2, sessionScheduler);
            queryStatement.setTimestamp(3, selectedTime);
            queryStatement.setString(4, sessionReason);
            queryStatement.setString(5, generateSessionID());

            
            queryStatement.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Session Scheduled!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private String generateSessionID(){
        String sessionID = null;
        try{
            Statement queryStatement = DBConnect.dbConnect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = queryStatement.executeQuery("SELECT * FROM STUDENT_RECORDS.SESSIONS_TABLE ORDER BY SESSION_ID ASC");
            rs.last();
            if(rs.getString("SESSION_ID").equals(null)){
                sessionID = "CS-0001";
            }else{
                sessionID = Integer.toString(Integer.parseInt(rs.getString("SESSION_ID").substring(4, 7)) + 1);
                if(sessionID.length() == 1){
                    sessionID = "CS-000" + sessionID;
                }else if(sessionID.length() == 2){
                    sessionID = "CS-00" + sessionID;
                }else if(sessionID.length() == 3){
                    sessionID = "CS-0" + sessionID;
                }else if(sessionID.length() == 4){
                    sessionID = "CS-" + sessionID;
                }
            }
            
            return sessionID;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    

    
    
}
