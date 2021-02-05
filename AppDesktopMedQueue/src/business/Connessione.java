package business;

import persistence.DriverManagerConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Classe che offre le funzionalita di business per connettersi e disconettersi da un database.
 */
public class Connessione implements ConnessioneInterface {

    public Connessione(){}

    /**
     * Metodo che permette la connessione al database.
     *
     * @return connessione
     */
    public Connection connect() {
        Connection con;
        con=DriverManagerConnectionPool.createDbConnection();
        return con;
    }

    /**
     * Metodo che permette di disconnettersi dal database.
     *
     * @param connect connessione al database
     */
    public void disconnect(Connection connect){
        try {
            DriverManagerConnectionPool.releaseConnection(connect);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }




}