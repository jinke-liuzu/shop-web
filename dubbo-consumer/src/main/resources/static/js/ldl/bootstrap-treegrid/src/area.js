/**

  //注解
  <script src="<%=request.getContextPath()%>/js/uploadify/jquery.uploadify.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>js/uploadify/uploadify.css">
<script src="<%=request.getContextPath()%>/js/kindeditor-4.1.10/kindeditor-all.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/kindeditor-4.1.10/themes/default/default.css">
//删除
 "<td><a href='javascript:delOneUtil(\"<%=request.getContextPath()%>/book/delAll.do\","+books[i].id+",true)'>删除</a>|<a href='javascript:editBook("+books[i].id+")'>修改</a></td>"+
 时间
  <input type="text" id="searchStarTime" class="Wate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">--
  HashMap<String, Object> params = new HashMap<>();
	
	//将传过来的实体bean放到map
	params.put("bookBean", bookBean);
	//查询总共有几条数据
	int count=bookMapper.findBookCount(params);
	PageUtil<BookBean> pageUtil=new PageUtil<>(count, pageIndex, pageSize);
	params.put("startIntex", pageUtil.getStartIndex());
	params.put("endIntex", pageUtil.getEndIndex());
	List<BookBean> books=bookMapper.findBookList(params);
	pageUtil.setList(books);
	return pageUtil;


	  SELECT * from 
    (
   SELECT A.*,ROWNUM RN
   from (
   
      select t.id,t.name,t.author,t.price,<!-- to_char(t.createtime,'yyyy-MM-dd hh24:mi:ss')as --> t.createTime,tt.name as typeName,t.img,ta.name as provinceName, tar.name as cityName, t.detail   
      from  t_book t left join t_type tt on t.type_id=tt.id
            left join t_area ta on t.province_code=ta.id
            left join t_area tar on t.city_code=tar.id
            <include refid="bookWhere"></include>
   )A
   WHERE ROWNUM &lt;=#{endIntex,jdbcType=NUMERIC}
   )
   WHERE RN >#{startIntex,jdbcType=NUMERIC}

 * id = "当前需要查询节点的上一级id"
 * url = "查询数据的后台控制层地址"
 * provinceDom = "省下拉框id"
 * cityDom = "市下拉框id"
 * 示例 initArea(0,'<%=path%>/student/findArea.do','provinceSelect','citySelect');
 <delete id="delBookTest" parameterType="com.jk.hxy.model.BookBean">
    delete from t_book where id in(
    <foreach collection="array" index="index" item="item" separator=",">#{item}</foreach>
    )

</delete>
 $(function(){
	    $("#searchProvinceCode").change(function(){
			
			var ProvinceCode = $(this).val();
			initArea(ProvinceCode,'<%=request.getContextPath()%>/area/findArea.do','','searchcityCode');
	  
	 }) 
	  
   })
  
     $("#addBtn").click(function(){
    	 $("#hideDetail").val(editor.html())
    	  $.ajax({
    		  url:"<%=request.getContextPath()%>/book/addBook.do",
    		  type:"post",
    		  data:$("#bookForm").serialize(),
    		  dataTtype:"json",
    		  success:function(data){
    			  if(data){
    				  
    				  location.href="<%=request.getContextPath()%>/page/pageList.do";
    			  }else{
    				  
    				  alert("修改失败")
    			  }
    			  
    		  }
    	  })
     })
 */
function initArea(id,url,provinceDom,cityDom){
	$.ajax({
		url:url,
		async:false,
		type:'post',
		data:{
			id:id
		},
		dataType:'json',
		success:function(data){
			var html = "<option value='-1'>请选择</option>";
			html+="<option value='-2'>其他</option>";
			for(var i = 0 ; i < data.length; i++){
				html += "<option value='"+data[i].id+"'>"+data[i].text+"</option>"
			}
			if(provinceDom != null && provinceDom != '' && cityDom != null && cityDom != ''){
				$('#'+provinceDom).html(html);
			}else if(provinceDom != null && provinceDom != ''){
				$('#'+provinceDom).html(html);
			}else if((provinceDom == null || provinceDom == '') && (cityDom != null && cityDom != '') ){
				$('#'+cityDom).html(html);
			}
			
		},
		error:function(){
			alert('初始化'+id+"节点下的数据失败")
		}
	})
	if(provinceDom != null || provinceDom != ''){
		initProvinceChange(provinceDom,url,cityDom);
	}
}

function initProvinceChange(provinceDom,url,cityDom){
	$('#'+provinceDom).change(function(){
		var id = $(this).val();
		initArea(id,url,'',cityDom);
	})
}