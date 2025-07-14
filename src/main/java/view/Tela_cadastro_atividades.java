package view;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JFrame;

import controllers.AtividadeController;
import exceptions.AuthenticationException;
import exceptions.DomainException;
import exceptions.InvalidInputException;
import exceptions.TimeParserException;
import model.bean.Ambiente;
import model.bean.Atividade;
import model.bean.Evento;
import support.TimeParser;
import usecases.CSListarAmbientes;
import usecases.CSListarEventos;

public class Tela_cadastro_atividades extends javax.swing.JFrame {

    private final AtividadeController controller = new AtividadeController();

    private void loadEventos() {
        List<Evento> eventos = new CSListarEventos().execute();
        for (Evento e : eventos) {
            this.select_evento.addItem(e.getTitulo());
        }
    }

    private void loadAmbientes() {
        List<Ambiente> ambientes = new CSListarAmbientes().execute();
        for (Ambiente a : ambientes) {
            this.select_ambiente.addItem(a.getNome());
        }
    }

    public Tela_cadastro_atividades() {
        initComponents();

        //faz com q abra em tela cheia
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        String texto = "<html><font color = 'GRAY'>Preencha os formulários<br>com as informações<br>da sua atividade.</html>";
        lbl_menudescricao.setText(texto);

        String texto2 = "<html><font color = 'WHITE'>Este sistema tem como objetivo gerenciar os eventos organizados<br>pelo Instituto Federal de Educação, Ciência e Tecnologia de<br>Rondônia - Campus Calama (IFRO), oferecendo ferramentas para<br>cadastro, divulgação, inscrições, controle de participante e<br>emissão de certificados</html>";
        lbl_descricaosistema.setText(texto2);

        // logica para abrir a tela de cadastro
        lbl_organizadores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_organizadores.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dispose(); // fecha a tela de login 
                Tela_cadastro_organizadores cadastro = new Tela_cadastro_organizadores();
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

        loadEventos();
        loadAmbientes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        lbl_ATIVIDADES = new javax.swing.JLabel();
        txt_titulo = new javax.swing.JTextField();
        lb_titulo = new javax.swing.JLabel();
        lbl_inicio = new javax.swing.JLabel();
        lbl_cadastro02 = new javax.swing.JLabel();
        lbl_atividades02 = new javax.swing.JLabel();
        lbl_componente1 = new javax.swing.JLabel();
        lbl_componente02 = new javax.swing.JLabel();
        lbl_data = new javax.swing.JLabel();
        btn_voltar = new javax.swing.JButton();
        bnt_salvar = new javax.swing.JButton();
        lb_descricao = new javax.swing.JLabel();
        txt_descricao = new javax.swing.JTextField();
        lb_select_evento = new javax.swing.JLabel();
        select_evento = new javax.swing.JComboBox<>();
        lb_select_ambiente = new javax.swing.JLabel();
        select_ambiente = new javax.swing.JComboBox<>();
        lb_data = new javax.swing.JLabel();
        txt_data = new javax.swing.JTextField();
        lb_hora_inicio = new javax.swing.JLabel();
        txt_hora_inicio = new javax.swing.JTextField();
        lb_hora_termino = new javax.swing.JLabel();
        txt_hora_termino = new javax.swing.JTextField();
        pnl_descricao = new javax.swing.JPanel();
        lbl_linkevento = new javax.swing.JLabel();
        lbl_linkatividades = new javax.swing.JLabel();
        lbl_linkcronograma = new javax.swing.JLabel();
        lbl_descricaosistema = new javax.swing.JLabel();
        lbl_titulosistema = new javax.swing.JLabel();
        lbl_links = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(234, 234, 234));

        lbl_cadastroevento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_cadastroevento.setText("Cadastro Geral");
        lbl_cadastroevento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lbl_atividades.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_atividades.setText("• Atividades");

        lbl_geral.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_geral.setText("◦ Geral");

        lbl_organizadores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_organizadores.setText("◦ Organizadores");

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
                                .addComponent(lbl_menudescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

        lbl_ATIVIDADES.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbl_ATIVIDADES.setText("• Atividades");

        txt_titulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tituloActionPerformed(evt);
            }
        });

        lb_titulo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_titulo.setText("Nome da atividade:");

        lbl_inicio.setText("Inicio");
        lbl_inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_inicioMouseClicked(evt);
            }
        });

        lbl_cadastro02.setText("Cadastro");

        lbl_atividades02.setText("Atividades");

        lbl_componente1.setText(">");

        lbl_componente02.setText(">");

        lbl_data.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbl_data.setText("• Data");

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

        lb_descricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_descricao.setText("Descricção da atividade:");

        txt_descricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_descricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descricaoActionPerformed(evt);
            }
        });

        lb_select_evento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_select_evento.setText("Selecione o evento:");

        select_evento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        select_evento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Selecione"}));

        lb_select_ambiente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_select_ambiente.setText("Selecione o ambiente:");

        select_ambiente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        select_ambiente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Selecione"}));

        lb_data.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_data.setText("Data da atividade:");

        txt_data.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dataActionPerformed(evt);
            }
        });

        lb_hora_inicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_hora_inicio.setText("Hora de início:");

        txt_hora_inicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_hora_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hora_inicioActionPerformed(evt);
            }
        });

        lb_hora_termino.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_hora_termino.setText("Hora de término:");

        txt_hora_termino.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_hora_termino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hora_terminoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_cadastroatividadesLayout = new javax.swing.GroupLayout(pnl_cadastroatividades);
        pnl_cadastroatividades.setLayout(pnl_cadastroatividadesLayout);
        pnl_cadastroatividadesLayout.setHorizontalGroup(
                pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(btn_voltar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bnt_salvar)
                                .addGap(27, 27, 27))
                        .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                                .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbl_ATIVIDADES)
                                                        .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(lb_hora_inicio)
                                                                        .addComponent(lb_data)
                                                                        .addComponent(lb_descricao)
                                                                        .addComponent(txt_descricao, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                                                        .addComponent(lb_select_ambiente)
                                                                        .addComponent(lbl_data)
                                                                        .addComponent(lb_titulo)
                                                                        .addComponent(txt_titulo)
                                                                        .addComponent(lb_select_evento)
                                                                        .addComponent(select_evento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(select_ambiente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(txt_data)
                                                                        .addComponent(txt_hora_inicio))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lb_hora_termino)
                                                                        .addComponent(txt_hora_termino, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                                                .addComponent(lbl_atividades02)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_cadastroatividadesLayout.setVerticalGroup(
                pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbl_inicio)
                                        .addComponent(lbl_cadastro02)
                                        .addComponent(lbl_atividades02)
                                        .addComponent(lbl_componente1)
                                        .addComponent(lbl_componente02))
                                .addGap(18, 18, 18)
                                .addComponent(lbl_ATIVIDADES)
                                .addGap(6, 6, 6)
                                .addComponent(lb_titulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lb_descricao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lb_select_evento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(select_evento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lb_select_ambiente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(select_ambiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_data)
                                .addGap(18, 18, 18)
                                .addComponent(lb_data)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btn_voltar)
                                                        .addComponent(bnt_salvar))
                                                .addContainerGap())
                                        .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                                                                .addComponent(lb_hora_termino)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txt_hora_termino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                                                                .addComponent(lb_hora_inicio)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txt_hora_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap(56, Short.MAX_VALUE))))
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
                                        .addComponent(pnl_cadastroatividades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnl_descricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        dispose(); // fecha a tela de login 
        Tela_cadastro_eventos_geral cadastro = new Tela_cadastro_eventos_geral();
        cadastro.setVisible(true);
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void bnt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_salvarActionPerformed
        String titulo = txt_titulo.getText().trim();
        String descricao = txt_descricao.getText().trim();
        String evento_nome = select_evento.getSelectedItem().toString().trim();
        String ambiente_nome = select_ambiente.getSelectedItem().toString().trim();

        String data = txt_data.getText().trim();
        String hora_inicio = txt_hora_inicio.getText().trim();
        String hora_termino = txt_hora_termino.getText().trim();

        Atividade atividade = new Atividade();
        atividade.setTitulo(titulo);
        atividade.setDescricao(descricao);

        try {
            atividade.setData(TimeParser.parseDate(data));
            atividade.setHora_inicio(TimeParser.parseTime(hora_inicio));
            atividade.setHora_termino(TimeParser.parseTime(hora_termino));
        } catch (TimeParserException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            this.controller.store(atividade, evento_nome, ambiente_nome);

            JOptionPane.showMessageDialog(this,
                    "Atividade salva com sucesso!\n\n"
                    + "Título: " + titulo + "\n"
                    + "Evento: " + evento_nome + "\n"
                    + "Ambiente: " + ambiente_nome + "\n"
                    + "Data: " + data + " das " + hora_inicio + " até " + hora_termino + "\n",
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE
            );

            this.dispose();
            new Tela_cadastro_organizadores().setVisible(true);
        } catch (AuthenticationException | InvalidInputException | DomainException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bnt_salvarActionPerformed

    private void txt_tituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tituloActionPerformed

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

    private void txt_descricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descricaoActionPerformed

    private void txt_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dataActionPerformed

    private void txt_hora_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hora_inicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hora_inicioActionPerformed

    private void txt_hora_terminoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hora_terminoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hora_terminoActionPerformed

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
    private javax.swing.JButton btn_inicio;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lb_data;
    private javax.swing.JLabel lb_descricao;
    private javax.swing.JLabel lb_hora_inicio;
    private javax.swing.JLabel lb_hora_termino;
    private javax.swing.JLabel lb_select_ambiente;
    private javax.swing.JLabel lb_select_evento;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JLabel lbl_ATIVIDADES;
    private javax.swing.JLabel lbl_atividades;
    private javax.swing.JLabel lbl_atividades02;
    private javax.swing.JLabel lbl_cadastro02;
    private javax.swing.JLabel lbl_cadastroevento;
    private javax.swing.JLabel lbl_componente02;
    private javax.swing.JLabel lbl_componente1;
    private javax.swing.JLabel lbl_data;
    private javax.swing.JLabel lbl_descricaosistema;
    private javax.swing.JLabel lbl_geral;
    private javax.swing.JLabel lbl_inicio;
    private javax.swing.JLabel lbl_linkatividades;
    private javax.swing.JLabel lbl_linkcronograma;
    private javax.swing.JLabel lbl_linkevento;
    private javax.swing.JLabel lbl_links;
    private javax.swing.JLabel lbl_menudescricao;
    private javax.swing.JLabel lbl_organizadores;
    private javax.swing.JLabel lbl_titulosistema;
    private javax.swing.JLabel lbl_topoevento;
    private javax.swing.JPanel pnl_cadastroatividades;
    private javax.swing.JPanel pnl_descricao;
    private javax.swing.JPanel pnl_topo;
    private javax.swing.JComboBox<String> select_ambiente;
    private javax.swing.JComboBox<String> select_evento;
    private javax.swing.JTextField txt_data;
    private javax.swing.JTextField txt_descricao;
    private javax.swing.JTextField txt_hora_inicio;
    private javax.swing.JTextField txt_hora_termino;
    private javax.swing.JTextField txt_titulo;
    // End of variables declaration//GEN-END:variables
}
