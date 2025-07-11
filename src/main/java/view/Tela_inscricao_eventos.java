/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author Kassandra Oliveira
 */
public class Tela_inscricao_eventos extends javax.swing.JFrame {
    
        private int contadorEstudante = 0;
        private int contadorServidor = 0;
        private int contadorPe = 0;

     private void carregarAtividadesDoEvento(long idEvento) {
    String url = "jdbc:mysql://localhost:3306/system_event";
    String usuario = "root";
    String senha = "12345";

    String sql = "SELECT titulo, hora_inicio, hora_termino FROM atividades WHERE id_evento = ? ORDER BY data, hora_inicio";

    try (Connection conn = DriverManager.getConnection(url, usuario, senha);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setLong(1, idEvento);
        ResultSet rs = stmt.executeQuery();

        pnl_atividades.removeAll(); // limpa o painel antes de adicionar novas atividades

        while (rs.next()) {
            String titulo = rs.getString("titulo");
            String horaInicio = rs.getString("hora_inicio");
            String horaTermino = rs.getString("hora_termino");

            JPanel item = new JPanel();
            item.setLayout(new BoxLayout(item, BoxLayout.X_AXIS));
            item.setBackground(new Color(240, 240, 240));
            item.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

            JLabel lblTitulo = new JLabel(titulo);
            lblTitulo.setPreferredSize(new Dimension(300, 20));
            JLabel lblHorario = new JLabel(" " + horaInicio + " - " + horaTermino);
            lblHorario.setForeground(Color.DARK_GRAY);

            item.add(lblTitulo);
            item.add(Box.createHorizontalGlue());
            item.add(lblHorario);

            pnl_atividades.add(item);
        }

        pnl_atividades.revalidate();
        pnl_atividades.repaint();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
     
    public Tela_inscricao_eventos() {
        initComponents();
        
         // Configurar layout vertical para o painel de atividades
        pnl_atividades.setLayout(new BoxLayout(pnl_atividades, BoxLayout.Y_AXIS));
        pnl_atividades.setBackground(Color.WHITE);

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
            System.out.println("Erro na conexão: " + e.getMessage());
        }
        
           String sql = "SELECT titulo, data_inicio, data_termino, descricao, formato FROM eventos WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            //aqui quando o gustavo juntar tudo tem q fazer de forma mulodar pra escolher qual evento é qual, por enquanto vamos passar o id de forma manual
            //stmt.setLong(1, idEvento);// define o ID do evento
            stmt.setLong(1, 1); 
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                lbl_titulo.setText(rs.getString("titulo"));
                lbl_datainicio.setText(rs.getDate("data_inicio").toString());
                lbl_datafinal.setText(rs.getDate("data_termino").toString());
                lbl_tipo.setText(rs.getString("formato"));
                lbl_descricao.setText(rs.getString("descricao"));
            } else {
                System.out.println("Evento não encontrado.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        
         //faz com q abra em tela cheia
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        String texto = "<html><font color = 'WHITE'>Este sistema tem como objetivo gerenciar os eventos organizados<br>pelo Instituto Federal de Educação, Ciência e Tecnologia de<br>Rondônia - Campus Calama (IFRO), oferecendo ferramentas para<br>cadastro, divulgação, inscrições, controle de participante e<br>emissão de certificados</html>";
        lbl_descricaosistema.setText(texto);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_topo = new javax.swing.JPanel();
        lbl_topoevento = new javax.swing.JLabel();
        pnl_descricao = new javax.swing.JPanel();
        lbl_linkevento = new javax.swing.JLabel();
        lbl_linkatividades = new javax.swing.JLabel();
        lbl_linkcronograma = new javax.swing.JLabel();
        lbl_descricaosistema = new javax.swing.JLabel();
        lbl_titulosistema = new javax.swing.JLabel();
        lbl_links = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_inscrever = new javax.swing.JButton();
        btn_menosservidor = new javax.swing.JButton();
        lbl_descricao = new javax.swing.JLabel();
        lbl_servidor = new javax.swing.JLabel();
        lbl_datainicio = new javax.swing.JLabel();
        lbl_descricaoevento = new javax.swing.JLabel();
        btn_maispe = new javax.swing.JButton();
        lbl_titulo = new javax.swing.JLabel();
        scr_atividades = new javax.swing.JScrollPane();
        pnl_atividades = new javax.swing.JPanel();
        lbl_datafinal = new javax.swing.JLabel();
        lbl_tipo = new javax.swing.JLabel();
        btn_menosestudante = new javax.swing.JButton();
        btn_menospe = new javax.swing.JButton();
        lbl_pe = new javax.swing.JLabel();
        lbl_Categoria = new javax.swing.JLabel();
        lbl_ESTUDANTE = new javax.swing.JLabel();
        btn_maisestudante = new javax.swing.JButton();
        lbl_SERVIDOR = new javax.swing.JLabel();
        lbl_estudante = new javax.swing.JLabel();
        lbl_PE = new javax.swing.JLabel();
        btn_maisservidor = new javax.swing.JButton();
        lbl_AtvEventos = new javax.swing.JLabel();
        pnl_menupesquisa = new javax.swing.JPanel();
        lbl_inicio = new javax.swing.JLabel();
        lbl_componente1 = new javax.swing.JLabel();
        lbl_inscricaoevento = new javax.swing.JLabel();
        lbl_componente02 = new javax.swing.JLabel();
        lbl_eventos = new javax.swing.JLabel();
        lbl_organizador = new javax.swing.JLabel();
        lbl_LCE = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

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

        pnl_descricao.setBackground(new java.awt.Color(51, 51, 51));

        lbl_linkevento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_linkevento.setForeground(new java.awt.Color(255, 255, 255));
        lbl_linkevento.setText("• Eventos");

        lbl_linkatividades.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_linkatividades.setForeground(new java.awt.Color(255, 255, 255));
        lbl_linkatividades.setText("• Atividades");

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

        javax.swing.GroupLayout pnl_descricaoLayout = new javax.swing.GroupLayout(pnl_descricao);
        pnl_descricao.setLayout(pnl_descricaoLayout);
        pnl_descricaoLayout.setHorizontalGroup(
            pnl_descricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_descricaoLayout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addGroup(pnl_descricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_titulosistema, javax.swing.GroupLayout.PREFERRED_SIZE, 416, Short.MAX_VALUE)
                    .addComponent(lbl_descricaosistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(119, 119, 119)
                .addGroup(pnl_descricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_linkcronograma)
                    .addComponent(lbl_linkevento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_links)
                    .addComponent(lbl_linkatividades, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_descricaoLayout.setVerticalGroup(
            pnl_descricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_descricaoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnl_descricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_links)
                    .addComponent(lbl_titulosistema))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_descricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_descricaoLayout.createSequentialGroup()
                        .addComponent(lbl_linkevento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_linkatividades)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_linkcronograma))
                    .addGroup(pnl_descricaoLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbl_descricaosistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btn_inscrever.setBackground(new java.awt.Color(0, 212, 146));
        btn_inscrever.setForeground(new java.awt.Color(255, 255, 255));
        btn_inscrever.setText("Realizar inscrição");
        btn_inscrever.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_inscrever.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inscreverActionPerformed(evt);
            }
        });

        btn_menosservidor.setText("-");
        btn_menosservidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menosservidorActionPerformed(evt);
            }
        });

        lbl_descricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_descricao.setForeground(new java.awt.Color(102, 102, 102));
        lbl_descricao.setText("descrição");
        lbl_descricao.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        lbl_servidor.setText("0");

        lbl_datainicio.setForeground(new java.awt.Color(102, 102, 102));
        lbl_datainicio.setText("data inicio");

        lbl_descricaoevento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_descricaoevento.setText("Descrição do Evento");

        btn_maispe.setText("+");
        btn_maispe.setToolTipText("");
        btn_maispe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_maispeActionPerformed(evt);
            }
        });

        lbl_titulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_titulo.setText("Titulo Evento");

        scr_atividades.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnl_atividades.setBackground(new java.awt.Color(255, 255, 255));
        pnl_atividades.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout pnl_atividadesLayout = new javax.swing.GroupLayout(pnl_atividades);
        pnl_atividades.setLayout(pnl_atividadesLayout);
        pnl_atividadesLayout.setHorizontalGroup(
            pnl_atividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );
        pnl_atividadesLayout.setVerticalGroup(
            pnl_atividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        scr_atividades.setViewportView(pnl_atividades);

        lbl_datafinal.setForeground(new java.awt.Color(102, 102, 102));
        lbl_datafinal.setText("data final");

        lbl_tipo.setForeground(new java.awt.Color(102, 102, 102));
        lbl_tipo.setText("tipo");

        btn_menosestudante.setText("-");
        btn_menosestudante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menosestudanteActionPerformed(evt);
            }
        });

        btn_menospe.setText("-");
        btn_menospe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menospeActionPerformed(evt);
            }
        });

        lbl_pe.setText("0");

        lbl_Categoria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_Categoria.setText("Categoria de inscrição");

        lbl_ESTUDANTE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_ESTUDANTE.setText("Estudante");

        btn_maisestudante.setText("+");
        btn_maisestudante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_maisestudanteActionPerformed(evt);
            }
        });

        lbl_SERVIDOR.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_SERVIDOR.setText("Servidor");

        lbl_estudante.setText("0");
        lbl_estudante.setToolTipText("");

        lbl_PE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_PE.setText("Pessoa Externa");

        btn_maisservidor.setText("+");
        btn_maisservidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_maisservidorActionPerformed(evt);
            }
        });

        lbl_AtvEventos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_AtvEventos.setText("Atividades  do Evento");

        pnl_menupesquisa.setBackground(new java.awt.Color(255, 255, 255));
        pnl_menupesquisa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_inicio.setText("Inicio");

        lbl_componente1.setText(">");

        lbl_inscricaoevento.setText("Inscrição");

        lbl_componente02.setText(">");

        lbl_eventos.setText("Eventos");

        javax.swing.GroupLayout pnl_menupesquisaLayout = new javax.swing.GroupLayout(pnl_menupesquisa);
        pnl_menupesquisa.setLayout(pnl_menupesquisaLayout);
        pnl_menupesquisaLayout.setHorizontalGroup(
            pnl_menupesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menupesquisaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbl_inicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_componente1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_inscricaoevento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_componente02)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_eventos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_menupesquisaLayout.setVerticalGroup(
            pnl_menupesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_menupesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_menupesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_inicio)
                    .addComponent(lbl_componente1)
                    .addComponent(lbl_inscricaoevento)
                    .addComponent(lbl_componente02)
                    .addComponent(lbl_eventos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_organizador.setForeground(new java.awt.Color(102, 102, 102));
        lbl_organizador.setText("Organizador responsável");

        lbl_LCE.setForeground(new java.awt.Color(102, 102, 102));
        lbl_LCE.setText("Local - Cidade - Estado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_menupesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_LCE, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_organizador, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_SERVIDOR)
                                    .addComponent(lbl_PE))
                                .addGap(241, 241, 241))
                            .addComponent(lbl_ESTUDANTE, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(126, 126, 126)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btn_menosservidor)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbl_servidor)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btn_maisservidor))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(btn_menospe)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbl_pe)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btn_maispe)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_menosestudante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_estudante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_maisestudante)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 368, Short.MAX_VALUE)
                        .addComponent(btn_inscrever)
                        .addGap(75, 75, 75))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbl_datainicio, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_datafinal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_AtvEventos)
                            .addComponent(lbl_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_descricaoevento)
                            .addComponent(scr_atividades, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Categoria)
                            .addComponent(lbl_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(pnl_menupesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_organizador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_LCE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_datainicio)
                    .addComponent(lbl_datafinal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_tipo)
                .addGap(18, 18, 18)
                .addComponent(lbl_descricaoevento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_AtvEventos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scr_atividades, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Categoria)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_maisestudante)
                        .addComponent(btn_menosestudante)
                        .addComponent(lbl_estudante, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_ESTUDANTE, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_menosservidor)
                    .addComponent(btn_maisservidor)
                    .addComponent(lbl_servidor, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_SERVIDOR))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_PE)
                    .addComponent(btn_menospe)
                    .addComponent(lbl_pe)
                    .addComponent(btn_maispe)
                    .addComponent(btn_inscrever))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_descricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnl_topo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_topo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_descricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_maisestudanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_maisestudanteActionPerformed
      contadorEstudante++;
      lbl_estudante.setText(String.valueOf(contadorEstudante));
    }//GEN-LAST:event_btn_maisestudanteActionPerformed

    private void btn_menosestudanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menosestudanteActionPerformed
        if (contadorEstudante > 0) {
            contadorEstudante--;
            lbl_estudante.setText(String.valueOf(contadorEstudante));
}
    }//GEN-LAST:event_btn_menosestudanteActionPerformed

    private void btn_maisservidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_maisservidorActionPerformed
        contadorServidor++;
        lbl_servidor.setText(String.valueOf(contadorServidor));
    }//GEN-LAST:event_btn_maisservidorActionPerformed

    private void btn_menosservidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menosservidorActionPerformed
        if (contadorServidor  > 0) {
            contadorServidor--;
            lbl_servidor.setText(String.valueOf(contadorServidor));
}
    }//GEN-LAST:event_btn_menosservidorActionPerformed

    private void btn_maispeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_maispeActionPerformed
        contadorPe++;
        lbl_pe.setText(String.valueOf(contadorPe));

    }//GEN-LAST:event_btn_maispeActionPerformed

    private void btn_menospeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menospeActionPerformed
       if (contadorPe  > 0) {
            contadorPe--;
            lbl_pe.setText(String.valueOf(contadorPe));
}
    }//GEN-LAST:event_btn_menospeActionPerformed

    private void btn_inscreverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inscreverActionPerformed
        String nomeEvento = lbl_titulo.getText();
        String qtdEstudante = lbl_estudante.getText();
        String qtdServidor = lbl_servidor.getText();
        String qtdPE = lbl_pe.getText();

        // Verifica se o nome do evento está preenchido
        if (nomeEvento != null && !nomeEvento.isEmpty()) {
            String mensagem = String.format(
                "Você se inscreveu no evento: %s\n\nIngressos selecionados:\n- Estudante: %s\n- Servidor: %s\n- Público Externo: %s",
                nomeEvento, qtdEstudante, qtdServidor, qtdPE
            );

            JOptionPane.showMessageDialog(null, mensagem, "Inscrição Realizada", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                "Nenhum evento selecionado!",
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    

    }//GEN-LAST:event_btn_inscreverActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_inscricao_eventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_inscricao_eventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_inscricao_eventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_inscricao_eventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_inscricao_eventos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_inscrever;
    private javax.swing.JButton btn_maisestudante;
    private javax.swing.JButton btn_maispe;
    private javax.swing.JButton btn_maisservidor;
    private javax.swing.JButton btn_menosestudante;
    private javax.swing.JButton btn_menospe;
    private javax.swing.JButton btn_menosservidor;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_AtvEventos;
    private javax.swing.JLabel lbl_Categoria;
    private javax.swing.JLabel lbl_ESTUDANTE;
    private javax.swing.JLabel lbl_LCE;
    private javax.swing.JLabel lbl_PE;
    private javax.swing.JLabel lbl_SERVIDOR;
    private javax.swing.JLabel lbl_componente02;
    private javax.swing.JLabel lbl_componente1;
    private javax.swing.JLabel lbl_datafinal;
    private javax.swing.JLabel lbl_datainicio;
    private javax.swing.JLabel lbl_descricao;
    private javax.swing.JLabel lbl_descricaoevento;
    private javax.swing.JLabel lbl_descricaosistema;
    private javax.swing.JLabel lbl_estudante;
    private javax.swing.JLabel lbl_eventos;
    private javax.swing.JLabel lbl_inicio;
    private javax.swing.JLabel lbl_inscricaoevento;
    private javax.swing.JLabel lbl_linkatividades;
    private javax.swing.JLabel lbl_linkcronograma;
    private javax.swing.JLabel lbl_linkevento;
    private javax.swing.JLabel lbl_links;
    private javax.swing.JLabel lbl_organizador;
    private javax.swing.JLabel lbl_pe;
    private javax.swing.JLabel lbl_servidor;
    private javax.swing.JLabel lbl_tipo;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_titulosistema;
    private javax.swing.JLabel lbl_topoevento;
    private javax.swing.JPanel pnl_atividades;
    private javax.swing.JPanel pnl_descricao;
    private javax.swing.JPanel pnl_menupesquisa;
    private javax.swing.JPanel pnl_topo;
    private javax.swing.JScrollPane scr_atividades;
    // End of variables declaration//GEN-END:variables
}
