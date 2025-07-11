/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        
        String url = "jdbc:mysql://localhost:3306/system_event";
        String usuario = "root";
        String senha = "12345";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão bem-sucedida!");
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }
        
        
         String sql = "SELECT titulo FROM eventos WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            //aqui quando o gustavo juntar tudo tem q fazer de forma mulodar pra escolher qual evento é qual, por enquanto vamos passar o id de forma manual
            //stmt.setLong(1, idEvento);// define o ID do evento
            stmt.setLong(1, 1); 
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                lbl_titulo.setText(rs.getString("titulo"));
            } else {
                System.out.println("Evento não encontrado.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
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
        pnl_topo = new javax.swing.JPanel();
        lbl_topoevento = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_inscricao = new javax.swing.JButton();
        pnl_menudescricao = new javax.swing.JPanel();
        lbl_informainicio = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_informainscricao = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_informaatividades = new javax.swing.JLabel();
        lbl_titulo = new javax.swing.JLabel();

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

        pnl_topo.setBackground(new java.awt.Color(255, 255, 255));

        lbl_topoevento.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_topoevento.setText("EVENTOS");

        javax.swing.GroupLayout pnl_topoLayout = new javax.swing.GroupLayout(pnl_topo);
        pnl_topo.setLayout(pnl_topoLayout);
        pnl_topoLayout.setHorizontalGroup(
            pnl_topoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_topoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbl_topoevento)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_topoLayout.setVerticalGroup(
            pnl_topoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_topoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_topoevento)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btn_inscricao.setBackground(new java.awt.Color(0, 212, 146));
        btn_inscricao.setForeground(new java.awt.Color(255, 255, 255));
        btn_inscricao.setText("Realizar Inscrição");
        btn_inscricao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pnl_menudescricao.setBackground(new java.awt.Color(255, 255, 255));
        pnl_menudescricao.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_informainicio.setText("Inicio");

        jLabel10.setText(">");

        lbl_informainscricao.setText("Inscrição");

        jLabel11.setText(">");

        lbl_informaatividades.setText("Atividades");

        javax.swing.GroupLayout pnl_menudescricaoLayout = new javax.swing.GroupLayout(pnl_menudescricao);
        pnl_menudescricao.setLayout(pnl_menudescricaoLayout);
        pnl_menudescricaoLayout.setHorizontalGroup(
            pnl_menudescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menudescricaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_informainicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_informainscricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_informaatividades)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_menudescricaoLayout.setVerticalGroup(
            pnl_menudescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_menudescricaoLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(pnl_menudescricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_informainicio)
                    .addComponent(jLabel10)
                    .addComponent(lbl_informainscricao)
                    .addComponent(jLabel11)
                    .addComponent(lbl_informaatividades))
                .addContainerGap())
        );

        lbl_titulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_titulo.setText("titulo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_menudescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_inscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(lbl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnl_menudescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 374, Short.MAX_VALUE)
                .addComponent(btn_inscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_descricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_topo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnl_topo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
    private javax.swing.JButton btn_inscricao;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_descricaosistema;
    private javax.swing.JLabel lbl_informaatividades;
    private javax.swing.JLabel lbl_informainicio;
    private javax.swing.JLabel lbl_informainscricao;
    private javax.swing.JLabel lbl_linkatividades;
    private javax.swing.JLabel lbl_linkcronograma;
    private javax.swing.JLabel lbl_linkevento;
    private javax.swing.JLabel lbl_links;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_titulosistema;
    private javax.swing.JLabel lbl_topoevento;
    private javax.swing.JPanel pnl_descricao;
    private javax.swing.JPanel pnl_menudescricao;
    private javax.swing.JPanel pnl_topo;
    // End of variables declaration//GEN-END:variables
}
