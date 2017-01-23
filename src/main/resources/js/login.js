/*jQuery(document).ready(function ($) {
    $('#loginform').submit(function (event) {
        event.preventDefault();
        var data = 'username=' + $('#username').val() + '&password=' + $('#password').val();
        $.ajax({
            data: data,
            timeout: 1000,
            type: 'POST',
            url: '/'

        }).success(function(data, textStatus, jqXHR) {
            alert("success!");
            //window.location = preLoginInfo.url;

        }).error(function(jqXHR, textStatus, errorThrown) {
            alert('Booh! Wrong credentials, try again!');
        });
    });
});*/