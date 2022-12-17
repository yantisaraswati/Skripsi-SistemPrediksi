<tiles:insertDefinition name="layouts">
    <tiles:putAttribute name="body">
		<h1><i class="fa fa-cog fa-spin"></i> Proses Apriori</h1>
		<form:form action="${pageContext.request.contextPath}/apriori/decission" modelAttribute="aprioriForm">
			<div class="card">
			    <div class="card-body">
			        <div class="card-form">
			            <div class="card-label _20">Min Support (%) </div>
			            <div class="form-control _80">
			                : <input type="number" name="minSupport" min="1" max="100" required value="${aprioriForm.minSupport}"/>
			            </div>
			        </div>
			        <div class="card-form">
			            <div class="card-label _20">Min Confidence (%) </div>
			            <div class="form-control _80">
			                : <input type="number" name="minConfidence" min="1" max="100" required value="${aprioriForm.minConfidence}"/>
			            </div>
			        </div>
			        <div class="card-form">
			            <div class="card-label _20">Bidang </div>
			            <div class="form-control _80">
			                : <select name="organizationId">
                                <c:forEach var="organization" items="${organizationList}">
                                	<option value="${organization.organizationId}" ${organization.organizationId eq aprioriForm.organizationId ? 'selected' : ''}>${organization.organizationName}</option>
                                </c:forEach>
                            </select>
			            </div>
			        </div>
			        <div class="card-form">
			            <div class="card-label _20"></div>
			            <div class="card-label _80">
			                <div style="flex">
			                    <input type="submit" class="btn btn-success" name="load" value="Lihat Data"/>
			                    <input type="submit" class="btn btn-info" name="calculate" value="Proses Apriori">
			                </div>
			            </div>
			        </div>
			    </div>
			</div>
			
			<c:if test="${message != null}">
				<div class="alert-danger">
				    <i class="fa fa-warning"></i> Peringatan!<br />
				    <div class="alert-body">${message}</div>
				</div>
			</c:if>
			
			<c:if test="${!empty itemSetSupportList}">
				<div class="card">
				    <div class="card-header">
				        <div class="card-title">
				            <h2>Support Count (${itemSetSupportList.size()} hasil)</h2>
				        </div>
				    </div>
				    <div class="card-body">
				        <table>
						    <thead>
						        <tr>
						            <th>Tanggal Diproses</th>
						            <th>Bidang</th>
						            <th>K-Item</th>
						            <th>Daftar Barang</th>
						            <th>Support (%)</th>
						        </tr>
						    </thead>
						    <tbody>
							    <c:forEach var="itemSupport" items="${itemSetSupportList}">
							    	<tr>
					                    <td style="width:15%;" class="_center"><fmt:formatDate pattern="dd MMM yyyy" value="${itemSupport.createdDate}" /></td>
					                    <td style="width:25%;">${itemSupport.organization}</td>
					                    <td style="width:10%;">${itemSupport.KItem}</td>
					                    <td style="width:50%;">${itemSupport.itemName}</td>
					                    <td style="width:5%;" class="_center">${itemSupport.support}</td>
					                </tr>
							    </c:forEach>
						    </tbody>
					    </table>
				    </div>
				</div>
			</c:if>
			<c:if test="${!empty associationRuleList}">
				<div class="card">
				    <div class="card-header">
				        <div class="card-title">
				            <h2>Association Rules (${associationRuleList.size()} hasil)</h2>
				        </div>
				    </div>
				    <div class="card-body">
				    	<table>
						    <thead>
						        <tr>
						            <th>Rules</th>
						            <th>Support (%)</th>
						            <th>Confidence (%)</th>
						            <th>Support * Confidence (%)</th>
						        </tr>
						    </thead>
						    <tbody>
							    <c:forEach var="rule" items="${associationRuleList}">
							    	<tr>
					                    <td style="width:70%;">${rule.rules}</td>
					                    <td style="width:10%;" class="_center">${rule.support}</td>
					                    <td style="width:10%;" class="_center">${rule.confidence}</td>
					                    <td style="width:10%;" class="_center">${rule.suppTimesConfidence}</td>
					                </tr>
							    </c:forEach>
						    </tbody>
					    </table>
				    </div>
				</div>
			</c:if>
		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>

<script type="text/javascript">
    $("#link-apriori").addClass("active");
</script>