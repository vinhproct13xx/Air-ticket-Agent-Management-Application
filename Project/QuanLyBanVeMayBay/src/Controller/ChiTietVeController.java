/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ChiTietVe;
import Model.ChiTietVeDAO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import com.sun.javafx.scene.control.skin.TableViewSkin;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.sql.SQLException;
import  javafx.scene.control.Button;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;


/**
 * FXML Controller class
 *
 * @author win10pro
 */
public class ChiTietVeController implements Initializable {

    @FXML
    private JFXTextField tfMaVe;
    @FXML
    private JFXTextField tfMaCB;
    @FXML
    private JFXTextField tfHangMB;
    @FXML
    private JFXTextField tfTGBay;
    @FXML
    private JFXTextField tfTenHK;
    @FXML
    private JFXTextField tfCMND;
    @FXML
    private JFXTextField tfSDT;
    @FXML
    private JFXTextField tfEmail;
    @FXML
    private JFXTextField tfLoaiHK;
    @FXML
    private JFXTextField tfGiaVe;
    @FXML
    private JFXButton btnHuyVe;
    @FXML
    private JFXButton btnSua;
    @FXML
    private JFXButton btnLuu;
    @FXML
    private JFXTextField tfLoaiHK1;
    @FXML
    private JFXTimePicker tpGioKH;
    @FXML
    private JFXDatePicker dpNgayKH;
    @FXML
    private JFXComboBox<String> cboDiemKH;
    @FXML
    private JFXComboBox<String> cboSanBayDi;
    @FXML
    private JFXComboBox<String> cboSanBayDen;
    ObservableList<ChiTietVe> listChuyenBay = FXCollections.observableArrayList();
    ObservableList<ChiTietVe> listSanBayDen = FXCollections.observableArrayList();
    ObservableList<ChiTietVe> listChiTietVe = FXCollections.observableArrayList();
    private ChiTietVeDAO ct;
    @FXML
    private JFXComboBox<String> cboDiemDen;
    /**ChiTietVeDAO
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
            LoadData();
        }catch (SQLException e){
            System.out.println("Can't load data in initialize");
        }
    }    
    private void LoadData()throws SQLException{
        ct=new ChiTietVeDAO();
        ChiTietVe ctv=new ChiTietVe();
        ctv=ct.getChuyenBay(tfMaCB.getText());
        tfHangMB.setText(String.valueOf(ctv.getTenHMB()));
        cboDiemKH.setValue(String.valueOf(ctv.getDiemKhoiHanh()));
        cboDiemDen.setValue(String.valueOf(ctv.getDiemDen()));
        cboSanBayDi.setValue(String.valueOf(ctv.getSanBayDi()));
    }
    @FXML
    private void btnHuyVeClick(ActionEvent event) {
    }

    @FXML
    private void btnSuaClick(ActionEvent event) {
    }

    @FXML
    private void btnLuuClick(ActionEvent event) {
    }
    public void loadtfMaVe(String a){
        tfMaVe.setText(a);
    }
    public void loadtfMaCB(String a){
        tfMaCB.setText(a);
    }
}
