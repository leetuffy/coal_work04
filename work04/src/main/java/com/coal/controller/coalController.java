package com.coal.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.coal.pojo.coal;
import com.coal.service.coalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@Controller
@RequestMapping("/coal")
public class coalController {
    @Autowired
    private coalService coalService;

    private List<coal> co = null;
    private List<coal> wasi = null;

    @ResponseBody
    @RequestMapping("/getOne")
    public Object getOne(Model model){
//        System.out.println(JSONObject.toJSON("{'a':111}"));
//        JSONObject object = (JSONObject) JSONObject.toJSON({"a":111});
//        System.out.println(object.getClass());
        return null;
    }
    @RequestMapping("/co")
    public String CO(Model model,HttpSession httpSession)
    {
//        List<coal> coalList = coalService.getCO();
        List<coal> coalList = this.co;
        this.co = coalList;
        String[] co = new String[coalList.size()];
        for (int i = 0; i < coalList.size(); i++)
        {
            co[i] = coalList.get(i).getPoint_location();
        }
        TreeSet<String> treeSet = new TreeSet<>();
        for (String s:co){
//            String[] split = s.split("\\s");
//            s = s.replace( "一氧化碳","").trim();
//            s = s.replace( "CO","").trim();
//            System.out.println(s);
//            continue;
//            treeSet.add(split[1].substring(0,split[1].length()-4));
            treeSet.add(s);
        }
        httpSession.setAttribute("co",treeSet);
        return "co";
    }
    @RequestMapping("/wasi")
//    @ResponseBody
    public String Wasi(Model model, HttpSession httpSession)
    {
//        List<coal> coalList = coalService.getWasi();
//        this.wasi = coalList;
        List<coal> coalList = this.wasi;
        String[] wasi = new String[coalList.size()];
        for (int i = 0; i < coalList.size(); i++){
            wasi[i] = coalList.get(i).getPoint_location();
        }
        TreeSet<String> treeSet = new TreeSet<>();
        for (String s:wasi){
//            String[] split = s.split("\\s");
//            System.out.println(split);
//            continue;
//            treeSet.add(split[1].substring(0,split[1].length()-2));
//            s = s.replace("CH4","").trim();
//            s = s.replace("瓦斯","").trim();
            treeSet.add(s);
        }
//        List list = new ArrayList(treeSet);
//        model.addAttribute("wasi",treeSet);
        httpSession.setAttribute("wasi",treeSet);
        return "wasi";
    }

    @RequestMapping("/data_select")
    @ResponseBody
    public Object data_select( HttpServletRequest httpServletRequest, HttpSession session)
    {
        String type = httpServletRequest.getParameter("type");;
//        if (httpServletRequest.getParameter("type") != null)
//        {
//            type = httpServletRequest.getParameter("type");
//        }
        String name = httpServletRequest.getParameter("name");
//        System.out.println(type);
//        System.out.println(name);
        OptionalDouble max = null,min = null,average = null;
        List<String> s = null;
        if(type == null)
        {
            return null;
        }
        switch (type)
        {
            case "co":
                Map<String, List<coal>> map = co.stream().collect(groupingBy(coal::getPoint_location));
                List<coal> list1 = map.get(name);

//                Stream<String> sorted = list1.stream().map(coal::getData_time).sorted().co;
//                return null;

                max = list1.stream().mapToDouble(coal::getPoint_value).max();
                min = list1.stream().mapToDouble(coal::getPoint_value).min();
                average = list1.stream().mapToDouble(coal::getPoint_value).average();
                s = list1.stream().map(coal::getData_time).sorted().collect(toList());
                break;
            case "wasi":
                Map<String, List<coal>> map1 = wasi.stream().collect(groupingBy(coal::getPoint_location));
                List<coal> list = map1.get(name);
                max = list.stream().mapToDouble(coal::getPoint_value).max();
                min = list.stream().mapToDouble(coal::getPoint_value).min();
                average = list.stream().mapToDouble(coal::getPoint_value).average();
//                System.out.println("max:"+max.getAsDouble());
//                System.out.println("min:"+min.getAsDouble());
//                System.out.println("avg:"+average.getAsDouble());
                s = list.stream().map(coal::getData_time).sorted().collect(toList());
//                System.out.println(s);
                break;
            default:
                System.out.println("Error");
        }
        session.setAttribute("max",max);
        session.setAttribute("min",min);
        session.setAttribute("average",average);
        session.setAttribute("TimeList",s);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("max",max);
        jsonObject.put("min",min);
        jsonObject.put("average",average);
        jsonObject.put("TimeList",s);
//        System.out.println(jsonObject);
//        String string = "";
        return jsonObject;
    }
    @RequestMapping("/main")
    public String main(Model model,HttpSession session){
        co=coalService.getCO();
        wasi=coalService.getWasi();
//        System.out.println("Main");
//        Object max = session.getAttribute("max");
//        System.out.println(max);
        return "main";
    }

}
