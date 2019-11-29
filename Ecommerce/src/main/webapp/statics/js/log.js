function login() {
    var account = $('#TPL_username_1');
    var passwd = $('#TPL_password_1');
    var err_tip = $('p.error');
    var mess_displ = $('#J_Message');
    var rsapwd = $("#rsaPwd");
    var logBut = $('#J_SubmitStatic');



    var nameLen = account.val().length;
    var pwdLen = passwd.val().length;

    /*提示用户名和密码*/
    if(nameLen == 0 && pwdLen == 0){
        mess_displ.attr("style", "display: block")
        err_tip.text(TRLang.ERROR_NICK_PASSWORD_BLANK);
    }
    /*提示用户名*/
    else if(nameLen == 0){
        mess_displ.attr("style", "display: block")
        err_tip.text(TRLang.ERROR_NICK_BLANK);
    }
    /*提示密码未填写*/
    else if(pwdLen == 0){
        mess_displ.attr("style", "display: block")
        err_tip.text(TRLang.ERROR_PASSWORD_BLANK);
    }
    /*向服务器验证数据*/
    else{
        logBut.text(logBut.attr("data-ing"));
        var encrypt = new JSEncrypt();
        encrypt.setPublicKey($('#pubkey').val());
        rsapwd.val(encrypt.encrypt(passwd.val()));
        $.ajax({
            type: "GET",
            dataType: "json",
            url: "/Ecommerce/login-form",
            data: $("#J_Form").serialize(),
            success: function(result){
                if(result.code == 400){
                    mess_displ.attr("style", "display: block");
                    err_tip.text(result.message);
                    logBut.text("登 录");
                }
                else {
                    window.location.href = "/Ecommerce";
                }
            },
            error: function () {
                alert("wrong");
            },
        });
    }
}