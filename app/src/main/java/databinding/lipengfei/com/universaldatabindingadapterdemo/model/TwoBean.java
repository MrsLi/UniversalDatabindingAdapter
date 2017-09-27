package databinding.lipengfei.com.universaldatabindingadapterdemo.model;

/**
 * Created by a1 on 2017/8/22.
 */

public class TwoBean extends MultiBaseBeanTest{
    private String name;
    private String aihao;

    public TwoBean(String name, String aihao) {
        this.name = name;
        this.aihao = aihao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAihao() {
        return aihao;
    }

    public void setAihao(String aihao) {
        this.aihao = aihao;
    }
}
