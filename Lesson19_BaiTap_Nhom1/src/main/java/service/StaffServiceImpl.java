/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.StaffDao;
import dao.StaffDaoImpl;
import entities.Staff;

/**
 *
 * @author SMILE ^^
 */
public class StaffServiceImpl implements StaffService {

    private final StaffDao staffDao;

    public StaffServiceImpl() {
        staffDao = new StaffDaoImpl();
    }

    @Override
    public Staff getStaff(String username, String password) {
        return staffDao.getStaff(username, password);
    }

}
