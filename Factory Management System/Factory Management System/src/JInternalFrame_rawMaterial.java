
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mehme
 */
public class JInternalFrame_rawMaterial extends javax.swing.JInternalFrame implements JInternalFrames{
    
    
    DefaultTableModel model;
    RawMaterialOperations rm_opeRawMaterialOperations = new RawMaterialOperations();
    

    /**
     * Creates new form JInternalFrame_rawMaterial
     */
    public JInternalFrame_rawMaterial() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        
        model = (DefaultTableModel) Table_rawmaterial.getModel();
        showAll();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TF_materail_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TF_materail_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TF_supp_id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA_explanation = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        TF_materail_amount = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TF_material_price = new javax.swing.JTextField();
        Button_add = new javax.swing.JButton();
        Button_delete = new javax.swing.JButton();
        Button_update = new javax.swing.JButton();
        Buttton_clear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_rawmaterial = new javax.swing.JTable();
        TF_search = new javax.swing.JTextField();
        label_message = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(16, 78, 139));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Raw Materail ID");

        TF_materail_id.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Supplier ID");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Explanation");

        TA_explanation.setColumns(20);
        TA_explanation.setRows(5);
        jScrollPane1.setViewportView(TA_explanation);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Amount");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Price");

        Button_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        Button_add.setText("ADD");
        Button_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_addActionPerformed(evt);
            }
        });

        Button_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        Button_delete.setText("DELETE");
        Button_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_deleteActionPerformed(evt);
            }
        });

        Button_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/updated.png"))); // NOI18N
        Button_update.setText("UPDATE");
        Button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_updateActionPerformed(evt);
            }
        });

        Buttton_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/clear.png"))); // NOI18N
        Buttton_clear.setText("CLEAR");

        Table_rawmaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Raw Material ID", "Name", "Supplier ID", "Explanation", "Amount", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table_rawmaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_rawmaterialMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table_rawmaterial);
        if (Table_rawmaterial.getColumnModel().getColumnCount() > 0) {
            Table_rawmaterial.getColumnModel().getColumn(0).setResizable(false);
            Table_rawmaterial.getColumnModel().getColumn(1).setResizable(false);
            Table_rawmaterial.getColumnModel().getColumn(2).setResizable(false);
            Table_rawmaterial.getColumnModel().getColumn(3).setResizable(false);
            Table_rawmaterial.getColumnModel().getColumn(4).setResizable(false);
            Table_rawmaterial.getColumnModel().getColumn(5).setResizable(false);
        }

        TF_search.setText("                                                                                                     SEARCH AREA");
        TF_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TF_searchMouseClicked(evt);
            }
        });
        TF_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TF_searchKeyReleased(evt);
            }
        });

        label_message.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(28, 28, 28)))
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TF_materail_name, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_materail_id, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_supp_id, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TF_material_price, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TF_materail_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Button_update, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Buttton_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Button_add, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Button_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(label_message, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(181, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(TF_search)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE))
                .addGap(115, 115, 115))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_add, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_update, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buttton_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(label_message, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(TF_search, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TF_materail_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(TF_materail_amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TF_materail_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(TF_material_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_supp_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_addActionPerformed
       
        
        String name = TF_materail_name.getText();
        int supplier_id = Integer.parseInt(TF_supp_id.getText());
        String explanation = TA_explanation.getText();
        int amount = Integer.parseInt(TF_materail_amount.getText());
        float price = Float.parseFloat(TF_material_price.getText());
        
        rm_opeRawMaterialOperations.addRawMaterial(name, supplier_id, explanation, amount, price);
        showAll();
        
    }//GEN-LAST:event_Button_addActionPerformed

    private void Button_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_deleteActionPerformed
        
        int selectedrow = Table_rawmaterial.getSelectedRow();
         if (selectedrow == -1) {
           if (model.getRowCount() == 0 ) {
               label_message.setText("TABLE IS EMPTY");
           }
           else {
               label_message.setText("PLEASE CHOOSE A RAW MATERIAL");
           }
      
       }
       else {
           int id = (int)model.getValueAt(selectedrow,0);
           
           rm_opeRawMaterialOperations.delete(id);
           
           showAll();
           
           label_message.setText("RAW MATERIAL IS DELETED SUCCESSFULLLY");
           clearAreas();
           
           
           
       }
        
        
        
    }//GEN-LAST:event_Button_deleteActionPerformed

    private void Button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_updateActionPerformed
        
        try {
            String name = TF_materail_name.getText();
        int supplier_id = Integer.parseInt(TF_supp_id.getText());
        String explanation = TA_explanation.getText();
        int amount = Integer.parseInt(TF_materail_amount.getText());
        float price = Float.parseFloat(TF_material_price.getText());
        
        
        int selectedrow = Table_rawmaterial.getSelectedRow();
        
        if (selectedrow == -1) {
            
            if (model.getRowCount() == 0) {
                label_message.setText("TABLE IS EMPYT");
            }
            else {
                label_message.setText("PLEASE CHOOSE A RAW MATERIAL");
            }
        }
        else {
            
            
            
            
            int id = (int)model.getValueAt(selectedrow,0);
            
            
            
            rm_opeRawMaterialOperations.updateRawMaterial(id, name, supplier_id, explanation, amount, price);
            
            showAll();
            
            label_message.setText("RAW MATERIAL IS UPDATE SUCCESSFULLLY");
        }
        } catch (Exception e) {
        }
        
        
        
    }//GEN-LAST:event_Button_updateActionPerformed

    private void TF_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF_searchKeyReleased
        
        
        String search = TF_search.getText();
        dynamicSearch(search);
        
    }//GEN-LAST:event_TF_searchKeyReleased

    private void Table_rawmaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_rawmaterialMouseClicked
        int selectedrow = Table_rawmaterial.getSelectedRow();
        TF_materail_id.setText(model.getValueAt(selectedrow, 0).toString());
        TF_materail_name.setText(model.getValueAt(selectedrow, 1).toString());
        TF_supp_id.setText(model.getValueAt(selectedrow, 2).toString());
        TA_explanation.setText(model.getValueAt(selectedrow, 3).toString());
        TF_materail_amount.setText(model.getValueAt(selectedrow, 4).toString());
        TF_material_price.setText(model.getValueAt(selectedrow, 5).toString());
        
        
        
    }//GEN-LAST:event_Table_rawmaterialMouseClicked

    private void TF_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TF_searchMouseClicked
        TF_search.setText("");
    }//GEN-LAST:event_TF_searchMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_add;
    private javax.swing.JButton Button_delete;
    private javax.swing.JButton Button_update;
    private javax.swing.JButton Buttton_clear;
    private javax.swing.JTextArea TA_explanation;
    private javax.swing.JTextField TF_materail_amount;
    private javax.swing.JTextField TF_materail_id;
    private javax.swing.JTextField TF_materail_name;
    private javax.swing.JTextField TF_material_price;
    private javax.swing.JTextField TF_search;
    private javax.swing.JTextField TF_supp_id;
    private javax.swing.JTable Table_rawmaterial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_message;
    // End of variables declaration//GEN-END:variables

    @Override
    public void showAll() {
        
        model.setRowCount(0);
        ArrayList<RawMaterial> RM = new ArrayList<RawMaterial>();
        
        RM = rm_opeRawMaterialOperations.showRawMaterials();
        
        if(RM != null){
            
            for(RawMaterial element : RM){
                
                Object[] x = {element.getRmaterial_id(),element.getRmaterial_name(),element.getSupp_id(),element.getExplanation(),element.getAmount(),element.getPrice()};
                model.addRow(x);
            
            
            }
        
        
        }
        
    }

    @Override
    public void clearAreas() {
        TF_materail_id.setText("");
        TF_materail_name.setText("");
        TF_supp_id.setText("");
        TA_explanation.setText("");
        TF_materail_amount.setText("");
        TF_material_price.setText("");
        
    }

    @Override
    public void dynamicSearch(String search) {
        
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        
        
        Table_rawmaterial.setRowSorter(tr);
        
        
        tr.setRowFilter(RowFilter.regexFilter(search));
        
    }
}
