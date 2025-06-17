package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.ConnectionFactory;
import model.bean.Ambiente;

public class AmbienteDao {
    
    private static Ambiente parseAmbiente(ResultSet result) {
        
        try {
            Ambiente ambiente = new Ambiente();
            
            Integer id = result.getInt("id");
            String nome = result.getString("nome");
            String descricao = result.getString("descricao");

            ambiente.setId(id);
            ambiente.setNome(nome);
            ambiente.setDescricao(descricao);
            
            return ambiente;
        } catch(SQLException e) {
            Logger.getLogger(AmbienteDao.class.getName()).log(Level.SEVERE, "Erro ao buscar ambiente!", e);
            return null;
        }
    }
    
    public static Ambiente findById(int id) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        String sql = "SELECT * FROM ambientes WHERE id = ? LIMIT 1;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery();

            if (!result.next()) {
                return null;
            }

            return AmbienteDao.parseAmbiente(result);
        } catch (SQLException ex) {
            Logger.getLogger(AmbienteDao.class.getName()).log(Level.SEVERE, "Erro ao buscar ambiente!", ex);
            return null;
        } finally {
            ConnectionFactory.close(conn, stmt);
        }
    }
    
    public static boolean create(Ambiente ambiente) {

        String sql = "INSERT INTO ambientes (nome, descricao) VALUES (?, ?)";

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, ambiente.getNome());
            stmt.setString(2, ambiente.getDescricao());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AmbienteDao.class.getName()).log(Level.SEVERE, "Erro ao criar ambiente!", ex);
            return false;
        } finally {
            ConnectionFactory.close(conn, stmt);
        }

        return true;
    }
    
    public static boolean update(Ambiente ambiente) {
        String sql = "UPDATE ambientes SET nome = ?, descricao = ? where id = ?";
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, ambiente.getNome());
            stmt.setString(2, ambiente.getDescricao());
            stmt.setInt(3, ambiente.getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AmbienteDao.class.getName()).log(Level.SEVERE, "Erro ao atualizar ambiente!", ex);
            return false;
        } finally {
            ConnectionFactory.close(conn, stmt);
        }

        return true;
    }

    public static boolean destroy(Ambiente ambiente) {
        String sql = "DELETE FROM ambientes WHERE id = ?";

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, ambiente.getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AmbienteDao.class.getName()).log(Level.SEVERE, "Erro ao deletar ambiente!", ex);
            return false;
        } finally {
            ConnectionFactory.close(conn, stmt);
        }

        return true;
    }
}
