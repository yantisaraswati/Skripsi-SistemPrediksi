<tiles:insertDefinition name="layouts">
    <tiles:putAttribute name="body">
		<h1>Master Barang (${totalCount} data)</h1>
		<form:form action="${pageContext.request.contextPath}/item/load" modelAttribute="itemForm">
			<div class="card" id="card-request">
			    <div class="card-body">
			        <table style="width:100%;table-layout:fixed;">
			            <thead>
			                <tr>
			                    <th>Nama Barang</th>
					            <th>Satuan</th>
					            <th>Tanggal Barang Masuk</th>
					            <th>Dibuat Oleh</th>
			                </tr>
			                
			                <c:forEach var="item" items="${itemForm.itemList}" varStatus="i">
			                    <tr>
			                        <td>${item.itemName}</td>
			                        <td>${item.unit}</td>
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
							criteriaQuery="${f:query(itemForm.itemList)}" page="${pagination}" pathTmpl="${pageContext.request.contextPath}/item/load" />
					</div>
			
			    </div>
			</div>
		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>

<script type="text/javascript">
	$("span").addClass("btn btn-default");
    $("#link-barang").addClass("active");
</script>