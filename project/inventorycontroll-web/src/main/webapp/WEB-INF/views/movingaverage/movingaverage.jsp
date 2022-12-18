<tiles:insertDefinition name="layouts">
    <tiles:putAttribute name="body">
		<h1><i class="fa fa-cog fa-spin"></i> Proses Moving Average</h1>
		<form:form action="${pageContext.request.contextPath}/movingaverage/decission" modelAttribute="movingAverageForm">
			<div class="card">
			    <div class="card-body">
			    	<div class="card-form">
			            <div class="card-label _40">Periode Terakhir </div>
			            <div class="form-control _60">
			                : <input type="text" name="lastPeriod" value="${movingAverageForm.lastPeriod}" class="disabled" />
			            </div>
			        </div>
			        <div class="card-form">
			            <div class="card-label _40">Jumlah Periode Pendukung (Bulan) </div>
			            <div class="form-control _60">
			                : <input type="number" name="timeFrame" min="1" max="12" required value="${movingAverageForm.timeFrame}"/>
			            </div>
			        </div>
			        <div class="card-form">
			            <div class="card-label _40">Jumlah Periode Diprediksi (Bulan) </div>
			            <div class="form-control _60">
			                : <input type="number" name="predictedMonth" min="1" max="12" required value="${movingAverageForm.predictedMonth}"/>
			            </div>
			        </div>
			        <div class="card-form">
			            <div class="card-label _40">Bidang </div>
			            <div class="form-control _60">
			                : <select name="organizationId">
                                <c:forEach var="organization" items="${organizationList}">
                                	<option value="${organization.organizationId}" ${organization.organizationId eq movingAverageForm.organizationId ? 'selected' : ''}>${organization.organizationName}</option>
                                </c:forEach>
                            </select>
			            </div>
			        </div>
			        <div class="card-form">
			            <div class="card-label _30"></div>
			            <div class="card-label _70">
			                <div style="flex">
			                    <input type="submit" class="btn btn-success" name="load" value="Lihat Data"/>
			                    <input type="submit" class="btn btn-info" name="calculate" value="Proses Moving Average">
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
			
			<c:if test="${!empty movingAverageList}">
				<div class="card">
				    <div class="card-header">
				        <div class="card-title">
				            <h2>Hasil Prediksi Barang Berdasarkan Bidang</h2>
				        </div>
				    </div>
				    <div class="card-body">
				        <table>
						    <thead>
						        <tr>
						            <th rowspan="2">Periode</th>
						            <th rowspan="2">Bidang</th>
						            <th rowspan="2">Nama Barang</th>
						            <th rowspan="2">Satuan</th>
						            <th colspan="2">Prediksi ${movingAverageForm.predictedMonth} Bulan Selanjutnya</th>
						        </tr>
						        <tr style="background-color: unset">
						            <th>Bulan Pendukung</th>
						            <th>Jumlah</th>
						        </tr>
						    </thead>
						    <tbody>
							    <c:forEach var="movingAverage" items="${movingAverageList}">
							    	<tr onclick="toggle(${movingAverage.movingAverageId})">
					                    <td style="width:10%;" class="_center">${movingAverage.period}</td>
					                    <td style="width:20%;">${movingAverage.organization}</td>
					                    <td style="width:40%;">${movingAverage.itemName}</td>
					                    <td style="width:10%;">${movingAverage.unit}</td>
					                    <td style="width:10%;">${movingAverage.NMonth} Bulan</td>
					                    <td style="width:10%;" class="_center">${movingAverage.forecast}</td>
					                </tr>
					                <tr id="${movingAverage.movingAverageId}" style="display:none">
					                	<td colspan="6">
						                	<table style="width: 80%;" align="center">
						                		<tr>
						                			<th>Periode</th>
										            <th>Jumlah</th>
										            <th>Average</th>
										            <th>Error</th>
										            <th>|Error|</th>
										            <th>Error<span>&#178;</span></th>
										            <th>|%Error|</th>
						                		</tr>
						                		<c:forEach var="detail" items="${movingAverage.movingAverageDetailList}">
						                			<tr>
							                			<td class="_center">${detail.period}</td>
							                			<td class="_center">${detail.quantity}</td>
							                			<td class="_center">${detail.forecast}</td>
							                			<td class="_center">${detail.error}</td>
							                			<td class="_center">${detail.errorAbsolute}</td>
							                			<td class="_center">${detail.errorSquared}</td>
							                			<td class="_center">${detail.errorPercentage}%</td>
							                		</tr>
						                		</c:forEach>
						                		<tr>
						                			<td colspan="4" class="_right">Total</td>
						                			<td class="_center">${movingAverage.mae}</td>
						                			<td class="_center">${movingAverage.mse}</td>
						                			<td class="_center">${movingAverage.mape}%</td>
						                		</tr>
						                	</table>
					                	</td>
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
    $("#link-movingaverage").addClass("active");
    
    function toggle(id) {
    	var x = document.getElementById(id);
		if (x.style.display === "none") {
			x.style.display = "";
		} else {
			x.style.display = "none";
		}
    }
</script>