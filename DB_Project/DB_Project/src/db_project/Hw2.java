/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db_project;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sayali Sakhalkar
 */
public class Hw2 extends javax.swing.JFrame {
  boolean anouncement_sys=false;
  boolean build=false;
  boolean student=false;
  boolean query1=false;
  boolean query2=false;
  boolean query3=false;
  boolean query4=false;
  boolean query5=false;
  //Connection mainConnection = null;
  Statement mainStatement = null;
  PreparedStatement SecondStatement = null;
  Statement ThirdStatement = null;
  ResultSet mainResultSet = null;
  Polygon poly[] = new Polygon[123];
  int radius[][] = new int [7][3]; 
    /**
     * Creates new form frame1
     */
    public Hw2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        xCod = new javax.swing.JTextField();
        yCod = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jCheckBox1.setText("AS");
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseClicked(evt);
            }
        });

        jCheckBox2.setText("buildings");
        jCheckBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox2MouseClicked(evt);
            }
        });
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("studeents");
        jCheckBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox3MouseClicked(evt);
            }
        });
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Whole Region");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("jRadioButton2");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("jRadioButton3");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("jRadioButton4");

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("jRadioButton5");

        jButton1.setText("Submit");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Co-ordinates");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/db_project/map.jpg"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel1MouseMoved(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox1)
                                    .addComponent(jCheckBox2)
                                    .addComponent(jCheckBox3)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton3)
                                    .addComponent(jRadioButton4)
                                    .addComponent(jRadioButton5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(xCod, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, Short.MAX_VALUE)
                                        .addComponent(yCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel2)))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {xCod, yCod});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox3)
                        .addGap(35, 35, 35)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton5)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(xCod, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(229, 229, 229)
                        .addComponent(jButton1))
                    .addComponent(jLabel1))
                .addGap(134, 134, 134)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {xCod, yCod});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        xCod.setText(""+ evt.getX());
        yCod.setText(""+ evt.getY());
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        xCod.setText(" ");
        yCod.setText(" ");
    }//GEN-LAST:event_jLabel1MouseExited

    private void jCheckBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseClicked
        // TODO add your handling code here:
          if(jCheckBox1.isSelected())
            anouncement_sys=true;
         else
            anouncement_sys=false;
    }//GEN-LAST:event_jCheckBox1MouseClicked

    private void jCheckBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox2MouseClicked
        // TODO add your handling code here:
        if(jCheckBox2.isSelected())
            build=true;
         else
            build=false;
    }//GEN-LAST:event_jCheckBox2MouseClicked

    private void jCheckBox3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox3MouseClicked
        // TODO add your handling code here:
          if(jCheckBox3.isSelected())
            student=true;
         else
            student=false;
    }//GEN-LAST:event_jCheckBox3MouseClicked

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        // TODO add your handling code here:
            if(jRadioButton1.isSelected())
            {
                query1 = true;
            }
            else
                query1 = false;
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    int co_ordinate = 0;
    String build_id = "";
    String student_id = "";
    String temp_build = "";
    String announcement_id = ""; 
    int xquery = 0;
    int num_of_vertices = 0;
    int yquery = 0; 
    System.out.println("Q1:" + query1);
    if(query1)
    {
        --co_ordinate;
        xquery = 0;
        yquery = 0;
        try 
        {
            //Whole_Region w = new Whole_Region();
            Populate d=new Populate();
            d.ConnectToDB();
            int counter=0;
            while(counter!=poly.length)
            {
                poly[counter] = new Polygon();
                counter++;
            }
            System.out.println("Build:"+ build);
            if(build)
            {
                xquery = 0;
                yquery = 0;
                build_id="";
                System.out.println("Hi");
                String store1 = "SELECT b.building_ID, b.num_of_vertices, COORD.x, COORD.y from buildings b, TABLE(SDO_UTIL.GETVERTICES(b.shape)) COORD "; 
                try
                {
                        System.out.println("Hi1");    
                        //d.mainConnection.prepareStatement(store1);
                        mainStatement = d.mainConnection.createStatement();
                        System.out.println("connnn");
                        mainResultSet = d.mainStatement.executeQuery(store1);
                        System.out.println("Hi");
                        int temp_count=0;
                        int count_val = 0;
                        int poly_count = 0;
                        while(mainResultSet.next())
                        {
                            xquery = mainResultSet.getInt(3);
                            System.out.println("Hi2");
                            yquery = mainResultSet.getInt(4);
                            build_id = mainResultSet.getString(1);
                            num_of_vertices = mainResultSet.getInt(2);
                            System.out.println("xquery "+xquery+"yquery "+yquery+"build_id "+build_id+"num_of_vertices "+num_of_vertices);
                            System.out.println("PolyCount :"+poly_count);
                            //poly[poly_count].addPoint(xquery, yquery);
                            temp_build = build_id;
                            while(count_val != (num_of_vertices-1))
                            {
                                System.out.println("build_id "+build_id+"temp_build"+temp_build);
                               // if(build_id.equals(temp_build))
                                {                       
                                    System.out.println("X:" + xquery + " Y:" + yquery);
                                    System.out.println("PolyCount :"+poly_count);
                                    poly[poly_count].addPoint(xquery, yquery);
                                }
                               /* else
                                {
                                    System.out.println("Enterd.....");
                                    poly_count++;
                                    System.out.println("X:" + xquery + " Y:" + yquery);
                                    System.out.println(poly_count);
                                    poly[poly_count].addPoint(xquery, yquery);
                                }*/
                                if(mainResultSet.next())
                                {
                                    xquery = mainResultSet.getInt(3);
                                    yquery = mainResultSet.getInt(4);
                                    poly[poly_count].addPoint(xquery, yquery);
                                }
                                count_val++;
                            }
                            poly_count++;
                            count_val = 0;
                        }
                }
                catch (SQLException ex) 
                {
                        Logger.getLogger(Hw2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(student)
            {
                xquery = 0;
                yquery = 0;
                student_id="";
                System.out.println("Hi");
                String store3 = "SELECT p.person_id, COORD.x, COORD.y from students p, TABLE(SDO_UTIL.GETVERTICES(p.shape)) COORD "; 
                try
                {
                        System.out.println("Hi1");    
                        mainStatement = d.mainConnection.createStatement();
                        System.out.println("connnn");
                        mainResultSet = d.mainStatement.executeQuery(store3);
                        System.out.println("Hi");
                        int temp_count=0;
                        int count_val = 0;
                        int point_count = 36;
                        while(mainResultSet.next())
                        {
                            xquery = mainResultSet.getInt(2);
                            System.out.println("Hi2");
                            yquery = mainResultSet.getInt(3);
                            student_id = mainResultSet.getString(1);
                            System.out.println("xquery "+xquery+"yquery "+yquery+"student_id"+student_id);
                            System.out.println("PointCount :"+point_count);
                            poly[point_count].addPoint(xquery-5, yquery-5);
                            poly[point_count].addPoint(xquery+5, yquery-5);
                            poly[point_count].addPoint(xquery+5, yquery+5);
                            poly[point_count].addPoint(xquery-5, yquery+5);
                            point_count++;
                        }
                }
                catch (SQLException ex) 
                {
                        Logger.getLogger(Hw2.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }
            if(anouncement_sys)
            {
                xquery = 0;
                int rquery=0;
                yquery = 0;
                student_id="";
                System.out.println("Hi");
                String store2 = "SELECT p.ANNOUNCEMENT_ID, p.radius, COORD.x, COORD.y from announcementSystems p, TABLE(SDO_UTIL.GETVERTICES(p.co_ordinate)) COORD "; 
                try
                {
                        System.out.println("Hi1");    
                        mainStatement = d.mainConnection.createStatement();
                        System.out.println("connnn");
                        mainResultSet = d.mainStatement.executeQuery(store2);
                        System.out.println("Hi");
                        int temp_count=0;
                        int count_val = 0;
                        int point_count1 = 116;
                        while(mainResultSet.next())
                        {
                            xquery = mainResultSet.getInt(3);
                            System.out.println("Hi2");
                            yquery = mainResultSet.getInt(4);
                            System.out.println("Hi3");
                            rquery = mainResultSet.getInt(2);
                            System.out.println("Hi4");
                            announcement_id = mainResultSet.getString(1);
                            radius[point_count1-116][0] = xquery;
                            radius[point_count1-116][1] = yquery;
                            radius[point_count1-116][2] = rquery;
                            System.out.println("xquery "+xquery+"yquery "+yquery+"announcement_id"+announcement_id);
                            System.out.println("PointCount :"+point_count1);
                            poly[point_count1].addPoint(xquery-7, yquery-7);
                            poly[point_count1].addPoint(xquery+7, yquery-7);
                            poly[point_count1].addPoint(xquery+7, yquery+7);
                            poly[point_count1].addPoint(xquery-7, yquery+7);
                            point_count1++;
                        }
                    }
                catch (SQLException ex) 
                {
                        Logger.getLogger(Hw2.class.getName()).log(Level.SEVERE, null, ex);
                }    
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        repaint();
    }
    
    }//GEN-LAST:event_jButton1ActionPerformed
  @Override
    public void paint (Graphics g1)
    {
        super.paint(g1);
        this.jPanel1.getGraphics();
        g1.setColor(Color.YELLOW);
        for(int i = 0; i<36 ;i++)
        {
            g1.drawPolygon(poly[i]);
        }
        g1.setColor(Color.GREEN);
        for(int i = 36; i<116 ;i++)
        {
            g1.fillPolygon(poly[i]);
        }
        if(anouncement_sys)
        {
         g1.setColor(Color.RED);
        for(int i = 116; i<123 ;i++)
        {
            g1.fillPolygon(poly[i]);
        }
        for (int i=0;i<7;i++)
        {
            g1.drawOval(radius[i][0]-radius[i][2], radius[i][1]-radius[i][2],2*(radius[i][2]) ,2* (radius[i][2]));
        }
        }
    }
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        if(query1 == true)
        {
            System.out.println("Query 1 Clicked...");
            if(anouncement_sys ==true)
                System.out.println("Announcement System");
            if(build==true)
                System.out.println("Building");
            if(student==true)
                System.out.println("Student");
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jLabel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseMoved
        // TODO add your handling code here:
         xCod.setText(""+ evt.getX());
         yCod.setText(""+ evt.getY());
    }//GEN-LAST:event_jLabel1MouseMoved

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Hw2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hw2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hw2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hw2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hw2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JTextField xCod;
    private javax.swing.JTextField yCod;
    // End of variables declaration//GEN-END:variables
}