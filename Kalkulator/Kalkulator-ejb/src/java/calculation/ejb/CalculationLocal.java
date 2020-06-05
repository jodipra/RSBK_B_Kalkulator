/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculation.ejb;

import javax.ejb.Local;

/**
 *
 * @author HZ
 */
@Local
public interface CalculationLocal {
public double subtract(double minuend, double subtrahend);    
     public double multiply(double factor1, double factor2);    
     public double divide(double dividend, double divisor);    
     public double add(double addend1, double addend2); 
}
