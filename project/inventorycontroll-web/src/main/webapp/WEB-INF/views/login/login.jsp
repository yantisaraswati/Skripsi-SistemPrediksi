<div id="card">
    <div id="card-content">
        <div id="card-title">
            <h2>Login</h2>
            <div class="underline-title"></div>
        </div>
        <form method="post" enctype="multipart/form-data" asp-controller="Home" asp-action="Login" class="form">
            <label for="user-username" style="padding-top:13px">
                &nbsp;Username
            </label>
            <input class="form-content" autocomplete="on" asp-for="Id" required />
            <div class="form-border"></div>
            <label for="user-password" style="padding-top:22px">
                &nbsp;Password
            </label>
            <input class="form-content" type="password" asp-for="Password" required />
            <div class="form-border"></div>
            <input id="submit-btn" type="submit" name="submit" value="LOGIN" />
        </form>
    </div>
</div>