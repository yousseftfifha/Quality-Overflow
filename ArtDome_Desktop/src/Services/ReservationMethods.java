/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import Tools.MyConnection;
import Entities.Client;
import Entities.Reservation;
import Entities.User;

/**
 *
 * @author HP
 */
public class ReservationMethods {
    
          private Connection cnx;
    private PreparedStatement ste;
    private ResultSet rs;
    private Statement st;

   
    public ReservationMethods() {
        cnx = MyConnection.getInstance().getConnection();
    }
     public void AddReservation(Reservation r){
        String req ="INSERT INTO reservation (nb_place, code_event)"+"values (?,?)";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, r.getNb_place());
            ste.setInt(2, r.getCode_event());

            ste.executeUpdate();
            JOptionPane.showMessageDialog(null, "Reservation ajoutée", "", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Reservation ajoutée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
    }
    
//    public ObservableList<Reservation> getReservationList(){
//        ObservableList<Reservation> Reservationlist = FXCollections.observableArrayList();
//         String req = "SELECT * from reservation ORDER BY code_event";
//        try {
//            st = cnx.createStatement();
//           rs= st.executeQuery(req);
//           while(rs.next()){
//               //User u=new User(rs.getString("nom_client"), rs.getString("prenom_client"), rs.getString("email"),rs.getInt("telephone") );
//               Client c= new Client(rs.getString("nom_client"), rs.getString("prenom_client"), rs.getString("email"),rs.getInt("telephone"));
//               Reservation r=new Reservation(rs.getInt("code_reservation"),c, rs.getInt("nb_place"),rs.getInt("code_event"));
//               Reservationlist.add(r);
//           }
//
//        } catch (SQLException ex) {
//           System.out.println("Probléme");
//            System.out.println(ex.getMessage());
//        }
//        return Reservationlist;
//    }
//    
//        public ObservableList<Reservation> getReservationListBack(){
//        ObservableList<Reservation> Reservationlist = FXCollections.observableArrayList();
//         String req = "SELECT * from reservation ORDER BY code_event";
//        try {
//            st = cnx.createStatement();
//           rs= st.executeQuery(req);
//           while(rs.next()){
//               //User u=new User(rs.getString("nom_client"), rs.getString("prenom_client"), rs.getString("email"),rs.getInt("telephone") );
//               Client c= new Client(rs.getString("nom_client"), rs.getString("prenom_client"), rs.getString("email"),rs.getInt("telephone"));
//               Reservation r=new Reservation(rs.getInt("code_reservation"),c, rs.getInt("nb_place"),rs.getInt("code_event"));
//               Reservationlist.add(r);
//           }
//
//        } catch (SQLException ex) {
//           System.out.println("Probléme");
//            System.out.println(ex.getMessage());
//        }
//        return Reservationlist;
//    }
   
    public void DeleteReservation(int codeee){
          try {
              String req = "DELETE from reservation WHERE code_reservation =" +codeee+ " ";
              
              st = cnx.createStatement();
              st.executeUpdate(req);
              JOptionPane.showMessageDialog(null, "Reservation supprimée", "", JOptionPane.INFORMATION_MESSAGE);
              System.out.println("Reservation supprimée");
          } catch (SQLException ex) {
              System.out.println("Probléme");
              Logger.getLogger(EventMethods.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
//    
     public void UpdateReservation(Reservation r,int codeee ){
        String req ="UPDATE reservation set nb_place=? WHERE code_reservation =" +codeee+ " ";
        try {
            ste = cnx.prepareStatement(req);
            ste.setInt(1, r.getNb_place());
            ste.executeUpdate();
            JOptionPane.showMessageDialog(null, "Reservation modifiée", "", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Reservation modifiée");
            
        } catch (SQLException ex) {
            System.out.println("Probléme");
            System.out.println(ex.getMessage());
            
        }
        
     }
     
     public ObservableList<Reservation> SearchReservation(int search ){
         ObservableList<Reservation> Reservationlist = FXCollections.observableArrayList();
         String req ="select * from reservation WHERE code_reservation='"+search+"'";
         try {
           st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
              // User u=new User(rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),rs.getInt("numero") );
               Client c= new Client(rs.getString("nom_client"), rs.getString("prenom_client"), rs.getString("email"),rs.getInt("telephone"));
               Reservation r=new Reservation(rs.getInt("code_reservation"),c, rs.getInt("nb_place"),rs.getInt("code_event"));
           Reservationlist.add(r);
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return Reservationlist;
     }
     
          public ObservableList<Reservation> SearchReservationB(int search ){
         ObservableList<Reservation> Reservationlist = FXCollections.observableArrayList();
         String req ="select * from reservation WHERE code_reservation='"+search+"' or code_event='"+search+"'";
         try {
           st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
              // User u=new User(rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),rs.getInt("numero") );
               Client c= new Client(rs.getString("nom_client"), rs.getString("prenom_client"), rs.getString("email"),rs.getInt("telephone"));
               Reservation r=new Reservation(rs.getInt("code_reservation"),c, rs.getInt("nb_place"),rs.getInt("code_event"));
           Reservationlist.add(r);
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }
        return Reservationlist;
     }
     
     
      public ObservableList<Reservation> listeResC(){   
     ObservableList<Reservation> infoclient = FXCollections.observableArrayList();
     String req ="Select r.code_reservation, r.nb_place, r.code_event, u.nom, u.prenom, u.email, u.numero FROM reservation r INNER JOIN user u ON r.code_client = u.id_user ORDER BY code_reservation DESC";
   try {
           st = cnx.createStatement();
           rs= st.executeQuery(req);
           while(rs.next()){
               User u=new User(rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),rs.getInt("numero") );
                Reservation r=new Reservation(rs.getInt("code_reservation"),u, rs.getInt("nb_place"),rs.getInt("code_event"));
               infoclient.add(r);
           }

        } catch (SQLException ex) {
           System.out.println("Probléme");
            System.out.println(ex.getMessage());
        }             
    return infoclient;
 }
     
}
