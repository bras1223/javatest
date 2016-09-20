/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.domain;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 *
 * @author Luuk
 */
public class SerializationMediator implements IPersistencyMediator{

    private Properties props;
    
    @Override
    public Drawing load(String nameDrawing) {
       try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(props.getProperty("filename")))) {
           Drawing drawing = (Drawing) ois.readObject();
           return drawing;
       } catch (IOException | ClassNotFoundException e) {
           e.printStackTrace(System.out);
           return null;
       }
    }

    @Override
    public Boolean save(Drawing drawing) {
      try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(props.getProperty("filename")))) {
          oos.writeObject(drawing);
          return true;
      } catch (IOException e) {
          e.printStackTrace(System.out);
          return false;
      }
    }

    @Override
    public Boolean init(Properties props) {
        if(props.containsKey("filename")){
            this.props = props;
            return true; 
        } else {
            return false;
        }    
    }
}
