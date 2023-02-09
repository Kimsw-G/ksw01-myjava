package db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class MemberEntity {
    private int mno;
    
    private final String mname;
    private final String mid;
    private final String mpass;
    private final String mphone;
    private final String mgender;


}
