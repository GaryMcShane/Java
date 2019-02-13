/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thefinancialmodeller;

/**
 *
 * @author Gary
 */
import javax.swing.JFrame;

public class FinancialModeller 
{
    public static void main(String[] args)
    {
        UseModeller frame = new UseModeller();
        frame.go();
        
        frame.setVisible(true);
        frame.setSize(950,450);
        frame.setTitle("Financial Modeller System");
    }

    
}
