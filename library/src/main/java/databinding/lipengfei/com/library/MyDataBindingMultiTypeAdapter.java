package databinding.lipengfei.com.library;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by lipengfei on 2017/6/23.
 */

public class MyDataBindingMultiTypeAdapter<D> extends RecyclerView.Adapter<MyDataBindingMultiTypeAdapter.ViewHolder> {

    //protected ArrayList<Pair<D, Pair<Integer, Integer>>> arrayList;//装载多布局的Type类型(R.layout),BR类型(variableId)
    protected ArrayList<D> dataList;//数据
    protected Map<Class<?>, Pair<Integer, Integer>> map;//装载多布局的Type类型(R.layout),BR类型(variableId)

    protected Context context;
    protected LayoutInflater layoutInflater;
    private ViewDataBinding binding;
    protected Presenter mPresenter;
    protected Decorator mDecorator;

    public interface Presenter {

    }

    public interface Decorator {
        void decorator(ViewHolder holder, int position, int viewType);
    }

    public MyDataBindingMultiTypeAdapter(ArrayList<D> dataList, Map<Class<?>, Pair<Integer, Integer>> map, Context context) {
        //this.list = list;
        this.dataList = dataList;
        this.map = map;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(context);
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        ViewHolder viewHolder = new ViewHolder(binding.getRoot());
        View view = binding.getRoot();
        viewHolder.setBinding(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        binding = holder.getBinding();
        binding.setVariable(map.get(dataList.get(position).getClass()).second,dataList.get(position));
        binding.executePendingBindings();
        if (mDecorator != null) {
            mDecorator.decorator(holder, position, getItemViewType(position));
        }
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    @Override
    public int getItemViewType(int position) {

        return map.get(dataList.get(position).getClass()).first;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding binding;

        public ViewDataBinding getBinding() {
            return binding;
        }

        public void setBinding(ViewDataBinding binding) {
            this.binding = binding;
        }

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public void addAll(Collection collection) {
        dataList.addAll(collection);
        notifyDataSetChanged();

    }

    public void add(int index,D d) {
        dataList.add(index, d);
        notifyDataSetChanged();
    }
    /**
     * 用于清空数据
     *
     * @param
     */
    public void clearListAll() {
        dataList.clear();
        //binding.executePendingBindings();
    }
    /**
     * 用于清楚某个数据
     *
     * @param
     */
    public void removeposition(int position) {
        dataList.remove(position);
        notifyDataSetChanged();
        //binding.executePendingBindings();
    }
    public void removeAllList(List<D> list) {
        dataList.removeAll(list);
        notifyDataSetChanged();
        //binding.executePendingBindings();
    }
    /**
     * 用于处理需要holder的view
     *
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
