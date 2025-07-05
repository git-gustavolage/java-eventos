package view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tela_cadastro extends javax.swing.JFrame {

    public boolean isEmailValido(String email) {
    String regex = "^[\\w\\.-]+@[\\w\\.-]+\\.[a-zA-Z]{2,}$";
    return email.matches(regex);
}

    public Tela_cadastro() {
        initComponents();
       
    //faz com q abra em tela cheia.
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
     // logica para abrir a tela de cadastro
        lbl_entrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_entrar.addMouseListener(new java.awt.event.MouseAdapter() {
         @Override
           public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose(); // fecha a tela de cadastro 
                Tela_login l = new Tela_login();
               l.setVisible(true);
           }
        });

        // logica para abrir a tela de cadastro após cadastro criado
        btn_cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
         @Override
           public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose(); // fecha a tela de cadastro 
                Tela_login l = new Tela_login();
               l.setVisible(true);
           }
        });
        
        txt_nomeusuario.setText("Digite seu Nome...");
        txt_nomeusuario.setForeground(Color.BLACK);
        txt_nomeusuario.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txt_nomeusuario.getText().equals("Digite seu Nome...")) {
                    txt_nomeusuario.setText("");
                    txt_nomeusuario.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txt_nomeusuario.getText().isEmpty()) {
                    txt_nomeusuario.setText("Digite seu Nome...");
                    txt_nomeusuario.setForeground(Color.GRAY);
                }
            }
        });
        
        txt_email.setText("Digite seu Email...");
        txt_email.setForeground(Color.GRAY);
        txt_email.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txt_email.getText().equals("Digite seu Email...")) {
                    txt_email.setText("");
                    txt_email.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                String email = txt_email.getText().trim();
             if (email.isEmpty()) {
            txt_email.setText("Digite seu Email...");
            txt_email.setForeground(Color.GRAY);
        }   else if (!isEmailValido(email)) {
            JOptionPane.showMessageDialog(null, "Email inválido. Por favor, digite um email válido.");
            txt_email.requestFocus();
        }   
            }
        });
     
        
        //Placeholder para pwd_senha
        pwd_senha.setEchoChar((char) 0);
        pwd_senha.setText("Senha");
        pwd_senha.setForeground(Color.GRAY);
        pwd_senha.addFocusListener(new java.awt.event.FocusAdapter(){
          public void focusGained(java.awt.event.FocusEvent evt) {
              if (String.valueOf(pwd_senha.getPassword()).equals("Senha")) {
                  pwd_senha.setText("");
                  pwd_senha.setForeground(Color.BLACK);
                  pwd_senha.setEchoChar('*');
              }
          }
           public void focusLost(java.awt.event.FocusEvent evt) {
              if (String.valueOf(pwd_senha.getPassword()).isEmpty()){
                  pwd_senha.setText("Senha");
                  pwd_senha.setForeground(Color.GRAY);
                  pwd_senha.setEchoChar((char) 0);
              }
          }     
        });
        
        
        //Placeholder para pwd_senha
        pwd_senha02.setEchoChar((char) 0);
        pwd_senha02.setText("Senha");
        pwd_senha02.setForeground(Color.GRAY);
        pwd_senha02.addFocusListener(new java.awt.event.FocusAdapter(){
          public void focusGained(java.awt.event.FocusEvent evt) {
              if (String.valueOf(pwd_senha02.getPassword()).equals("Senha")) {
                  pwd_senha02.setText("");
                  pwd_senha02.setForeground(Color.BLACK);
                  pwd_senha02.setEchoChar('*');
              }
          }
           public void focusLost(java.awt.event.FocusEvent evt) {
              if (String.valueOf(pwd_senha02.getPassword()).isEmpty()){
                  pwd_senha02.setText("Senha");
                  pwd_senha02.setForeground(Color.GRAY);
                  pwd_senha02.setEchoChar((char) 0);
              }
          }     
        });  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_barraazul = new javax.swing.JPanel();
        pnl_fundo = new javax.swing.JPanel();
        pnl_cadastro = new javax.swing.JPanel();
        lbl_cadastro = new javax.swing.JLabel();
        btn_cadastrar = new javax.swing.JButton();
        pwd_senha = new javax.swing.JPasswordField();
        txt_email = new javax.swing.JTextField();
        lbl_pergunta = new javax.swing.JLabel();
        lbl_entrar = new javax.swing.JLabel();
        txt_nomeusuario = new javax.swing.JTextField();
        pwd_senha02 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_barraazul.setBackground(new java.awt.Color(43, 127, 255));
        pnl_barraazul.setForeground(new java.awt.Color(43, 127, 255));

        javax.swing.GroupLayout pnl_barraazulLayout = new javax.swing.GroupLayout(pnl_barraazul);
        pnl_barraazul.setLayout(pnl_barraazulLayout);
        pnl_barraazulLayout.setHorizontalGroup(
            pnl_barraazulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        pnl_barraazulLayout.setVerticalGroup(
            pnl_barraazulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        pnl_fundo.setBackground(new java.awt.Color(255, 255, 255));

        pnl_cadastro.setBackground(new java.awt.Color(255, 255, 255));
        pnl_cadastro.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbl_cadastro.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 35)); // NOI18N
        lbl_cadastro.setText("CADASTRO");
        lbl_cadastro.setToolTipText("");

        btn_cadastrar.setBackground(new java.awt.Color(0, 212, 146));
        btn_cadastrar.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        btn_cadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cadastrar.setText("Cadastrar");
        btn_cadastrar.setBorderPainted(false);
        btn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cadastrarActionPerformed(evt);
            }
        });

        pwd_senha.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        pwd_senha.setForeground(new java.awt.Color(212, 212, 216));
        pwd_senha.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        pwd_senha.setText("Senha");
        pwd_senha.setToolTipText("");
        pwd_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwd_senhaActionPerformed(evt);
            }
        });

        txt_email.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        txt_email.setForeground(new java.awt.Color(212, 212, 216));
        txt_email.setText("E-mail");
        txt_email.setToolTipText("");
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });

        lbl_pergunta.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 16)); // NOI18N
        lbl_pergunta.setText("Já possui uma conta?");

        lbl_entrar.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 16)); // NOI18N
        lbl_entrar.setForeground(new java.awt.Color(43, 127, 255));
        lbl_entrar.setText("Entrar");

        txt_nomeusuario.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        txt_nomeusuario.setForeground(new java.awt.Color(212, 212, 216));
        txt_nomeusuario.setText("Nome de usuário");
        txt_nomeusuario.setToolTipText("");
        txt_nomeusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomeusuarioActionPerformed(evt);
            }
        });

        pwd_senha02.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 14)); // NOI18N
        pwd_senha02.setForeground(new java.awt.Color(212, 212, 216));
        pwd_senha02.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        pwd_senha02.setText("Confirmação da senha");
        pwd_senha02.setToolTipText("");
        pwd_senha02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwd_senha02ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_cadastroLayout = new javax.swing.GroupLayout(pnl_cadastro);
        pnl_cadastro.setLayout(pnl_cadastroLayout);
        pnl_cadastroLayout.setHorizontalGroup(
            pnl_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cadastroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnl_cadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cadastroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_cadastro)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnl_cadastroLayout.createSequentialGroup()
                        .addGroup(pnl_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_email)
                            .addComponent(pwd_senha02, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_nomeusuario)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_cadastroLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lbl_pergunta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_entrar)
                                .addGap(228, 228, 228))
                            .addComponent(pwd_senha))
                        .addContainerGap())))
        );
        pnl_cadastroLayout.setVerticalGroup(
            pnl_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cadastroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_cadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nomeusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pwd_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pwd_senha02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(pnl_cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_pergunta)
                    .addComponent(lbl_entrar))
                .addGap(23, 23, 23)
                .addComponent(btn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout pnl_fundoLayout = new javax.swing.GroupLayout(pnl_fundo);
        pnl_fundo.setLayout(pnl_fundoLayout);
        pnl_fundoLayout.setHorizontalGroup(
            pnl_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_fundoLayout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(pnl_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );
        pnl_fundoLayout.setVerticalGroup(
            pnl_fundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_fundoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnl_barraazul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_barraazul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_fundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void btn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cadastrarActionPerformed
    

String nome = txt_nomeusuario.getText().trim();    // nome de usuário
String email = txt_email.getText().trim();         // email
String senha = new String(pwd_senha.getPassword()).trim();      // senha
String senha2 = new String(pwd_senha02.getPassword()).trim();   // confirmação de senha

// Verificação de campos obrigatórios
if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || senha2.isEmpty()) {
      JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
return;
}

// Verificação se as senhas coincidem
if (!senha.equals(senha2)) {
    JOptionPane.showMessageDialog(this, "As senhas não coincidem!", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
}

// Cadastro bem-sucedido
JOptionPane.showMessageDialog(this, "Seu cadastro foi realizado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
   dispose(); // Fecha a tela de cadastro
    Tela_login login = new Tela_login();
    login.setVisible(true);
    return; 
   
        
    }//GEN-LAST:event_btn_cadastrarActionPerformed

    private void pwd_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwd_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwd_senhaActionPerformed

    private void txt_nomeusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomeusuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeusuarioActionPerformed

    private void pwd_senha02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwd_senha02ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwd_senha02ActionPerformed
 
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
            java.util.logging.Logger.getLogger(Tela_cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cadastrar;
    private javax.swing.JLabel lbl_cadastro;
    private javax.swing.JLabel lbl_entrar;
    private javax.swing.JLabel lbl_pergunta;
    private javax.swing.JPanel pnl_barraazul;
    private javax.swing.JPanel pnl_cadastro;
    private javax.swing.JPanel pnl_fundo;
    private javax.swing.JPasswordField pwd_senha;
    private javax.swing.JPasswordField pwd_senha02;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nomeusuario;
    // End of variables declaration//GEN-END:variables
}
