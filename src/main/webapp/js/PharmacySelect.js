
$(".PSmnext").on("click",function(){
    if($(".PSmidInput").val()==""){
        alert('주소를 입력해주세요')
    }

});


$("#searchPharmBtn").on("click",function(){
	const addr = $("#inpAddr").val();
	$.ajax({
               url : "/searchAroundPharm.do",
               type : "get",
               data : {addr : addr},
               dataType:"JSON",
               success : function(list){
				const table = $("<table>");
				console.log(list);	
				$("#newTbl").empty();		
				for(let i=0; i<list.length; i++){
					const tr = $("<tr onclick='showAddr(this);'> ");
						const td1 = $("<td>");
						const title = list[i].pharmTitle;
						td1.append(title);
						const td2 = $("<td>");
						const phone = list[i].pharmPhone;
						td2.append(phone);
						const td3 = $("<td class='pharm'>");
						const addr = list[i].pharmAddr;
						td3.append(addr);
					
					tr.append(td1).append(td2).append(td3);
					table.append(tr);
				} // for
		   const inptable = $(".inpTbl");
		   inptable.append(table);
				 // if끝
	        	} // success끝
    		}) // .ajax끝
}); // 끝

function showAddr(obj){	
	
	const tblAddr = ($(obj).children().last().text());
	console.log(tblAddr);
	$(".PSmidsearchResult").text(tblAddr);
}

