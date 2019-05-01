/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Date;
/**
 *
 * @author Van Tich
 */
public class DatVeMayBay {
    private String DiemKhoiHanh;
    private String DiemDen;
    private  Date Date;
    private int SLNguoiLon;
    private int SLTreEM;
    public DatVeMayBay(String DiemKhoiHanh,String DiemDen, Date Date, int SLNguoiLon, int SLTreEm)
    {
        this.DiemKhoiHanh = DiemKhoiHanh;
        this.DiemDen = DiemDen;
        this.Date =Date;
        this.SLNguoiLon = SLNguoiLon; 
        this.SLTreEM = SLTreEm;
    }
    
        @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    public DatVeMayBay()
    {}
    public void SetDiemKhoiHanh(String DiaDiem){
      this.DiemKhoiHanh = DiemKhoiHanh;
    }
    public void SetDiemDen(String DiemDen){
      this.DiemDen = DiemDen;
    }
    public void SetDate(Date Date){
        this.Date =Date;
    }
    public void SetSLNguoiLon(int SLNguoiLon){
        this.SLNguoiLon = SLNguoiLon; 
    }
    public void SetSLTreEM(int SLTreEM){
        this.SLTreEM = SLTreEM;
    }
    public String GetDiemKhoiHanh(String DiemKhoiHanh){
      return DiemKhoiHanh;
    }
    public String GetDiemDen(String DiemDen){
      return DiemDen;
    }
    public Date GetDate(Date Date){
        return Date;
    }
    public int GetSLNguoiLon(int SLNguoiLon){
        return SLNguoiLon; 
    }
    public int GetSLTreEM(int SLTreEM){
        return SLTreEM;
    }
}
