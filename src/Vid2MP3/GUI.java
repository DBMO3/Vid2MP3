// package
package Vid2MP3;

// Libraries
import java.awt.Desktop;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import javax.swing.JOptionPane;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Author DBMO3*/
public class GUI extends javax.swing.JFrame {
    private boolean warningMessage = false;
    
    // Create GUI
    public GUI() {
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

        jTextField_URL = new javax.swing.JTextField();
        jButton_Convert = new javax.swing.JButton();
        jLabel_Text = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMenuItem_Help = new javax.swing.JMenuItem();
        jMenuItem_Donate = new javax.swing.JMenuItem();
        jMenuItem_About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vid2MP3 v1.0");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jTextField_URL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_URLActionPerformed(evt);
            }
        });

        jButton_Convert.setText("Convert");
        jButton_Convert.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_Convert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ConvertActionPerformed(evt);
            }
        });

        jLabel_Text.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_Text.setText("Put your URL:");

        jMenu.setText("More");
        jMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenuItem_Help.setText("Help");
        jMenuItem_Help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_HelpActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItem_Help);

        jMenuItem_Donate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/donate.png"))); // NOI18N
        jMenuItem_Donate.setText("Donate");
        jMenuItem_Donate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_DonateActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItem_Donate);

        jMenuItem_About.setText("About");
        jMenuItem_About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_AboutActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItem_About);

        jMenuBar.add(jMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jTextField_URL, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jButton_Convert))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel_Text, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel_Text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField_URL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_Convert)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTextField_URL.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_URLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_URLActionPerformed
        //Nothing
    }//GEN-LAST:event_jTextField_URLActionPerformed

    private void jMenuItem_HelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_HelpActionPerformed
        // Show help message
        JOptionPane.showMessageDialog(null, "How to use: \n "
                + "1. Put your URL to text field.\n "
                + "2. Click on Convert Button.\n"
                + "3. Enjoy :3\n"
                + "-------------------------\n"
                + "Como usar:\n"
                + "1. Pega tu URL en el campo de texto.\n"
                + "2. Pulsa el boton Convert.\n"
                + "3. Disfruta :3.\n", "Vid2MP3", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem_HelpActionPerformed
    private boolean isValidURL(String url) {
        String regex = "^(https?|ftp)://[\\w\\-]+(\\.[\\w\\-]+)+([\\w\\-.,@?^=%&:/~+#]*[\\w\\-@?^=%&/~+#])?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
    private void jButton_ConvertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ConvertActionPerformed
        try{
        // url
        String url = jTextField_URL.getText();
        
        // Catch error if var url is empty
        if(!isValidURL(url)){
            JOptionPane.showMessageDialog(null, "Input a URL from YouTube", "Invalid URL", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // rojectPath & exe folder
        String projectPath = System.getProperty("user.dir");
        String executableFolder = "executables";
        
        // Path executables
        String convertVideo = projectPath + "/" + executableFolder + "/yt-dlp";
        
        // Save files on Desktop
        String downloadPath = System.getProperty("user.home") + "/Downloads/";
        
        // Warning message
        if(!warningMessage){
            JOptionPane.showMessageDialog(null, "Hello! We'd like to let you know that during the conversion process, you might notice that the program appears to be frozen for a moment. \n Don't worry, this is completely normal. \n Video conversion can be a resource-intensive task and may take some time, depending on the video's duration and your internet connection. \n We kindly ask for your patience and not to close the program. \n Once the conversion is complete, you'll receive a notification. \n Thank you for your understanding!", "Notice", JOptionPane.INFORMATION_MESSAGE);
            warningMessage = true;
        }
        
        // Get title video
        ProcessBuilder infoProcessBuilder = new ProcessBuilder(convertVideo, "--get-title",url);
        Process infoProcess = infoProcessBuilder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(infoProcess.getInputStream()));
        String videoTitle = reader.readLine().trim();
        
        //Remove invalid chars
        videoTitle = videoTitle.replaceAll("[^a-zA-Z0-9-_\\.]", "_");
        
        // Output with videoTitle
        String convertedVideo = videoTitle + ".mp3";
        String outputPath = downloadPath + convertedVideo;
        
        // Command 
        String[] command = {
            convertVideo, url, "-x", "--audio-format", "mp3", "--audio-quality", "5", "-o", outputPath
        };
        
        // Execute command
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();
        
        // Status code
        int exitCode = process.waitFor();
        if(exitCode == 0){
            JOptionPane.showMessageDialog(null, "Success, video converted to mp3", "Complete", JOptionPane.INFORMATION_MESSAGE);
            
            // Open download folder
            String userHome = System.getProperty("user.home");
            String downloadsFolder = userHome + File.separator + "Downloads";
            
            File folder = new File(downloadsFolder);
            try{
                if(folder.exists() && Desktop.isDesktopSupported()){
                    Desktop.getDesktop().open(folder);
                } else {
                    JOptionPane.showMessageDialog(null, "Error to open downloads folder", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch(IOException e){
                 JOptionPane.showMessageDialog(null, "An unexpected error ocurred while converting video, please try again", "Unexpected error", JOptionPane.ERROR_MESSAGE);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Error converting to mp3, verify your internet connectivity", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        }
        catch(IOException | InterruptedException e){
            JOptionPane.showMessageDialog(null, "An unexpected error ocurred while converting video, please try again", "Unexpected error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton_ConvertActionPerformed

    private void jMenuItem_DonateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_DonateActionPerformed
        // Open website PayPal
        try{
            Desktop.getDesktop().browse(new URI("https://paypal.me/dbm360?country.x=MX&locale.x=es_XC"));
        } catch(URISyntaxException | IOException e) {
            // Catch some error
            JOptionPane.showMessageDialog(null, "Error to open website", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem_DonateActionPerformed

    private void jMenuItem_AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_AboutActionPerformed
        // Show message info
        JOptionPane.showMessageDialog(null, "Vid2MP3 v1.0 (2023).\nDeveloper by: DBMO3", "About",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem_AboutActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Convert;
    private javax.swing.JLabel jLabel_Text;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem_About;
    private javax.swing.JMenuItem jMenuItem_Donate;
    private javax.swing.JMenuItem jMenuItem_Help;
    private javax.swing.JTextField jTextField_URL;
    // End of variables declaration//GEN-END:variables

}