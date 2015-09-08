package com.wx.action;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.opensymphony.xwork2.ActionContext;
import com.shxt.action.BaseAction;
import com.wx.model.Consumer;
import com.wx.model.ICCard;
import com.wx.model.Product;
import com.wx.model.ProductType;
import com.wx.service.IICCardService;
import com.wx.service.IProductService;
import com.wx.service.IProductTypeService;

public class ICCardAction extends BaseAction {
	private IICCardService icCardService;
	private ICCard icCard;
	// 商品类型
	private IProductTypeService typeService;
	private List<ProductType> productTypeList;
	private ProductType productType;
	// 商品
	private IProductService productService;
	private List<Product> productList = new ArrayList<Product>();
	private Product product;
	//顾客
	private Consumer consumer;
	//商品id和购买数量
	private String idArr;
	private String countArr;
	private String[]id;
	private String[]count;
	//商品退货数量
	private Integer pro_num;
	

	/***
	 * 获取商品类型
	 * 
	 * @return
	 */
	public String listProType() {
		productTypeList = typeService.listAll(null);
		ActionContext.getContext().put("productTypeList", productTypeList);

		this.toFolder = "icCard";
		this.toJsp = "listProduct";
		return SUCCESS;
	}
	/**
	 * 获取购买商品
	 * @return
	 */
	public String balance(){
		consumer = icCardService.getConsumerById(consumer.getConsu_id());
		
		if(idArr.contains(",")){
			id = idArr.trim().split(",");
			count = countArr.split(",");
		}else{
			id = new String[]{idArr};
			count = new String[]{countArr};
		}
		
		float money = 0.0f;
		for(int i = 0 ; i < id.length ; i ++){
			
			product = productService.queryById(Integer.parseInt(id[i]));
			
			productList.add(product);
			
			ICCard icCard = new ICCard();
			icCard.setIc_proName(product.getPro_name());
			icCard.setIc_proNum(count[i]);
			icCard.setIc_proPrice(""+product.getPro_price());
			icCard.setIc_time(new Date());
			icCard.setIc_outMoney(product.getPro_price()*Integer.parseInt(count[i]));
			icCard.setIc_consuId(consumer);
			
			icCardService.add(icCard);
			money += product.getPro_price()*Integer.parseInt(count[i]); 
			
			product.setPro_store(product.getPro_store()-Integer.parseInt(count[i]));
			product.setPro_outstore(product.getPro_outstore()+Integer.parseInt(count[i]));
			productService.updateProduct(product);
		}
		DecimalFormat df = new DecimalFormat("###.00");
		 
		ActionContext.getContext().put("productList", productList);
		ActionContext.getContext().put("count", count);
		ActionContext.getContext().put("money", df.format(money));
		
		this.toFolder = "icCard";
		this.toJsp = "message";
		this.flag = "balance";
		this.message = "购物成功!欢迎下次再来!";
		return SUCCESS;
	}
	//退货
	public String decrease(){
		Product p =	productService.getProductById(product.getPro_id());
		p.setPro_store(p.getPro_store()-pro_num);
		productService.updateProduct(p);
		this.toFolder = "icCard";
		this.toJsp = "message1";
		this.message = " 退货成功!";
		this.flag = "toMod";
		return SUCCESS;
	}
	public IICCardService getIcCardService() {
		return icCardService;
	}

	public void setIcCardService(IICCardService icCardService) {
		this.icCardService = icCardService;
	}

	public IProductTypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(IProductTypeService typeService) {
		this.typeService = typeService;
	}

	public List<ProductType> getProductTypeList() {
		return productTypeList;
	}

	public void setProductTypeList(List<ProductType> productTypeList) {
		this.productTypeList = productTypeList;
	}

	public IProductService getProductService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public Consumer getConsumer() {
		return consumer;
	}
	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}
	public String getIdArr() {
		return idArr;
	}
	public void setIdArr(String idArr) {
		this.idArr = idArr;
	}
	public String getCountArr() {
		return countArr;
	}
	public void setCountArr(String countArr) {
		this.countArr = countArr;
	}
	public ICCard getIcCard() {
		return icCard;
	}
	public void setIcCard(ICCard icCard) {
		this.icCard = icCard;
	}
	public String[] getId() {
		return id;
	}
	public void setId(String[] id) {
		this.id = id;
	}
	public String[] getCount() {
		return count;
	}
	public void setCount(String[] count) {
		this.count = count;
	}
	public Integer getPro_num() {
		return pro_num;
	}
	public void setPro_num(Integer proNum) {
		pro_num = proNum;
	}
	
}
