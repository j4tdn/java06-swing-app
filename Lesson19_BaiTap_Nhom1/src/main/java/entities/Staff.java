/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author SMILE ^^
 */
public class Staff {

    private Integer id;
    private String name;
    private String phoneNumber;
    private String address;
    private String email;
    private LocalDate dayOfBirth;
    private String username;
    private String password;
    private Title title;

    public Staff() {
    }

    public Staff(Integer id, String name, String phoneNumber, String address, String email, LocalDate dayOfBirth,
            String username, String password, Title title) {
        super();
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.dayOfBirth = dayOfBirth;
        this.username = username;
        this.password = password;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Staff)) {
            return false;
        }

        Staff staff = (Staff) obj;
        return Objects.equals(staff.getId(), getId());
    }

    @Override
    public String toString() {
        return "Staff [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address
                + ", email=" + email + ", dayOfBirth=" + dayOfBirth + ", username=" + username + ", password="
                + password + "]";
    }

}
