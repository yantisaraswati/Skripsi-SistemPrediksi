<div id="card">
    <div id="card-content">
        <div id="card-title">
            <h2>Login</h2>
            <div class="underline-title"></div>
            <h6 style="color: #f00">${userMessage}</h6>
        </div>
        <form:form action="${pageContext.request.contextPath}/login/authchecking" method="post" class="form" modelAttribute="loginForm">
            <label for="user-username" style="padding-top:13px">
                &nbsp;Username
            </label>
            <input class="form-content" autocomplete="on" name="username" required />
            <div class="form-border"></div>
            <label for="user-password" style="padding-top:22px">
                &nbsp;Password
            </label>
            <input class="form-content" type="password" name="password" required />
            <div class="form-border"></div>
            <input id="submit-btn" type="submit" name="submit" value="LOGIN" />
        </form:form>
    </div>
</div>