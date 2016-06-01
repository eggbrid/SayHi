package com.xu.sayhi.activity.help;

import android.widget.TextView;

import com.xu.sayhi.R;
import com.xu.sayhi.activity.BaseActivity;
import com.xu.sayhi.bean.tobean.HelpToBean;
import com.xu.sayhi.openactivity.HelperOpen;

/**
 * Created by wangxu on 2016/6/1.
 */
public class HelpActivity extends BaseActivity{
    private HelpToBean helpToBean;
    private TextView content;
    @Override
    public int getLayoutID() {
        return R.layout.activity_help;
    }

    @Override
    public void initView() {
        initTitleBack(helpToBean.getTitle());
        content=(TextView)findViewById(R.id.content);
    }

    @Override
    public void initData() {
        content.setText(helpToBean.getTitle());
    }

    @Override
    public void readyInit() {
        helpToBean=(HelpToBean)getBaseToBean();

    }

    @Override
    public String getOpenBean() {
        return HelperOpen.Key;
    }
}
