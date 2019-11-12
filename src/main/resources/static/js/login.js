function loginoutcommon() {
    $.ajax({
        type: 'POST',
        url: "/loginout",
        data: {},
        success: function (data) {
            location.reload();
        },
        dataType: "json"
    });
}
function  getisLogin(username) {
    var result = false;
    $.ajax({
        type: 'POST',
        url: "/islogin",
        data: {"username":username},
        async: false,
        success: function (data) {
            result = data;
        },
        dataType: "json"
    });
    return result;
}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

function clearCookie(name) {
    setCookie(name, "", -1);
}
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++)
    {
        var c = ca[i].trim();
        if (c.indexOf(name)==0) return c.substring(name.length,c.length);
    }
    return "";
}
function GetUrlRelativePath()
{
    var url = document.location.toString();
    var arrUrl = url.split("//");

    var start = arrUrl[1].indexOf("/");
    var relUrl = arrUrl[1].substring(start);//stop省略，截取从start开始到结尾的所有字符

    if(relUrl.indexOf("?") != -1){
        relUrl = relUrl.split("?")[0];

    }
    return relUrl;
}
function isindex() {
    var url = GetUrlRelativePath().toString();
    if (url!=("/")&& url!=("/index")) {
        return "<a href='/index'>返回首页</a>";
    }
    return "";
}
function isLogin() {
    var usertext = "";
    usertext = isindex();
    if (getCookie("username") != "") {
        if (getisLogin(getCookie("username")) == true) {
             usertext+= "<b style='padding-left: 10px'>欢迎光临网上书城</b><a href= target=\"_self\" class=\"userCenter\">" + getCookie("username") + "</a><a href=\"javascript:void(0)\" class=\"userExit\" onclick=\"loginoutcommon();\">[安全退出]</a>";
            $(".loginArea").empty();
            $(".loginArea").append(usertext);
        } else {
            clearCookie("username");
        }

    }
}