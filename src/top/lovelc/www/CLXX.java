package top.lovelc.www;
//车辆信息的类
public class CLXX {

    private String vno;//车牌号
    private String vcolour;//颜色
    private String vmodel;//模型
    private String vtype;//车型
    private String vquality;//载重
    private String id;

    public CLXX(String vno, String vcolour, String vmodel, String vtype, String vquality, String id) {
        this.vno = vno;
        this.vcolour = vcolour;
        this.vmodel = vmodel;
        this.vtype = vtype;
        this.vquality = vquality;
        this.id = id;
    }

    @Override
    public String toString() {
        return "CLXX{" +
                "vno='" + vno + '\'' +
                ", vcolour='" + vcolour + '\'' +
                ", vmodel='" + vmodel + '\'' +
                ", vtype='" + vtype + '\'' +
                ", vquality='" + vquality + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public void setVno(String vno) {
        this.vno = vno;
    }

    public void setVcolour(String vcolour) {
        this.vcolour = vcolour;
    }

    public void setVmodel(String vmodel) {
        this.vmodel = vmodel;
    }

    public void setVtype(String vtype) {
        this.vtype = vtype;
    }

    public void setVquality(String vquality) {
        this.vquality = vquality;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVno() {
        return vno;
    }

    public String getVcolour() {
        return vcolour;
    }

    public String getVmodel() {
        return vmodel;
    }

    public String getVtype() {
        return vtype;
    }

    public String getVquality() {
        return vquality;
    }

    public String getId() {
        return id;
    }
}
