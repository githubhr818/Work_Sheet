package com.school.software.oa.bean;

public class Dept {
    private String dno ;
    private String dname;
    private String dloc;

    public Dept() {
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dno='" + dno + '\'' +
                ", dname='" + dname + '\'' +
                ", dloc='" + dloc + '\'' +
                '}';
    }

    public String getDno() {
        return dno;
    }

    public void setDno(String dno) {
        this.dno = dno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDloc() {
        return dloc;
    }

    public void setDloc(String dloc) {
        this.dloc = dloc;
    }
}
