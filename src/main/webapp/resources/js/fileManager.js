// const fileList = document.getElementById("fileList");
// const btn = document.getElementById("btn");




let clickCount=0;
let max=1;
let param='pic';
let idx=0;

function setName(p){
    param=p;
}

function setMax(m){
    max=m;
}
function setCount(c){
    clickCount=c;
}


$("#fileList").on("click",".del",function(){
    clickCount--;
    $(this).parent().remove();
    // let id=$(this).attr('data-id');
    // $("#"+id).remove();
    // $('#'+$(this).attr("data-id")).remove();
}) 
    


    
    
    // fileList.addEventListener("click",function(e){
        
    //     if(e.target.classList.contains('del')){
    //         clickCount--;
    //         console.log("클릭");
    //         // let id=e.target.getAttribute("data-id");
    //         // document.getElementById(id).remove(); 
    //         e.target.parentNode.remove();
    //     }

               
    // });



    $(".deleteCheck").click(function(){
        if($(this).prop("checked")){
            let result = confirm("파일이 영구 삭제됩니다");
            let ch = $(this);
            if(result){
                //아직 ajax안에 들어가지 않았기때문에 $(".deleteCheck")객체 자기 자신
                let fileNum = $(this).val();
                //ajax 안에 있는 $(this)는 ajax 객체 자기 자신
                $.ajax({
                    type:'POST',
                    url:'./boardFileDelete',
                    data:{
                        fileNum: fileNum
                    },
                    success:function(response){
                        if(response.trim()>0){
                            alert("삭제 완료");
                            //this : ajax 객체 자기자신
                            ch.parent().parent().remove();
                            console.log(ch);
                            clickCount--;
                        }else{
                            alert("삭제 실패<br> 관리자 문의 필요!");
                        }
                    },
                    error:function(){

                    }

                })
                //ajax DB 삭제
            //    fetch("URL?p=1" ,{
            //     method:'GET'
            //    }).then((response)=>response.text()).then((res)=>{
            //     res.trim()
            //    })
            
            // $.get("URL?p=1",function(response){
            //     //
            //     response.trim();
            // })

            // fetch("URL",{
            //     method:"POST",
            //     headers :{
            //         'Contents-Type':'X'
            //     },
            //     body:"p=1"
            // }).then((response)=>response.text()).then((res)=>{
            //         res.trim();
            //     })

            //parameter 안에 들어가는 값은 문자열 형식으로 쓸 필요가 없음 파라미터 값에 ''붙일 필요 x
            //     $.post("URL",{p:1},function(res){})

            // }else{
            //     $(this).prop("checked",false);
             }
        }
        else{
            
            if(clickCount==5){
                console.log(idx);
                
                idx--;
                $("#del"+idx).remove();
                return;
            }
           
            clickCount++;
        
        }
    });










// $(".deleteCheck").click(function(){
//     if($(this).prop("checked")){
//         let result = confirm("파일이 영구 삭제됩니다");
//         if(result){

//             clickCount--;
//         }else{
//             $(this).prop("checked",false);
//         }
//     }else{
        
//         if(clickCount==5){
//             console.log(idx);
            
//             idx--;
//             $("#del"+idx).remove();
//             return;
//         }
       
//         clickCount++;
    
//     }
// });



$("#btn").click((e)=>{
    

    if(clickCount>=max){
                alert("파일 추가는"+max+"만큼만 가능합니다");
                return;
                
        }
            
    clickCount++;
    let child ='<div class="mb-3 input-group" id="del'+idx+'">';
    child=child+'<input type="file" class="form-control" name="'+param+'">'
    child=child+'<button type="button" class="del btn btn-outline-danger" data-id="del'+idx+'">X</button></div>'
    $("#fileList").append(child);

    idx++;
});




// btn.addEventListener('click',function(event){
//     if(clickCount>=max){
//         alert("파일 추가는"+max+"만큼만 가능합니다");
//         return;
        
//     }
   
//     clickCount++;
   
//     console.log("click");
//     let div =document.createElement('div');
//    // let lab =document.createElement('label');
//     let inp=document.createElement('input');
//     let btn=document.createElement('button');
    
//     //div
//     let cl=document.createAttribute('class');
//     cl.value='mb-3 input-group';
//     div.setAttributeNode(cl);
//     cl =document.createAttribute('id');
//     cl.value='del'+idx;
//     div.setAttributeNode(cl);
    
    
    
//     //label
//     // let te = document.createTextNode('Image');
//     // let c2=document.createAttribute('class');
//     // c2.value='form-label';
//     // lab.setAttributeNode(c2);
//     // lab.appendChild(te);
//     // c2=document.createAttribute('for');
//     // c2.value='files';
//     // lab.setAttributeNode(c2);
    
//     //input    
//     let c3 =document.createAttribute('type');
//     c3.value='file';
//     inp.setAttributeNode(c3);
//     c3 =document.createAttribute('class');
//     c3.value='form-control';
//     inp.setAttributeNode(c3);
//     c3 =document.createAttribute('id');
//     c3.value='files';
//     inp.setAttributeNode(c3);
//     c3 =document.createAttribute('name');
//     c3.value=param;
//     inp.setAttributeNode(c3);

//     //button
//     c3 = document.createAttribute('type');
//     c3.value='button';
//     btn.setAttributeNode(c3);

//     c3=document.createAttribute('data-id');
//     c3.value='del'+idx;
//     btn.setAttributeNode(c3);
//     idx++;

//     c3 =document.createAttribute('class');
//     c3.value='del btn btn-outline-danger';
//     btn.setAttributeNode(c3);
    

//     te = document.createTextNode('X');
//     btn.appendChild(te);

    
//     //div.appendChild(lab); //div안에 label추가
//     div.appendChild(inp); //div 안에 input 추가
//     div.appendChild(btn);
//     fileList.prepend(div); //div file list안에 div를 새로 추가
    
// });