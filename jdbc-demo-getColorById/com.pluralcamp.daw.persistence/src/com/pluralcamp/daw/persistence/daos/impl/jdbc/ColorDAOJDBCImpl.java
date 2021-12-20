package com.pluralcamp.daw.persistence.daos.impl.jdbc;

import com.pluralcamp.daw.entities.core.Color;
import com.pluralcamp.daw.persistence.daos.contracts.ColorDAO;
import com.pluralcamp.daw.persistence.exceptions.DAOException;

import java.sql.DriverManager;//Implementacio
//Interficies:
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

public class ColorDAOJDBCImpl implements ColorDAO {
    @Override
    public Color getColorById(long id) throws DAOException {

        //Objectes que calen:
        //1er objecte - Connexio, via DriverManager de JDBC
        //2n objecte - Obrir un canal de Consulta - PraparedStatement
        //2.1 - Enviar la consulta SQL
        //3er objecte - Obrir un canal de Lectura, un cursor - ResultSet

        //Codi previ a Java 7
        Connection connection = null;
        PreparedStatement sentSQL = null;
        ResultSet reader = null;
        Color color = null;

        try { //Obrim els recursos i els consumim
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar?serverTimezone=Europe/Paris",
                    "orboan", "mysql");
            sentSQL = connection.prepareStatement("SELECT id, name, red, green, blue FROM colors WHERE id = ?");
            sentSQL.setLong(1, id);
            reader = sentSQL.executeQuery();
            if (reader.next()) { //rconstruim les dades com a objecte color
                color = new Color(reader.getString("name"),
                        reader.getInt("red"),
                        reader.getInt("green"),
                        reader.getInt("blue"));
                color.setId(reader.getLong("id"));
            }

        } catch (SQLException ex) {
            throw new DAOException();
        } finally { //tanquem recursos, en ordre invers
            try {
                if (reader != null) reader.close();
                if (sentSQL != null) sentSQL.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {

            }
        }

        return color;
    }

    @Override
    public List<Color> getColors() throws DAOException {
        return null;
    }

    @Override
    public List<Color> getColors(int offset, int count) throws DAOException {
        return null;
    }

    @Override
    public List<Color> getColors(String searchTerm) throws DAOException {
        return null;
    }

    @Override
    public List<Color> getColors(String searchTerm, int offset, int count) throws DAOException {
        return null;
    }
}
