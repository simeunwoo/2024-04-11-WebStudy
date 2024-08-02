window.onload=()=>{ // 익명의 함수
	for(let i=1;i<=7;i++)
	{
		let img=document.createElement('img') // <img> => react
		img.src='m'+i+'.jpg' // img의 속성 추가
		img.width=200
		img.height=300
		img.title='영화명'
		// <img src="" width="" height="" title="">
		document.body.appendChild(img)
	}
}