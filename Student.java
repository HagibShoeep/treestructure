/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treestructure;

/**
 *
 * @author شعيب
 */
public class Student {

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getISN() {
        return ISN;
    }

    public void setISN(String ISN) {
        this.ISN = ISN;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String FirstName;

    private String LastName;

    private String ISN;

    private int id;

    public Boolean searchName(String name) {
        if (this.FirstName.equals(name)) {
            return true;
        }
        return false;
    }

    public Boolean searchId(int id) {
        if (this.id == id) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "" + "FirstName=" + FirstName + ", LastName=" + LastName + ", ISN=" + ISN + ", id=" + id + '\n';
    }

}
