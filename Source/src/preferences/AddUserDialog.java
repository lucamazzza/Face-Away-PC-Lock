package preferences;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.LineBorder;

/**
 *
 * @author lucamazza
 */
public class AddUserDialog extends javax.swing.JDialog {

    private String dir;
    
    private String name;
    
    private boolean cancelled  = true;
    
    private boolean hasRegistered;
    
    private String filename;
    
    /**
     * Creates new form AddUserDialog
     */
    public AddUserDialog(java.awt.Frame parent, boolean modal, String dir) {
        super(parent, modal);
        this.dir = dir;
        this.filename = "/Users/lucamazza/Documents/GitHub/Face-Away-PC-Lock/Source/facelock/faceCheck.py";
        initComponents();
    }
    
    public String getName(){
        return this.name;
    }
    
    public boolean isCancelled(){
        return this.cancelled;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        nameTextField = new javax.swing.JTextField();
        registerFaceButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(236, 236, 236));
        setResizable(false);

        nameLabel.setText("Name");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        nameTextField.setToolTipText("");

        registerFaceButton.setText("Register Face");
        registerFaceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerFaceButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(registerFaceButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerFaceButton)
                    .addComponent(cancelButton)
                    .addComponent(saveButton)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if(!nameTextField.getText().equals("") /*&& this.hasRegistered*/){
            this.name = nameTextField.getText().strip().trim();
            this.cancelled = false;
            this.nameTextField.setBorder(new LineBorder(Color.black));
            this.registerFaceButton.setForeground(Color.black);
            File dir = new File(this.dir + name);
            // if the directory does not exist, create it
            if (!dir.exists()) {
                boolean result = false;
                try{
                    dir.mkdir();
                    result = true;
                } 
                catch(SecurityException se){
                    //handle it
                }
            }
            this.dispose();
        }else if(nameTextField.getText().equals("") /*&& this.hasRegistered*/) {
            this.nameTextField.setBorder(new LineBorder(Color.red));
            this.cancelled = true;
        }else if(!nameTextField.getText().equals("") /*&& !this.hasRegistered*/){
            this.registerFaceButton.setForeground(Color.red);
            this.nameTextField.setBorder(new LineBorder(Color.black));
            this.cancelled = true;
        }else{
            this.nameTextField.setBorder(new LineBorder(Color.red));
            this.registerFaceButton.setForeground(Color.red);
            this.cancelled = true;
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.cancelled = true;
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void registerFaceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerFaceButtonActionPerformed
        String os = System.getProperty("os.name").toLowerCase();
        if(os.indexOf("mac") >= 0){
            try {
                System.out.println("mac");
                //Process p = Runtime.getRuntime().exec("open -a /System/Applications/Utilities/Terminal.app");
                Process p = Runtime.getRuntime().exec("open -a /System/Applications/Utilities/Terminal.app");
            } catch (IOException ex) {
                System.out.println("Errore D:");
            }
        }else if(os.indexOf("win") >= 0){
            System.out.println("win");
        }else if(os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") >= 0){
            System.out.println("nix");
        }
    }//GEN-LAST:event_registerFaceButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddUserDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUserDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUserDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUserDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddUserDialog dialog = new AddUserDialog(new javax.swing.JFrame(), true, "/Users/lucamazza/Desktop/");
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton registerFaceButton;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
