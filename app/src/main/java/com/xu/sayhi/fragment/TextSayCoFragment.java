package com.xu.sayhi.fragment;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xu.sayhi.R;
import com.xu.sayhi.bean.fkbean.MoreResults;
import com.xu.sayhi.bean.response.FkResponse;

/**
 * Created by wangxu on 2016/6/3.
 */
@SuppressLint("ValidFragment")
public class TextSayCoFragment extends BaseSayCoFragment {
    private TextView text;

    public TextSayCoFragment(FkResponse fkResponse) {
        super(fkResponse);
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_sayco_text;
    }

    @Override
    public void initView(View view) {
        text = (TextView) view.findViewById(R.id.text);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        if (fkResponse.getAnswer() != null && fkResponse.getAnswer().getType().equals("T")) {
            text.setText(fkResponse.getAnswer().getText());
            return;
        }
        if (fkResponse.getMoreResults()!=null&&fkResponse.getMoreResults().size() > 0) {
            for (MoreResults moreResults : fkResponse.getMoreResults()) {
                if (moreResults.getAnswer() != null && moreResults.getAnswer().getType().equals("T")) {
                    text.setText(moreResults.getAnswer().getText());
                    return;
                }
            }
        }

        Toast.makeText(getActivity(),"手机在玩，懒得理你", Toast.LENGTH_SHORT).show();
    }
}
