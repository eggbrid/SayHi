package com.xu.sayhi.bean.response;

import com.xu.sayhi.bean.fkbean.Answer;
import com.xu.sayhi.bean.fkbean.MoreResults;

import java.util.List;

/**
 * Created by wangxu on 2016/6/3.
 */
public class FkResponse extends BaseResponse{
    private String rc;//
    private String operation;//ANSWER
    private String service;//openQA
    private Answer answer;//ANSWER
    private String text;//哈哈哈
    private List<MoreResults> moreResults;

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<MoreResults> getMoreResults() {
        return moreResults;
    }

    public void setMoreResults(List<MoreResults> moreResults) {
        this.moreResults = moreResults;
    }
}
