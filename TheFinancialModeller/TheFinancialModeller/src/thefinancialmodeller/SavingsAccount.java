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



public class SavingsAccount extends javax.swing.JPanel 
{
    double savingsBal;
    String strSavingsBalance;
    Timer auto = new javax.swing.Timer(5000, new StartTimer());
      
    public SavingsAccount(double savings) 
    {
        initComponents();
        //Carrying over the users initial value 
        savingsBal = savings;
        strSavingsBalance = Double.toString(savingsBal);
        
        double savingsBalance = savings;
        String strSavingsBal;
        
           
        btnWithdrawl.addActionListener(new WithdrawlListener());
        btnDeposit.addActionListener(new DepositListener()); 
      
        
        btnStartTimer.addActionListener(new StartListener());
        btnStopTimer.addActionListener(new StopListener());
        
        txtBal.setEditable(false);
        strSavingsBal = Double.toString(savingsBalance);
        txtBal.setText(strSavingsBal);
        
    }
        
    class WithdrawlListener implements ActionListener
    {  
        @Override
        public void actionPerformed(ActionEvent e)
        {   
            int num = 0;
            num++;
            String strSaveAmt; 
            
            
            try
            {//Prompting the user to enter the amount which to take from the account
                strSaveAmt = JOptionPane.showInputDialog("Enter your Withdrawl amount");
                double withdrawl = Double.parseDouble(strSaveAmt);
            
                savingsBal = savingsBal - withdrawl;
                strSavingsBalance = Double.toString(savingsBal);
                txtBal.setText(strSavingsBalance);

                if(savingsBal < 100.00)//Ensuring that the user doesn't go below £100
                {
                    JOptionPane.showMessageDialog(null,"Withdrawl deined!!");
                }
                //strSavingsBalance = Double.toString(savingsBal);
                //txtBal.setText(strSavingsBalance);
                
                if (num > 2)//Ensuring the users doesn't exceed the withdrawl limit
                {
                    JOptionPane.showMessageDialog(null,"You have exceed the withdrawl limit");
                    savingsBal = savingsBal;//+ withdrawl;
                }
            }
            catch (NumberFormatException event)
            {//This message will about if the user enters character rather then a value
                JOptionPane.showMessageDialog(null,"You enter a non-numeric value");
            }
        }
    }
    
    class DepositListener implements ActionListener 
    {
       
        @Override
        public void actionPerformed(ActionEvent e)
        {
            double input;
            String strSave;
            try
            {//Prompt user to enter a value to add to the account
                strSave = JOptionPane.showInputDialog("Enter your Deposit");
                input = Double.parseDouble(strSave); 
                
                savingsBal = savingsBal + input;
                strSavingsBalance = Double.toString(savingsBal);
                txtBal.setText(strSavingsBalance);
            }
            catch (NumberFormatException event)
            {//This message will about if the user enters character rather then a value
                JOptionPane.showMessageDialog(null,"You have entered a non-numer value");
            }           
        }
    }
    
    public class StartListener implements ActionListener
    {
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
        { 
            savingsBal = savingsBal * 1.03;//3% being added after each month
            savingsBal = Math.round(savingsBal*100.0)/100.0;// rounding the value
            strSavingsBalance = Double.toString(savingsBal);
            txtBal.setText(strSavingsBalance);
                       
        }
    }
    
    public class StopListener implements ActionListener
    {
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

        btnStartTimer = new javax.swing.JButton();
        btnStopTimer = new javax.swing.JButton();
        btnWithdrawl = new javax.swing.JButton();
        btnDeposit = new javax.swing.JButton();
        txtBal = new javax.swing.JTextField();
        lblSavings = new javax.swing.JLabel();
        lblBal = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 255));

        btnStartTimer.setText("Start Timer");

        btnStopTimer.setText("Stop Timer");
        btnStopTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopTimerActionPerformed(evt);
            }
        });

        btnWithdrawl.setText("Withdrawl");

        btnDeposit.setText("Deposit ");

        txtBal.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N

        lblSavings.setFont(new java.awt.Font("Georgia", 3, 18)); // NOI18N
        lblSavings.setForeground(new java.awt.Color(255, 255, 255));
        lblSavings.setText("Savings Account");

        lblBal.setFont(new java.awt.Font("Calibri Light", 3, 14)); // NOI18N
        lblBal.setForeground(new java.awt.Color(255, 255, 255));
        lblBal.setText("Account Balance");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblSavings)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStartTimer)
                    .addComponent(btnStopTimer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 368, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnWithdrawl)
                    .addComponent(btnDeposit))
                .addGap(143, 143, 143))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblBal, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtBal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(279, 279, 279))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblSavings)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnStartTimer)
                            .addComponent(btnWithdrawl))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnStopTimer)
                            .addComponent(btnDeposit))
                        .addGap(0, 177, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75))))
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
    private javax.swing.JLabel lblSavings;
    private javax.swing.JTextField txtBal;
    // End of variables declaration//GEN-END:variables
}
