package com.xu.sayhi.fragment;

import com.xu.sayhi.bean.response.FkResponse;

/**
 * Created by wangxu on 2016/6/3.
 */
public abstract class BaseSayCoFragment extends BaseFragment {
    public FkResponse fkResponse;

    public BaseSayCoFragment(FkResponse fkResponse) {
        this.fkResponse = fkResponse;
    }

}
