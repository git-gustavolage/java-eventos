/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author Kassandra Oliveira
 */
public class Tela_cadastro_atividades extends javax.swing.JFrame {

    private void atualizarDiasEHorarios() {
    String qtdDiasTexto = txt_quantdias.getText().trim();

    try {
        int qtdDias = Integer.parseInt(qtdDiasTexto);
        if (qtdDias <= 0) {
            JOptionPane.showMessageDialog(this, "Informe um número maior que zero.");
            return;
        }

        jPanel1.removeAll();  // limpa os componentes antes

        for (int i = 1; i <= qtdDias; i++) {
            JPanel painelDia = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

            JLabel lblDia = new JLabel("Dia " + i + ": ");
            lblDia.setPreferredSize(new java.awt.Dimension(60, 25));

            // Campo Hora de Início
            JLabel lblHoraInicio = new JLabel("Hora início:");
            JTextField txtHoraInicio = new JTextField();
            txtHoraInicio.setColumns(5);
            txtHoraInicio.setName("txtHoraInicioDia" + i);

            // Campo Hora Final
            JLabel lblHoraFinal = new JLabel("Hora final:");
            JTextField txtHoraFinal = new JTextField();
            txtHoraFinal.setColumns(5);
            txtHoraFinal.setName("txtHoraFinalDia" + i);

            // Adiciona tudo no painel horizontal
            painelDia.add(lblDia);
            painelDia.add(lblHoraInicio);
            painelDia.add(txtHoraInicio);
            painelDia.add(lblHoraFinal);
            painelDia.add(txtHoraFinal);

            jPanel1.add(painelDia);
        }

        jPanel1.revalidate();
        jPanel1.repaint();

    } catch (NumberFormatException e) {
        
    }
}

    private boolean isHoraValida(String horaStr) {
    if (horaStr == null || horaStr.isEmpty()) return false;

    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm");
    sdf.setLenient(false);

    try {
        sdf.parse(horaStr);
        return true;
    } catch (java.text.ParseException e) {
        return false;
    }
}
    
    private void mostrarDataFinal() {
    String dataTexto = txt_dataatividade.getText().trim();
    String qtdDiasTexto = txt_quantdias.getText().trim();

    if (!isDataValida(dataTexto)) {
        JOptionPane.showMessageDialog(this, "Data inválida! Use o formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        int qtdDias = Integer.parseInt(qtdDiasTexto);
        if (qtdDias <= 0) {
            JOptionPane.showMessageDialog(this, "A quantidade de dias deve ser maior que zero.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        java.util.Date dataInicio = sdf.parse(dataTexto);

        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(dataInicio);
        cal.add(java.util.Calendar.DAY_OF_MONTH, qtdDias - 1); // -1 porque o dia inicial já conta

        String dataFinal = sdf.format(cal.getTime());

        JOptionPane.showMessageDialog(this, "Data final: " + dataFinal, "Data Calculada", JOptionPane.INFORMATION_MESSAGE);

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Digite um número válido de dias.", "Erro", JOptionPane.ERROR_MESSAGE);
    } catch (java.text.ParseException e) {
        JOptionPane.showMessageDialog(this, "Erro ao processar a data.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    private boolean isDataValida(String dataStr) {
        if (dataStr == null || dataStr.isEmpty()) return false;

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // não permite datas inválidas como 32/01/2023

        try {
            sdf.parse(dataStr);
            return true;
        } catch (java.text.ParseException e) {
            return false;
        }
    }

    public Tela_cadastro_atividades() {
        initComponents();
        
             jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        // logica para abrir a tela de cadastro
        lbl_organizadores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_organizadores.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose(); // fecha a tela de login 
                Tela_cadastro_organizador cadastro = new Tela_cadastro_organizador();
                cadastro.setVisible(true);
            }
        });
        
                // logica para abrir a tela de cadastro
        lbl_geral.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_geral.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose(); // fecha a tela de login 
                Tela_cadastro_eventos_geral cadastro = new Tela_cadastro_eventos_geral();
                cadastro.setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_quantdias = new javax.swing.JLabel();
        txt_quantdias = new javax.swing.JTextField();
        lbl_ambientes = new javax.swing.JLabel();
        lbl_localatividade = new javax.swing.JLabel();
        txt_localatividade = new javax.swing.JTextField();
        btn_voltar = new javax.swing.JButton();
        lbl_dialocal = new javax.swing.JLabel();
        lbl_inicio = new javax.swing.JLabel();
        lbl_cadastro02 = new javax.swing.JLabel();
        lbl_atividades02 = new javax.swing.JLabel();
        lbl_componente1 = new javax.swing.JLabel();
        lbl_componente02 = new javax.swing.JLabel();
        lbl_data = new javax.swing.JLabel();
        bnt_salvar = new javax.swing.JButton();
        lbl_ATIVIDADES = new javax.swing.JLabel();
        txt_nomeatividades = new javax.swing.JTextField();
        lbl_nomeatividades = new javax.swing.JLabel();
        txt_categoria = new javax.swing.JTextField();
        lbl_categoria = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_cadastroevento = new javax.swing.JLabel();
        lbl_atividades = new javax.swing.JLabel();
        lbl_geral = new javax.swing.JLabel();
        lbl_organizadores = new javax.swing.JLabel();
        lbl_dataatividade = new javax.swing.JLabel();
        txt_dataatividade = new javax.swing.JTextField();
        btn_confirmadata = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_quantdias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_quantdias.setText("Quantidade de dias:");

        txt_quantdias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantdiasActionPerformed(evt);
            }
        });

        lbl_ambientes.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbl_ambientes.setText("• Ambientes");

        lbl_localatividade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_localatividade.setText("Local da atividade:");

        txt_localatividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_localatividadeActionPerformed(evt);
            }
        });

        btn_voltar.setText("Voltar");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        lbl_dialocal.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbl_dialocal.setText("Dia 01");

        lbl_inicio.setText("Inicio");

        lbl_cadastro02.setText("Cadastro");

        lbl_atividades02.setText("Atividades");

        lbl_componente1.setText(">");

        lbl_componente02.setText(">");

        lbl_data.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbl_data.setText("• Data");

        bnt_salvar.setBackground(new java.awt.Color(0, 212, 146));
        bnt_salvar.setForeground(new java.awt.Color(255, 255, 255));
        bnt_salvar.setText("Salvar");
        bnt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_salvarActionPerformed(evt);
            }
        });

        lbl_ATIVIDADES.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbl_ATIVIDADES.setText("• Atividades");

        txt_nomeatividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomeatividadesActionPerformed(evt);
            }
        });

        lbl_nomeatividades.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_nomeatividades.setText("Nome da atividade:");

        txt_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_categoriaActionPerformed(evt);
            }
        });

        lbl_categoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_categoria.setText("Categoria:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 248, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        lbl_cadastroevento.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbl_cadastroevento.setText("Cadastro de eventos");
        lbl_cadastroevento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbl_atividades.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_atividades.setText("• Atividades");

        lbl_geral.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_geral.setText("◦ Geral");

        lbl_organizadores.setText("◦ Organizadores");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_organizadores)
                            .addComponent(lbl_atividades)
                            .addComponent(lbl_geral)))
                    .addComponent(lbl_cadastroevento))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_cadastroevento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_geral)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_atividades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_organizadores)
                .addContainerGap(439, Short.MAX_VALUE))
        );

        lbl_dataatividade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_dataatividade.setText("Data da atividade:");

        txt_dataatividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dataatividadeActionPerformed(evt);
            }
        });

        btn_confirmadata.setText("Confirmar");
        btn_confirmadata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmadataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bnt_salvar)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_inicio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_componente1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_cadastro02)
                                .addGap(6, 6, 6)
                                .addComponent(lbl_componente02)
                                .addGap(6, 6, 6)
                                .addComponent(lbl_atividades02))
                            .addComponent(lbl_ATIVIDADES)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_nomeatividades)
                                    .addComponent(txt_localatividade, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_voltar)
                                    .addComponent(lbl_categoria)
                                    .addComponent(txt_nomeatividades, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_data)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_dataatividade)
                                            .addComponent(txt_dataatividade, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(59, 59, 59)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_quantdias)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txt_quantdias, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btn_confirmadata))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_dialocal)
                                            .addComponent(lbl_ambientes)
                                            .addComponent(lbl_localatividade))))))
                        .addContainerGap(209, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_inicio)
                    .addComponent(lbl_cadastro02)
                    .addComponent(lbl_atividades02)
                    .addComponent(lbl_componente1)
                    .addComponent(lbl_componente02))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_ATIVIDADES)
                .addGap(6, 6, 6)
                .addComponent(lbl_nomeatividades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nomeatividades, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_categoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_data)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_dataatividade)
                    .addComponent(lbl_quantdias))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_dataatividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_quantdias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_confirmadata))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(lbl_ambientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_dialocal, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_localatividade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_localatividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bnt_salvar)
                    .addComponent(btn_voltar))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 54, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_quantdiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantdiasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantdiasActionPerformed

    private void txt_localatividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_localatividadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_localatividadeActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void bnt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_salvarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bnt_salvarActionPerformed

    private void txt_nomeatividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomeatividadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeatividadesActionPerformed

    private void txt_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_categoriaActionPerformed

    private void txt_dataatividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dataatividadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dataatividadeActionPerformed

    private void btn_confirmadataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmadataActionPerformed
    mostrarDataFinal();
    atualizarDiasEHorarios();
    }//GEN-LAST:event_btn_confirmadataActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_cadastro_atividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_cadastro_atividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_cadastro_atividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_cadastro_atividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_cadastro_atividades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_salvar;
    private javax.swing.JButton btn_confirmadata;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_ATIVIDADES;
    private javax.swing.JLabel lbl_ambientes;
    private javax.swing.JLabel lbl_atividades;
    private javax.swing.JLabel lbl_atividades02;
    private javax.swing.JLabel lbl_cadastro02;
    private javax.swing.JLabel lbl_cadastroevento;
    private javax.swing.JLabel lbl_categoria;
    private javax.swing.JLabel lbl_componente02;
    private javax.swing.JLabel lbl_componente1;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_dataatividade;
    private javax.swing.JLabel lbl_dialocal;
    private javax.swing.JLabel lbl_geral;
    private javax.swing.JLabel lbl_inicio;
    private javax.swing.JLabel lbl_localatividade;
    private javax.swing.JLabel lbl_nomeatividades;
    private javax.swing.JLabel lbl_organizadores;
    private javax.swing.JLabel lbl_quantdias;
    private javax.swing.JTextField txt_categoria;
    private javax.swing.JTextField txt_dataatividade;
    private javax.swing.JTextField txt_localatividade;
    private javax.swing.JTextField txt_nomeatividades;
    private javax.swing.JTextField txt_quantdias;
    // End of variables declaration//GEN-END:variables
}
