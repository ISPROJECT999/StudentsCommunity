/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

import java.util.List;
import models.Students;
import queries.StudentsQR;

/**
 *
 * @author Yoosuf
 */
public class Test {
    
    public void t(){
    
       List<Students> studs= StudentsQR.getAll();
       
       
    
    }
    
}
