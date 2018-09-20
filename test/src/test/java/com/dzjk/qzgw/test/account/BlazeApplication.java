package com.dzjk.qzgw.test.account;


//import com.risk.common.utils.XMLtoJSON;
//import j.m.XMap;

import com.alibaba.fastjson.JSON;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by wxn on 2018/5/26
 */
public class BlazeApplication {

    //定义blaze 参数模型 xml 节点名称
    public static final String APPLICATION = "Application";
    public static final String INPUTOBJECT = "InputObject";
//
    public static final String DECISION_AREA = "@DecisionArea";
    public static final String SOURCE_CODE = "@SourceCode";

    public static final String CALL_NODE = "@CallNode";
    public static final String NODE_STATUS = "@NodeStatus";
    public static final String REQUEST_UUID = "@RequestUUID";
    public static final String IS_AUTH = "@IS_AUTH";


    public static final String DECISION_AREAVALUE = "RISK";
    public static final String MZ_DB = "MZ_DB";

    public static final String NODE_STATUS_PARAM = "0";
    public static final String NODE_STATUS_GATHERPARAM = "1";
    public static final String NODE_STATUS_RESULT = "2";


   public static final String BLAZE_PARAM_HEAD = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
           "\n" +
           "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pac=\"http://package.name.in.reverse.order\">  \n" +
           "  <soapenv:Header/>  \n" +
           "  <soapenv:Body> \n" +
           "    <pac:invokeExternalMain> \n" +
           "      <arg0> <![CDATA[";


    public static final String BLAZE_PARAM_TAIL = "]]> </arg0> \n" +
            "    </pac:invokeExternalMain> \n" +
            "  </soapenv:Body> \n" +
            "</soapenv:Envelope>";


    public static final String BLAZE_DCIN_HEAD= "<?xml version='1.0' encoding='UTF-8'?><S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\"><S:Body><ns2:invokeExternalMainResponse xmlns:ns2=\"http://package.name.in.reverse.order\"><return>";
    public static final String BLAZE_DCIN_TAIL= "</return></ns2:invokeExternalMainResponse></S:Body></S:Envelope>";


    static String ADD_URL = "http://139.224.146.220:60010/dazhijinke/EDMRuleServiceService";
/*    public static void main(String[] args) {
        Map application = new HashMap();
        Map map2 = new HashMap();
//        map2.put(BlazeApplication.DECISION_AREA,BlazeApplication.DECISION_AREAVALUE);
//        map2.put(BlazeApplication.SOURCE_CODE,"MZJK");
//        map2.put(BlazeApplication.CALL_NODE,"1");
//        map2.put(BlazeApplication.NODE_STATUS,"0");
        map2.put("@DecisionArea","RISK");
        map2.put("@SourceCode","A02");
        Map map1 = new HashMap();
        map1.put("@age","70");
        map1.put("@loanInner","6000");
        map2.put("cusInfo",map1);

        application.put(BlazeApplication.APPLICATION,map2);
        String Str="{\"Application\":{\"@DecisionArea\":\"RISK\",\"cusInfo\":{\"@age\":\"70\",\"@loanInner\":\"6000\"},\"@SourceCode\":\"A02\"}}";
//        String Str="{\"Application\":{\"@DecisionArea\":\"RISK\",\"cusInfo\":{\"@age\":\"70\",\"@loanInner\":\"6000\"},\"@SourceCode\":\"A02\"}}";
//        System.out.println(application.toPrettyXML());
        String param = XMLtoJSON.json2Xml(JSONObject.fromObject(Str),"root");
//       System.out.println(JSONObject.fromObject(application).toString());
        System.out.println(param);
        param = param.substring(6,param.length()-7);
        StringBuilder blazeParam = new StringBuilder();
        blazeParam
                .append(BlazeApplication.BLAZE_PARAM_HEAD)
                .append(param)
                .append(BlazeApplication.BLAZE_PARAM_TAIL);
        System.out.println(blazeParam.toString());


        HttpPost httpPost = new HttpPost(ADD_URL);


        HttpClient httpClient = new DefaultHttpClient();
        httpPost.setHeader(HTTP.CONTENT_TYPE, "text/xml");
        String jsonstr = blazeParam.toString();
        StringEntity se = null;
        try {
            se = new StringEntity(jsonstr);

        se.setContentType("text/xml");
        se.setContentEncoding("UTF-8");
        httpPost.setEntity(se);

        HttpResponse response = httpClient.execute(httpPost);

        //输出调用结果
        if (response != null && response.getStatusLine().getStatusCode() == 200) {
            String result = EntityUtils.toString(response.getEntity());
            // 生成 JSON 对象
            com.alibaba.fastjson.JSONObject obj = com.alibaba.fastjson.JSONObject.parseObject(result);
            System.out.print("result:"+result);
        }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }*/


    public static void main(String[] args) {
  /*      String result = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "\n" +
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pac=\"http://package.name.in.reverse.order\">  \n" +
                "  <soapenv:Header/>  \n" +
                "  <soapenv:Body> \n" +
                "    <pac:invokeExternalMain> \n" +
                "      <!--Optional:-->  \n" +
                "      <arg0> <![CDATA[<Application DecisionArea=\"RISK\" SourceCode=\"QD0200A001\" SPID=\"\" ApplicationID=\"\" CallNode=\"\" StrategyRandomDigit1=\"-99999\" StrategyRandomDigit2=\"-99999\" StrategyRandomDigit3=\"-99999\" StrategyRandomDigit4=\"-99999\">\n" +
                "     \t\n" +
                "<InputObject>\n" +
                "        <MZ_DB DB_BAS_NAME=\"5000\" DB_BAS_ID_NUM=\"220591198802021234\"></MZ_DB>\n" +
                "        <AF_TD EX_AF_TD_SCORE=\"50\" EX_AF_TD_7D_PLATEFORM_CNT=\"1\"></AF_TD>\n" +
                "    </InputObject>  \n" +
                " </Application>]]> </arg0> \n" +
                "    </pac:invokeExternalMain> \n" +
                "  </soapenv:Body> \n" +
                "</soapenv:Envelope>";*/
  String right="<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
          "   <S:Body>\n" +
          "      <ns2:invokeExternalMainResponse xmlns:ns2=\"http://package.name.in.reverse.order\">\n" +
          "         <return><![CDATA[<Application DecisionArea=\"RISK\" SourceCode=\"A02\">\n" +
          "\n" +
          "         \t\t<cusInfo age=\"50\" loanInner=\"6000\"></cusInfo>\n" +
          "  <DecisionResponse>\n" +
          "\t\t<RuleDecision Index=\"1\" ReasonCode=\"RJ9005\" RuleCode=\"BLD_mutiLend\" RuleDecisionResult=\"RJ\" RuleName=\"多头借贷限制\" RuleSeverityLevel=\"0\" RuleTriggerReason=\"多头借贷超限\" RulesetCode=\"BLD_zhunru\" RulesetName=\"白领贷准入\"></RuleDecision>\n" +
          "\t\t<RuleDecision Index=\"2\" ReasonCode=\"RJ9004\" RuleCode=\"BLD_edu\" RuleDecisionResult=\"RJ\" RuleName=\"学历限制\" RuleSeverityLevel=\"0\" RuleTriggerReason=\"学历不达标\" RulesetCode=\"BLD_zhunru\" RulesetName=\"白领贷准入\"></RuleDecision>\n" +
          "\t\t<RuleDecision Index=\"3\" ReasonCode=\"RJ9003\" RuleCode=\"BLD_periodLimite\" RuleDecisionResult=\"RJ\" RuleName=\"审贷期数限制\" RuleSeverityLevel=\"0\" RuleTriggerReason=\"审贷期数不符合\" RulesetCode=\"BLD_zhunru\" RulesetName=\"白领贷准入\"></RuleDecision>\n" +
          "\t\t<RuleDecision Index=\"4\" ReasonCode=\"RJ9002\" RuleCode=\"BLD_loanLimite\" RuleDecisionResult=\"RJ\" RuleName=\"审贷金额限制\" RuleSeverityLevel=\"0\" RuleTriggerReason=\"申请金额超过单次审贷金额限制\" RulesetCode=\"BLD_zhunru\" RulesetName=\"白领贷准入\"></RuleDecision>\n" +
          "\t\t\n" +
          "\t</DecisionResponse>\n" +
          "\t\n" +
          "\t\n" +
          "\t<ProcessingHistory DecisionArea=\"RISK\" ElapsedMillis=\"62\" StartTimestamp=\"2018-06-13T15:54:05.755\" StopTimestamp=\"2018-06-13T15:54:05.817\">\n" +
          "\t\t<DecisionFlowHistory FlowName=\"白领贷决策流\">\n" +
          "\t\t\t<DecisionFlowStepHistory ImplementationName=\"白领贷准入\" ImplementationType=\"规则集\" StepIndex=\"1\">\n" +
          "\t\t\t\t<RulesetHistory RulesetCode=\"BLD_zhunru\" RulesetName=\"白领贷准入\">\n" +
          "\t\t\t\t\t<RuleHistory RuleCode=\"BLD_mutiLend\" RuleName=\"多头借贷限制\"></RuleHistory>\n" +
          "\t\t\t\t\t<RuleHistory RuleCode=\"BLD_edu\" RuleName=\"学历限制\"></RuleHistory>\n" +
          "\t\t\t\t\t<RuleHistory RuleCode=\"BLD_periodLimite\" RuleName=\"审贷期数限制\"></RuleHistory>\n" +
          "\t\t\t\t\t<RuleHistory RuleCode=\"BLD_loanLimite\" RuleName=\"审贷金额限制\"></RuleHistory>\n" +
          "\t\t\t\t</RulesetHistory>\n" +
          "\t\t\t</DecisionFlowStepHistory>\n" +
          "\t\t\t<DecisionFlowStepHistory ImplementationName=\"初审授信\" ImplementationType=\"评分卡\" StepIndex=\"2\"></DecisionFlowStepHistory>\n" +
          "\t\t</DecisionFlowHistory>\n" +
          "\t\t<DerivedVariableHistory FlowName=\"白领贷决策流\">\n" +
          "\t\t\t<PropertyHistory DataType=\"string\" ImplementationName=\"初始值\" ImplementationType=\"衍生变量集\" Index=\"1\" Name=\"衍生变量集's 最高优先级\" Value=\"9\"></PropertyHistory>\n" +
          "\t\t</DerivedVariableHistory>\n" +
          "\t</ProcessingHistory><MessageList StatusCode=\"1\" StatusDescription=\"Successful\"></MessageList></Application>]]></return></ns2:invokeExternalMainResponse>\n" +
          "   </S:Body>\n" +
          "</S:Envelope>";
  String aaa = "<?xml version='1.0' encoding='UTF-8'?><S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
          "<S:Body>\n" +
          "\t\t<ns2:invokeExternalMainResponse xmlns:ns2=\"http://package.name.in.reverse.order\">\n" +
          "\t\t<return><![CDATA[<Application DecisionArea=\"RISK\" SourceCode=\"A02\">\n" +
          "\t<cusInfo age=\"70\" loanInner=\"6000\"></cusInfo>\n" +
          "\t<DecisionResponse>\n" +
          "\t\t<RuleDecision Index=\"1\" ReasonCode=\"RJ9002\" RuleCode=\"BLD_AGE_ZHUNRU\" RuleDecisionResult=\"RJ\" RuleName=\"年龄准入\" RuleSeverityLevel=\"0\" RuleTriggerReason=\"年龄超限\" RulesetCode=\"BLD_ZHUNRU\" RulesetName=\"白领贷准入规则集\"></RuleDecision>\n" +
          "\t\t<RuleDecision Index=\"2\" ReasonCode=\"RJ9001\" RuleCode=\"BLD_SALARY_ZHUNRU\" RuleDecisionResult=\"RJ\" RuleName=\"贷款总额超限\" RuleSeverityLevel=\"0\" RuleTriggerReason=\"贷款总额超限\" RulesetCode=\"BLD_ZHUNRU\" RulesetName=\"白领贷准入规则集\"></RuleDecision>\n" +
          "\t</DecisionResponse>\n" +
          "\t<ProcessingHistory DecisionArea=\"RISK\" ElapsedMillis=\"15\" StartTimestamp=\"2018-06-13T10:54:00.991\" StopTimestamp=\"2018-06-13T10:54:01.006\">\n" +
          "\t\t<DecisionFlowHistory FlowName=\"白领贷决策流\">\n" +
          "\t\t\t<DecisionFlowStepHistory ImplementationName=\"白领贷准入规则集\" ImplementationType=\"规则集\" StepIndex=\"1\">\n" +
          "\t\t\t\t<RulesetHistory RulesetCode=\"BLD_ZHUNRU\" RulesetName=\"白领贷准入规则集\">\n" +
          "\t\t\t\t\t<RuleHistory RuleCode=\"BLD_AGE_ZHUNRU\" RuleName=\"年龄准入\"></RuleHistory>\n" +
          "\t\t\t\t\t<RuleHistory RuleCode=\"BLD_SALARY_ZHUNRU\" RuleName=\"贷款总额超限\"></RuleHistory>\n" +
          "\t\t\t\t</RulesetHistory>\n" +
          "\t\t\t</DecisionFlowStepHistory>\n" +
          "\t\t</DecisionFlowHistory>\n" +
          "\t\t<DerivedVariableHistory FlowName=\"白领贷决策流\">\n" +
          "\t\t\t<PropertyHistory DataType=\"string\" ImplementationName=\"初始值\" ImplementationType=\"衍生变量集\" Index=\"1\" Name=\"衍生变量集's 最高优先级\" Value=\"9\"></PropertyHistory>\n" +
          "\t\t</DerivedVariableHistory>\n" +
          "\t</ProcessingHistory>\n" +
          "\t<MessageList StatusCode=\"1\" StatusDescription=\"Successful\"></MessageList>\n" +
          "</Application>]]></return></ns2:invokeExternalMainResponse></S:Body></S:Envelope>";
  String result2="<?xml version='1.0' encoding='UTF-8'?><S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "<S:Body>\n" +
                "\t\t<ns2:invokeExternalMainResponse xmlns:ns2=\"http://package.name.in.reverse.order\">\n" +
                "\t\t<return>&lt;Application DecisionArea=\"RISK\" SourceCode=\"A02\"&gt;\n" +
                "\t&lt;cusInfo age=\"70\" loanInner=\"6000\"&gt;&lt;/cusInfo&gt;\n" +
                "\t&lt;DecisionResponse&gt;\n" +
                "\t\t&lt;RuleDecision Index=\"1\" ReasonCode=\"RJ9002\" RuleCode=\"BLD_AGE_ZHUNRU\" RuleDecisionResult=\"RJ\" RuleName=\"年龄准入\" RuleSeverityLevel=\"0\" RuleTriggerReason=\"年龄超限\" RulesetCode=\"BLD_ZHUNRU\" RulesetName=\"白领贷准入规则集\"&gt;&lt;/RuleDecision&gt;\n" +
                "\t\t&lt;RuleDecision Index=\"2\" ReasonCode=\"RJ9001\" RuleCode=\"BLD_SALARY_ZHUNRU\" RuleDecisionResult=\"RJ\" RuleName=\"贷款总额超限\" RuleSeverityLevel=\"0\" RuleTriggerReason=\"贷款总额超限\" RulesetCode=\"BLD_ZHUNRU\" RulesetName=\"白领贷准入规则集\"&gt;&lt;/RuleDecision&gt;\n" +
                "\t&lt;/DecisionResponse&gt;\n" +
                "\t&lt;ProcessingHistory DecisionArea=\"RISK\" ElapsedMillis=\"15\" StartTimestamp=\"2018-06-13T10:54:00.991\" StopTimestamp=\"2018-06-13T10:54:01.006\"&gt;\n" +
                "\t\t&lt;DecisionFlowHistory FlowName=\"白领贷决策流\"&gt;\n" +
                "\t\t\t&lt;DecisionFlowStepHistory ImplementationName=\"白领贷准入规则集\" ImplementationType=\"规则集\" StepIndex=\"1\"&gt;\n" +
                "\t\t\t\t&lt;RulesetHistory RulesetCode=\"BLD_ZHUNRU\" RulesetName=\"白领贷准入规则集\"&gt;\n" +
                "\t\t\t\t\t&lt;RuleHistory RuleCode=\"BLD_AGE_ZHUNRU\" RuleName=\"年龄准入\"&gt;&lt;/RuleHistory&gt;\n" +
                "\t\t\t\t\t&lt;RuleHistory RuleCode=\"BLD_SALARY_ZHUNRU\" RuleName=\"贷款总额超限\"&gt;&lt;/RuleHistory&gt;\n" +
                "\t\t\t\t&lt;/RulesetHistory&gt;\n" +
                "\t\t\t&lt;/DecisionFlowStepHistory&gt;\n" +
                "\t\t&lt;/DecisionFlowHistory&gt;\n" +
                "\t\t&lt;DerivedVariableHistory FlowName=\"白领贷决策流\"&gt;\n" +
                "\t\t\t&lt;PropertyHistory DataType=\"string\" ImplementationName=\"初始值\" ImplementationType=\"衍生变量集\" Index=\"1\" Name=\"衍生变量集's 最高优先级\" Value=\"9\"&gt;&lt;/PropertyHistory&gt;\n" +
                "\t\t&lt;/DerivedVariableHistory&gt;\n" +
                "\t&lt;/ProcessingHistory&gt;\n" +
                "\t&lt;MessageList StatusCode=\"1\" StatusDescription=\"Successful\"&gt;&lt;/MessageList&gt;\n" +
                "&lt;/Application&gt;"+ "</return></ns2:invokeExternalMainResponse></S:Body></S:Envelope>";

//  String result = StringEscapeUtils.unescapeXml(result2);
//   System.out.println(result);
//String re = result.replaceAll("<return>","<return><![CDATA[").replaceAll("</return>","]]></return>");
//        String re = result.replaceAll("<Application","<![CDATA[<Application").replaceAll("</Application>","</Application>]]>");
        int i = right.indexOf("<![CDATA[")+9;
        int num = right.indexOf("]]>");
//        int i = result.indexOf("&lt;DecisionResponse&gt;")+24;
//        int num = result.indexOf("&lt;/DecisionResponse&gt;");
        String applcationResult = right.substring(i,num);
        StringBuilder str = new StringBuilder();
        str.append("<root>").append(applcationResult).append("</root>");
        String s = str.toString();
        String b = s.replaceAll("<DecisionResponse>","<DecisionResponse Index=\"1\">");
        JSONObject jsonObject = JSONObject.fromObject(XMLtoJSON.xml2JSON(b));
//        Set<Map.Entry> set = jsonObject.getJSONObject(APPLICATION).getJSONObject("InputObject").entrySet();
////         while (set.stream().iterator().hasNext()) {
////             Map.Entry s = set.stream().iterator().next();
////             System.out.println("key:"+s.getKey());
////             System.out.println("value:"+s.getValue());
////         }
//
//        Iterator<Map.Entry> it = set.iterator();
//        while (it.hasNext()) {
//            Map.Entry s = it.next();
//            System.out.println("key:"+s.getKey());
//            System.out.println("value:"+s.getValue());
//        }
        System.out.println(jsonObject.toString().replaceAll("@",""));
    }

    /*public static void main(String[] args) {
        Map map = new HashMap();
        Map map2 = new HashMap();
        map2.put(DECISION_AREA,"Risk");
        map2.put(SOURCE_CODE,"MYFQ");
        map2.put(CALL_NODE,"1");
        map2.put(NODE_STATUS,"1");

        Map map4 = new HashMap();
        map4.put("@EX_AF_TD_7D_PLATEFORM_CNT","1");
        map4.put("@EX_AF_TD_SCORE","5");
        Map map5 = new HashMap();
        map5.put("@DB_BAS_ID_NUM","220591198802021234");
        map5.put("@DB_BAS_NAME","5000");
        Map map3 = new HashMap();
        map3.put("AF_TD",map4);
        map3.put("MZ_DB",map4);
        map2.put("InputObject",map3);
        map.put(APPLICATION,map2);

        System.out.println(XMLtoJSON.json2Xml(JSONObject.fromObject(map),"root"));

        String st = "{\"Application\": {\n" +
                "          \"@CallNode\": \"1\",\n" +
                "          \"@DecisionArea\": \"Risk\",\n" +
                "          \"@NodeStatus\": \"1\",\n" +
                "          \"@SourceCode\": \"MYFQ\",\n" +
                "          \"InputObject\":           {\n" +
                "                    \"AF_TD\":                     {\n" +
                "                              \"@EX_AF_TD_7D_PLATEFORM_CNT\": \"1\",\n" +
                "                              \"@EX_AF_TD_SCORE\": \"5\"\n" +
                "                    },\n" +
                "                    \"MZ_DB\":                     {\n" +
                "                              \"@EX_AF_TD_7D_PLATEFORM_CNT\": \"1\",\n" +
                "                              \"@EX_AF_TD_SCORE\": \"5\"\n" +
                "                    }\n" +
                "          }\n" +
                "}}";
        JSONObject jsonObject = JSONObject.fromObject(st);
        System.out.println(jsonObject);

//        String st = "<Application CallNode=\"1\" DecisionArea=\"Risk\" NodeStatus=\"1\" SourceCode=\"MYFQ\"/>";

//        System.out.println(XMLtoJSON.xml2JSON("<root><Application CallNode=\"1\" DecisionArea=\"Risk\" NodeStatus=\"1\" SourceCode=\"MYFQ\"/></root>"));
    }*/


}
