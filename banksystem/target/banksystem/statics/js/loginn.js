function login() {
    var account = $("#form-account");
    var input_tip = $('div.input-tip span');
    var pwd = $("#form-pwd");
    var nameLen = account.val().length;
    if (nameLen == 0) {

        $(input_tip.get(0)).html("<i class='i-error'></i>请输入用户名");
        return false;
    }
    var pwdLen = pwd.val().length;
    if(pwdLen == 0){
        $(input_tip.get(1)).html("<i class='i-error'></i>请输入密码");

        return false;
    }
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "/banksystem/login-form",
        data: $("#loginn-form").serialize(),
        success: function (result) {
            if (result.code == 400) {
                alert(result.message);
            } else {
                window.location.href = "//localhost:8080/banksystem/findUser";
            }

        },
        error: function () {
            alert("wrong");
        },
    });
}