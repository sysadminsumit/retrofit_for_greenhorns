package com.retrofitparsing.retrofit.exception;


import com.retrofitparsing.R;
import com.retrofitparsing.utils.ResourceUtils;

public class UnknownError extends BaseException {

    public UnknownError(){
        cause = ResourceUtils.instance().getString(R.string.alert_unknown_error);
        suggestion = ResourceUtils.instance().getString(R.string.alert_common_suggestion);
    }
}
