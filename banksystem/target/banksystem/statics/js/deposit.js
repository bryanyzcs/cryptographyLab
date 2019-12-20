function deposit(){
    var saveAccount= $("#form-saveAccount");
    var money = $("#form-money");

    var savePasswd = $("#form-passwd");
    var input_tip = $('div.input-tip span');
    var err_tip = $('p.error');
    var mess_displ = $('#J_Message');
    var flag = 1;


    if(saveAccount.val().length == 0){
        $(input_tip.get(0)).html("<i class='i-error'></i>请填写卡号");
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

    if(savePasswd.val().length == 0){
        $(input_tip.get(2)).html("<i class='i-error'></i>请填写密码");
        flag = 0;
    }
    else{
        $(input_tip.get(2)).html("");
    }


    if(flag == 0){
        return false;
    }
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "/banksystem/deposit-form",
        data: $("#deposit-form").serialize(),
        success: function(result){
            if(result.code == 200){
                window.location.href = "/banksystem/deposit";
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



}
