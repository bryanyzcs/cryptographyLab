function transfer(){
    var payAccount= $("#form-payAccount");
    var money = $("#form-money");
    var recvName = $("#form-recvName");
    var recvAccount = $("#form-recvAccount");
    var input_tip = $('div.input-tip span');
    var flag = 1;

    if(payAccount.val().length == 0){
        $(input_tip.get(0)).html("<i class='i-error'></i>请填写账号信息");
        flag = 0;
    }
    else{
        $(input_tip.get(0)).html("");
    }

    if(money.val().length == 0){
        $(input_tip.get(1)).html("<i class='i-error'></i>请输入金额");
        flag = 0;
    }
    else if(/^0*\.0*$/.test(money.val())){
        $(input_tip.get(1)).html("<i class='i-error'></i>金额不正确");
    }
    else{
        $(input_tip.get(1)).html("");
    }

    if(recvName.val().length == 0){
        $(input_tip.get(3)).html("<i class='i-error'></i>请填写收款账户信息");
        flag = 0;
    }
    else{
        $(input_tip.get(0)).html("");
    }
    if(recvAccount.val().length == 0){
        $(input_tip.get(4)).html("<i class='i-error'></i>请填写收款方卡号信息");
        flag = 0;
    }
    else{
        $(input_tip.get(0)).html("");
    }
    if(flag == 0){
        return false;
    }
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "/banksystem/transfer-form",
        data: $("#transfer-form").serialize(),
        success: function(result){
            if(result.code == 200){
                window.location.href = "/banksystem/transfer-confirm";
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
