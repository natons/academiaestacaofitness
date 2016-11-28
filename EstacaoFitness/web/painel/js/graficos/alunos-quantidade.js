$(function () {
    $('#grafico-alunos-quantidade').highcharts({
        chart: {
            type: 'pie',
            options3d: {
                enabled: true,
                alpha: 45
            }
        },
        title: {
            text: '2015'
        },
        subtitle: {
            text: 'Quantidade de Alunos por Mês'
        },
        plotOptions: {
            pie: {
                innerSize: 100,
                depth: 45
            }
        },
        series: [{
            name: 'Quantidade de Alunos',
            data: [
                ['Janeiro', 20],
                ['Fevereiro', 78],
                ['Março', 55],
                ['Abril', 44],
                ['Maio', 30],
            ]
        }]
    });
});