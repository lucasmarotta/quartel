$(function(){

	var dataTableBr = {
	    emptyTable: "Nenhum registro encontrado",
	    info: "de _START_ até _END_ de _TOTAL_ registros",
	    infoEmpty: "0 até 0 de 0 registros",
	    infoFiltered: "(Filtrados de _MAX_ registros)",
	    infoPostFix: "",
	    infoThousands: ".",
	    lengthMenu: "_MENU_ QTD Por Página",
	    loadingRecords: "Carregando...",
	    processing: "Processando...",
	    zeroRecords: "Nenhum registro encontrado",
	    search: "Pesquisar",
	    paginate: {
	        next: "Próximo",
	        previous: "Anterior",
	        first: "Primeiro",
	        last: "Último"
	    },
	    aria: {
	        sortAscending: ": Ordenar colunas de forma ascendente",
	        sortDescending: ": Ordenar colunas de forma descendente"
	    }
	};

	$('.table').DataTable({language:dataTableBr});
});