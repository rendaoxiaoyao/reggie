// 使用ECharts绘制成绩分布饼图

// 加载数据
const scores = [90, 75, 80, 87, 95, 92, 60, 85, 88, 93];

// 初始化ECharts，找到容器div
let chart = echarts.init(document.getElementById('chart'));

// 配置项
let option = {
    title: {
        text: '成绩分布饼图',
        subtext: '共有' + scores.length + '名学生参加考试'
    },
    tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b}: {c} ({d}%)'
    },
    legend: {
        orient: 'vertical',
        left: 10,
        data: ['不及格', '及格', '良好', '优秀']
    },
    series: [
        {
            name: '成绩分布',
            type: 'pie',
            radius: ['50%', '70%'],
            avoidLabelOverlap: false,
            label: {
                show: false,
                position: 'center'
            },
            emphasis: {
                label: {
                    show: true,
                    fontSize: '30',
                    fontWeight: 'bold'
                }
            },
            labelLine: {
                show: false
            },
            data: [
                {value: scores.filter(score=>score<60).length, name: '不及格'},
                {value: scores.filter(score=>score>=60 && score<80).length, name: '及格'},
                {value: scores.filter(score=>score>=80 && score<90).length, name: '良好'},
                {value: scores.filter(score=>score>=90).length, name: '优秀'}
            ]
        }
    ]
};

// 将配置项设置给ECharts实例
chart.setOption(option);
