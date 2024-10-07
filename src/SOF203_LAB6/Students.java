/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SOF203_LAB6;

/**
 *
 * @author THANHDAT
 */
public class Students {
    private int RegID;
    private String Name;
    private String Address;
    private String ParentName;
    private String Phone;
    private String Standard;
    private String RegDate;

    public Students() {
    }

    public Students(int RegID, String Name, String Address, String ParentName, String Phone, String Standard, String RegDate) {
        this.RegID = RegID;
        this.Name = Name;
        this.Address = Address;
        this.ParentName = ParentName;
        this.Phone = Phone;
        this.Standard = Standard;
        this.RegDate = RegDate;
    }

    public int getRegID() {
        return RegID;
    }

    public void setRegID(int RegID) {
        this.RegID = RegID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getParentName() {
        return ParentName;
    }

    public void setParentName(String ParentName) {
        this.ParentName = ParentName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getStandard() {
        return Standard;
    }

    public void setStandard(String Standard) {
        this.Standard = Standard;
    }

    public String getRegDate() {
        return RegDate;
    }

    public void setRegDate(String RegDate) {
        this.RegDate = RegDate;
    }
    
    
}
