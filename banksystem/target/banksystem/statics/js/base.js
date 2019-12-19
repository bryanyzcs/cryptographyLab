$(function () {
    var input_tip =  $('div.input-tip span');
    var accountInput = $('#form-account');
    var pwdInput = $('#form-pwd');
    var repwdInput = $('#form-equalTopwd');

    /*提示账户输入信息格式*/
    accountInput.on({
        "focus": function() {
            $(input_tip.get(0)).html(accountInput.attr("default"));},
        "blur": function () {
            $(input_tip.get(0)).html("");}
    });

    /*提示密码输入信息格式*/
    pwdInput.on({
        "focus": function() {
            $(input_tip.get(1)).html(accountInput.attr("default"));},
        "blur": function () {
            $(input_tip.get(1)).html("");}
    });

    /*提示密码输入信息格式*/
    repwdInput.on({
        "focus": function() {
            $(input_tip.get(2)).html(accountInput.attr("default"));},
        "blur": function () {
            $(input_tip.get(2)).html("");}
    });
});