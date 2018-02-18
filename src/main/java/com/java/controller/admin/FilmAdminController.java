package com.java.controller.admin;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.time.DateUtils;
import org.jsoup.helper.DataUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.java.entity.Config;
import com.java.entity.Film;
import com.java.service.FilmService;
import com.java.util.DateUtil;


@Controller
@RequestMapping("/admin/film")
public class FilmAdminController {

	@Resource
	private Config config;
	@Resource
	private FilmService filmService;
	
	
	
	@RequestMapping("/ckeditorUpload1")
	public void ckeditorUpload(@RequestParam("upload")MultipartFile file,String CKEditorFuncNum
			,HttpServletResponse response,HttpServletRequest request)throws Exception{
		
		
		
		
		String fileName=file.getOriginalFilename(); // 获取文件名
		String suffixName=fileName.substring(fileName.lastIndexOf(".")); // 获取文件的后缀
		String newFileName=DateUtil.getCurrentDateStr()+suffixName;
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File(config.getImageFilePath()+newFileName));
		
		StringBuffer sb=new StringBuffer();
	    sb.append("<script type=\"text/javascript\">");
	    sb.append("window.parent.CKEDITOR.tools.callFunction("+ CKEditorFuncNum + ",'" +"/static/filmImage/"+ newFileName + "','')");
	    sb.append("</script>");
	     
	    response.setCharacterEncoding("utf-8");
	    PrintWriter out = null;
	    out = response.getWriter();
	    out.println(sb.toString());
		
	}
	
	
	@RequestMapping(value="/save")
	public String save(Film film,@RequestParam(value="imageFile",required=false)MultipartFile file,HttpServletResponse response)throws Exception{
		int resultTotal = 0;
		
		if(file!=null){
			String fileName=file.getOriginalFilename(); // 获取文件名
			String suffixName=fileName.substring(fileName.lastIndexOf(".")); // 获取文件的后缀
			String newFileName=DateUtil.getCurrentDateStr()+suffixName;
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(config.getImageFilePath()+newFileName));
			film.setImageName(newFileName);  //设置文件名
		}
		
		if (film.getId()==null) {
			film.setCreateDate(new Date());
			resultTotal = filmService.addFilm(film);
		}else {
			resultTotal = filmService.updateFilm(film);
		}
		
		JSONObject result = new JSONObject();
		if (resultTotal>0) {
			result.put("success", true);
		}else {
			result.put("success", false);
		}
		
		return null;
		
	}
	
}
