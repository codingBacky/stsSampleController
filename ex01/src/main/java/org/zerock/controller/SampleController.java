package org.zerock.controller;

import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import lombok.extern.log4j.Log4j;

@Controller
//@RestController
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@GetMapping("/ex06/{name}/{age}")
	public String ex06(@PathVariable("name") String name, @PathVariable("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age);
		return "ex06";
	}
	
	@GetMapping("/ex05")
	public String ex05(String name, int age, RedirectAttributes rttr) {
		log.info(name);
		log.info(age);
		rttr.addAttribute("name",name);
		rttr.addAttribute("age", age);
		rttr.addFlashAttribute("name2",name);
		rttr.addFlashAttribute("age2",age);
		
		return "ex05";
	}

	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, int page, Model model) {
		log.info(dto);
		log.info(page);
		model.addAttribute("page", page);
		model.addAttribute("dto", dto);
		return "sample/ex4";
	}
	
	@GetMapping("ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list : " + list);
		return "ex02Bean";
	}

	@GetMapping("/ex02")
	public String ex02(/* @RequestParam("name") */ String name2, /* @RequestParam("age") */ int age2) {
		log.info("지금 DTO : " + name2);
		log.info("DTO : " + (age2 + 100));
		
		return "ex02";
	}
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto, Model model) {
		log.info("DTO : " + dto);
		log.info("DTO : " + (dto.getAge()+100));
		log.info("DTO : " + dto.getName());
		model.addAttribute("dto", dto);
		return "ex01";
	}
	@RequestMapping("")
	public void basic() {
		log.info("basic");
	}
	
	//@RequestMapping(value="/basic",method = RequestMethod.GET)
	@GetMapping("/basic")
	public void basic2() {
		log.info("basic get");
	}
	
	//@RequestMapping(value="/basic",method = RequestMethod.POST)
	@PostMapping("/basic")
	public void basic3() {
		log.info("basic post");
	}
	
	//@RequestMapping(value="/basic",method = RequestMethod.DELETE)
	@Delete("/basic")
	public void basic4() {
		log.info("basic DELETE");
	}
	
	@RequestMapping("first/")
	public void first() {
		log.info("first");
	}
	@RequestMapping("second/")
	public void second() {
		log.info("second");
	}
}
