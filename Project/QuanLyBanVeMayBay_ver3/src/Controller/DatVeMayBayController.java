/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.ChiTietVe;
import Model.ChiTietVeDAO;
import Model.DatVeMayBay;
import Model.DatVeMayBayDAO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import fxsampler.Sample;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;

import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author hoangdang
 */
public class DatVeMayBayController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXComboBox<String> cbBoxKhoiHanh;
    @FXML
    private JFXComboBox<String> cbBoxDiemDen;
    @FXML
    private JFXDatePicker dPNgayDi;
    @FXML
    private JFXComboBox<Integer> cbBoxTreEm;
    @FXML
    private JFXComboBox<Integer> cbBoxNguoiLon;
    @FXML
    private JFXComboBox<Integer> cbBoxLoaiGhe;
    @FXML
    private JFXComboBox<String> cbBoxKhoiHanh1;
    @FXML
    private JFXComboBox<String> cbBoxDiemDen1;
    @FXML
    private JFXDatePicker dPNgayDi1;
    @FXML
    private JFXDatePicker dPNgayVe1;
    @FXML
    private JFXComboBox<Integer> cbBoxTreEm1;
    @FXML
    private JFXComboBox<Integer> cbBoxNguoiLon1;
    @FXML
    private JFXComboBox<Integer> cbBoxLoaiGhe1;
    @FXML
    private JFXButton btnTimChuyenBay;
    
    ObservableList cbBoxSoLuongVeList = FXCollections.observableArrayList(1,2,3 );
    ObservableList cbBoxLoaiGheList = FXCollections.observableArrayList("Thuong Gia","Pho Thong" );
    ObservableList<String> listSanBays = FXCollections.observableArrayList();
    
    private DatVeMayBayDAO datVe;
    
    private DatVeMayBay datVeMayBay = new DatVeMayBay();
    
    @FXML
    public void handleTimChuyenBay(ActionEvent event) throws IOException{
        AnchorPane paneChiTietChuyenBay = new AnchorPane();
        FXMLLoader fXMLLoader = MainController.getMainController().createPage(paneChiTietChuyenBay, "/View/DanhSachChuyenBay.fxml");
        paneChiTietChuyenBay.getChildren().add(paneChiTietChuyenBay); 
        GeneralFuntion.FitChildContent(paneChiTietChuyenBay);
//        String dkh = cbBoxKhoiHanh.getValue();
//        datVeMayBay.setDiemKhoiHanh(cbBoxKhoiHanh.getValue());
//        datVeMayBay.setDiemDen(cbBoxDiemDen.getValue());
//        datVeMayBay.setNgay(dPNgayDi.getValue());
//        datVeMayBay.setSLNguoiLon(cbBoxNguoiLon.getValue());
//        datVeMayBay.setSLTreEM(cbBoxTreEm.getValue());
//        datVeMayBay.setLoaiVe(cbBoxLoaiGhe.getValue());
//        System.out.println(datVeMayBay);
    }
//    @FXML
    public void getDiemKhoiHanh(ActionEvent event){
        datVeMayBay.setDiemKhoiHanh(cbBoxKhoiHanh.getValue());
//        System.out.println(datVeMayBay.getDiemKhoiHanh());
    }
     public void getDiemDen(ActionEvent event){
        datVeMayBay.setDiemDen(cbBoxDiemDen.getValue());
//        System.out.println(datVeMayBay.getDiemKhoiHanh());
    }
      public void getNgay(ActionEvent event){
        datVeMayBay.setNgay(dPNgayDi.getValue());
//        System.out.println(datVeMayBay.getDiemKhoiHanh());
    }
       public void getNglon(ActionEvent event){
        datVeMayBay.setSLNguoiLon(cbBoxNguoiLon.getValue());
//        System.out.println(datVeMayBay.getDiemKhoiHanh());
    }
        public void getTreEm(ActionEvent event){
        datVeMayBay.setSLTreEM(cbBoxTreEm.getValue());
//        System.out.println(datVeMayBay.getDiemKhoiHanh());
    }
         public void getGhe(ActionEvent event){
        datVeMayBay.setLoaiVe(cbBoxLoaiGhe.getValue());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbBoxNguoiLon.setItems(cbBoxSoLuongVeList);
        cbBoxTreEm.setItems(cbBoxSoLuongVeList);
        cbBoxNguoiLon1.setItems(cbBoxSoLuongVeList);
        cbBoxTreEm1.setItems(cbBoxSoLuongVeList);
        cbBoxLoaiGhe.setItems(cbBoxLoaiGheList);
        cbBoxLoaiGhe1.setItems(cbBoxLoaiGheList);
        try {
            LoadData();
        } catch (SQLException ex) {
            Logger.getLogger(DatVeMayBayController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void LoadData()throws SQLException{
        datVe = new DatVeMayBayDAO();
        listSanBays = datVe.getDiaDiemSanBay();
//        System.out.println("listSanBays: " +listSanBays );
        cbBoxKhoiHanh.setItems(listSanBays);
        cbBoxDiemDen.setItems(listSanBays);
        cbBoxKhoiHanh1.setItems(listSanBays);
        cbBoxDiemDen1.setItems(listSanBays);
      

    }
    
   
  
}
