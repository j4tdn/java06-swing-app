/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson18_exercise_02;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SMILE ^^
 */
public class Team {

    private String name;
    private List<Member> team;

    public Team() {
        team= new ArrayList<>();
    }

    public Team(String name, List<Member> team) {
        this.name = name;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getTeam() {
        return team;
    }

    public void setTeam(String dir, String[] fileNameOfMembers) {
        for (String pathOfTeam : fileNameOfMembers) {
            String nameOfMember = pathOfTeam.substring(0, pathOfTeam.lastIndexOf("."));
            Member member = new Member(nameOfMember, dir + File.separator + pathOfTeam);
            this.team.add(member);
        }
    }

    public static Team Team(String name, String dir, String[] paths) {
        Team temp = new Team();
        temp.setName(name);
        temp.setTeam(dir, paths);
        return temp;
    }
}
