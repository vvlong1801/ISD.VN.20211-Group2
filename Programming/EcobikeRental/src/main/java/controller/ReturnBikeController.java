package controller;

public class ReturnBikeController extends BaseController {
    public boolean validateDockName(String dockName){
        if(dockName == null) return false;
        String exp = "^[a-zA-Z][a-zA-Z\\s]{0,}$";
        return dockName.matches(exp);
    }
}
