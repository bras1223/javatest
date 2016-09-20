/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.domain;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author Luuk
 */
public class DatabaseMediator implements IPersistencyMediator{
    
    private Properties props;
    private Connection con;

    @Override
    public Drawing load(String nameDrawing) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT emp FROM Employee");
            Drawing draw = null;
            while (rs.next()) {
                byte[] st = (byte[]) rs.getObject(1);
                ByteArrayInputStream baip = new ByteArrayInputStream(st);
                ObjectInputStream ois = new ObjectInputStream(baip);
                draw = (Drawing) ois.readObject();
            }
            return draw;
            } catch (SQLException | IOException | ClassNotFoundException e){
                e.printStackTrace(System.out);
                return null;
            }
    }

    @Override
    public Boolean save(Drawing drawing) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(drawing);
            byte[] drawingAsBytes = baos.toByteArray();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO EMPLOYEE (emp) VALUES(?)");
            ByteArrayInputStream bais = new ByteArrayInputStream(drawingAsBytes);
            pstmt.setBinaryStream(1, bais, drawingAsBytes.length);
            pstmt.executeUpdate();
            pstmt.close();
            return true;
        } catch (IOException | SQLException e) {
            e.printStackTrace(System.out);
            return false;
        }
    }

    @Override
    public Boolean init(Properties props) {
         if(props.containsKey("password") && props.containsKey("username") && props.containsKey("conString")) {
            this.props = props;
            return true; 
        } else {
            return false;
        }    
    }
    
    private void closeConnection() {
        try {
          con.close();  
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        
    }
    
    private void initConnection() {
        try {
            con = DriverManager.getConnection(props.getProperty("conString"), props.getProperty("username"), props.getProperty("password"));
        } catch(SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}
