/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.domain;

import java.util.Properties;

/**
 *
 * @author Luuk
 */
public interface IPersistencyMediator {
    Drawing load(String nameDrawing);
    Boolean save(Drawing drawing);
    Boolean init(Properties props);
}
