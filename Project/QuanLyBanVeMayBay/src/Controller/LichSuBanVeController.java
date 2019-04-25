/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.LichSuBanVe;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.*;

/**
 * FXML Controller class
 *
 * @author win10pro
 */
public class LichSuBanVeController implements Initializable {

    @FXML
    private TableView<LichSuBanVe> tbHocSinh;
    @FXML
    private TableColumn<LichSuBanVe,String> colMaVe;
    @FXML
    private TableColumn<LichSuBanVe,String> colMaCB;
    @FXML
    private TableColumn<LichSuBanVe,String> colTen;
    @FXML
    private TableColumn<LichSuBanVe,Integer> colGiaVe;
    @FXML
    private TableColumn<?,?> colChiTiet;
    @FXML
    private JFXButton btnTim;
    @FXML
    private JFXTextField tfTim;
    ObservableList<LichSuBanVe> listBanVe = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnTimClick(ActionEvent event) {
    }
    
}
