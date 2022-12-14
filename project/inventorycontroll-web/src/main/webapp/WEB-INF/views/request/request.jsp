<tiles:insertDefinition name="layouts">
    <tiles:putAttribute name="body">
		<h1>Permintaan Bidang (${totalCount} data)</h1>
		<form:form action="${pageContext.request.contextPath}/request/load" modelAttribute="requestForm">
			<div class="card" id="card-request">
			    <div class="card-body">
			        <table style="width:100%;table-layout:fixed;">
			            <thead>
			                <tr>
			                    <th style="width:20%;">Tanggal Permintaan</th>
			                    <th style="width:20%;">Bidang</th>
			                    <th style="width:40%;">Item yang diminta</th>
			                    <th style="width:20%;">Jumlah</th>
			                </tr>
			                
			                <c:forEach var="request" items="${requestForm.requestList}" varStatus="i">
			                    <tr style='background-color: ${i.index%2==0 ? "#f5d6e6" : "#f2f2f2"}'>
			                        <td rowspan="${request.requestItems.size()}" style="width:20%;" class="_center"><fmt:formatDate pattern="dd MMM yyyy" value="${request.requestDate}" /></td>
			                        <td rowspan="${request.requestItems.size()}" style="width:40%;">${request.organization}</td>
			                        <td style="width:40%;">${request.requestItems[0].itemName}</td>
			                        <td style="width:20%;" class="_center">${request.requestItems[0].quantity}</td>
			                    </tr>
			                    <c:forEach var="idx" begin="1" end="${request.requestItems.size() - 1}">
			                    	<tr style='background-color: ${i.index%2==0 ? "#f5d6e6" : "#f2f2f2"}'>
				                        <td style="width:40%;">${request.requestItems[idx].itemName}</td>
				                        <td style="width:20%;" class="_center">${request.requestItems[idx].quantity}</td>
			                        </tr>
			                    </c:forEach>
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
							criteriaQuery="${f:query(requestForm.requestList)}" page="${pagination}" pathTmpl="${pageContext.request.contextPath}/request/load" />
					</div>		
			    </div>
			</div>
		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>

<script type="text/javascript">
	$("span").addClass("btn btn-default");
    $("#link-permintaan").addClass("active");
</script>