/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

/**
 *
 * @author Kassandra Oliveira
 */
public class Tela_inscrição_atividades extends javax.swing.JFrame {

    /**
     * Creates new form Tela_inscrição_atividades
     */
    public Tela_inscrição_atividades() {
        initComponents();
        
          String texto = "<html><font color = 'WHITE'>Este sistema tem como objetivo gerenciar os eventos organizados<br>pelo Instituto Federal de Educação, Ciência e Tecnologia de<br>Rondônia - Campus Calama (IFRO), oferecendo ferramentas para<br>cadastro, divulgação, inscrições, controle de participante e<br>emissão de certificados</html>";
        lbl_descricaosistema.setText(texto);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_descricao = new javax.swing.JPanel();
        lbl_linkcronograma = new javax.swing.JLabel();
        lbl_descricaosistema = new javax.swing.JLabel();
        lbl_titulosistema = new javax.swing.JLabel();
        lbl_links = new javax.swing.JLabel();
        lbl_linkevento = new javax.swing.JLabel();
        lbl_linkatividades = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_descricao.setBackground(new java.awt.Color(0, 0, 0));

        lbl_linkcronograma.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_linkcronograma.setForeground(new java.awt.Color(255, 255, 255));
        lbl_linkcronograma.setText("• Cronograma");

        lbl_titulosistema.setBackground(new java.awt.Color(255, 255, 255));
        lbl_titulosistema.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl_titulosistema.setForeground(new java.awt.Color(60, 181, 132));
        lbl_titulosistema.setText("SISTEMA DE GERENCIAMENTO DE EVENTOS");

        lbl_links.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lbl_links.setForeground(new java.awt.Color(60, 181, 132));
        lbl_links.setText("Links");

        lbl_linkevento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_linkevento.setForeground(new java.awt.Color(255, 255, 255));
        lbl_linkevento.setText("• Eventos");

        lbl_linkatividades.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_linkatividades.setForeground(new java.awt.Color(255, 255, 255));
        lbl_linkatividades.setText("• Atividades");

        javax.swing.GroupLayout pnl_descricaoLayout = new javax.swing.GroupLayout(pnl_descricao);
        pnl_descricao.setLayout(pnl_descricaoLayout);
        pnl_descricaoLayout.setHorizontalGroup(
            pnl_descricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_descricaoLayout.createSequentialGroup()
                .addContainerGap(238, Short.MAX_VALUE)
                .addGroup(pnl_descricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_titulosistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_descricaosistema, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addGroup(pnl_descricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_linkcronograma)
                    .addComponent(lbl_linkevento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_links)
                    .addComponent(lbl_linkatividades, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(275, Short.MAX_VALUE))
        );
        pnl_descricaoLayout.setVerticalGroup(
            pnl_descricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_descricaoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnl_descricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_links)
                    .addComponent(lbl_titulosistema))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_descricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_descricaoLayout.createSequentialGroup()
                        .addComponent(lbl_linkevento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_linkatividades)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_linkcronograma))
                    .addGroup(pnl_descricaoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbl_descricaosistema, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_descricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 535, Short.MAX_VALUE)
                .addComponent(pnl_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Tela_inscrição_atividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_inscrição_atividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_inscrição_atividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_inscrição_atividades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_inscrição_atividades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_descricaosistema;
    private javax.swing.JLabel lbl_linkatividades;
    private javax.swing.JLabel lbl_linkcronograma;
    private javax.swing.JLabel lbl_linkevento;
    private javax.swing.JLabel lbl_links;
    private javax.swing.JLabel lbl_titulosistema;
    private javax.swing.JPanel pnl_descricao;
    // End of variables declaration//GEN-END:variables
}
