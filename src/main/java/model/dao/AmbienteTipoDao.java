package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.ConnectionFactory;
import model.bean.AmbienteTipo;

public class AmbienteTipoDao {
    
    private static AmbienteTipo parseAmbienteTipo(ResultSet result) {
        try {
            AmbienteTipo tipo = new AmbienteTipo();
            
            tipo.setId(result.getInt("id"));
            tipo.setTipo(result.getString("tipo"));
            
            return tipo;
        } catch (SQLException e) {
            Logger.getLogger(AmbienteTipoDao.class.getName()).log(Level.SEVERE, "Erro ao buscar tipo de ambiente!", e);
            return null;
        }
    }

    public static AmbienteTipo findById(int id) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        String sql = "SELECT * FROM ambientes_tipos WHERE id = ? LIMIT 1;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery();

            if (!result.next()) {
                return null;
            }

            return AmbienteTipoDao.parseAmbienteTipo(result);
        } catch (SQLException ex) {
            Logger.getLogger(AmbienteTipoDao.class.getName()).log(Level.SEVERE, "Erro ao buscar tipo de ambiente!", ex);
            return null;
        } finally {
            ConnectionFactory.close(conn, stmt);
        }
    }

    public static boolean create(AmbienteTipo tipo) {

        String sql = "INSERT INTO ambientes_tipos (tipo) VALUES (?)";

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, tipo.getTipo());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AmbienteTipoDao.class.getName()).log(Level.SEVERE, "Erro ao criar tipo de ambiente!", ex);
            return false;
        } finally {
            ConnectionFactory.close(conn, stmt);
        }

        return true;
    }
}
