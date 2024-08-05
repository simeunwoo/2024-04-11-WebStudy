let httpRequest=null
// 브라우저에 내장 => XMLHttpRequest : 브라우저 => 서버 요청 => 결과값을 읽어 오는 클래스
function getXMLHttpRequest(){
	if(window.getXMLHttpRequest)
	{
		return new XMLHttpRequest()
	}
	else
	{
		return null
	}
}
function sendRequset(url,params,callback,method){
	httpRequest=getXMLHttpRequest()
	let httpMethod=method?method:'GET'
	if(httpMethod!='GET'&&httpMethod!='POST')
	{
		httpMethod='GET'
	}
	
	// 메소드 방식 지정
	let httpParams=(params==null||params=="")?null:params
	let httpUrl=url
	if(httpMethod=='GET'&&httpParams!=null) // 전송할 값이 있다면
	{
		httpUrl=httpUrl+"?"+httpParams
	}
	
	// 서버 연결 => open
	httpRequest.open(httpMethod,httpUrl,true) // true => 비동기
	// 한글 처리
	httpRequest.setRequsetRequestHeader('Content-Type','application/x-www-form-urlencoded')
	// 자동 호출 함수 지정
	httpRequest.onreadystatechange=callback
	// 데이터 전송
	httpRequest.send(httpMethod=='POST'?httpParams:null)
	/*
		$.ajax({
			type:GET,
			url:
			data:
			success:function(){
				
			}
		})
		// 일반 Ajax
		
		axios.get('',{
			
		}).then(function(){
			
		})
		// Ajax 포함
	*/
}