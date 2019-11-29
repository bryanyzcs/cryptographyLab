function register(){
    var account= $("#form-account");
    var pwd = $("#form-pwd");
    var repwd = $("#form-equalTopwd");
    var rsapwd = $("#rsaPwd");
    var input_tip = $('div.input-tip span');


    var nameRe = "[\u4e00-\u9fa5_-A-za-z]+";
    var nameLen = account.val().length;
    if(nameLen < 4 || nameLen > 20){
        $(input_tip.get(0)).html("<i class='i-error'></i>用户名不符合要求，请重试");
        pwd.val("");
        repwd.val("");
        return false;
    }

    var pwdLen = pwd.val().length;
    if(pwdLen < 8 || pwdLen > 20){
        $(input_tip.get(1)).html("<i class='i-error'></i>密码字符数不符合要求");
        pwd.val("");
        repwd.val("");
        return false;
    }
    if(pwd.val() !== repwd.val()){
        $(input_tip.get(1)).html("<i class='i-error'></i>两次输入的密码不一致，请重试");
        /*errno.text("两次输入的密码不一致请重新输入，请重新输入");*/
        pwd.val("");
        repwd.val("");
        return false;
    }
    var encrypt = new JSEncrypt();
    encrypt.setPublicKey($('#pubkey').val());
    rsapwd.val(encrypt.encrypt(pwd.val()));
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "/Ecommerce/register-form",
        data: $("#reg-form").serialize(),
        success: function(result){
            if(result.code == 200){
                window.location.href = "/Ecommerce";
            }
            else {
                $(input_tip.get(0)).html("<i class='i-error'></i>" + result.message);
            }

        },
        error: function () {
            alert("wrong");
        },
    });



}
