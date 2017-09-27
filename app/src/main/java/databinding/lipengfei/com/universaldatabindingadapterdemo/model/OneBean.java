package databinding.lipengfei.com.universaldatabindingadapterdemo.model;

/**
 * Created by a1 on 2017/8/22.
 */

public class OneBean extends MultiBaseBeanTest {
    private String sex;

    public OneBean(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
