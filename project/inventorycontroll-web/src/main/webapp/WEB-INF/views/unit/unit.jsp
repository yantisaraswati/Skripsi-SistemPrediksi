<tiles:insertDefinition name="layouts">
    <tiles:putAttribute name="body">
		<h1>Master Satuan (${totalCount} data)</h1>
		<form:form action="${pageContext.request.contextPath}/unit/load" modelAttribute="unitForm">
			<div class="card" id="card-request">
			    <div class="card-body">
			        <table style="width:100%;table-layout:fixed;">
			            <thead>
			                <tr>
			                    <th>Nama Satuan</th>
					            <th>Dibuat Tanggal</th>
					            <th>Dibuat Oleh</th>
			                </tr>
			                
			                <c:forEach var="item" items="${unitForm.unitList}" varStatus="i">
			                    <tr>
			                        <td>${item.param}</td>
			                        <td class="_center"><fmt:formatDate pattern="dd MMM yyyy" value="${item.createdDate}" /></td>
			                        <td>${item.createdBy}</td>
			                    </tr>
		                    </c:forEach>
			            </thead>
			        </table>
			        
			        <div class="pull-right">
						<t:pagination innerElement="span"
    						disabledClass="disabled"
							previousLinkText="Prev"
						    nextLinkText="Next"
						    maxDisplayCount="0"
						    firstLinkText=""
						    lastLinkText=""
							criteriaQuery="${f:query(unitForm.unitList)}" page="${pagination}" pathTmpl="${pageContext.request.contextPath}/unit/load" />
					</div>
			
			    </div>
			</div>
		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>

<script type="text/javascript">
	$("span").addClass("btn btn-default");
    $("#link-satuan").addClass("active");
</script>