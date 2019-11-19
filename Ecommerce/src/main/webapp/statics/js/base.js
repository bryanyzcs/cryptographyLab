$(function () {
   var accountInput = $('#form-account');
   accountInput.click(function() {
      $('div.input-tip span').html(accountInput.attr("default"))
   });
});