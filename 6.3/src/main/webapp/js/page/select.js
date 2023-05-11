function StudentDelete(id) {
    console.log(id)
    location.href="./students?id="+id+"&method=delete"
}

function StudentUpdate(id) {
    console.log(id)
    location.href="./students?id="+id+"&method=select&select=one"
}

function select() {
    msg=document.getElementById('msg').value;
    console.log(msg);
    if(msg==null||msg==""){
        location.href="./students?method=select";
    }else{
        location.href="./students?method=select&msg="+msg;
    }
}
function add() {
    location.href="./page/insert.jsp"
}


//初始化标签：
function initf() {
    //选择条数：<!--下拉选择条数：默认：15 50 100 200-->
    document.getElementById("page_s").innerHTML = "<select id='select_t' class='page_select' onchange='pageselect()'>" +
        "<option value='5'>5</option><option value='10'>10</option><option value='20'>20</option>" +
        "<option value='50'>50</option></select>";
    //跳转：
    var re_t = "";
    re_t += "到： <input class='inputc' id='inputs' type='text'/> 页 &emsp;";
    re_t += "<button  class='btc' onclick='return_bt()'>跳转</button>";
    document.getElementById("input_put").innerHTML = re_t;
}

//选择：
function pageselect() {
    var select_ct = document.getElementById("select_t");
    var vinfo = select_ct.options[select_ct.selectedIndex].value;
    setpage(1, vinfo);
}

//跳转
function return_bt() {
    var select_ct = document.getElementById("select_t");
    var vinfo = select_ct.options[select_ct.selectedIndex].value;
    var inp = document.getElementById("inputs").value;
    if (inp == "" || inp == null) {
        alert("请输入正整数。");
        inp = 1;
    }
    setpage(inp, vinfo);
}

function setpage(page, page_size) {

    //条数
    var table_row = document.getElementById("tableId");
    var info_num = table_row.rows.length;
    var total = 0;
    //单页条数
    var size = page_size;
    //总页数
    if (info_num / size > parseInt(info_num / size)) {
        total = parseInt(info_num / size) + 1;
    } else {
        total = parseInt(info_num / size);
    }
    //第N页
    var thispage = page;
    var first_row = (thispage - 1) * size + 1;
    var last_row = thispage * size;
    last_row = (last_row > info_num) ? info_num : last_row;
    //分页隐藏、显示：
    for (var i = 1; i < (info_num + 1); i++) {
        var row_bn = table_row.rows[i - 1];
        if (i >= first_row && i <= last_row) {
            row_bn.style.display = "block";
        } else {
            row_bn.style.display = "none";
        }
    }
    //条数
    document.getElementById("page_n").innerHTML = "第<strong>" + thispage + "</strong>页/共<strong>" + total + "</strong>页"
        + " &emsp;&emsp; 共<strong>" + info_num + "</strong>条 &emsp;";
    //首页 上一页：
    var p_num = "";
    if (thispage > 1) {
        p_num += "<button class='btc' onClick=setpage(" + (1) + "," + page_size + ")>首页</button>&emsp;&emsp;";
        p_num += "<button class='btc' onClick=setpage(" + (thispage - 1) + "," + page_size + ")>上一页</button>&emsp;&emsp;";
    } else {
        p_num += "<button class='btc'>首页</button>&emsp;&emsp;";
        p_num += "<button class='btc'>上一页</button>&emsp;&emsp;";
    }
    //生成数字显示：默认显示1 2 3 4 5 6
    var tt = 6;
    if (tt > total) {
        tt = total;
    }
    p_num += "<ul class='pagination'>";
    var te = 1;
    var d = thispage + 1;
    if (d > 6) {
        te = d;
        //当前页是否超显示数：
        for (var i = te; i <= (d + tt); i++) {
            //在总页数范围内。若超出，则不显示。
            if (i < total) {
                p_num += "<li><a onclick=setpage(" + (i) + "," + page_size + ")>" + i + "</a></li>";
            }
        }
    } else {
        for (var i = 1; i <= tt; i++) {
            p_num += "<li><a onclick=setpage(" + (i) + "," + page_size + ")>" + i + "</a></li>";
        }
    }
    p_num += "</ul>&emsp;&emsp;";
    //尾页 下一页
    if (thispage < total) {
        p_num += "<button class='btc' onClick=setpage(" + (thispage + 1) + "," + page_size + ")>下一页</button>&emsp;&emsp;";
        p_num += "<button class='btc' onClick=setpage(" + (total) + "," + page_size + ")> 尾页 </button>";

    } else {
        p_num += "<button class='btc'>下一页</button>&emsp;&emsp;";
        p_num += "<button class='btc'> 尾页 </button>";
    }
    document.getElementById("page_t").innerHTML = p_num;
}
