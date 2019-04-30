/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.DBConnect;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javax.naming.spi.DirStateFactory;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author win10pro
 */
public class ChiTietVeDAO {
    private ChiTietVe createChuyenBay(ResultSet rs){
        ChiTietVe ct = new ChiTietVe();
        try{
            ct.setTenHMB(rs.getString("TenHMB"));
            ct.setDiemKhoiHanh(rs.getString("DiemKhoiHanh"));
            ct.setDiemDen(rs.getString("DiemDen"));
            ct.setSanBayDi(rs.getString("SanBayDi"));
            ct.setNgayKhoiHanh(rs.getDate("NgayKhoiHanh"));
            ct.setThoiGianBay(rs.getInt("ThoiGianBay"));
            ct.setGioKhoiHanh(rs.getTime("GioKhoiHanh"));
        }catch(Exception e){
            e.printStackTrace();
            System.out.print("Can't load ChuyenBay");
        }
        return ct;
    }
    public ChiTietVe getChuyenBay(String MaCB) throws SQLException {
        String sql = "select TenHMB,DiemKhoiHanh,DiemDen,TenSB as SanBayDi,NgayKhoiHanh,ThoiGianBay,GioKhoiHanh\n" +
"from ChuyenBay,SanBay,HangMayBay\n" +
"where ChuyenBay.MaHMB=HangMayBay.MaHMB and ChuyenBay.SanBayDi=SanBay.MaSB\n" +
"and MaCB='"+MaCB+"'";
        ChiTietVe ct =new ChiTietVe();
        System.out.println(sql);
        try {
            ResultSet rs = DBConnect.dbExcute(sql);
            ct = createChuyenBay(rs); //Gán dòng vào đối tượng qua hàm ở trên
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Can't load ChuyenBay");
        }
        return ct;
    }
    
    private ChiTietVe createSanBayDen(ResultSet rs){
        ChiTietVe ct = new ChiTietVe();
        try{
            ct.setSanBayDen(rs.getString("SanBayDen"));
        }catch(Exception e){
            e.printStackTrace();
            System.out.print("Can't load SanBayDen");
        }
        return ct;
    }
    public ChiTietVe getSanBayDen(String MaCB) throws SQLException {
        String sql = "select TenSB as SanBayDen\n" +
"from SanBay,ChuyenBay\n" +
"where ChuyenBay.SanBayDen=SanBay.MaSB and MaCB='"+MaCB+"'";
        System.out.println(sql);
        ChiTietVe ct=new ChiTietVe();
        try {
            ResultSet rs = DBConnect.dbExcute(sql);
                ct = createChuyenBay(rs); //Gán dòng vào đối tượng qua hàm ở trên
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Can't load SanBayDen");
        }
        return ct;
    }
    public ChiTietVe createChiTietVe(ResultSet rs){
        ChiTietVe ct = new ChiTietVe();
        try{
            ct.setTenHK(rs.getString("TenHK"));
            ct.setCMND(rs.getString("CMND"));
            ct.setSDT(rs.getString("SDT"));
            ct.setLoaiHK(rs.getBoolean("LoaiHK"));
            ct.setLoaiVe(rs.getBoolean("LoaiVe"));
            ct.setGia(rs.getInt("Gia"));
            ct.setEmail(rs.getString("Email"));
        }catch(Exception e){
            e.printStackTrace();
            System.out.print("Can't load ChiTietVe");
        }
        return ct;
    }
    public ChiTietVe getChiTietVe(String MaVe) throws SQLException {
        String sql = "select TenHK,CMND,SDT,Email,LoaiHK,LoaiVe,Gia from ChiTietChuyenBay,Ve where ChiTietChuyenBay.MaVe='"+MaVe+"' and Ve.MaVe=ChiTietChuyenBay.MaVe";
        System.out.println(sql);
        ChiTietVe ct =new ChiTietVe();
        try {
            ResultSet rs = DBConnect.dbExcute(sql);
            while (rs.next()) { // Chạy từng dòng trong ResultSet
                ct = createChuyenBay(rs); //Gán dòng vào đối tượng qua hàm ở trên
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Can't load ChiTietVe");
        }
        return ct;
    }
}
