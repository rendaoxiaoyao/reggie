// ʹ��ECharts���Ƴɼ��ֲ���ͼ

// ��������
const scores = [90, 75, 80, 87, 95, 92, 60, 85, 88, 93];

// ��ʼ��ECharts���ҵ�����div
let chart = echarts.init(document.getElementById('chart'));

// ������
let option = {
    title: {
        text: '�ɼ��ֲ���ͼ',
        subtext: '����' + scores.length + '��ѧ���μӿ���'
    },
    tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b}: {c} ({d}%)'
    },
    legend: {
        orient: 'vertical',
        left: 10,
        data: ['������', '����', '����', '����']
    },
    series: [
        {
            name: '�ɼ��ֲ�',
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
                {value: scores.filter(score=>score<60).length, name: '������'},
                {value: scores.filter(score=>score>=60 && score<80).length, name: '����'},
                {value: scores.filter(score=>score>=80 && score<90).length, name: '����'},
                {value: scores.filter(score=>score>=90).length, name: '����'}
            ]
        }
    ]
};

// �����������ø�EChartsʵ��
chart.setOption(option);
