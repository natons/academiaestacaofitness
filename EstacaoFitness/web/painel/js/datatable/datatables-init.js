var InitiateSimpleDataTablePequena = function () {
    return {
        init: function () {
            //Datatable Initiating
            var oTable = $('#editabledatatable').dataTable({
                "aLengthMenu": [
                    [5, 15, 20, 100, -1],
                    [5, 15, 20, 100, "All"]
                ],
                "iDisplayLength": 5,
                "sPaginationType": "bootstrap",
                "sDom": "Tflt<'row DTTTFooter'<'col-sm-6'i><'col-sm-6'p>>",
                "oTableTools": {
                    "aButtons": [
				        {
				            "sExtends": "copy",
				            "sButtonText": "Copiar"
				        },
				        "print",
				        {
				            "sExtends": "collection",
				            "sButtonText": "Salvar <i class=\"fa fa-angle-down\"></i>",
				            "aButtons": ["csv","xls","pdf"]
				        }
                                ],
                    "sSwfPath": "//cdn.datatables.net/tabletools/2.2.2/swf/copy_csv_xls_pdf.swf"
                },
                "language": {
                    "sProcessing":   "Processando...",
                    "sLengthMenu":   "_MENU_",
                    "sZeroRecords":  "N&atilde;o foram encontrados resultados",
                    "sInfo":         "Mostrando de _START_ at&eacute; _END_ de _TOTAL_ registros",
                    "sInfoEmpty":    "Mostrando de 0 at&eacute; 0 de 0 registros",
                    "sInfoFiltered": "(filtrado de _MAX_ registros no total)",
                    "sInfoPostFix":  "",
                    "sSearch":       "",
                    "sUrl":          "",
                    "oPaginate": {
                        "sFirst":    "Primeiro",
                        "sPrevious": "Anterior",
                        "sNext":     "Seguinte",
                        "sLast":     "&Uacute;ltimo"
                    }
                }
            });
        }

    };

}();

var InitiateEditableDataTable = function () {
    return {
        init: function () {
            //Datatable Initiating
            var oTable = $('#editabledatatable').dataTable({
                "aLengthMenu": [
                    [5, 15, 20, 100, -1],
                    [5, 15, 20, 100, "All"]
                ],
                "iDisplayLength": 5,
                "sPaginationType": "bootstrap",
                "dom": "Tflt<'row DTTTFooter'<'col-sm-6'i><'col-sm-6'p>>",
                "oTableTools": {
                    "aButtons": [
				        {
				            "sExtends": "copy",
				            "sButtonText": "Copiar"
				        },
				        "print",
				        {
				            "sExtends": "collection",
				            "sButtonText": "Salvar <i class=\"fa fa-angle-down\"></i>",
				            "aButtons": ["csv","xls","pdf"]
				        }
                                ],
                    "sSwfPath": "//cdn.datatables.net/tabletools/2.2.2/swf/copy_csv_xls_pdf.swf"
                },
                "language": {
                    "sProcessing":   "Processando...",
                    "sLengthMenu":   "_MENU_",
                    "sZeroRecords":  "N&atilde;o foram encontrados resultados",
                    "sInfo":         "Mostrando de _START_ at&eacute; _END_ de _TOTAL_ registros",
                    "sInfoEmpty":    "Mostrando de 0 at&eacute; 0 de 0 registros",
                    "sInfoFiltered": "(filtrado de _MAX_ registros no total)",
                    "sInfoPostFix":  "",
                    "sSearch":       "",
                    "sUrl":          "",
                    "oPaginate": {
                        "sFirst":    "Primeiro",
                        "sPrevious": "Anterior",
                        "sNext":     "Seguinte",
                        "sLast":     "&Uacute;ltimo"
                    }
                },
            });
        }
    };
}();
