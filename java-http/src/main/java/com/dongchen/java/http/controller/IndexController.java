package com.dongchen.java.http.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dongchen.java.dao.mapper.extend.TpDealTimeMapper;
import com.dongchen.java.util.common.HttpUtils;
import com.dongchen.java.util.common.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: mdd
 * @date:2017/12/7
 */
@RestController
public class IndexController {

    @Autowired
    private TpDealTimeMapper tpDealTimeMapper;

    @RequestMapping("/index")
    public String index() {
        Date date = tpDealTimeMapper.queryDealTime();
        return "2";
    }

    /**
     * 测试http调用
     *
     * @param
     * @return
     */
    @RequestMapping("/test/receiveMsg")
    public String testReceiveMsg() {
        Map<String, String> headers = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("cardNo", "1234");
        headers.put("Content-Type", "application/json; charset=UTF-8");
        JSONObject jsonObject = new JSONObject();
        try {
            HttpResponse httpResponse = HttpUtils.doPost("http://0.0.0.0:5201", "/test/receiveMsg", "POST", headers, new HashMap<String, String>()
                    , JSON.toJSONString(bodys));
            HttpEntity httpEntity = httpResponse.getEntity();
            if (null !=httpEntity){
                InputStream instreams = httpEntity.getContent();
                String str = StringUtils.convertStreamToString(instreams);
                jsonObject = JSONObject.parseObject(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toJSONString();
    }
}
