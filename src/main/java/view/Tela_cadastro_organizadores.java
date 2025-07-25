/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JFrame;

/**
 *
 * @author Kassandra Oliveira
 */
public class Tela_cadastro_organizadores extends javax.swing.JFrame {

    /**
     * Creates new form Tela_cadastro_organizadores
     */
    public Tela_cadastro_organizadores() {
        initComponents();
        //faz com q abra em tela cheia
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        String texto = "<html><font color = 'GRAY'>Preencha os formulários<br>com as informações<br>do organizador responsável.</html>";
        lbl_menudescricao.setText(texto);

        String texto2 = "<html><font color = 'WHITE'>Este sistema tem como objetivo gerenciar os eventos organizados<br>pelo Instituto Federal de Educação, Ciência e Tecnologia de<br>Rondônia - Campus Calama (IFRO), oferecendo ferramentas para<br>cadastro, divulgação, inscrições, controle de participante e<br>emissão de certificados</html>";
        lbl_descricaosistema.setText(texto2);

        // Altera o texto do checkbox já existente
        pnl_resultado.setLayout(new BoxLayout(pnl_resultado, BoxLayout.Y_AXIS));

// Lógica do botão confirmar
        btn_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnl_resultado.removeAll(); // limpa antes de adicionar

                if (check_CordenadorTecnico.isSelected()) {
                    pnl_resultado.add(new JLabel("Responsável - Coordenador Tecnico"));
                    pnl_resultado.add(new JTextField(20));
                }

                if (check_TecnicoSegurança.isSelected()) {
                    pnl_resultado.add(new JLabel("Responsável - Tecnico de Segurança"));
                    pnl_resultado.add(new JTextField(20));
                }

                if (check_SuporteTI.isSelected()) {
                    pnl_resultado.add(new JLabel("Responsável - Suporte de TI"));
                    pnl_resultado.add(new JTextField(20));
                }

                if (check_TecnicoTI.isSelected()) {
                    pnl_resultado.add(new JLabel("Responsável - Tecnico de TI"));
                    pnl_resultado.add(new JTextField(20));
                }

                if (check_TecnicoIluminacao.isSelected()) {
                    pnl_resultado.add(new JLabel("Responsável - Técnico de Iluminação"));
                    pnl_resultado.add(new JTextField(20));
                }

                if (check_TecnicoSom.isSelected()) {
                    pnl_resultado.add(new JLabel("Responsável - Técnico de Som"));
                    pnl_resultado.add(new JTextField(20));
                }
                if (check_TecnicoVideo.isSelected()) {
                    pnl_resultado.add(new JLabel("Responsável - Técnico de Video"));
                    pnl_resultado.add(new JTextField(20));
                }

                if (check_EletricistaEventos.isSelected()) {
                    pnl_resultado.add(new JLabel("Responsável - Eletricista de Eventos"));
                    pnl_resultado.add(new JTextField(20));
                }
                if (check_MontadorPalco.isSelected()) {
                    pnl_resultado.add(new JLabel("Responsável - Montador de Palco"));
                    pnl_resultado.add(new JTextField(20));
                }

                pnl_resultado.revalidate();
                pnl_resultado.repaint();
            }
        });

        // logica para abrir a tela de cadastro
        lbl_atividades.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_atividades.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose(); // fecha a tela de login 
                Tela_cadastro_atividades cadastro = new Tela_cadastro_atividades();
                cadastro.setVisible(true);
            }
        });

        // logica para abrir a tela de cadastro
        lbl_geral.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_geral.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose(); // fecha a tela de login 
                Tela_cadastro_eventos_geral cadastro2 = new Tela_cadastro_eventos_geral();
                cadastro2.setVisible(true);
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

        check_seguranca7 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        lbl_cadastroevento = new javax.swing.JLabel();
        lbl_atividades = new javax.swing.JLabel();
        lbl_geral = new javax.swing.JLabel();
        lbl_organizadores = new javax.swing.JLabel();
        lbl_menudescricao = new javax.swing.JLabel();
        pnl_topo = new javax.swing.JPanel();
        lbl_topoevento = new javax.swing.JLabel();
        btn_inicio = new javax.swing.JButton();
        pnl_cadastroatividades = new javax.swing.JPanel();
        lbl_ORGANIZADORES = new javax.swing.JLabel();
        txt_nome = new javax.swing.JTextField();
        lbl_nome = new javax.swing.JLabel();
        lbl_inicio = new javax.swing.JLabel();
        lbl_cadastro02 = new javax.swing.JLabel();
        lbl_organizadores02 = new javax.swing.JLabel();
        lbl_componente1 = new javax.swing.JLabel();
        lbl_componente02 = new javax.swing.JLabel();
        txt_fiscal = new javax.swing.JTextField();
        lbl_fiscal = new javax.swing.JLabel();
        lbl_apoio = new javax.swing.JLabel();
        btn_voltar = new javax.swing.JButton();
        bnt_salvar = new javax.swing.JButton();
        btn_confirmar = new javax.swing.JButton();
        scroll_pane_resultado = new javax.swing.JScrollPane();
        pnl_resultado = new javax.swing.JPanel();
        check_CordenadorTecnico = new javax.swing.JCheckBox();
        check_TecnicoIluminacao = new javax.swing.JCheckBox();
        check_TecnicoTI = new javax.swing.JCheckBox();
        check_TecnicoSom = new javax.swing.JCheckBox();
        check_TecnicoSegurança = new javax.swing.JCheckBox();
        check_SuporteTI = new javax.swing.JCheckBox();
        check_TecnicoVideo = new javax.swing.JCheckBox();
        check_EletricistaEventos = new javax.swing.JCheckBox();
        check_MontadorPalco = new javax.swing.JCheckBox();
        pnl_descricao = new javax.swing.JPanel();
        lbl_linkevento = new javax.swing.JLabel();
        lbl_linkatividades = new javax.swing.JLabel();
        lbl_linkcronograma = new javax.swing.JLabel();
        lbl_descricaosistema = new javax.swing.JLabel();
        lbl_titulosistema = new javax.swing.JLabel();
        lbl_links = new javax.swing.JLabel();

        check_seguranca7.setText("Segurança");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(234, 234, 234));

        lbl_cadastroevento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_cadastroevento.setText("Cadastro Geral");
        lbl_cadastroevento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbl_atividades.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_atividades.setText("• Atividades");

        lbl_geral.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_geral.setText("◦ Geral");

        lbl_organizadores.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_organizadores.setText("• Organizadores");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_menudescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_cadastroevento)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_organizadores)
                            .addComponent(lbl_atividades)
                            .addComponent(lbl_geral))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_cadastroevento, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_menudescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_geral)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_atividades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_organizadores)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_topo.setBackground(new java.awt.Color(255, 255, 255));

        lbl_topoevento.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_topoevento.setText("EVENTOS");

        btn_inicio.setBackground(new java.awt.Color(0, 212, 146));
        btn_inicio.setForeground(new java.awt.Color(255, 255, 255));
        btn_inicio.setText("Início");
        btn_inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_inicioMouseClicked(evt);
            }
        });
        btn_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_topoLayout = new javax.swing.GroupLayout(pnl_topo);
        pnl_topo.setLayout(pnl_topoLayout);
        pnl_topoLayout.setHorizontalGroup(
            pnl_topoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_topoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbl_topoevento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_topoLayout.setVerticalGroup(
            pnl_topoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_topoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_topoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_topoevento)
                    .addComponent(btn_inicio))
                .addContainerGap())
        );

        pnl_cadastroatividades.setBackground(new java.awt.Color(255, 255, 255));

        lbl_ORGANIZADORES.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbl_ORGANIZADORES.setText("• Organizadores");

        txt_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomeActionPerformed(evt);
            }
        });

        lbl_nome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_nome.setText("Organizador Responsável:");

        lbl_inicio.setText("Inicio");
        lbl_inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_inicioMouseClicked(evt);
            }
        });

        lbl_cadastro02.setText("Cadastro");

        lbl_organizadores02.setText("Organizadores");

        lbl_componente1.setText(">");

        lbl_componente02.setText(">");

        txt_fiscal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fiscalActionPerformed(evt);
            }
        });

        lbl_fiscal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_fiscal.setText("Fiscal de Presença:");

        lbl_apoio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_apoio.setText("Apoio Técnico:");

        btn_voltar.setText("Voltar");
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        bnt_salvar.setBackground(new java.awt.Color(0, 212, 146));
        bnt_salvar.setForeground(new java.awt.Color(255, 255, 255));
        bnt_salvar.setText("Salvar");
        bnt_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt_salvarActionPerformed(evt);
            }
        });

        btn_confirmar.setText("Confirmar");
        btn_confirmar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btn_confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmarActionPerformed(evt);
            }
        });

        pnl_resultado.setBackground(new java.awt.Color(255, 255, 255));
        pnl_resultado.setMinimumSize(new java.awt.Dimension(320, 140));

        javax.swing.GroupLayout pnl_resultadoLayout = new javax.swing.GroupLayout(pnl_resultado);
        pnl_resultado.setLayout(pnl_resultadoLayout);
        pnl_resultadoLayout.setHorizontalGroup(
            pnl_resultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );
        pnl_resultadoLayout.setVerticalGroup(
            pnl_resultadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );

        scroll_pane_resultado.setViewportView(pnl_resultado);

        check_CordenadorTecnico.setText("Coordenador Tecnico");

        check_TecnicoIluminacao.setText("Tecnico de Iluminacao");

        check_TecnicoTI.setText("Tecnico de TI");

        check_TecnicoSom.setText("Tecnico de Som");

        check_TecnicoSegurança.setText("Tecnico de Segurança");

        check_SuporteTI.setText("Suporte de TI");
        check_SuporteTI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_SuporteTIActionPerformed(evt);
            }
        });

        check_TecnicoVideo.setText("Tecnico de Video");

        check_EletricistaEventos.setText("Eletricista de Eventos");

        check_MontadorPalco.setText("Montador de Palco");

        javax.swing.GroupLayout pnl_cadastroatividadesLayout = new javax.swing.GroupLayout(pnl_cadastroatividades);
        pnl_cadastroatividades.setLayout(pnl_cadastroatividadesLayout);
        pnl_cadastroatividadesLayout.setHorizontalGroup(
            pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btn_voltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bnt_salvar)
                .addGap(31, 31, 31))
            .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lbl_inicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_componente1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_cadastro02)
                        .addGap(6, 6, 6)
                        .addComponent(lbl_componente02)
                        .addGap(6, 6, 6)
                        .addComponent(lbl_organizadores02))
                    .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                                .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(check_TecnicoTI)
                                    .addComponent(check_TecnicoVideo))
                                .addGap(41, 41, 41)
                                .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(check_EletricistaEventos)
                                    .addComponent(check_TecnicoIluminacao)))
                            .addComponent(lbl_nome)
                            .addComponent(lbl_ORGANIZADORES)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_fiscal)
                            .addComponent(lbl_apoio)
                            .addComponent(txt_fiscal, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                                .addComponent(check_CordenadorTecnico)
                                .addGap(18, 18, 18)
                                .addComponent(check_TecnicoSegurança)
                                .addGap(22, 22, 22)
                                .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(check_SuporteTI)
                                    .addComponent(check_MontadorPalco)
                                    .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                                        .addComponent(check_TecnicoSom)
                                        .addGap(69, 69, 69)
                                        .addComponent(btn_confirmar))))
                            .addComponent(scroll_pane_resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(356, Short.MAX_VALUE))
        );
        pnl_cadastroatividadesLayout.setVerticalGroup(
            pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_inicio)
                    .addComponent(lbl_cadastro02)
                    .addComponent(lbl_organizadores02)
                    .addComponent(lbl_componente1)
                    .addComponent(lbl_componente02))
                .addGap(18, 18, 18)
                .addComponent(lbl_ORGANIZADORES)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_fiscal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_fiscal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_apoio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check_CordenadorTecnico)
                    .addComponent(check_TecnicoSegurança)
                    .addComponent(check_SuporteTI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check_TecnicoIluminacao)
                    .addComponent(check_TecnicoSom)
                    .addComponent(check_TecnicoTI)
                    .addComponent(btn_confirmar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check_TecnicoVideo)
                    .addComponent(check_EletricistaEventos)
                    .addComponent(check_MontadorPalco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scroll_pane_resultado, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_voltar)
                    .addComponent(bnt_salvar))
                .addGap(14, 14, 14))
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
                    .addComponent(lbl_titulosistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_descricaosistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(119, 119, 119)
                .addGroup(pnl_descricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_linkcronograma)
                    .addComponent(lbl_linkevento, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_links)
                    .addComponent(lbl_linkatividades, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 113, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_topo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnl_cadastroatividades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnl_descricao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_topo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_cadastroatividades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_descricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomeActionPerformed

    private void txt_fiscalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fiscalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fiscalActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        new Tela_cadastro_atividades().setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void bnt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_salvarActionPerformed
        String nome = txt_nome.getText().trim();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Cadastro Realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_bnt_salvarActionPerformed

    private void check_SuporteTIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_SuporteTIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check_SuporteTIActionPerformed

    private void btn_confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_confirmarActionPerformed

    private void lbl_inicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_inicioMouseClicked
        new Tela_Inicial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_inicioMouseClicked

    private void btn_inicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_inicioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_inicioMouseClicked

    private void btn_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inicioActionPerformed
        new Tela_Inicial().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_inicioActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_cadastro_organizadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_cadastro_organizadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_cadastro_organizadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_cadastro_organizadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_cadastro_organizadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt_salvar;
    private javax.swing.JButton btn_confirmar;
    private javax.swing.JButton btn_inicio;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JCheckBox check_CordenadorTecnico;
    private javax.swing.JCheckBox check_EletricistaEventos;
    private javax.swing.JCheckBox check_MontadorPalco;
    private javax.swing.JCheckBox check_SuporteTI;
    private javax.swing.JCheckBox check_TecnicoIluminacao;
    private javax.swing.JCheckBox check_TecnicoSegurança;
    private javax.swing.JCheckBox check_TecnicoSom;
    private javax.swing.JCheckBox check_TecnicoTI;
    private javax.swing.JCheckBox check_TecnicoVideo;
    private javax.swing.JCheckBox check_seguranca7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_ORGANIZADORES;
    private javax.swing.JLabel lbl_apoio;
    private javax.swing.JLabel lbl_atividades;
    private javax.swing.JLabel lbl_cadastro02;
    private javax.swing.JLabel lbl_cadastroevento;
    private javax.swing.JLabel lbl_componente02;
    private javax.swing.JLabel lbl_componente1;
    private javax.swing.JLabel lbl_descricaosistema;
    private javax.swing.JLabel lbl_fiscal;
    private javax.swing.JLabel lbl_geral;
    private javax.swing.JLabel lbl_inicio;
    private javax.swing.JLabel lbl_linkatividades;
    private javax.swing.JLabel lbl_linkcronograma;
    private javax.swing.JLabel lbl_linkevento;
    private javax.swing.JLabel lbl_links;
    private javax.swing.JLabel lbl_menudescricao;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JLabel lbl_organizadores;
    private javax.swing.JLabel lbl_organizadores02;
    private javax.swing.JLabel lbl_titulosistema;
    private javax.swing.JLabel lbl_topoevento;
    private javax.swing.JPanel pnl_cadastroatividades;
    private javax.swing.JPanel pnl_descricao;
    private javax.swing.JPanel pnl_resultado;
    private javax.swing.JPanel pnl_topo;
    private javax.swing.JScrollPane scroll_pane_resultado;
    private javax.swing.JTextField txt_fiscal;
    private javax.swing.JTextField txt_nome;
    // End of variables declaration//GEN-END:variables
}
