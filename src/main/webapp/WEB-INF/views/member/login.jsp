<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>2023. 4. 11.오전 10:35:00</title>
<style>
table {border-collapse: collapse; width: 800px; margin: 10px;}
table, td, th {border:1px solid; text-align: center;}
.receiveList tr {cursor: pointer}
.receiveList tr:hover {text-decoration: underline;}
</style>

</head>
<body>
	<c:if test="${empty member}">
	<form method="post">
		<input name="id">
		<input name="pw" type="password">
		<button>로그인</button>
		<p>${msg}</p>
	</form>
	</c:if>
	<c:if test="${not empty member}">
		<p>로그인 됨</p>
		<p>${member.name} / ${member.id}</p>
		<p>미확인 쪽지의 개수 <span id="uncheckedNoteCount">0</span></p>
		<a href="logout">로그아웃</a>
	</c:if>
	<hr>
	
	<select size="10" id="receiverList">
		<option>1</option>
		<option>1</option>
		<option>1</option>
	</select>
	<input type="text" id="textMessage">
	<button id="btnSend">발송</button>
	<hr>
	<h4>${member.name}의 발송 목록</h4>
	<table class="sendList">
	</table>
	<hr>
	<h4>${member.name}의 수신 목록</h4>
	<table class="receiveList">
	</table>
	<hr>
	<h4>${member.name}의 수신(미확인) 목록</h4>
	<table class="receiveCheckedList">
	</table>
	
	
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js" integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script>let cp = '${pageContext.request.contextPath}';</script>
    
    <script src="${pageContext.request.contextPath}/resources/js/note.js"></script>
    <script>
    console.log(noteService)
    
	$(function() {
		var ws = new WebSocket("ws://localhost/note");
		let sender = '${member.id}';
		
		ws.onopen = function(ev) {
			console.log("연결 완료", ev);
		}
		ws.onclose = function(ev) {
			console.log("연결 종료", ev);
		}
		ws.onmessage = function(ev) {
			console.log(ev.data);
			var obj = JSON.parse(ev.data);
			console.log(obj);
			if(obj.sender === sender){
				$(".sendList").html(getTableText(obj.sendList));
			} else {
				$("#uncheckedNoteCount").text(obj.receiveUncheckedList.length);
				$(".receiveCheckedList").html(getTableText(obj.receiveUncheckedList));
				$(".receiveList").html(getTableText(obj.receiveList));
			}
		}
		
		$.getJSON("getList").done(function(data) {
			let str = "";
			for ( let i in data) {
				str += `<option>\${data[i].id}</option>`;
			}
			$("#receiverList").html(str);
		})

		$("#btnSend").click(function() {
			let receiver = $("#receiverList").val();
			let message = $("#textMessage").val();
			console.log(sender);
			console.log(receiver);
			console.log(message);
			let obj = {
				sender : sender,
				receiver : receiver,
				message : message
			};
			console.log(obj);
			if (!sender || !receiver || !message) {
				alert("오류");
				return false;
			}
			console.log(obj);
			noteService.send(obj, function(data) {
				console.log(data);
			})
		})

		noteService.getSendList(sender, function(data) {
			$(".sendList").html(getTableText(data));
		})
		noteService.getReceiveList(sender, function(data) {
			$(".receiveList").html(getTableText(data));
		})
		noteService.getReceiveCheckedList(sender, function(data) {
			$("#uncheckedNoteCount").text(data.length);
			$(".receiveCheckedList").html(getTableText(data));
		})
		
		$(".receiveList").on("click", "tr", function() {
			var noteno = $(this).find("td:first").text();
			//alert(noteno); 
			var rdate = $(this).find("td:last").text(); 
			console.log(rdate)
			console.log(typeof rdate);
			if(rdate && rdate === 'null') {
				console.log('event');
				noteService.receive(noteno , function(data) {
					console.log(data)
				})
			}
			/*noteService.receive(noteno , function(data) {
				console.log(data)
			}) */
		})
		
		function getTableText(data) {
	    	var str = "<tr>";
			str += "<th>쪽지번호</th>";
			str += "<th>발송자</th>";
			str += "<th>수신자</th>";
			str += "<th>발송시간</th>";
			str += "<th>수신시간</th>";
			str += "</tr>";
			for ( var i in data) {
				str += "<tr>";
				str += `<td>\${data[i].noteno}</td>`;
				str += `<td>\${data[i].sender}</td>`;
				str += `<td>\${data[i].receiver}</td>`;
				str += `<td>\${data[i].sdate}</td>`;
				str += `<td>\${data[i].rdate}</td>`;
				str += "</tr>";
			}
			return str;
		}
		

	})
    
</script>

</body>
</html>