<tiles:insertDefinition name="layouts">
    <tiles:putAttribute name="body">
		<h1><i class="fa fa-cog fa-spin"></i> Proses Apriori</h1>
		<form:form action="${pageContext.request.contextPath}/apriori/decission" modelAttribute="aprioriForm">
			<div class="card">
			    <div class="card-body">
			        <div class="card-form">
			            <div class="card-label _20">Min Support </div>
			            <div class="form-control _80">
			                : <input type="number" name="minSupport" min="1" max="100" required value="${aprioriForm.minSupport}"/>%
			            </div>
			        </div>
			        <div class="card-form">
			            <div class="card-label _20">Min Confidence </div>
			            <div class="form-control _80">
			                : <input type="number" name="minConfidence" min="1" max="100" required value="${aprioriForm.minConfidence}"/>%
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
		</form:form>
	</tiles:putAttribute>
</tiles:insertDefinition>

<script type="text/javascript">
    $("#link-apriori").addClass("active");
</script>