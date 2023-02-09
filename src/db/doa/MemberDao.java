package db.doa;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.entity.MemberEntity;

public class MemberDao extends DBCon {
    
    public MemberEntity loginCheck(String id, String pass) throws SQLException{
        MemberEntity memberEntity = null;
        conn = conn();
        final String SQL = "select * from member where mid = ? and mpass = ?";
        pstmt = conn.prepareStatement(SQL);
        pstmt.setString(1, id);
        pstmt.setString(2, pass);
        rs = pstmt.executeQuery();
        if(rs.next()){
            int mno = rs.getInt("mno");
            String mname = rs.getString("mname");
            String mid = rs.getString("mid");
            String mpass = rs.getString("mpass");
            String mphone = rs.getString("mphone");
            String mgender = rs.getString("mgender");
            memberEntity = new MemberEntity(mno ,mname, mid, mpass, mphone, mgender);
        }

        return memberEntity;
    }

    public void join(MemberEntity memberEntity) throws SQLException{
        conn = conn();
        final String SQL = "Insert into member values (mno_seq.NEXTVAL,?,?,?,?,?)";
        pstmt = conn.prepareStatement(SQL);
        pstmt.setString(1, memberEntity.getMname());
        pstmt.setString(2, memberEntity.getMid());
        pstmt.setString(3, memberEntity.getMpass());
        pstmt.setString(4, memberEntity.getMphone());
        pstmt.setString(5, memberEntity.getMgender());
        pstmt.executeUpdate();
    }

    public List<MemberEntity> findAllMember(){
        List<MemberEntity> memberList = new ArrayList<>();
        try {
            conn = conn();
            final String SQL = "select * from member ";
            pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();
            while(rs.next()){
                int mno = rs.getInt("mno");
                String mname = rs.getString("mname");
                String mid = rs.getString("mid");
                String mpass = rs.getString("mpass");
                String mphone = rs.getString("mphone");
                String mgender = rs.getString("mgender");
                MemberEntity memberEntity = new MemberEntity(mno ,mname, mid, mpass, mphone, mgender);
                memberList.add(memberEntity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            closeDB();
        }
        return memberList;
    }
    public void deleteMember(int mno){
        try {
            conn = conn();
            final String SQL = "delete from member where mno = ?";
            pstmt = conn.prepareStatement(SQL);
            pstmt.executeUpdate(SQL);
            pstmt.setInt(1, mno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateMember(MemberEntity memberEntity){
        try {
            conn = conn();
            final String SQL = "update member set mpass=? where mno=?";
            pstmt = conn.prepareStatement(SQL);
            pstmt.executeUpdate(SQL);
            pstmt.setString(1, memberEntity.getMpass());
            pstmt.setInt(2, memberEntity.getMno());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            closeDB();
        }
    }

    public MemberEntity findMemberByMno(int mno){
        MemberEntity memberEntity = null;
        try {
            conn = conn();
            final String SQL = "select * from member where mno = ?";
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1,mno);
            rs = pstmt.executeQuery();
            if(rs.next()){
                String mname = rs.getString("mname");
                String mid = rs.getString("mid");
                String mpass = rs.getString("mpass");
                String mphone = rs.getString("mphone");
                String mgender = rs.getString("mgender");
                memberEntity = new MemberEntity(mno ,mname, mid, mpass, mphone, mgender);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return memberEntity;
    }
}
