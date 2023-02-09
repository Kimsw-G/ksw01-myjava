package db.controller;

import db.entity.MemberEntity;
import db.view.JoinForm;
import db.view.ListForm;
import db.view.MainForm;
import db.view.UpdateForm;
import db.view.LoginForm;

public class MainController {
    private static MainController controller = null;

    private MainController() {
    }

    public static MainController getInstance() {
        if (controller == null)
            return new MainController();
        else
            return controller;
    }

    private MemberEntity session;

    public MemberEntity getSession() {
        return session;
    }

    public static void main(String[] args) {
        MainController.getInstance().getController("Main");
    }

    public void  getController(String cmd) {
        getController(cmd, 0);
    }
    public void getController(String cmd,int mno){
        switch (cmd) {
            case "Main":
                // System.out.println("goMain");
                new MainForm();
                break;
            case "Login":
                // System.out.println("goLogin");
                new LoginForm();
                break;
            case "Join":
                // System.out.println("goJoin");
                new JoinForm();
                break;
            case "List":
                new ListForm();
                break;
            case "Update":
                new UpdateForm(mno);
                break;
            case "Delete":
            default:
                break;
        }
    }
}
