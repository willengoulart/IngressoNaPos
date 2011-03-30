<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link href="<c:url value='/'/>/css/layout.css" rel="stylesheet"
	type="text/css" />
<link href="<c:url value='/'/>/css/jquery-ui.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="<c:url value='/'/>/js/jquery.js"></script>
<script type="text/javascript" src="<c:url value='/'/>/js/gdl.js"></script>
<script language="javascript" type="text/javascript"
	src="<c:url value='/'/>/js/interface.js"></script>
<script language="javascript" type="text/javascript"
	src="<c:url value='/'/>/js/jquery-ui.js"></script>
<script language="javascript" type="text/javascript"
	src="<c:url value='/'/>/js/dateFormat.js"></script>
<script type="text/javascript">
$(function() {
	$(".column").sortable({
		connectWith: '.column',
		handle: $(".portlet-header")
	});

	$(".portlet").addClass("ui-widget ui-widget-content ui-helper-clearfix ui-corner-all")
		.find(".portlet-header")
			.addClass("ui-widget-header ui-corner-all")
			.prepend('<span class="ui-icon ui-icon-minusthick"></span>')
			.end()
		.find(".portlet-content");

	$(".portlet-header .ui-icon").click(function() {
		$(this).toggleClass("ui-icon-minusthick").toggleClass("ui-icon-plusthick");
		$(this).parents(".portlet:first").find(".portlet-content").toggle();
	});

	/*$(".column").disableSelection();*/

	$.datepicker.setDefaults($.datepicker.regional['pt-BR']);
	$("#calendario").datepicker({ maxDate: '+1m', onSelect: exibeTarefas });
	exibeTarefas(new Date().format("dd/mm/yyyy"));
	//exibeRelatorioTarefas();
	exibeEmpresaFiltro();
});

function exibeTarefas(data) {
	$("#tarefasPendentes").html("<img src='<c:url value='/'/>/images/load2.gif'>");
	$("#tarefasPendentes").load("tarefas/listaPendentes/"+data);
}

function exibeRelatorioTarefas() {
<c:if test="${usuarioSessao.usuario.perfil.getPerfilId() == 1}">
	$("#tarefasPendentes").html("<img src='<c:url value='/'/>/images/load2.gif'>");
	$("#relatorioTarefas").load("relatorios/tarefasPorAtendente");
</c:if>
}		

function exibeEmpresaFiltro() {
	$("#empresaFiltro").html("<img src='<c:url value='/'/>/images/load2.gif'>");
	$("#empresaFiltro").load("empresas/empresaFiltro");
}

$.ajaxSetup ({
    cache: false
});

</script>
</head>
<body>

<center>
<div id="principal">
<div id="menu"><%@ include file="../menu.jsp"%></div>
<div id="corpo" align="left">
<div style="height: 768px; width: 100%">
	<div class="column" style="width: 650px">
		<div class="portlet">
			<div class="portlet-header">Filtro</div>
			<div class="portlet-content">
				<div id="empresaFiltro" style="overflow:auto;">
				</div>
			</div>
		</div>
		<div class="portlet">
			<div class="portlet-header">Tarefas pendentes
			</div>
			<div class="portlet-content">
				<div id="tarefasPendentes" style="overflow:auto; height: 150px">
				</div>
			</div>
		</div>
		<c:if test="${usuarioSessao.usuario.perfil.getPerfilId() == 1}">
			<div class="portlet">
				<div class="portlet-header">Tarefas por Atendente
				</div>
				<div class="portlet-content">
					<div id="relatorioTarefas" style="overflow:auto; height: 250px">
					</div>
				</div>
			</div>
		</c:if>
	</div>
	<div class="column" style="width: 230px; float: left;">
		<div class="portlet">
			<div class="portlet-header">Usu�rio</div>
			<div class="portlet-content">${usuarioSessao.usuario.nome}</div>
		</div>
		<div class="portlet">
			<div class="portlet-header">Calend�rio</div>
			<div class="portlet-content"><div id="calendario"></div></div>
		</div>
	</div>
</div>
</div>

<div><%@ include file="../rodape.jsp"%></div>
</div>

</center>

</body>