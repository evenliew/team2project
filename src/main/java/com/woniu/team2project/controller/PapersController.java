package com.woniu.team2project.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.woniu.team2project.entity.Module;
import com.woniu.team2project.entity.Papers;
import com.woniu.team2project.entity.PapersType;
import com.woniu.team2project.entity.Sx;
import com.woniu.team2project.entity.User;
import com.woniu.team2project.service.PapersService;
import com.woniu.team2project.service.PapersTypeService;
import com.woniu.team2project.service.impl.PapersServiceImpl;
import com.woniu.team2project.service.impl.PapersTypeServiceImpl;

@Controller
public class PapersController {
	@Autowired
	PapersService papersService;
	
	@RequestMapping("/showpapers")
	public List<Papers> getPapersModel(Model model) {
		List<Papers> papers=null;
		//查询数据库中所有文件信息
		PapersService papersService=new PapersServiceImpl();
		papers = papersService.getPapers();
		System.out.println(papers);
		return papers;
	}
	/**
	 * 
	 * @param httpSession
	 * @param username
	 * @param file_name
	 * @param modulename
	 * @param sxname
	 * @param model
	 * @param fileUpload
	 * @param type_name
	 * @return
	 */
	@PostMapping("/newpapers")
	public String newPapers(HttpSession httpSession,String username, String file_name, String modulename, String sxname, 
			Model model,MultipartFile fileUpload,String type_name) {

//		Object user_name = httpSession.getAttribute("user_name");// 从域中获取上传人名称
//		
//		if(!username.equals(user_name)) {
//				model.addAttribute("msg", "用户名错误");
//				return "/newpapers";
//		}
		
//		// id
//		String file_id = UUID.randomUUID().toString().replace("-", "");
//		
//		// 获取当前时间
//		Date file_time = new Date();
//		
//		//调用service层查询用户对象
//		User user=new User("1", null, null, null, null, null, null, null);
//		
//		//调用service层查询module对象
//		Module module=new Module(1, null, new Module());
//		
//		//调用service层查询papersType对象
//		PapersType papersType=new PapersType(2, "类型2");
////		PapersTypeService papersTypeService=new PapersTypeServiceImpl();
////		PapersType papersType=papersTypeService.getPapersTypeName(type_name);
//		
//		//调用service层查询sx对象
//		Sx sx=new Sx("1", null, null, null, null, null, null, null, null, null, null, null, null, null);
//		
//		//
//		Papers papers=new Papers(file_id, file_time, file_name, user, module, sx, "file_url", papersType);
//		
//		//调用service添加文件信息
//		papersService.addPapers(papers);
//		
		//获取文件名
        String filename = fileUpload.getOriginalFilename();
        //获取文件后缀名
        String suffixName = filename.substring(filename.lastIndexOf("."));
        //重新生成文件名
        filename = UUID.randomUUID()+suffixName;
		System.out.println(filename);
		String filePath="D:/zhao_xue_sts1/data/team2project/src/main/resources/static/";
		try {
			fileUpload.transferTo(new File(filePath+filename));
			return "newpapers";
		} catch (Exception e) {
			return "newpapers";
		}
	}
	@GetMapping(value="/file" )
	public String files() {
		return "papers";
	}
	
	@GetMapping(value="/newfile" )
	public String newfiles() {
		return "newpapers";
	}
	
}
