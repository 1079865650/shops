var base = "http://localhost/onl"
    //个人中心
function personal() {
    if (localStorage.getItem("token") == null || localStorage.getItem("token") === "") {
        location.href = "login.html"
    } else {
        location.href = "uc.html"
    }
}

function myOrder() {
    if (localStorage.getItem("token") == null || localStorage.getItem("token") === "") {
        location.href = "login.html"
    } else {
        location.href = "uc-order.html.html"
    }
}

function goCart() {
    if (localStorage.getItem("token") == null || localStorage.getItem("token") === "") {
        location.href = "login.html"
    } else {
        location.href = "cart.html"
    }
}

function ucorder() {
    if (localStorage.getItem("token") == null || localStorage.getItem("token") === "") {
        location.href = "login.html"
    } else {
        location.href = "uc-order.html"
    }
}

function logout() {
    var token = localStorage.getItem("token");
    $.ajax({
        headers: { token },
        url: base + "/sys/user/logout",
        type: "get",
        success: function(data) {
            location.href = "login.html";
        }
    })
    localStorage.clear()
}

var token = localStorage.getItem("token")

function getCartNums() {
    $.ajax({
        headers: { token },
        url: base + "/cart/findNumber",
        success: function(res) {
            $("#cartNums").html(res.data.nums);
            console.log("更新购物车数量成功:" + res.data.nums)
        }
    })
}



//获取URL里面的参数方法
function getQueryVariable(variable) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        if (pair[0] == variable) {
            return pair[1];
        }
    }
    return (false);
}

/*var shid = getQueryVariable("shid");*/