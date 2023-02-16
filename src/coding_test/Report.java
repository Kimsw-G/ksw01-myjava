package coding_test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Report {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        ReportSol s = new ReportSol();
        System.out.println(Arrays.toString(s.solution(id_list, report, k)));
    }
}

class ReportSol {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        AUser[] auser = new AUser[id_list.length];
        BUser[] buser = new BUser[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            auser[i] = new AUser();
            buser[i] = new BUser(k);
        }

        for (int i = 0; i < report.length; i++) {
            String[] reportData = report[i].split(" ");
            auser[getArrayIdx(id_list, reportData[0])].doReport(reportData[1]);
            buser[getArrayIdx(id_list, reportData[1])].doReported(reportData[0]); // buser에 신고한 사람 숫자 추가
        }

        for (int i = 0; i < id_list.length; i++) {
            Set<String> set = auser[i].reportList;
            Iterator<String> itr = set.iterator();
            while(itr.hasNext()){
                if(buser[getArrayIdx(id_list, itr.next())].isBan()) answer[i]++;
            }
        }

        

        return answer;
    }
    public int getArrayIdx(String[] id_list, String name){
        int idx = 0;
        for (int i = 0; i < id_list.length; i++) {
            if (id_list[i].equals(name)) {
                idx = i;
            }
        }
        return idx;
    }
}

class AUser{
    Set<String> reportList = new HashSet<>();

    public void doReport(String user){
        reportList.add(user);
    }
}

class BUser{ // BadUser 신고당한 유저들이다
    Set<String> reportedList = new HashSet<>();
    int k;

    public BUser(int k){
        this.k = k;
    }

    public void doReported(String user){
        reportedList.add(user);
    }
    public int getRepotUser(){
        return reportedList.size();
    }
    public boolean isBan(){ // 기준 k보다 신고한 유저가 많으면 true를 반환. 밴 된 상태
        return k<=reportedList.size();
    }
}