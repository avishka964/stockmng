
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;



/**
 *
 * @author avishka
 */
public class Sales extends javax.swing.JFrame {

    /**
     * Creates new form Sales
     */
    public Sales() {
        initComponents();
        SelectProd();
        SelectCus();
        DateSet();
    }

    Connection Con  = null;
    Statement St = null;
    ResultSet Rs = null;
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        orderId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        addOrderBtn = new javax.swing.JButton();
        addToOrderBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTbl = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        customerTbl = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        amount = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderTbl = new javax.swing.JTable();
        customerName = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 245, 245));

        jPanel2.setBackground(new java.awt.Color(48, 129, 202));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 254, 254));
        jLabel1.setText("Stock Management System");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(254, 254, 254));
        jLabel2.setText("Sales Manage");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        close.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        close.setText("X");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(close)
                        .addGap(25, 25, 25))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("Order Id");

        orderId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderIdMouseClicked(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("Quantity");

        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("Customer Name");

        jLabel7.setForeground(new java.awt.Color(1, 1, 1));
        jLabel7.setText("Date");

        addOrderBtn.setBackground(new java.awt.Color(24, 119, 232));
        addOrderBtn.setForeground(new java.awt.Color(254, 254, 254));
        addOrderBtn.setText("Add Order");
        addOrderBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addOrderBtnMouseClicked(evt);
            }
        });

        addToOrderBtn.setBackground(new java.awt.Color(24, 119, 232));
        addToOrderBtn.setForeground(new java.awt.Color(254, 254, 254));
        addToOrderBtn.setText("Add to Order");
        addToOrderBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addToOrderBtnMouseClicked(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(24, 119, 232));
        backBtn.setForeground(new java.awt.Color(254, 254, 254));
        backBtn.setText("Back");
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
        });

        productTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Code", "Product Name", "Quantity", "Price", "Category"
            }
        ));
        productTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productTbl);

        customerTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer Id", "Customer Name", "Phone"
            }
        ));
        customerTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerTblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(customerTbl);

        jLabel8.setForeground(new java.awt.Color(6, 133, 253));
        jLabel8.setText("Products List");

        jLabel9.setForeground(new java.awt.Color(6, 133, 253));
        jLabel9.setText("Customers List");

        amount.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        amount.setForeground(new java.awt.Color(21, 116, 242));

        orderTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "number", "productName", "quantity", "unitPrice", "total"
            }
        ));
        orderTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderTblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(orderTbl);

        customerName.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        customerName.setForeground(new java.awt.Color(21, 116, 242));

        date.setText("jLabel6");

        jLabel6.setForeground(new java.awt.Color(1, 1, 1));
        jLabel6.setText("Price");

        jLabel10.setForeground(new java.awt.Color(1, 1, 1));
        jLabel10.setText("Total Amount (Rs.)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(addOrderBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(orderId, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                        .addComponent(customerName, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(30, 30, 30)
                                .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6)
                        .addGap(34, 34, 34)
                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addToOrderBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(37, 37, 37))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(addToOrderBtn))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel5)
                                    .addComponent(customerName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(jLabel7)
                                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(addOrderBtn)
                                    .addComponent(backBtn)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(orderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public void SelectProd(){
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stockmng","root","MySql#123");
            St = Con.createStatement();
            Rs = St.executeQuery("select * from Product");
            productTbl.setModel(DbUtils.resultSetToTableModel(Rs));
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
     
    public void SelectCus(){
        try{
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stockmng","root","MySql#123");
            St = Con.createStatement();
            Rs = St.executeQuery("select * from Customer");
            customerTbl.setModel(DbUtils.resultSetToTableModel(Rs));
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    private void DateSet() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        date.setText(dtf.format(now));
    }
    
    private void UpdateProd(){
        int newQty = oldQty - Integer.valueOf(quantity.getText());
        try{
         Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stockmng","root","MySql#123");
         String UpdateQuery = "update stockmng.Product set quantity="+newQty+""+"where productId ="+productId;
         Statement Add = Con.createStatement();
         Add.executeUpdate(UpdateQuery);
//         JOptionPane.showMessageDialog(this, "Product Succesfully Updated!");
         SelectProd();
        }catch(Exception e){
         e.printStackTrace();
        }
    }
    
    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void addOrderBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addOrderBtnMouseClicked
        if(orderId.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter Order Id");

        }else{
            try{
                
            Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stockmng","root","MySql#123");
            PreparedStatement add = Con.prepareStatement("insert into Sales values(?,?,?,?)");
            add.setInt(1, Integer.valueOf(orderId.getText()));
            add.setString(2, customerName.getText());
            add.setString(3, date.getText());
            add.setInt(4, Integer.valueOf(amount.getText()));          
            int row = add.executeUpdate();
            JOptionPane.showMessageDialog(this, "Order Succesfully Added!");
            Con.close();               
          
        }catch(SQLException e){
            e.printStackTrace();
        }
            
        }
        
      

    }//GEN-LAST:event_addOrderBtnMouseClicked

    int i = 1 ,unitPrice, total = 0 , tot;
    String productName;
    
    private void addToOrderBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addToOrderBtnMouseClicked
        if(flag == 0 || quantity.getText().isEmpty()||price.getText().isEmpty()){
             JOptionPane.showMessageDialog(this, "Please Select Product and Enetr Quantity");
        }else{
        unitPrice = Integer.valueOf(price.getText());
        total = unitPrice * Integer.valueOf(quantity.getText());
        Vector v = new Vector();
        v.add(i);
        v.add(productName);
        v.add(quantity.getText());
        v.add(price.getText());
        v.add(total);
        DefaultTableModel dt = (DefaultTableModel)orderTbl.getModel();
        dt.addRow(v);
        tot = tot + total;
        amount.setText(""+tot);
        UpdateProd();
        i++; 
        }
        
        
    }//GEN-LAST:event_addToOrderBtnMouseClicked

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnMouseClicked

    int flag = 0 , productId, oldQty;
    private void productTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTblMouseClicked
        DefaultTableModel model = (DefaultTableModel)productTbl.getModel();
        int Myindex = productTbl.getSelectedRow();
        productId = Integer.valueOf(model.getValueAt(Myindex, 0).toString());        
        productName = model.getValueAt(Myindex, 1).toString();
        oldQty = Integer.valueOf(model.getValueAt(Myindex, 2).toString());       
        price.setText(model.getValueAt(Myindex, 3).toString()); 
        
        flag = 1;
       
    }//GEN-LAST:event_productTblMouseClicked

    private void customerTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerTblMouseClicked
       DefaultTableModel model = (DefaultTableModel)customerTbl.getModel();
        int Myindex = customerTbl.getSelectedRow();
//        customerId.setText(model.getValueAt(Myindex, 0).toString());        
        customerName.setText(model.getValueAt(Myindex, 1).toString());
//        phoneNo.setText(model.getValueAt(Myindex, 2).toString());       
    }//GEN-LAST:event_customerTblMouseClicked

    private void orderTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderTblMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_orderTblMouseClicked

    private void orderIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderIdMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_orderIdMouseClicked

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
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addOrderBtn;
    private javax.swing.JButton addToOrderBtn;
    private javax.swing.JLabel amount;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel close;
    private javax.swing.JLabel customerName;
    private javax.swing.JTable customerTbl;
    private javax.swing.JLabel date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField orderId;
    private javax.swing.JTable orderTbl;
    private javax.swing.JLabel price;
    private javax.swing.JTable productTbl;
    private javax.swing.JTextField quantity;
    // End of variables declaration//GEN-END:variables
}
