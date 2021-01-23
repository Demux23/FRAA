package persistence;

import business.OperazioneBean;
import business.PrenotazioneBean;
import business.StrutturaBean;

import java.sql.*;
import java.util.ArrayList;

public class DataAccess {

    public static PrenotazioneBean getPrenotazione(int id){
        PrenotazioneBean prenotazione = new PrenotazioneBean();
        try {
            Statement st = DriverManagerConnectionPool.getConnection().createStatement();
            String sql = "SELECT p.* FROM Prenotazione p WHERE p.id='"+id+"'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                prenotazione.setId(Integer.parseInt(rs.getString(1)));
                prenotazione.setData(rs.getString(2));
                prenotazione.setTime(rs.getString(3));
                prenotazione.setConvalida(Boolean.parseBoolean(rs.getString(4)));
                prenotazione.setCodiceFiscale(rs.getString(5));
                prenotazione.setIdOperazione(Integer.parseInt(rs.getString(6)));
                prenotazione.setIdStruttura(Integer.parseInt(rs.getString(7)));
            }
            st.close();
        } catch(SQLException e) {
            System.err.println("SQLException:"+ e.getMessage());
        }
        return prenotazione;
    }

    public static StrutturaBean getStruttura(int id){
        StrutturaBean struttura=new StrutturaBean();
        try {
            Statement st = DriverManagerConnectionPool.getConnection().createStatement();
            String sql = "SELECT s.* FROM Struttura s WHERE s.id='"+id+"'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                struttura.setId(Integer.parseInt(rs.getString(1)));
                struttura.setNome(rs.getString(2));
                struttura.setIndirizzo(rs.getString(3));
                struttura.setNumeroDiTelefono(rs.getString(4));
            }

            st.close();
        } catch(SQLException e) {
            System.err.println("SQLException:"+ e.getMessage());
        }
        return struttura;

    }

    public static OperazioneBean getOperazione(int id){
        OperazioneBean operazione =new OperazioneBean();
        try {
            Statement st = DriverManagerConnectionPool.getConnection().createStatement();
            String sql = "SELECT o.* FROM Operazione o WHERE o.id='"+id+"'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                operazione.setId(Integer.parseInt(rs.getString(1)));
                operazione.setTipoOperazione(rs.getString(2));
                operazione.setDescrizione(rs.getString(3));
            }

            st.close();
        } catch(SQLException e) {
            System.err.println("SQLException:"+ e.getMessage());
        }
        return operazione;

    }


    /*
    Metodo per verificare se esiste l'impiegato nel database,si utilizza una query basata sul codicefiscale
    Con la query verifichiano se nel database è presente un utente che possiede gia quel codice fiscale
    Se la query non restituisce nulla return false altrimenti return true
     */
    public static boolean verificaDatiImpiegato(String cf,String password){
        boolean verifica=false;
        try {
            Statement st = DriverManagerConnectionPool.getConnection().createStatement();
            String sql = "SELECT i.codiceFiscale,i.password FROM impiegato i WHERE i.codiceFiscale='"+cf+"'&& i.password='"+password+"'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                verifica=true;
            }
            st.close();
        } catch(SQLException e) {
            System.err.println("SQLException:"+ e.getMessage());
        }
        return verifica;
    }

    //Metodo per ottenere operazioni
    public static ArrayList<String> getOperazioni(){
        ArrayList<String> operazioni=new ArrayList<String>();
        try {
            Statement st = DriverManagerConnectionPool.getConnection().createStatement();
            String sql = "SELECT o.tipoOperazione From operazione o";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                operazioni.add(rs.getString(1));
            }
            st.close();
        } catch(SQLException e) {
            System.err.println("SQLException:"+ e.getMessage());
        }
        return operazioni;
    }
}
