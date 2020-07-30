package com.xijue.uruleclient.controller;

import com.bstek.urule.Utils;
import com.bstek.urule.runtime.KnowledgePackage;
import com.bstek.urule.runtime.KnowledgeSession;
import com.bstek.urule.runtime.KnowledgeSessionFactory;
import com.bstek.urule.runtime.service.KnowledgeService;
import com.xijue.uruleclient.entity.RequestDto;
import com.xijue.uruleclient.entity.ResponseDto;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @RequestMapping("/rule")
    public String getRara(@RequestParam String data) throws IOException {
        KnowledgeService knowledgeService = (KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
        //参数，Urule项目名/知识包名
        KnowledgePackage knowledgePackage = knowledgeService.getKnowledge("urule-demo/test");
        KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);
        Integer integer = Integer.valueOf(data);
        Map<String, Object> param = new HashMap();
        //参数，var，传入参数，和参数库中定义一致
        param.put("var", integer);
        session.fireRules(param);
        //result，返回参数，和参数库中定义一致
        Integer result = (Integer) session.getParameter("result");
        return String.valueOf(result);
    }

    @RequestMapping(value = "/cal_sum_score", method = RequestMethod.POST)
    public ResponseDto calSumScore(@RequestBody RequestDto request) throws Exception {
        ResponseDto result = new ResponseDto();
        if (!CollectionUtils.isEmpty(request.getLists())) {
            KnowledgeService knowledgeService = (KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
            //参数，Urule项目名/知识包名
            KnowledgePackage knowledgePackage = knowledgeService.getKnowledge("urule-demo/framework");
            KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);
//            List<Framework> lists = request.getLists();
//            Map<String, Object> param = new HashMap();
//            参数，var，传入参数，和参数库中定义一致
//            param.put("request", request);
//            session.fireRules(param);
            session.insert(request);
            session.fireRules();
            String sumScore = (String) session.getParameter("sumScore");

            result.setSumScore(sumScore);
            return result;
        }
        return result;
    }
}