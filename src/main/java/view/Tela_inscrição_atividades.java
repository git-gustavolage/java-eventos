/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Kassandra Oliveira
 */
public class Tela_inscrição_atividades extends javax.swing.JFrame {
    
    private void carregarAtividadesDoEvento(long idEvento) {
    String url = "jdbc:mysql://localhost:3306/system_event";
    String usuario = "root";
    String senha = "12345";

    String sql = "SELECT a.id, a.data, a.titulo, a.hora_inicio, a.hora_termino, amb.nome AS local " +
                 "FROM atividades a " +
                 "JOIN ambientes amb ON a.id_ambiente = amb.id " +
                 "WHERE a.id_evento = ? " +
                 "ORDER BY a.data, a.hora_inicio";

    try (Connection conn = DriverManager.getConnection(url, usuario, senha);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setLong(1, idEvento);
        ResultSet rs = stmt.executeQuery();

        pnl_atividades.removeAll();
        pnl_atividades.setLayout(new BoxLayout(pnl_atividades, BoxLayout.Y_AXIS));

        LocalDate dataAtual = null;
        int contadorDias = 1;
        JPanel painelDia = null;

        while (rs.next()) {
            long idAtividade = rs.getLong("id");
            LocalDate data = rs.getDate("data").toLocalDate();
            String titulo = rs.getString("titulo");
            String horaInicio = rs.getString("hora_inicio");
            String horaTermino = rs.getString("hora_termino");
            String local = rs.getString("local");

            if (!data.equals(dataAtual)) {
                dataAtual = data;

                // Painel com alinhamento à esquerda para o rótulo do dia
                JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                headerPanel.setBackground(Color.WHITE);

                JLabel lblDia = new JLabel("Dia " + contadorDias + " - " + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                lblDia.setFont(new Font("SansSerif", Font.BOLD, 16));
                lblDia.setForeground(Color.BLACK);
                headerPanel.add(lblDia);

                // Painel das atividades daquele dia
                painelDia = new JPanel();
                painelDia.setLayout(new BoxLayout(painelDia, BoxLayout.Y_AXIS));
                painelDia.setBackground(Color.WHITE);
                painelDia.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(200, 200, 200)),
                        BorderFactory.createEmptyBorder(10, 15, 10, 15)
                ));

                pnl_atividades.add(headerPanel);
                pnl_atividades.add(painelDia);

                contadorDias++;
            }

            // Painel da atividade
            JPanel atividadePanel = new JPanel(new BorderLayout());
            atividadePanel.setBackground(new Color(245, 245, 245)); // Cor padrão
            atividadePanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            atividadePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

            atividadePanel.putClientProperty("selecionado", false); // inicialmente não selecionado
            atividadePanel.putClientProperty("id", idAtividade);    // salva o ID da atividade, se precisar depois

            // Informações da atividade
            JLabel lblTitulo = new JLabel(titulo);
            lblTitulo.setFont(new Font("SansSerif", Font.PLAIN, 14));

            JLabel lblHorarioLocal = new JLabel(horaInicio + " - " + horaTermino + " | " + local);
            lblHorarioLocal.setFont(new Font("SansSerif", Font.ITALIC, 12));
            lblHorarioLocal.setForeground(new Color(100, 100, 100));

            atividadePanel.add(lblTitulo, BorderLayout.WEST);
            atividadePanel.add(lblHorarioLocal, BorderLayout.EAST);

            // Clique para seleção
            atividadePanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    boolean selecionado = (boolean) atividadePanel.getClientProperty("selecionado");
                    if (!selecionado) {
                        atividadePanel.setBackground(new Color(173, 216, 230)); // azul claro
                    } else {
                        atividadePanel.setBackground(new Color(245, 245, 245)); // cor padrão
                    }
                    atividadePanel.putClientProperty("selecionado", !selecionado);
                }
            });

            if (painelDia != null) {
                painelDia.add(atividadePanel);
                painelDia.add(Box.createVerticalStrut(5)); // espaço entre atividades
            }
        }

        pnl_atividades.revalidate();
        pnl_atividades.repaint();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public Tela_inscrição_atividades() {
        initComponents();
        
        //faz com q abra em tela cheia
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Configurar layout vertical para o painel de atividades
        pnl_atividades.setLayout(new BoxLayout(pnl_atividades, BoxLayout.Y_AXIS));
        pnl_atividades.setBackground(Color.WHITE);
        scr_atividades.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


        //aqui quando o gustavo juntar tudo tem q fazer de forma mulodar pra escolher qual evento é qual, por enquanto vamos passar o id de forma manual
        carregarAtividadesDoEvento(1); // ou outro ID conforme o evento selecionado

        
        String url = "jdbc:mysql://localhost:3306/system_event";
        String usuario = "root";
        String senha = "12345";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão bem-sucedida!");
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro na conexao: " + e.getMessage());
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
        jPanel1 = new javax.swing.JPanel();
        btn_inscrever = new javax.swing.JButton();
        pnl_menudescricao = new javax.swing.JPanel();
        lbl_informainicio = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_informainscricao = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_informaatividades = new javax.swing.JLabel();
        lbl_titulo = new javax.swing.JLabel();
        scr_atividades = new javax.swing.JScrollPane();
        pnl_atividades = new javax.swing.JPanel();
        chk_deficiencia = new javax.swing.JCheckBox();
        txt_deficiencia = new javax.swing.JTextField();
        lbl_possuideficiencia = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnl_topo = new javax.swing.JPanel();
        lbl_topoevento = new javax.swing.JLabel();

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btn_inscrever.setBackground(new java.awt.Color(0, 212, 146));
        btn_inscrever.setForeground(new java.awt.Color(255, 255, 255));
        btn_inscrever.setText("Realizar Inscrição");
        btn_inscrever.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_inscrever.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inscreverActionPerformed(evt);
            }
        });

        pnl_menudescricao.setBackground(new java.awt.Color(255, 255, 255));
        pnl_menudescricao.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lbl_informainicio.setText("Inicio");
        lbl_informainicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_informainicioMouseClicked(evt);
            }
        });

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

        scr_atividades.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scr_atividades.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnl_atividades.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_atividadesLayout = new javax.swing.GroupLayout(pnl_atividades);
        pnl_atividades.setLayout(pnl_atividadesLayout);
        pnl_atividadesLayout.setHorizontalGroup(
            pnl_atividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );
        pnl_atividadesLayout.setVerticalGroup(
            pnl_atividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 197, Short.MAX_VALUE)
        );

        scr_atividades.setViewportView(pnl_atividades);

        chk_deficiencia.setBackground(new java.awt.Color(255, 255, 255));
        chk_deficiencia.setText("Sim");
        chk_deficiencia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chk_deficienciaItemStateChanged(evt);
            }
        });
        chk_deficiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_deficienciaActionPerformed(evt);
            }
        });

        txt_deficiencia.setEnabled(false);
        txt_deficiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_deficienciaActionPerformed(evt);
            }
        });

        lbl_possuideficiencia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_possuideficiencia.setText("Possuo alguma deficiência e necessito de atendimento especial?");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Especifique qual:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_menudescricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_possuideficiencia, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chk_deficiencia, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_deficiencia, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scr_atividades, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_inscrever, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pnl_menudescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lbl_titulo)
                .addGap(27, 27, 27)
                .addComponent(scr_atividades, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_possuideficiencia)
                    .addComponent(chk_deficiencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_deficiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_inscrever, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout pnl_descricaoLayout = new javax.swing.GroupLayout(pnl_descricao);
        pnl_descricao.setLayout(pnl_descricaoLayout);
        pnl_descricaoLayout.setHorizontalGroup(
            pnl_descricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_descricaoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_descricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_descricaosistema, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_titulosistema, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_descricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_linkcronograma)
                    .addComponent(lbl_linkevento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_links)
                    .addComponent(lbl_linkatividades, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(275, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_descricaoLayout.setVerticalGroup(
            pnl_descricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_descricaoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_descricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_links)
                    .addComponent(lbl_titulosistema))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(10, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_descricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_topo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnl_topo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_descricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chk_deficienciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chk_deficienciaItemStateChanged
      boolean ativado = (evt.getStateChange() == ItemEvent.SELECTED);
    txt_deficiencia.setEnabled(ativado);

    if (!ativado) {
        txt_deficiencia.setText(""); 
    }
    }//GEN-LAST:event_chk_deficienciaItemStateChanged

    private void chk_deficienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_deficienciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_deficienciaActionPerformed

    private void txt_deficienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_deficienciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_deficienciaActionPerformed

    private void btn_inscreverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inscreverActionPerformed
       
    String nomeEvento = lbl_titulo.getText();
    String deficiencia = txt_deficiencia.getText();
    boolean possuiDeficiencia = chk_deficiencia.isSelected();

    // Verifica se o nome do evento está preenchido
    if (nomeEvento != null && !nomeEvento.isEmpty()) {

        if (possuiDeficiencia && (deficiencia == null || deficiencia.trim().isEmpty())) {
            JOptionPane.showMessageDialog(null,
                "Por favor, informe qual é a deficiência.",
                "Campo Obrigatório",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Coletar atividades selecionadas
        List<String> atividadesSelecionadas = new ArrayList<>();

     for (Component comp : pnl_atividades.getComponents()) {
        // Verifica se é um painel do dia
        if (comp instanceof JPanel diaPanel) {
            for (Component atividadeComp : diaPanel.getComponents()) {
                if (atividadeComp instanceof JPanel atividadePanel) {
                    Boolean selecionado = (Boolean) atividadePanel.getClientProperty("selecionado");
                    if (Boolean.TRUE.equals(selecionado)) {
                        // Pega o título da atividade (assumindo que está em BorderLayout.WEST)
                        Component west = ((BorderLayout) atividadePanel.getLayout()).getLayoutComponent(BorderLayout.WEST);
                        if (west instanceof JLabel lblTitulo) {
                            atividadesSelecionadas.add(lblTitulo.getText());
                        }
                    }
                }
            }
        }
    }

    // Montar a mensagem
    StringBuilder mensagem = new StringBuilder();
    mensagem.append("Você se inscreveu no evento: ").append(nomeEvento);

    if (possuiDeficiencia) {
        mensagem.append("\nDeficiência informada: ").append(deficiencia);
    }

    if (!atividadesSelecionadas.isEmpty()) {
        mensagem.append("\n\nAtividades selecionadas:");
        for (String atividade : atividadesSelecionadas) {
            mensagem.append("\n• ").append(atividade);
        }
    } else {
        mensagem.append("\n\nNenhuma atividade foi selecionada.");
    }

    JOptionPane.showMessageDialog(null, mensagem.toString(), "Inscrição Realizada", JOptionPane.INFORMATION_MESSAGE);

    } else {
    JOptionPane.showMessageDialog(null,
        "Nenhum evento selecionado!",
        "Erro",
        JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btn_inscreverActionPerformed

    private void lbl_informainicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_informainicioMouseClicked
        new Tela_Inicial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_informainicioMouseClicked

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
    private javax.swing.JButton btn_inscrever;
    private javax.swing.JCheckBox chk_deficiencia;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel lbl_possuideficiencia;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_titulosistema;
    private javax.swing.JLabel lbl_topoevento;
    private javax.swing.JPanel pnl_atividades;
    private javax.swing.JPanel pnl_descricao;
    private javax.swing.JPanel pnl_menudescricao;
    private javax.swing.JPanel pnl_topo;
    private javax.swing.JScrollPane scr_atividades;
    private javax.swing.JTextField txt_deficiencia;
    // End of variables declaration//GEN-END:variables
}
