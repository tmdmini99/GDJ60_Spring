const btn=document.getElementById("btn");
const di=document.getElementById("di");
const inp1 = document.getElementById("inp1");
const inp2 = document.getElementById("inp2");
const inp3 = document.getElementById("inp3");
const comment = document.getElementById("comment");

const pageLink = document.querySelectorAll(".page-link");

const contentsConfirm = document.getElementById("contentsConfirm");

const closeModal = document.getElementById("closeModal");





//댓글 등록
btn.addEventListener("click",function(){
    console.log(btn.getAttribute('data-book-bookNumber'));
    
    //JS에서 사용할 가상의 Form 태그 생성
    const form = new FormData(); // == <form></form>
    form.append("contents",inp3.value);//<form><input type="text" name="contents" value="dfds"> </form>
    form.append("bookNumber",btn.getAttribute('data-book-bookNumber'));//<form><input type="text" name="contents" value="dfds"> <input type="text" name="bookNumber" value="dfds"></form>


    
    fetch("../bankBookComment/add",{
        method:"POST",
        //headers : {"Content-type": "application/x-www-form-urlencoded"},
        body:form
    }).then((response) => response.text()).then((res) =>{
            if(res.trim()==1){
                alert("댓글이 등록되었습니다");
                inp3.value="";
                getList(1);
            }else{
                alert("댓글이 등록실패");
            }
    }).catch(()=>{
        console.log("error 발생");
    })
    
    
    // let xhttp = new XMLHttpRequest();
    // xhttp.open("POST","../bankBookComment/add");
    // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    
    // console.log(btn.getAttribute("data-book-bookNumber"));
    // //xhttp.send("bookNumber="+inp1.value+"&writer="+inp2.value+"&contents="+inp3.value);
    // xhttp.send("contents="+inp3.value+"&bookNumber="+btn.getAttribute('data-book-bookNumber'));
    
    // xhttp.addEventListener("readystatechange",function(){
    //     if(this.readyState==4 && this.status==200){
    //         //di.innerText=this.responseText.trim();
    //         if(this.responseText.trim() !=null){
    //             //alert("댓글이 등록되었습니다");
    //             inp3.value="";
    //             getList(1);
    //             //comment.innerHTML=getList().responseText.trim();
                
    //         }else{
    //             alert("댓글이 등록실패");
    //         }
    //     }
    // });
    
});
getList(1);

function getList(page){
    
    let count  =0;
    
    fetch("../bankBookComment/list?bookNumber="+btn.getAttribute('data-book-bookNumber')+"&page="+page,{
        method:"GET"
        //GET과 HEAD 메서드는 body 속성을 가질수 없다
    }).then((response)=>response.text()).then((res)=>{
        comment.innerHTML=res.trim();
    });

    // let xhttp = new XMLHttpRequest();
    // xhttp.open("GET","../bankBookComment/list?bookNumber="+btn.getAttribute('data-book-bookNumber')+"&page="+page);
    
    // xhttp.send();
    // xhttp.addEventListener("readystatechange",function(){
        
    //     if(this.readyState==4 && this.status==200){
    //         comment.innerHTML=this.responseText.trim();
    //         count++;
    //     }
    // })
    //0이 출력 : 비동기 방식이기 때문에
    console.log("count : ",count);
}




pageLink.forEach(function(p){
    console.log("p :",p);
});





// const pageFirst = document.getElementById("pageFirst");
// const pageLast = document.getElementById("pageLast");
// const pageBefore = document.getElementById("pageBefore");
// const pageAfter = document.getElementById("pageAfter");









// comment.addEventListener("click",function(e){
      
//    if(e.target.classList.contains('btns')){
//         let a = e.target.getAttribute("data-page");
//         getList(a);
//         // let xhttp = new XMLHttpRequest();
//         // xhttp.open("GET","../bankBookComment/list?page="+a+"&bookNumber="+btn.getAttribute('data-book-bookNumber'));
//         // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
//         // xhttp.send();
//         // xhttp.addEventListener("readystatechange",function(){
//         //     if(this.readyState==4 && this.status==200){
//         //         comment.innerHTML=this.responseText.trim();
//         //     }
//         // });

//    } 
//     if(e.target.classList.contains('pageFirst')){
//         getList(0);
//    }if(e.target.classList.contains('pageBefore')){
//         let a = e.target.getAttribute("data-page-before");
//         getList(a);
//    }if(e.target.classList.contains('pageAfter')){
//         let a = e.target.getAttribute("data-page-after");
//         getList(a);
//    }if(e.target.classList.contains('pageLast')){
//         let a = e.target.getAttribute("data-page-total");
//         getList(a);
//    }
// });

comment.addEventListener("click",function(e){
    let pageLink = e.target;
    if(pageLink.classList.contains("page-link")){
        let page=pageLink.getAttribute("data-board-page");
        getList(page);
    }

    
});
//delete
comment.addEventListener("click",function(e){
    let del = e.target;
    
    if(del.classList.contains("dt")){
        
         let res=fetch("../bankBookComment/delete", {
            method:'POST',
            headers :{
                "Content-type": "application/x-www-form-urlencoded"
            },
            body:"num="+del.getAttribute('data-delete')
            //응답객체에서 Data 추출
        }).then((response=>response.text()))//then(function(response){return response.text()})
        //추출한 Data 사용
          .then((res)=>{
            if(res.trim()>0){
                alert("댓글이 삭제되었습니다");
                    getList(1);
            }else{
                alert("삭제 실패");
            }
          }).catch(()=>{alert("오류")});
        // console.log("삭제 버튼");
        // let xhttp = new XMLHttpRequest();
        // xhttp.open("POST","../bankBookComment/delete");
        // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        // xhttp.send("num="+del.getAttribute('data-delete'));
        //  xhttp.addEventListener("readystatechange",function(){
        //     if(this.readyState==4 && this.status==200){
        //         let result = this.responseText.trim();
        //         if(result>0){
        //             alert("댓글이 삭제되었습니다");
        //             getList(1);
        //         }else{
        //             alert("삭제 실패");
        //         }
                
        //     }
        // })
        
    }
    
    
});


// comment.addEventListener("click",function(e){
//     let up = e.target;
    
//     if(up.classList.contains("up")){
        
    
//         let xhttp = new XMLHttpRequest();
//         xhttp.open("GET","../bankBookComment/update?contents="+up.getAttribute("data-contents")+"&num="+up.getAttribute('data-update'));
        
//         xhttp.send();
//          xhttp.addEventListener("readystatechange",function(){
//             if(this.readyState==4 && this.status==200){
//                 comment.innerHTML= this.responseText.trim();
                
                
//             }
//         })
        
//     }
    
   
// });
//update
comment.addEventListener("click",function(e){
    
    let up = e.target;
    
    
    // if(up.classList.contains("upbtn")){
        
    //     fetch("../bankBookComment/update",{
    //         method:"POST",
    //         headers:{"Content-type": "application/x-www-form-urlencoded"},
    //         body:"num="+up.getAttribute('data-update')+"&contents="+document.getElementById("update").value
    //     }).then((data)=>data.text()).then((res)=>{
    //                     if(result>0){
    //                         alert("수정 성공");
                            
    //                     }else{
    //                         alert("수정 실패");
    //                     }
    //                     getList(1);
            
    //     });

        // let xhttp = new XMLHttpRequest();
        // xhttp.open("POST","../bankBookComment/update");
        // xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        // xhttp.send("num="+up.getAttribute('data-update')+"&contents="+document.getElementById("update").value);
        //  xhttp.addEventListener("readystatechange",function(){
        //     if(this.readyState==4 && this.status==200){
        //         let result = this.responseText.trim();
        //         console.log("result는 :",this.responseText.trim());
        //         if(result>0){
        //             alert("수정 성공");
                    
        //         }else{
        //             alert("수정 실패");
        //         }
        //         getList(1);
                
        //     }
        // })
        
    //}  
});

//update Get

comment.addEventListener("click",function(e){
    
    let updateButton = e.target;
    
    
    if(updateButton.classList.contains("up")){
 
        //console.log(updateButton.parentNode.previousSibling.previousSibling.previousSibling.previousSibling);
        let num = updateButton.getAttribute("data-update");
        let contents=document.getElementById("contents"+num);//td
        let contentsTextArea=document.getElementById("contents");//Modal textarea
        contentsTextArea.value=contents.innerText;
        contentsConfirm.setAttribute("data-update",num);
    }  

    e.preventDefault();
});

//update Post
//then 뒤에 매개변수는 내가 원하는 값 넣으면 됨
contentsConfirm.addEventListener("click",function(){
    console.log("Update Post");
    let updateContents = document.getElementById("contents").value;
    let num = contentsConfirm.getAttribute("data-update");

    fetch("../bankBookComment/update",{
        method:"POST",
        headers:{"Content-type": "application/x-www-form-urlencoded"},
        body:"num="+num+"&contents="+updateContents
    }).then((response)=>response.text()).then((res)=>{
                            if(res.trim()>0){
                                alert("수정 성공");
                                getList(1);
                                closeModal.click();
                            }else{
                                alert("수정 실패");
                            }
                            
                
            });


    // let xhttp = new XMLHttpRequest();
    //     xhttp.open("POST","../bankBookComment/update");
    //     xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //     xhttp.send("num="+num+"&contents="+updateContents);
    //      xhttp.addEventListener("readystatechange",function(){
    //         if(this.readyState==4 && this.status==200){
    //             let result = this.responseText.trim();
    //             if(result>0){
    //                 alert("수정 성공");
    //                 getList(1);
    //                 closeModal.click();
    //             }else{
    //                 alert("수정 실패");
    //             }
                
    //         }
    //     })


});


