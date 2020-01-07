/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Staff;

/**
 *
 * @author SMILE ^^
 */
public interface StaffDao {

    public Staff getStaff(String username, String password);
}
