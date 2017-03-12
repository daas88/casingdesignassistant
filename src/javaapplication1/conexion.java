package javaapplication1;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class conexion {

    Connection conexion;

    public conexion(String inf, String usuario, String contrasena) {
        conectar(inf, usuario,contrasena);
    }
    
    

    private boolean con(String inf, String usuario, String contrasena) {

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = DriverManager.getConnection(inf, usuario, contrasena);

            System.out.println(" jejejejej me conecte mysql");
            return true;

        } catch (Exception e) {
            System.out.println(" locura ERROR:   " + e.getMessage());
            return false;
        }
    }

    private boolean con2(String inf, String usuario, String contrasena) {

        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(inf, usuario, contrasena);

            System.out.println(" jejejejej me conecte2 postegresl");
            return true;

        } catch (Exception e) {
            System.out.println(" locura ERROR:   " + e.getMessage());
            return false;
        }
    }

    private boolean con3(String inf, String usuario, String contrasena) {

        try {
            Class.forName("com.sybase.jdbc2.jdbc.SybDriver");
            conexion = DriverManager.getConnection(inf, usuario, contrasena);

            System.out.println(" jejejejej me conecte sybase");
            return true;

        } catch (Exception e) {

            System.out.println(" locura ERROR:   " + e.getMessage());
            return false;

        }
    }

    public ResultSet ExecQuery(String query) {
        Statement statement;
        ResultSet result;


        if (this.conexion != null) {
            try {
                statement = (Statement) conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                result = statement.executeQuery(query);

                if (result != null) {
                    return result;
                } else {
                    return null;
                }

            } catch (SQLException ex) {

                Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        System.out.println("no ta conectao");
        return null;

    }

    private int conectar(String inf, String usuario, String contrasena) {

        if (con(inf, usuario, contrasena)) {
            return 0;
        } else if (con2(inf, usuario, contrasena)) {
            return 0;
        } else if (con3(inf, usuario, contrasena)) {
            return 0;
        } else {
            return 1;
        }


    }

    public void Desconectar() throws SQLException {
        if (this.conexion != null) {

            this.conexion.close();

        }

    }

    public int Actualizar(String sql) {
        Statement statement;
        if (this.conexion != null) {
            try {
                statement = (Statement) conexion.createStatement();

                return statement.executeUpdate(sql);


            } catch (SQLException ex) {

                Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
        return -1;

    }
}
