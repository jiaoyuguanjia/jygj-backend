package com.jygj.admin.action.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jygj.admin.pojo.EducationType;
import com.jygj.admin.pojo.Resume;
import com.jygj.admin.pojo.TechnologyType;
import com.jygj.admin.service.ResumeService;

@Controller
@RequestMapping("/customer")
public class ResumeController {

	@Autowired
	private ResumeService resumeService;

	@RequestMapping(value="/addJinli.html", method = RequestMethod.GET)
	public String addPage(Model model, @RequestParam(required = false) String id) {
		Resume resume = new Resume();
		if (id != null && id.trim() != "") {
			try {
				resume = resumeService.get(Integer.valueOf(id));
			} catch (Exception e) {
				// TODO: 这里应该跳转到Error页面
				e.printStackTrace();
			}
		}
		model.addAttribute("resume", resume);
		model.addAttribute("educationTypes", EducationType.values());
		model.addAttribute("technologyTypes", TechnologyType.values());
		return "customer/add";
	}

	@RequestMapping(value="/addJinli.html", method = RequestMethod.POST)
	public String save(Model model, Resume form) {
		resumeService.save(form);
		return "redirect:/customer/index.html";//重定向
	}
	
	@RequestMapping(value="/deleteResume.html", method = RequestMethod.GET)
	public String delete(Model model,  @RequestParam String id) {
		if (id != null && id.trim() != "") {
			try {
				resumeService.delete(Integer.valueOf(id));
			} catch (Exception e) {
				// TODO: 这里应该跳转到Error页面
				e.printStackTrace();
			}
		}
		return "redirect:/customer/index.html";//重定向
	}
	
}
