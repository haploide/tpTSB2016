/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class DocumentoJDBC
{

    public static int Insert(String doc, Connection connection)
    {
        int id = 0;

        try
        {
//            Connection connection = abrirConexion();
            String sql = "INSERT INTO Documento (documento)  VALUES(?)";
            PreparedStatement preparedStmt = connection.prepareStatement(sql);

            preparedStmt.setString(1, doc);
            preparedStmt.executeUpdate();

//            connection.commit();
            preparedStmt.close();
//            connection.close();

        } catch (SQLException ex)
        {
            Logger.getLogger(DocumentoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        id = getIdDocumento(doc, connection);
        return id;

    }

    public static LinkedList<String> getDocumentos(int idP,Connection connection)
    {
        LinkedList<String> d = new LinkedList<>();
        try
        {

//            Connection connection = abrirConexion();
            String sql = "select d.documento from  Documento d join DocumentoXPalabra dp on d.id_documento = dp.id_documento where dp.id_palabra = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(2, idP);

            ResultSet result = statement.executeQuery();
            while (result.next())
            {
                d.add("d.documento");
            }
            result.close();
            statement.close();
//            connection.close();

        } 
//        catch (IOException ex)
//        {
//            Logger.getLogger(DocumentoJDBC.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        catch (ClassNotFoundException ex)
//        {
//            Logger.getLogger(DocumentoJDBC.class.getName()).log(Level.SEVERE, null, ex);
//        }
        catch (SQLException ex)
        {
            Logger.getLogger(DocumentoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;

    }

    public static int getIdDocumento(String doc, Connection connection)
    {
        int id = 0;
        try
        {

//            Connection connection = abrirConexion();
            String sql = "SELECT id_documento FROM Documento WHERE documento = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, doc);

            ResultSet result = statement.executeQuery();
            while (result.next())
            {
                id = result.getInt(1);

            }
            result.close();
            statement.close();
//            connection.close();

        } //        catch (IOException ex)
        //        {
        //            Logger.getLogger(DocumentoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        //        } catch (ClassNotFoundException ex)
        //        {
        //            Logger.getLogger(DocumentoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        //        } 
        catch (SQLException ex)
        {
            Logger.getLogger(DocumentoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public DocumentoJDBC()
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
