
package com.quickbyte.fims.data;

import java.sql.*;
import com.quickbyte.fims.data.*;
import javax.swing.JOptionPane;

public class Schedule {
    public Schedule(String studentNumber, String sessionScheduler, int[] sessionSchedule){
        try{
            Connection dbConnect = DBConnect.dbConnect();
            String SQL = "INSERT INTO SESSIONS_TABLE(STUDENT_NO, SESSION_SCHEDULER, SESSION_TIME) VALUES(?, ?, ?)";
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
            
            queryStatement.execute();
            
            JOptionPane.showMessageDialog(null, "Session Scheduled!");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
}
