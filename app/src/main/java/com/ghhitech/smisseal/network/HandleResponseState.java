package com.ghhitech.smisseal.network;

import org.json.JSONException;
import org.json.JSONObject;

public class HandleResponseState {
    /**
 * 判断请求回来的json ，是否是请求成功的，请求成功返回true ，请求失败返回false
 * @param json
 * @return
 * @throws JSONException
 */
public  static boolean  doHandle(String  json)  {
    JSONObject jsonO= null;
    try {
        jsonO = new JSONObject(json);
    } catch (JSONException e) {
        e.printStackTrace();
    }
    String  rsp=  jsonO.optString("rsp");
    if ("succ".equals(rsp)) {
        return  true;
    }
    return false;
}
}
