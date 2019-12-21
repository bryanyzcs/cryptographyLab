function orderPay(){
    var payAccount= $("#form-payAccount");
    var payName = $("#form-name");
    var payPasswd = $("#form-passwd");
    var input_tip = $('div.input-tip span');
    var flag = 1;

    if(payAccount.val().length == 0){
        $(input_tip.get(0)).html("<i class='i-error'></i>请填写账号信息");
        flag = 0;
    }
    else{
        $(input_tip.get(0)).html("");
    }
    if(payName.val().length == 0){
        $(input_tip.get(1)).html("<i class='i-error'></i>请填写付款账户信息");
        flag = 0;
    }
    else{
        $(input_tip.get(1)).html("");
    }
    if(payPasswd.val().length==0){
        $(input_tip.get(2)).html("<i class='i-error'></i>请填写密码");
        flag=0;
    }
    else{
        $(input_tip.get(2)).html("");
    }
    if (flag==0)
        return false;

    $.ajax({
        type: "POST",
        dataType: "json",
        url: "/banksystem/pay?method=paycommit",
        data: $("#transfer-form").serialize(),
        success: function(result){
            if(result.code == 200){
                window.location.href = "/banksystem/method=showreturn";
            }
            else {
                mess_displ.attr("style", "display: block");
                err_tip.text(result.message);

            }

        },
        error: function () {
            alert("wrong");
        },
    });
    // $.ajax({
    //     type: "GET",
    //     dataType: "json",
    //     url: "/banksystem/pay?method=paycommit",
    //     data: $("#transfer-form").serialize(),
    //     success: function(result){
    //         if(result.code == 200){
    //             window.location.href = "/banksystem/transfer-confirm";
    //         }
    //         else {
    //             $(input_tip.get(0)).html("<i class='i-error'></i>" + result.message);
    //         }
    //
    //     },
    //     error: function () {
    //         alert("wrong");
    //     },
    // });
    //document.getElementById('transfer-form').submit();


}