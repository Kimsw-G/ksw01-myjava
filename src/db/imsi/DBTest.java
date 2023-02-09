package db.imsi;

import db.doa.DBCon;
import db.entity.MemberEntity;

public class DBTest {
    public static void main(String[] args) {
        DBCon dbCon = new DBCon();

        try {
            dbCon.conn();
            System.out.println("해ㅐㅇ");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            dbCon.closeDB();
        }
        
    }
}
