/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thefinancialmodeller;

/**
 *Program Name: TheFinancialModeller
 * Module Programming II (COM373)
 * Lecturer: George Wilkie
 * Date:01/12/2015
 * @author Gary McShane - B00656764
 */

import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;


public class CurrentAccount extends javax.swing.JPanel 
{
    double currentBal;
    String strCurrentBal;
    Timer auto = new javax.swing.Timer(5000, new StartTimer());
    
    
    
    public CurrentAccount(double current) 
    {
        initComponents();
        //Carrying over the users initial value 
        currentBal = current;
        strCurrentBal = Double.toString(currentBal);
                   
        //Adding actionListener
        btnWithdrawl.addActionListener(new WithdrawlListener());
        btnDeposit.addActionListener(new DepositListener()); 
        
        btnStartTimer.addActionListener(new StartListener());
        btnStopTimer.addActionListener(new StopListener());
        
        //Doesn't allow the user to enter the value in the text box
        txtBal.setEditable(false);
        strCurrentBal = Double.toString(currentBal);//passes the value into the textbox
        txtBal.setText(strCurrentBal);
        
    }

    
    class WithdrawlListener implements ActionListener
    {  
        @Override
        public void actionPerformed(ActionEvent e)
        {   
            
            String strSaveAmt; 
            
            
            try
            {
            //Prompting the user to enter the amount which to take from the account
                strSaveAmt = JOptionPane.showInputDialog("Enter your Withdrawl amount");
                double withdrawl = Double.parseDouble(strSaveAmt);
            
                currentBal = currentBal - withdrawl;
                strCurrentBal = Double.toString(currentBal);
                txtBal.setText(strCurrentBal);

                if(currentBal < -200.00)//Ensuring that the user over draw more than £200
                {
                    JOptionPane.showMessageDialog(null,"Withdrawl deined!!");
                }
                //strCurrentBal = Double.toString(currentBal);
                //txtBal.setText(strCurrentBal);
               
            }
            catch (NumberFormatException event)
            {//Ensuring that the user enters a vaild value
                JOptionPane.showMessageDialog(null,"You enter a non-numeric value");
            }
        }
    }
    
    class DepositListener implements ActionListener 
    {
       
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String strSave;
            try
            {//Prompt user to enter a value to add to the account
                strSave = JOptionPane.showInputDialog("Enter your Deposit");
                double input = Double.parseDouble(strSave); 
                if(input >=500)
                {
                    input = input +10.00;
                    currentBal = currentBal + input;
                    strCurrentBal = Double.toString(currentBal);
                    txtBal.setText(strCurrentBal);
                }
                
            }
            catch (NumberFormatException event)
            {//This message will about if the user enters character rather then a value
                JOptionPane.showMessageDialog(null,"You have entered a non-numer value");
            }           
        }
    }
    
    public class StartListener implements ActionListener
    {//Automoaically starts the stimulation 
        @Override
        public void actionPerformed (ActionEvent e)
        {
            auto.start();
        }
    }
    
    public class StartTimer implements ActionListener
    {
            @Override
            public void actionPerformed(ActionEvent e)
        
            {//The information that will output when the Start Button is selected
                if(currentBal >=500.00)
                {
                    currentBal = currentBal + 10.00;
                    currentBal= Math.round(currentBal * 100.0)/100.0;//rounding the value
                    strCurrentBal = Double.toString(currentBal);
                    txtBal.setText(strCurrentBal);
                }
                else if(currentBal >= 1.00)
                {
                    currentBal = currentBal + currentBal;
                    strCurrentBal = Double.toString(currentBal);
                    txtBal.setText(strCurrentBal);
                }
                        
            
            
            }
    }
            
    
    public class StopListener implements ActionListener
    {//Stops the stimulation
        @Override
        public void actionPerformed (ActionEvent e)
        {
            auto.stop();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnStopTimer = new javax.swing.JButton();
        btnStartTimer = new javax.swing.JButton();
        btnDeposit = new javax.swing.JButton();
        btnWithdrawl = new javax.swing.JButton();
        lblCurrent = new javax.swing.JLabel();
        lblBal = new javax.swing.JLabel();
        txtBal = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 0, 255));

        btnStopTimer.setText("Stop Timer");
        btnStopTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopTimerActionPerformed(evt);
            }
        });

        btnStartTimer.setText("Start Timer");

        btnDeposit.setText("Deposit ");

        btnWithdrawl.setText("Withdrawl");

        lblCurrent.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        lblCurrent.setForeground(new java.awt.Color(255, 255, 255));
        lblCurrent.setText("Current Account");

        lblBal.setFont(new java.awt.Font("Calibri Light", 3, 14)); // NOI18N
        lblBal.setForeground(new java.awt.Color(255, 255, 255));
        lblBal.setText("Account Balance");

        txtBal.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(lblCurrent))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(lblBal, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnStopTimer)
                                    .addComponent(btnStartTimer))
                                .addGap(445, 445, 445)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnWithdrawl)
                                    .addComponent(btnDeposit))))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblCurrent)
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStartTimer)
                    .addComponent(btnWithdrawl))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStopTimer)
                    .addComponent(btnDeposit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnStopTimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopTimerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStopTimerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeposit;
    private javax.swing.JButton btnStartTimer;
    private javax.swing.JButton btnStopTimer;
    private javax.swing.JButton btnWithdrawl;
    private javax.swing.JLabel lblBal;
    private javax.swing.JLabel lblCurrent;
    private javax.swing.JTextField txtBal;
    // End of variables declaration//GEN-END:variables
}
