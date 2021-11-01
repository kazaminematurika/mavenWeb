package Weed9_Test2_Listener_StuBean;

import Weed9_Test2_MySQL.AccessDB;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class StuBean implements HttpSessionBindingListener {

    @Override
    public String toString() {
        return "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Chinese=" + Chinese +
                ", Math=" + Math +
                ", English=" + English;
    }

    private int ID;
    private String Name;
    private int Chinese;
    private int Math;
    private int English;

    public StuBean(int setID){
        setID(setID);
    }

    public StuBean(int setID, String setName, int setChinese, int setMath, int setEnglish){
        setID(setID);
        setName(setName);
        setChinese(setChinese);
        setMath(setMath);
        setEnglish(setEnglish);
    }

    public String getName() {
        return Name;
    }

    public void setName(String setName) {
        Name = setName;
    }

    public int getChinese() {
        return Chinese;
    }

    public void setChinese(int setChinese) {
        Chinese = setChinese;
    }

    public int getMath() {
        return Math;
    }

    public void setMath(int setMath) {
        Math = setMath;
    }

    public int getEnglish() {
        return English;
    }

    public void setEnglish(int setEnglish) {
        English = setEnglish;
    }

    public int getID() {
        return ID;
    }

    public void setID(int setID) {
        ID = setID;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("对象正在被绑定在Http会话中。。。");
        AccessDB accessDB = new AccessDB(ID);
        StuBean stuBean = accessDB.selectDBByid();
        Name = stuBean.getName();
        ID = stuBean.getID();
        Chinese = stuBean.getChinese();
        Math = stuBean.getMath();
        English = stuBean.getEnglish();
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("从被绑定的会话中删除对象");
        AccessDB accessDB = new AccessDB(ID);
        System.out.println(accessDB.updateDB(Math));
    }
}
