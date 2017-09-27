package databinding.lipengfei.com.library;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.Collection;
import java.util.List;

/**
 * Created by a1 on 2017/7/5.
 * 用于DataBinding  for ListView
 */

public class MyDataBindingAdapterForListView<D>  extends BaseAdapter{
    private List<D> list;
    private Context context;
    private int layoutId;
    private int variableId;
    protected Presenter mPresenter;
    protected Decorator mDecorator;

    public interface Presenter {

    }

    public interface Decorator {
        void decorator(int position, View convertView, ViewGroup parent);
    }

    public MyDataBindingAdapterForListView(List<D> list, Context context, int layoutId, int variableId) {
        this.list = list;
        this.context = context;
        this.layoutId = layoutId;
        this.variableId = variableId;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public D getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = DataBindingUtil.inflate(LayoutInflater.from(context),layoutId,parent,false).getRoot();

        }
        ViewDataBinding binding = DataBindingUtil.getBinding(convertView);
        binding.setVariable(variableId,list.get(position));
        if (mDecorator != null) {
            mDecorator.decorator(position, convertView, parent);
        }
        return convertView;
    }

    public void addAll(Collection<? extends D> collection){
        list.addAll(collection);
        notifyDataSetChanged();
    }
    /**
     * 用于更新数据
     *
     * @param list
     */
    public void setListAll(List<D> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
        //binding.executePendingBindings();
    }

    /**
     * 用于清空数据
     *
     * @param
     */
    public void clearListAll() {
        this.list.clear();
        //binding.executePendingBindings();
    }
    /**
     * 用于清楚某个数据
     *
     * @param
     */
    public void removeposition(int position) {
        this.list.remove(position);
        notifyDataSetChanged();
        //binding.executePendingBindings();
    }
    public void removeAllList(List<D> list) {
        this.list.removeAll(list);
        notifyDataSetChanged();
        //binding.executePendingBindings();
    }
    /**
     * 用于处理需要holder的view
     * @param decorator
     */
    public void setDecorator(Decorator decorator) {
        mDecorator = decorator;
    }

    public void setPresenter(Presenter presenter) {
        mPresenter = presenter;
    }
    protected Presenter getPresenter() {
        return mPresenter;
    }
}
