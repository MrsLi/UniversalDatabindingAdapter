package databinding.lipengfei.com.universaldatabindingadapterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import databinding.lipengfei.com.library.MyDataBindingMultiTypeAdapter;
import databinding.lipengfei.com.universaldatabindingadapterdemo.model.MultiBaseBeanTest;
import databinding.lipengfei.com.universaldatabindingadapterdemo.model.OneBean;
import databinding.lipengfei.com.universaldatabindingadapterdemo.model.TwoBean;

public class MainActivity extends AppCompatActivity {
    private RecyclerView RcView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RcView = (RecyclerView) findViewById(R.id.RcView);
        ArrayList<OneBean> oneBeenList = new ArrayList<>();
        ArrayList<TwoBean> twoBeanList = new ArrayList<>();

        ArrayList<MultiBaseBeanTest> dataList = new ArrayList<>();

        Map<Class<?>, Pair<Integer, Integer>> classMapPair = new HashMap<>();
        classMapPair.put(OneBean.class,new Pair(R.layout.multi_type_one_test,BR.oneBean));
        classMapPair.put(TwoBean.class,new Pair(R.layout.multi_type_two_test,BR.twoBean));
        //假数据
        for (int i = 0; i < 2; i++) {
            oneBeenList.add(new OneBean("男"));
        }

        for (int i = 0; i < 5; i++) {
            twoBeanList.add(new TwoBean("li", "lanqiu"));
        }


        MyDataBindingMultiTypeAdapter<MultiBaseBeanTest> multiBaseBeanTestMyDataBindingMultiTypeAdapter =
                new MyDataBindingMultiTypeAdapter<>(dataList, classMapPair, this);
        RcView.setAdapter(multiBaseBeanTestMyDataBindingMultiTypeAdapter);
        multiBaseBeanTestMyDataBindingMultiTypeAdapter.addAll(oneBeenList);
        multiBaseBeanTestMyDataBindingMultiTypeAdapter.addAll(twoBeanList);
    }
}
