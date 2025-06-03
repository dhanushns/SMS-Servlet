<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SMS-Admin Login</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<div class="login-model">
		<h2>SMS Admin Login</h2>
		<div class="model-body">
			<form id="loginForm" action="login" method="post">
				<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
				<% if (errorMessage != null) { %>
				<div id="error" class="group err-grp">
					<p><%= errorMessage %></p>
				</div>
				<% } %>

				<div class="group g1">
					<label for="username">Username</label> <input type="text"
						name="username" required placeholder="username" />
				</div>
				<div class="group g2">
					<label for="password">Password</label> <input type="password"
						name="password" required placeholder="password" />
				</div>
				<div class="group g3">
					<button type="submit">Login</button>
				</div>
			</form>
		</div>
	</div>
	<script src="script.js"></script>
</body>
</html>