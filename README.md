# UniversalDatabindingAdapter
DataBinding与RecyclerView ListView结合的万能适配器

使用说明:
1.单布局的使用:
话不多说,反手就是代码,下面举一个栗子:

XML文件:item.xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>
        <import type="android.view.View"/>
        <variable
            name="findGoodsModelTest"
            type="com.jmhshop.logisticsCar.model.FindGoodsModelTest"/>
    </data>
    <android.support.constraint.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <TextView

            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            tools:text="出发地"
            android:text="@{findGoodsModelTest.placeFirst}"
            android:textSize="@dimen/sp_15"
            android:textColor="@color/color_FF051832"
            app:layout_constraintTop_toTopOf="parent"
            android:layout_marginTop="4dp"
            android:layout_marginLeft="10dp"
            app:layout_constraintLeft_toLeftOf="parent"
            android:layout_marginStart="10dp" />

        <ImageView
            android:id="@+id/imageView2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@mipmap/icon_point_big"
            app:layout_constraintLeft_toRightOf="@+id/textView"
            android:layout_marginLeft="3dp"
            app:layout_constraintTop_toTopOf="@+id/textView"
            app:layout_constraintBottom_toBottomOf="@+id/textView"
            android:layout_marginStart="3dp" />

        <TextView
            android:id="@+id/textView2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            tools:text="目的地"
            android:text="@{findGoodsModelTest.placeEnd}"
            android:textSize="@dimen/sp_15"
            android:textColor="@color/color_FF051832"
            app:layout_constraintTop_toTopOf="@+id/textView"
            app:layout_constraintBottom_toBottomOf="@+id/textView"
            app:layout_constraintVertical_bias="0.0"
            app:layout_constraintLeft_toRightOf="@+id/imageView2"
            android:layout_marginLeft="3dp"
            android:layout_marginStart="3dp" />

        <TextView
            android:id="@+id/textView3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            tools:text="时间"
            android:text="@{findGoodsModelTest.time}"
            android:textColor="@color/color_FF999999"
            android:textSize="@dimen/sp_13"
            android:layout_marginRight="25dp"
            app:layout_constraintRight_toRightOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            android:layout_marginTop="6dp"
            android:layout_marginEnd="25dp" />

        <TextView
            android:text="@{findGoodsModelTest.type}"
            android:id="@+id/textView4"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            tools:text="13米 高低板/34吨 重货"
            android:textColor="@color/color_FF051832"
            android:textSize="@dimen/sp_14"
            app:layout_constraintLeft_toLeftOf="@+id/textView"
            android:layout_marginTop="5dp"
            app:layout_constraintTop_toBottomOf="@+id/textView" />

        <ImageView
            android:id="@+id/imageView3"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:scaleType="fitXY"
            android:src="@drawable/ic_launcher"
            app:layout_constraintLeft_toLeftOf="@+id/textView"
            android:layout_marginTop="8dp"
            app:layout_constraintTop_toBottomOf="@+id/textView4" />

        <TextView
            android:id="@+id/textView5"
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            tools:text="河北聚民惠有限责任公司"
            android:text="@{findGoodsModelTest.name}"
            android:singleLine="true"
            android:ellipsize="end"
            android:textColor="@color/color_FF606060"
            android:textSize="14sp"
            app:layout_constraintLeft_toRightOf="@+id/imageView3"
            android:layout_marginLeft="8dp"
            android:layout_marginTop="12dp"
            app:layout_constraintTop_toBottomOf="@+id/textView4"
            android:layout_marginStart="8dp" />

        <ImageView
            android:id="@+id/imageView4"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@mipmap/icon_renzheng"
            app:layout_constraintLeft_toRightOf="@+id/textView5"
            android:layout_marginLeft="4dp"
            android:visibility="@{findGoodsModelTest.IDAuth==true?View.VISIBLE:View.GONE}"
            app:layout_constraintTop_toTopOf="@+id/textView5"
            app:layout_constraintBottom_toBottomOf="@+id/textView5"
            android:layout_marginStart="4dp" />

        <ImageView
            android:visibility="@{findGoodsModelTest.IDAuth==true?View.VISIBLE:View.GONE}"
            android:id="@+id/imageView5"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@mipmap/icon_companyrz"
            app:layout_constraintTop_toTopOf="@+id/imageView4"
            app:layout_constraintBottom_toBottomOf="@+id/imageView4"
            app:layout_constraintLeft_toRightOf="@+id/imageView4"
            android:layout_marginLeft="5dp"
            android:layout_marginStart="5dp" />

        <TextView
            android:id="@+id/textView6"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            tools:text="交易:"
            android:text="@{`交易:`+findGoodsModelTest.jiaoyiNum}"
            android:textColor="@color/color_FF606060"
            android:textSize="@dimen/sp_13"
            app:layout_constraintLeft_toLeftOf="@+id/textView5"
            android:layout_marginTop="5dp"
            app:layout_constraintTop_toBottomOf="@+id/textView5" />

        <TextView
            android:id="@+id/textView7"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            tools:text="发货:"
            android:text="@{`发货:`+findGoodsModelTest.sendGoodsNum}"
            android:textColor="@color/color_FF606060"
            android:textSize="@dimen/sp_13"
            app:layout_constraintBottom_toBottomOf="@+id/textView6"
            app:layout_constraintLeft_toRightOf="@+id/textView6"
            android:layout_marginLeft="20dp"
            app:layout_constraintTop_toTopOf="@+id/textView6"
            android:layout_marginStart="20dp" />

        <ImageView
            android:id="@+id/call_phone"
            android:layout_width="24dp"
            android:layout_height="23dp"
            android:src="@mipmap/icon_tel"
            android:layout_marginRight="20dp"
            app:layout_constraintRight_toRightOf="parent"
            android:layout_marginTop="18dp"
            app:layout_constraintTop_toBottomOf="@+id/textView3"
            android:layout_marginEnd="20dp" />
        <View
            android:layout_width="wrap_content"
            android:layout_height="1dp"
            android:background="@color/color_cccccccc"
            android:layout_marginRight="0dp"
            app:layout_constraintRight_toRightOf="parent"
            android:layout_marginLeft="0dp"
            app:layout_constraintLeft_toLeftOf="parent"
            app:layout_constraintBottom_toBottomOf="parent"
            android:layout_marginBottom="0dp"
            android:layout_marginTop="8dp"
            app:layout_constraintTop_toBottomOf="@+id/imageView3" />
    </android.support.constraint.ConstraintLayout>

</layout>

代码中使用:Fragment or Activity

        findGoodsModelTestListData = new ArrayList<>();
        findGoodsModelTestMyDataBindingAdapter = new MyDataBindingAdapter<>(findGoodsModelTestListData, R.layout.item_find_goods, BR.findGoodsModelTest, getActivity());
        findGoodsModelTestMyDataBindingAdapter.setDecorator(new FindGoodsDecorator());
        recyclerview.setAdapter(findGoodsModelTestMyDataBindingAdapter);
        
FindGoodsDecorator.class(为了使用数据方面,可以直接写在Acitivity或Fragment中)的作用是:回调,以便处理item的点击事件等,下面请看栗子

 private class FindGoodsDecorator implements MyDataBindingAdapter.Decorator{

        @Override
        public void decorator(MyDataBindingAdapter.ViewHolder holder, int position, int viewType) {
            ViewDataBinding binding = holder.getBinding();
            View view = binding.getRoot();
            //在这里处理自己的item事件
           view.setOnClickListener(v->{
               startActivity(new Intent(getActivity(), NewOrderDetailActivity.class));
           });
        }
    }
2.多布局的使用:
  多布局的使用demo app中有栗子,可以直接参考(栗子写的有点粗糙,但是它的使用方法表达的还算清晰)
  喜欢的猿们,star一下吧!
  
二 使用方式:
Step 1. 添加JitPack代码库地址

allprojects {
        repositories {
	
            maven { url 'https://jitpack.io' }
        }
    }

Step 2.添加依赖


	dependencies {
	        compile 'com.github.MrsLi:UniversalDatabindingAdapter:v1.0'
	}

