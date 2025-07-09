/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BoxLayout;
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

    private boolean validarHoras() {
    Component[] componentes = jPanel1.getComponents();

    for (Component comp : componentes) {
        if (comp instanceof JPanel) {
            JPanel painelDia = (JPanel) comp;

            for (Component c : painelDia.getComponents()) {
                if (c instanceof JTextField) {
                    JTextField txtHora = (JTextField) c;
                    String hora = txtHora.getText().trim();

                    if (!hora.isEmpty() && !isHoraValida(hora)) {
                        JOptionPane.showMessageDialog(this,
                            "Hora inválida no campo: " + txtHora.getName() + "\nUse o formato HH:mm.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                        txtHora.requestFocus();
                        return false;
                    }
                }
            }
        }
    }
    return true;
}

private void atualizarLocaisAtividade() {
    String qtdDiasTexto = txt_quantdias.getText().trim();

    try {
        int qtdDias = Integer.parseInt(qtdDiasTexto);
        if (qtdDias <= 0) {
            JOptionPane.showMessageDialog(this, "Informe um número maior que zero.");
            return;
        }

        jPanel3.removeAll();  // limpa componentes existentes

        for (int i = 1; i <= qtdDias; i++) {   // inicia no dia 1
            JPanel painelDia = new JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

            JLabel lblDia = new JLabel("Dia " + i + ": ");
            lblDia.setPreferredSize(new java.awt.Dimension(60, 25));

            JLabel lblLocal = new JLabel("Local da atividade:");
            JTextField txtLocal = new JTextField();
            txtLocal.setColumns(15);
            txtLocal.setName("txtLocalDia" + i);

            painelDia.add(lblDia);
            painelDia.add(lblLocal);
            painelDia.add(txtLocal);

            jPanel3.add(painelDia);
        }

        jPanel3.revalidate();
        jPanel3.repaint();

    } catch (NumberFormatException e) {
        
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
        
        
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));

        // Essas configurações são opcionais (se quiser controlar o tamanho da área visível):
        jScrollPane1.setPreferredSize(new Dimension(550, 160));
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        
        
        jPanel3.setLayout(new BoxLayout(jPanel3, BoxLayout.Y_AXIS));

    // Essas configurações são opcionais (se quiser controlar o tamanho da área visível):
    jScrollPane2.setPreferredSize(new Dimension(550, 160));
    jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


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

        jPanel2 = new javax.swing.JPanel();
        lbl_cadastroevento = new javax.swing.JLabel();
        lbl_atividades = new javax.swing.JLabel();
        lbl_geral = new javax.swing.JLabel();
        lbl_organizadores = new javax.swing.JLabel();
        lbl_menudescricao = new javax.swing.JLabel();
        pnl_topo = new javax.swing.JPanel();
        lbl_topoevento = new javax.swing.JLabel();
        pnl_cadastroatividades = new javax.swing.JPanel();
        lbl_ATIVIDADES = new javax.swing.JLabel();
        txt_nomeatividades = new javax.swing.JTextField();
        lbl_nomeatividades = new javax.swing.JLabel();
        lbl_inicio = new javax.swing.JLabel();
        lbl_cadastro02 = new javax.swing.JLabel();
        lbl_atividades02 = new javax.swing.JLabel();
        lbl_componente1 = new javax.swing.JLabel();
        lbl_componente02 = new javax.swing.JLabel();
        txt_categoria = new javax.swing.JTextField();
        lbl_categoria = new javax.swing.JLabel();
        lbl_data = new javax.swing.JLabel();
        lbl_dataatividade = new javax.swing.JLabel();
        txt_dataatividade = new javax.swing.JTextField();
        btn_confirmadata = new javax.swing.JButton();
        lbl_quantdias = new javax.swing.JLabel();
        lbl_ambientes = new javax.swing.JLabel();
        btn_voltar = new javax.swing.JButton();
        bnt_salvar = new javax.swing.JButton();
        txt_quantdias = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
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

        pnl_cadastroatividades.setBackground(new java.awt.Color(255, 255, 255));

        lbl_ATIVIDADES.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbl_ATIVIDADES.setText("• Atividades");

        txt_nomeatividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomeatividadesActionPerformed(evt);
            }
        });

        lbl_nomeatividades.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_nomeatividades.setText("Nome da atividade:");

        lbl_inicio.setText("Inicio");

        lbl_cadastro02.setText("Cadastro");

        lbl_atividades02.setText("Atividades");

        lbl_componente1.setText(">");

        lbl_componente02.setText(">");

        txt_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_categoriaActionPerformed(evt);
            }
        });

        lbl_categoria.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_categoria.setText("Categoria:");

        lbl_data.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbl_data.setText("• Data");

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

        lbl_quantdias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_quantdias.setText("Quantidade de dias:");

        lbl_ambientes.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lbl_ambientes.setText("• Ambientes");

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

        txt_quantdias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantdiasActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel3);

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
                        .addGap(30, 30, 30)
                        .addComponent(lbl_inicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_componente1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_cadastro02)
                        .addGap(6, 6, 6)
                        .addComponent(lbl_componente02)
                        .addGap(6, 6, 6)
                        .addComponent(lbl_atividades02))
                    .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_ATIVIDADES)
                            .addComponent(lbl_data)
                            .addComponent(lbl_ambientes)
                            .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_categoria, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_nomeatividades, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbl_nomeatividades)
                                    .addComponent(lbl_categoria)
                                    .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                                        .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_dataatividade, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_dataatividade))
                                        .addGap(166, 166, 166)
                                        .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_quantdias)
                                            .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                                                .addComponent(txt_quantdias, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(38, 38, 38)
                                                .addComponent(btn_confirmadata))))
                                    .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)))))))
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
                .addComponent(lbl_nomeatividades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nomeatividades, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_categoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(lbl_data)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                        .addComponent(lbl_dataatividade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_dataatividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_cadastroatividadesLayout.createSequentialGroup()
                        .addComponent(lbl_quantdias)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_confirmadata)
                            .addComponent(txt_quantdias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lbl_ambientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_cadastroatividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_voltar)
                    .addComponent(bnt_salvar))
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

    private void txt_quantdiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantdiasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantdiasActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        dispose(); // fecha a tela de login 
                Tela_cadastro_eventos_geral cadastro = new Tela_cadastro_eventos_geral();
                cadastro.setVisible(true);
    }//GEN-LAST:event_btn_voltarActionPerformed

    private void bnt_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt_salvarActionPerformed
    String nome = txt_nomeatividades.getText().trim();
    String categoria = txt_categoria.getText().trim();
    String dataTexto = txt_dataatividade.getText().trim();
    String qtdDiasTexto = txt_quantdias.getText().trim();

    if (nome.isEmpty() || categoria.isEmpty() || dataTexto.isEmpty() || qtdDiasTexto.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (!isDataValida(dataTexto)) {
        JOptionPane.showMessageDialog(this, "Data inválida! Use o formato dd/MM/yyyy.", "Erro", JOptionPane.ERROR_MESSAGE);
        txt_dataatividade.requestFocus();
        return;
    }

    if (!validarHoras()) {
        return; // já mostra a mensagem no próprio método
    }

    // Coletar os locais de atividade
    Component[] componentes = jPanel3.getComponents();
    StringBuilder locais = new StringBuilder();

    for (Component comp : componentes) {
        if (comp instanceof JPanel) {
            JPanel painelDia = (JPanel) comp;

            for (Component c : painelDia.getComponents()) {
                if (c instanceof JTextField) {
                    JTextField txtLocal = (JTextField) c;
                    String local = txtLocal.getText().trim();

                    if (local.isEmpty()) {
                        JOptionPane.showMessageDialog(this,
                            "Preencha todos os campos de local da atividade.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                        txtLocal.requestFocus();
                        return;
                    }

                    locais.append(txtLocal.getName()).append(": ").append(local).append("\n");
                }
            }
        }
    }
    
    

    // Aqui você poderia salvar no banco ou em uma lista, mas vamos apenas mostrar a confirmação por enquanto
    JOptionPane.showMessageDialog(this,
        "Atividade salva com sucesso!\n\n"
        + "Nome: " + nome + "\n"
        + "Categoria: " + categoria + "\n"
        + "Data de início: " + dataTexto + "\n"
        + "Locais:\n" + locais.toString().replace("txtLocal",""),
        "Sucesso", JOptionPane.INFORMATION_MESSAGE
    );

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
    atualizarLocaisAtividade();
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
    private javax.swing.JLabel lbl_descricaosistema;
    private javax.swing.JLabel lbl_geral;
    private javax.swing.JLabel lbl_inicio;
    private javax.swing.JLabel lbl_linkatividades;
    private javax.swing.JLabel lbl_linkcronograma;
    private javax.swing.JLabel lbl_linkevento;
    private javax.swing.JLabel lbl_links;
    private javax.swing.JLabel lbl_menudescricao;
    private javax.swing.JLabel lbl_nomeatividades;
    private javax.swing.JLabel lbl_organizadores;
    private javax.swing.JLabel lbl_quantdias;
    private javax.swing.JLabel lbl_titulosistema;
    private javax.swing.JLabel lbl_topoevento;
    private javax.swing.JPanel pnl_cadastroatividades;
    private javax.swing.JPanel pnl_descricao;
    private javax.swing.JPanel pnl_topo;
    private javax.swing.JTextField txt_categoria;
    private javax.swing.JTextField txt_dataatividade;
    private javax.swing.JTextField txt_nomeatividades;
    private javax.swing.JTextField txt_quantdias;
    // End of variables declaration//GEN-END:variables
}
