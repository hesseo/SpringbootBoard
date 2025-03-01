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
    frm.submit();
}
function checkId(){
    var memId=document.form1.id.value;

    if(!memId){
        alert("아이디를 입력하세요")
        document.form1.id.focus();
        return false;
    }else{
        // target="": 새창으로 연다
        // window.open("../member/checkId?id="+memId, "_blank",'width=350, height=200, left=400, top=200');
    }
    if(!frm.pwd.value){
        alert("비밀번호를 입력하세요")
        return false;
    }
    memId.submit();
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