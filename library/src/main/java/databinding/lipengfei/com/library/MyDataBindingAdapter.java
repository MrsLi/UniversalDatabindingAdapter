package databinding.lipengfei.com.library;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by lipengfei on 2017/6/23.
 */

public class MyDataBindingAdapter<D> extends RecyclerView.Adapter<MyDataBindingAdapter.ViewHolder>{
    protected List<D> list;
    protected int layoutItemId;
    protected int variableId;
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

    public MyDataBindingAdapter(List<D> list, int layoutItemId, int variableId, Context context) {
        this.list = list;
        this.layoutItemId = layoutItemId;
        this.variableId = variableId;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(context);
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, layoutItemId, parent, false);
        ViewHolder viewHolder = new ViewHolder(binding.getRoot());
        View view = binding.getRoot();
        viewHolder.setBinding(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        binding = holder.getBinding();
        binding.setVariable(variableId, list.get(position));
        binding.executePendingBindings();
        if (mDecorator != null) {
            mDecorator.decorator(holder, position, getItemViewType(position));
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
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
