// 假设这是从后端获取的学生成绩数组
const scores = [];
let segmentCounts = [0, 0, 0, 0, 0]; // 记录每个成绩段的人数

let ctx = document.getElementById('count').getContext('2d');
let myChart
let myCharta
// 根据条件查询数据，并显示分页查询数据
function showData(page) {
    // 划分成绩段并计算人数、平均分、最高分等信息

    let segmentRanges = ["0~60", "60~80", "80~89", "90~99", "100"]; // 每个成绩段的分数范围
    let maxScore = 0;
    let totalScore = 0;

    var url = "";
    url += "/Student/SearchScoreServlet?search_type=" + $("#search_type").val();
    url += "&value=" + encodeURI(encodeURI($("#value").val())) + "&page="
        + -1;


    $.post(url, null, function(rs) {
console.log(rs)
        for ( var i = 0; i < rs.length; i++) {
            let score=0
            if(page==='daily'){
                score=parseInt(rs[i].daily)
            }else if(page==='count'){
                score=parseInt(rs[i].count)
            }else{
                score=parseInt(rs[i].exam)
            }
            scores.unshift(score)
            // alert(score)
            if (score < 60) {
                segmentCounts[0]++;
            } else if (score >= 60 && score <= 79) {
                segmentCounts[1]++;
            } else if (score >= 80 && score <= 89) {
                segmentCounts[2]++;
            } else if (score >= 90 && score <= 99) {
                segmentCounts[3]++;
            } else if (score === 100) {
                segmentCounts[4]++;
            }

            // 更新最高分和总分
            if (score > maxScore) {
                maxScore = score;
            }
            totalScore += score;
        }
        console.log(segmentCounts)

        const averageScore = totalScore / scores.length; // 平均分

// 使用Chart.js创建扇形图
        ctx = document.getElementById('count').getContext('2d');
        const chartData = {
            labels: segmentRanges,
            datasets: [{
                label: '成绩分布',
                data: segmentCounts,
                backgroundColor: [
                    'rgba(255, 99, 132, 0.6)',
                    'rgba(54, 162, 235, 0.6)',
                    'rgba(255, 206, 86, 0.6)',
                    'rgba(75, 192, 192, 0.6)',
                    'rgba(153, 102, 255, 0.6)'
                ]
            }]
        };
        const options = {
            responsive: true,
            maintainAspectRatio: false,
            legend: {
                position: 'right'
            },
            title: {
                display: true,
                text: '成绩分布统计图'
            }
        };
        myChart = new Chart(ctx, {
            type: 'pie',
            data: chartData,
            options: options
        });
    }, "json");


}
const cs=['count','daily','exam']


// AJAX异步查询成绩
$(function() {
    $("#search_score").click(
        function() {
            if ($("#search_type").val() != "stu_all"
                && $.trim($("#value").val()) == "")
                alert("请输入关键字。");
            else {
                if(myChart instanceof Chart)
                {
                    myChart.destroy();
                }
                if(myCharta instanceof Chart)
                {
                    myCharta.destroy();
                }
                segmentCounts=[0,0,0,0,0]

                showData(cs[0])

                var timer = setTimeout(function () {
                    showB();
                }, 1000);
                showD()
            }


        });
});

function showB() {

    gradesData=segmentCounts
    const ctx = document.getElementById("myChart");
    myCharta = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['0-59', '60-79', '80-89', '90-99', '100'],
            datasets: [{
                label: '成绩分布直方图',
                data: gradesData,
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                yAxes: [{
                    ticks: {
                        beginAtZero: true
                    }
                }]
            }
        }
    });

}


// 根据条件查询数据，并显示分页查询数据
function showD() {
    var url = "";
    url += "/Student/SearchScoreServlet?search_type=" + $("#search_type").val();
    url += "&value=" + encodeURI(encodeURI($("#value").val())) + "&page="
        + -1;
    $.post(url, null, function(rs) {

        $("#table>tbody>tr").not(":first").remove();
        var str = "";
        let a=0,b,c
        let max=0,min=100
        for ( var i = 0; i < rs.length; i++) {

            a+=rs[i].count
            if(rs[i].count>max){
                max=rs[i].count
            }
            if(rs[i].count<min){
                min=rs[i].count
            }
        }
        let type=$("#search_type").val()==='stu_all'?'全部科目':$("#search_type").val()

        str = "<tr class='change' align='center'>";
        str += "<td>" + type + "</td>";
        str += "<td>" +rs.length + "</td>";
        str += "<td>" + a/rs.length + "</td>";
        str += "<td>" + min + "</td>";
        str += "<td>" + max + "</td>";
        $("#table").append(str);

    }, "json");
}
