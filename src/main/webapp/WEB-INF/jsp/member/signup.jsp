<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <%@ include file="../common/head.jsp" %>
</head>
<body>
	<main class="container p-3 pb-5">
		<div class="col-lg-4 col-md-6 mx-auto" >
			<div class="mt-5">
				<h3 class="text-center my-5"><a href="${pageContext.request.contextPath}/">더 조은 아카데미</a></h3>
			</div>
	        <div class="card">
	            <div class="card-header p-5">
	                <h2>Sign Up</h2>
	            </div>
	            <div class="card-body">
	                <form method="post" autocomplete="off">
	                	<h4 class="my-5"><i class="fas fa-list-ul"></i> 필수정보</h4>
	                    <div class="mb-3 mt-3">
	                    <label for="id" class="form-label">ID</label>
	                    <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
	                    </div>
	                    <div class="mb-3">
		                    <label for="pwd" class="form-label">Password</label>
		                    <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pw">
	                    </div>
	                    <div class="mb-3">
		                    <label for="pwdChk" class="form-label">Password Confirm</label>
		                    <input type="password" class="form-control" id="pwdChk" placeholder="Enter password repeat" >
	                    </div>
	                    <div class="mb-3">
		                    <label for="name" class="form-label">name</label>
		                    <input type="text" class="form-control" id="name" placeholder="Enter your name" name="name">
	                    </div>
	                    
	                    <hr>
	                    <h4 class="my-5"><i class="fas fa-list-ul"></i> 부가정보</h4>
	                    <div class="mb-3">
		                    <label for="email" class="form-label">email</label>
		                    <input type="text" class="form-control" id="email" placeholder="Enter your email" name="email">
	                    </div>
	                    <div class="mb-3">
		                    <label for="addr" class="form-label">address</label>
		                    <div class="input-group">
		                    	<input type="text" class="form-control" id="addr" placeholder="" name="addr" readonly>
		                    	<button class="btn btn-primary" type="button" id="btnAddr">주소 검색</button>
		                    </div>
		                    <input type="text" class="form-control mt-3" id="addrDetail" placeholder="상세주소" name="addrDetail" readonly>
	                    </div>
	                    <div class="mb-3">
	                    	<p class="text-danger small">${param.msg}</p>
	                    </div>
	                    
	                    <button type="submit" class="btn btn-primary">Sign Up</button>
	                </form>
	            </div>
	        </div>
      	</div>
    </main>
    
   <!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">주소 검색</h4>
        <br>
        <form id="jusoSearchFrm">
      		<input type="hidden" name="currentPage" value="1"/> 
			<input type="hidden" name="countPerPage" value="10"/>
			<input type="hidden" name="resultType" value="json"/>
			<input type="hidden" name="confmKey" value="U01TX0FVVEgyMDIzMDMyMzE1NTczMDExMzYyMDQ="/>
			<div class="input-group">
				<input type="text" name="keyword" value="" class="form-control w-75"/>
				<button class="btn btn-primary">검색</button>
			</div>
      	</form>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
      	<div class="result-search card bg">
   
      	</div>
      </div>
      
      <ul class="pagination justify-content-center mt-3">
		  <li class="page-item"><a class="page-link" href="#">Previous</a></li>
		  <li class="page-item active"><a class="page-link" href="#">1</a></li>
		  <li class="page-item "><a class="page-link" href="#">2</a></li>
		  <li class="page-item"><a class="page-link" href="#">3</a></li>
		  <li class="page-item"><a class="page-link" href="#">4</a></li>
		  <li class="page-item"><a class="page-link" href="#">5</a></li>
		  <li class="page-item"><a class="page-link" href="#">Next</a></li>
		</ul>
      
      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>


	
<jsp:include page="../common/footer.jsp" />
<!-- U01TX0FVVEgyMDIzMDMyMzE1NTczMDExMzYyMDQ= --> 
<script>
$(function() {
	$("#btnAddr").click(function() {
		$("#myModal").modal("show").find(":text").focus();
		$("#addr").val("");
		$("#addrDetail").prop("readonly", true).val("");
	})
	
	$(".result-search").on("click", "a", function() {
		event.preventDefault();
		let str = $(this).text();
		console.log(str);
		$("#myModal").modal("hide");
		$("#addr").val(str);
		$("#addrDetail").prop("readonly", false).val("");
		
	})
	
	$("#jusoSearchFrm").submit(function() {
		
		console.log("event");
		let data = $(this).serialize();
		$.post({
			url : "https://business.juso.go.kr/addrlink/addrLinkApiJsonp.do",
			data : data,
			dataType : "jsonp",
			crossDomain : true,
			success : function(data) {
				if(! (data.results.common.totalCount/1)){
					$(".result-search").html("검색 결과가 없습니다");
					return;
				}
				let result = "";
				let arr = data.results.juso
				for(var i in arr){
					result += `
					<div class="card-body border p-3 \${i%2 ? 'bg-secondary' : ''} ">
						<p class="card-text text-truncate">
							<span class="badge bg-primary d-inline-block me-2" style="width:45px">지번</span> 
							<a href="" class="\${i%2 ? 'text-white' : 'text-secondary' }">\${arr[i].jibunAddr}</a>
						</p>
						<p class="card-text text-truncate">
							<span class="badge bg-primary me-2">도로명</span>
							<a href="" class="\${i%2 ? 'text-white' : 'text-secondary' }">\${arr[i].roadAddr} </a>
						</p>
      				</div>
					`;

					console.log(i, arr[i].jibunAddr, arr[i].roadAddr);
				}
				console.log(result);
				$(".result-search").html(result);
				
			}
		})
		return false;
	})
})
</script>
</body>
</html>