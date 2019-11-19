function register(){
    var account= $("#form-account");
    var pwd = $("#form-pwd");
    var repwd = $("#form-equalTopwd");
    var rsapwd = $("#rsaPwd");
    var errno = $("#errno");

    var nameRe = "[\u4e00-\u9fa5_-A-za-z]+";
    var nameLen = account.val().length;
    if(nameLen < 4 || nameLen > 20){
        errno.innerText = "用户名错误，支持中文、英文、数字、“-”、“_”的组合，4-20个字符";
        return false
    }

    var pwdLen = pwd.val().length;
    if(pwdLen < 8 || pwdLen > 20){
        errno.text("密码格式错误， 建议使用字母、数字和符号两种及以上的组合，8-20个字符");
        return false;
    }
    if(pwd.val() !== repwd.val()){
        errno.text("两次输入的密码不一致请重新输入，请重新输入");
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
                alert(result.message);
            }
            else {
                errno.text(result.message);
            }

        },
        error: function () {
            alert("wrong");
        },
    });



}
