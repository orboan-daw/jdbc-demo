package com.pluralcamp.daw.ui.console;

import com.pluralcamp.daw.persistence.daos.impl.jdbc.ColorDAOJDBCImpl;
import com.pluralcamp.daw.persistence.exceptions.DAOException;

public class App {
    public static void main(String[] args) {
        var colorDAO = new ColorDAOJDBCImpl();
        try {
            var color = colorDAO.getColorById(1);
            if (color != null) {
                System.out.println(color.toString());
            }
        } catch(DAOException ex){

        }
    }
}
