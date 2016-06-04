package com.xu.sayhi.fragment;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.TextUnderstander;
import com.iflytek.cloud.TextUnderstanderListener;
import com.iflytek.cloud.UnderstanderResult;
import com.xu.sayhi.R;
import com.xu.sayhi.bean.fkbean.MoreResults;
import com.xu.sayhi.bean.response.FkResponse;
import com.xu.sayhi.util.SpeechUtil;

/**
 * Created by wangxu on 2016/6/3.
 */
@SuppressLint("ValidFragment")
public class NomalSayCoFragment extends BaseSayCoFragment implements TextUnderstanderListener {
    private TextUnderstander mTextUnderstander;
    private boolean isBoring = false;
    private boolean isSaying = false;
    private int timeCount = 10;
    public static final int TO_BORING = 0x23;
    public static final int TO_SAYING = 0x24;
    private TextView text;
    private String allTexts;
    private String sayTexts;

    public NomalSayCoFragment(FkResponse fkResponse) {
        super(fkResponse);
    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case TO_BORING:
                    if (timeCount > 0) {
                        isBoring = false;
                        timeCount--;
                        handler.sendEmptyMessageDelayed(TO_BORING, 1000);
                    } else {
                        timeCount = 10;
                        isBoring = true;
                        sayCoBoring();
                    }
                    break;
                case TO_SAYING:
                    if (allTexts!=null&&allTexts.length() > 0) {
                        isBoring = false;
                        isSaying = true;
                        sayTexts = (sayTexts==null?"":sayTexts) + allTexts.substring(0,1);
                        allTexts = allTexts.substring(1, allTexts.length());
                        text.setText(sayTexts);
                        handler.sendEmptyMessageDelayed(TO_SAYING, 200);
                    } else {
                        isBoring = true;
                        isSaying = false;
                        handler.sendEmptyMessageDelayed(TO_BORING, 1000);
                        timeCount = 10;


                    }
                    break;
            }
        }
    };

    /**
     * 像sayCo发消息
     *
     * @param text
     */
    public void sayToSayCo(String text) {
        if (mTextUnderstander == null) {
            mTextUnderstander = TextUnderstander.createTextUnderstander(getActivity(), null);

        }
        mTextUnderstander.understandText(text, this);

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_sayco_nomal;
    }

    @Override
    public void initView(View view) {
        text=(TextView)view.findViewById(R.id.text);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        text.setVisibility(View.GONE);
        handler.sendEmptyMessageDelayed(TO_BORING, 1000);
    }

    @Override
    public void onResult(UnderstanderResult understanderResult) {
        Log.e("wangxu",understanderResult.getResultString());
        fkResponse=new Gson().fromJson(understanderResult.getResultString(),FkResponse.class);
        if (fkResponse.getAnswer() != null && fkResponse.getAnswer().getType().equals("T")) {
            allTexts=fkResponse.getAnswer().getText();
            saying();
            return;
        }
        if (fkResponse.getMoreResults() != null && fkResponse.getMoreResults().size() > 0) {
            for (MoreResults moreResults : fkResponse.getMoreResults()) {
                if (moreResults.getAnswer() != null && moreResults.getAnswer().getType().equals("T")) {
                    allTexts=moreResults.getAnswer().getText();
                    saying();
                    return;
                }
            }
        }
    }

    @Override
    public void onError(SpeechError speechError) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        SpeechUtil.stop();
    }

    public void sayCoBoring() {
        sayTexts="";
        text.setVisibility(View.VISIBLE);

        text.setText(sayTexts);
        sayToSayCo("讲个笑话");
    }

    public void saying() {
        isSaying = true;
        isBoring=false;
        handler.sendEmptyMessageDelayed(TO_SAYING, 500);
    }
}
