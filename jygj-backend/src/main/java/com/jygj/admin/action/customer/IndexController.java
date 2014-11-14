package com.jygj.admin.action.customer;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jygj.admin.pojo.Resume;
import com.jygj.admin.service.ResumeService;

/**
 * 首页的Web服务
 */
@Controller
@RequestMapping("/customer")
//@Scope(value = "property")
public class IndexController {
	
	@Autowired
	private ResumeService resumeService;

	@RequestMapping(value="/index.html", method = RequestMethod.GET)
	public String index(Model model) {
		List<Resume> resumeList = resumeService.queryAll();
		
		model.addAttribute("welcome", "Welcome to lansaipu study java language");
		model.addAttribute("resumeList", resumeList);
		return "customer/index";
	}
	
	@RequestMapping(value="/queryResume.html", method = RequestMethod.POST)
	public String queryResume(String name, Integer jobYear, Model model) {
		List<Resume> resumeList = resumeService.query(StringUtils.trim(name), jobYear) ;
		
		model.addAttribute("welcome", "Welcome to lansaipu study java language");
		model.addAttribute("resumeList", resumeList);
		model.addAttribute("name", name);
		model.addAttribute("jobYear", jobYear);
		return "customer/index";
	}

}
