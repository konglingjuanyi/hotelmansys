package com.shxt.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.shxt.action.BaseAction;

public class UploadAction extends BaseAction{
	
	private File xyz;
	private String xyzFileName;
	private String xyzContentType;
	private String imgName = "";
	

	public UploadAction(File xyz, String xyzFileName, String xyzContentType) {
		this.xyz = xyz;
		this.xyzFileName = xyzFileName;
		this.xyzContentType = xyzContentType;
	}


	public String load() throws IOException{
		
		OutputStream out = null;
		InputStream in = null;
		
		try {
			
			//获取上传路径
			String path = ServletActionContext.getServletContext().getRealPath("/upload");
			//获取图片名称
			//System.out.println(this.getXyzFileName());//image/jpeg
			if(this.getXyzFileName().length()>0||this.getXyzFileName()!=null){
				int start = this.getXyzFileName().lastIndexOf(".");// 获得最后一个反斜杠的位置
				if(start > 0){
					imgName = new Date().getTime()+".jpg";
				}else{
					imgName = this.getXyzFileName()+".jpg";
				}
				//创建文件
				File f = new File(path, imgName);
				
				if(!f.getParentFile().exists()){
					f.getParentFile().mkdirs();
				}
				out = new FileOutputStream(f);
				in = new FileInputStream(xyz);
				
				int length = 0;
				//建立缓冲区
				byte[]bs = new byte[1024];
				while((length=in.read(bs))>0){
					out.write(bs,0,length);
				}
			}

		} catch (Exception e) {
			this.message = e.getMessage();
			return INPUT;
		}finally{
			in.close();
			out.close();
		}
		return SUCCESS;
		
	}


	public File getXyz() {
		return xyz;
	}

	public void setXyz(File xyz) {
		this.xyz = xyz;
	}

	public String getXyzFileName() {
		return xyzFileName;
	}

	public void setXyzFileName(String xyzFileName) {
		this.xyzFileName = xyzFileName;
	}

	public String getXyzContentType() {
		return xyzContentType;
	}

	public void setXyzContentType(String xyzContentType) {
		this.xyzContentType = xyzContentType;
	}


	public String getImgName() {
		return imgName;
	}


	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
}
