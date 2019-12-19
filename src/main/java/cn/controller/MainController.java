package cn.controller;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;

import cn.pojo.Dingwei;
import cn.pojo.Phone;
import cn.pojo.Xuanshou;
import cn.service.DingweiService;
import cn.service.PhoneService;
import cn.service.XuanshouService;

@Controller
@RequestMapping("/ice")
public class MainController {
	@Resource
	private XuanshouService xuanshouService;
	@Resource
	private PhoneService phoneService;
	@Resource
	private DingweiService dingweiService;

	@RequestMapping("/towelcome")
	public ModelAndView towelcome(ModelAndView md) {
		List<Xuanshou> list = xuanshouService.getXuanshouList();
		md.addObject("list", list);
		md.setViewName("welcome");// 转发
		return md;
	}

	@RequestMapping("/tocontent")
	public ModelAndView tocontent(ModelAndView md) {
		List<Xuanshou> list = xuanshouService.getXuanshouList();
		md.addObject("list", list);
		md.setViewName("content");// 转发
		return md;
	}

	@RequestMapping(value = "/sendSms", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String sendSms(HttpServletRequest request, HttpServletResponse response, String phone) {
		try {
			JSONObject json = null;
			String verifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
			SmsSingleSender ssender = new SmsSingleSender(1400204036, "7f8105013e59f11a671dc3cd393c8f3f");
			SmsSingleSenderResult result = ssender.send(0, "86", phone,
					"【魔法多】您的验证码是: " + verifyCode + "，该码有效期为5分钟，该码只能使用一次！如非本人操作，请忽略本短信。", "", "");
			json = JSONObject.parseObject(result.toString());//
			if (json.getIntValue("code") != 0) {// 发送短信失败
				return null;
			}
			HttpSession session = request.getSession();
			json = new JSONObject();
			json.put("verifyCode", verifyCode);
			json.put("createTime", System.currentTimeMillis());
			session.setAttribute("verifyCode", json);
			System.out.println(json);// 验证码，和发送的时间(createTime)
			return JSON.toJSONString(json);
		} catch (Exception e) {
			// HTTP响应码错误
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = "/submit", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String submit(String tel, String code) {
		Phone phone = new Phone();
		phone.setTel(tel);
		phone.setStatus(1);
		Xuanshou xuanshou = new Xuanshou();
		xuanshou.setCode(code);
		int count = xuanshouService.getCount(xuanshou);
		count++;
		xuanshou.setCount(count);
		int i = phoneService.addPhone(phone);
		int j = xuanshouService.updateCount(xuanshou);
		System.out.println("i=" + i + ",j=" + j);
		if (i > 0 && j > 0) {
			return JSON.toJSONString("ok");
		}
		return JSON.toJSONString("no");
	}

	@RequestMapping(value = "/checkPhone", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String checkPhone(String tel) {
		Phone phone = new Phone();
		phone.setTel(tel);
		Phone ph = phoneService.checkPhone(phone);
		if (ph == null) {
			return JSON.toJSONString("ok");
		}
		return JSON.toJSONString("no");
	}

	@RequestMapping(value = "/getStatus", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getStatus(String tel) {
		Phone phone = new Phone();
		phone.setTel(tel);
		Phone ph = phoneService.checkPhone(phone);
		if (ph != null) {
			Integer i = phoneService.getStatus(phone);
			if (i <= 0) {
				return JSON.toJSONString("ok");
			}
		} else {
			return JSON.toJSONString("ok");
		}
		return JSON.toJSONString("no");
	}

	@RequestMapping(value = "/getPhoneList", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getPhoneList() {
		List<Phone> list = phoneService.getPhoneList();
		return JSON.toJSONString(list);
	}

	@RequestMapping(value = "/getDingweiList", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getDingweiList() {
		List<Dingwei> list = dingweiService.getDingweiList();
		return JSON.toJSONString(list);
	}

	@RequestMapping(value = "/addDingWei", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String addDingWei(@RequestParam(name = "longitude", required = false, defaultValue = "") String longitude,
			@RequestParam(name = "latitude", required = false, defaultValue = "") String latitude,
			@RequestParam(name = "name", required = false, defaultValue = "") String name,
			@RequestParam(name = "detail", required = false, defaultValue = "") String detail,
			@RequestParam(name = "city", required = false, defaultValue = "") String city,
			@RequestParam(name = "beizhu", required = false, defaultValue = "0") String beizhu) {
		Dingwei dingwei = new Dingwei(longitude, latitude, name, detail, city, Integer.parseInt(beizhu));
		int i = dingweiService.addDingWei(dingwei);
		if (i > 0) {
			return JSON.toJSONString("ok");
		}
		return JSON.toJSONString("no");
	}

	@RequestMapping(value = "/getDingwei", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String getDingwei() {
		Dingwei dingwei = dingweiService.getDingwei();
		if (dingwei != null) {
			return JSON.toJSONString(dingwei);
		} else {
			dingwei = new Dingwei("117.136991", "31.832883", "合肥市蜀山区望江西路774", "合肥创新产业园附近", "合肥市", 1);
		}
		return JSON.toJSONString(dingwei);
	}
}
