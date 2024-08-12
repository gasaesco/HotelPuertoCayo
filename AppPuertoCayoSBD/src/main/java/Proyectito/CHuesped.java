/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyectito;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

/**
 *
 * @author crisp
 */
public class CHuesped {
    public void agregarHuesped(TextField cedHuesped, TextField nombres, TextField apellidos, TextField nacionalidad, TextField telefono, TextField correo){
        CConexion objetoCConexion= new CConexion();
        String consulta= "insert into huesped(cedHuesped, nombres, apellidos, nacionalidad, telefono, correo) values (?,?,?,?,?,?);";
        try(CallableStatement cs= objetoCConexion.estableceConexion().prepareCall(consulta)){
            cs.setString(1, cedHuesped.getText());
            cs.setString(2, nombres.getText());
            cs.setString(3, apellidos.getText());
            cs.setString(4, nacionalidad.getText());
            cs.setString(5, telefono.getText());
            cs.setString(6, correo.getText());
            cs.execute();
            showAlert("Informacion", "Se guardó correctamente");
            
            
        }
        catch(Exception e){
            showAlert("Informacion", "Error al guardar: "+ e.toString());
            
        }
        finally{
            objetoCConexion.cerrarConexion();
            
        }
    
        
    }
        
    private void showAlert(String title, String content){
        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
    public void MostrarHuesped (TableView<Object[]> TablaTotalHuesped){

        Proyectito.CConexion objetoConexion = new Proyectito.CConexion();

        TableColumn<Object[],String> cedHuespedColumn = new TableColumn<>("CedHuesped");
        TableColumn<Object[],String> nombresColumn = new TableColumn<>("Nombres");
        TableColumn<Object[],String> apellidosColumn = new TableColumn<>("Apellidos");
        TableColumn<Object[],String> nacionalidadColumn = new TableColumn<>("Nacionalidad");
        TableColumn<Object[],String> telfColumn = new TableColumn<>("Telefono");
        TableColumn<Object[],String> correoColumn = new TableColumn<>("Correo");


        cedHuespedColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[0].toString()));
        nombresColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[1].toString()));
        apellidosColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[2].toString()));
        nacionalidadColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[3].toString()));
        telfColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[4].toString()));
        correoColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue()[5].toString()));
        
       


        TablaTotalHuesped.getColumns().addAll(cedHuespedColumn,nombresColumn,apellidosColumn,nacionalidadColumn,telfColumn,correoColumn);

        String sql = "SELECT * from huesped;";

            try {

                Statement st = objetoConexion.estableceConexion().createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {                
                    Object[] rowData = {

                        rs.getString("cedHuesped"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("nacionalidad"),
                        rs.getString("telefono"),
                        rs.getString("correo")
   
                    };

                    TablaTotalHuesped.getItems().add(rowData);

                }

            } catch (Exception e) {
                showAlert("Error", "Error al guardar: "+ e.toString());
            } finally {

                objetoConexion.cerrarConexion();
            }
            
    }
    
    public void SeleccionarHuesped (TableView<Object[]> TablaTotalHuesped, TextField cedHuesped, TextField nombres,TextField apellidos, TextField nacionalidad, TextField telefono, TextField correo){

        int fila = TablaTotalHuesped.getSelectionModel().getSelectedIndex();

        if (fila>=0) {

            Object[] filaSeleccionada  = TablaTotalHuesped.getItems().get(fila);

            cedHuesped.setText(filaSeleccionada[0].toString());
            nombres.setText(filaSeleccionada[1].toString());
            apellidos.setText(filaSeleccionada[2].toString());
            nacionalidad.setText(filaSeleccionada[3].toString());
            telefono.setText(filaSeleccionada[4].toString());
            correo.setText(filaSeleccionada[5].toString());            
         }


    }
//logica para modificar Huesped
    public void ModificarUsuario(TextField cedHuesped, TextField nombres,TextField apellidos, TextField nacionalidad, TextField telefono, TextField correo){
    
    CConexion objetoConexion = new CConexion();
    
    String consulta = "update huesped SET huesped.nombres= ?, huesped.apellidos=?, huesped.nacionalidad=?,huesped.telefono=?,huesped.correo=? where huesped.cedHuesped=?;";
    
        try {
            
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setString(1, nombres.getText());
            cs.setString(2, apellidos.getText());
            cs.setString(3,  nacionalidad.getText());
            cs.setString(4, telefono.getText());
            cs.setString(5, correo.getText());
            cs.setString(6, cedHuesped.getText());
            cs.execute();
                    
            showAlert("Informacion", "Se modificó");
            
            
        } catch (Exception e) {
            
            showAlert("Informacion", "NO Se modificó,"+ e.toString());
        } finally {
            
            objetoConexion.cerrarConexion();
        }
    
    
    }
    
    //logica para Eliminar Huesped
        public void EliminarHuesped (TextField cedHuesped){
    
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM huesped WHERE huesped.cedHuesped=?;";
        
        try {
            CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
            cs.setString(1, cedHuesped.getText());
            cs.execute();
            
            showAlert("INFORMACIÓN", "Se eliminó correctamente el registro");
            
        } catch (Exception e) {
            
            showAlert("ERROR", "No se eliminó: "+ e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }
    
    }
    
    public void limpiarCampos (TextField cedHuesped, TextField nombres,TextField apellidos, TextField nacionalidad, TextField telefono, TextField correo){
    
    cedHuesped.setText("");
    nombres.setText("");
    apellidos.setText("");
    nacionalidad.setText("");
    telefono.setText("");
    correo.setText("");
    
    }
    
    
}
