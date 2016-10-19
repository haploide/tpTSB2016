/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte;

import interfaz.Principal;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class Documento
{

    public static void Insert(String doc)
    {

        try
        {
            Connection connection = abrirConexion();
            String query = "INSERT INTO Documento (documento) VALUES( ?,? )";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(2, doc);
            preparedStmt.executeUpdate();

            preparedStmt.close();
            connection.close();

        } catch (IOException ex)
        {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex)
        {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Documento()
    {
    }

    private static Connection abrirConexion() throws IOException, ClassNotFoundException, SQLException
    {

        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:Vocabulario.sqlite");
        connection.setAutoCommit(false);
        return connection;
    }

}
