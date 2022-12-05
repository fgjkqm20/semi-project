
const reqjs1= $("#reqjs1");
const reqjs2= $("#reqjs2");
const reqjs3= $("#reqjs3");
const reqjs4= $("#reqjs4");

$(".qibtn").on("click",function(){
   if($(reqjs2).val()==""){
		alert('전화번호를 입력해주세요');
    }else if($(reqjs3).val()==""){
        alert('수령인주소 입력해주세요');
    }else if($(reqjs4).val()==""){
        alert('상세주소를 입력해주세요');
    }else{
        Swal.fire({
        title: '신청이 완료되었습니다',
          text: '',
          imageUrl: '/img/mainmain.jpg',
          imageWidth: 400,
          imageHeight: 200,
          imageAlt: 'Custom image',
          
      }).then(function(){
            location.href = '/';
      });
      
    }
    
    
        
});

