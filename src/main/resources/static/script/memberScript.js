function checkMember(){
    var frm=document.form1;
    if(!frm.name.value){
        alert("이름을 입력하세요")
        return false;
    }
    if(!frm.id.value){
        alert("아이디를 입력하세요")
        return false;
    }
    if(!frm.pwd.value){
        alert("비밀번호를 입력하세요")
        return false;
    }
    if (frm.pwd.value != frm.repwd.value){
        alert("비밀번호를 확인해주세요");
        return false;
    }
    if (!frm.tel1.value||!frm.tel2.value||!frm.tel3.value){
        alert("전화번호를 입력해주세요");
        return false;
    }
    frm.submit();
}
function checkId(){
    var memId=document.form1.id.value;

    if(!memId){
        alert("아이디를 입력하세요")
        document.form1.id.focus();
        return false;
    }else{
        // AJAX 요청
        fetch(`checkId?id=${memId}`)
            .then(response => response.json())
            .then(data => {
                if (data.result) {
                    alert("사용 가능한 아이디입니다.");
                } else {
                    alert("이미 존재하는 아이디입니다.");
                    return false; // 폼 제출 방지
                }
            })
            .catch(error => console.error("Error:", error));
    }
}
function loginMember(){
    var frm=document.form1;
    if(!frm.id.value){
        alert("아이디를 입력하세요")
        return false;
    }
    if(!frm.pwd.value){
        alert("비밀번호를 입력하세요")
        return false;
    }
    frm.submit();
}

function modifyMember() {
    var frm=document.form1;
    if(!frm.name.value){
        alert("이름을 입력하세요")
        return false;
    }
    if(!frm.pwd.value){
        alert("비밀번호를 입력하세요")
        return false;
    }
    if (frm.pwd.value != frm.repwd.value){
        alert("비밀번호를 확인해주세요");
        return false;
    }
    frm.submit();
}