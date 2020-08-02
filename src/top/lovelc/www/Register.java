package top.lovelc.www;

public class Register {

    private String id;//工号
    private String name;//姓名
    private String type;//类型
    private String password;//密码

    public Register(String id, String name, String type, String password) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
