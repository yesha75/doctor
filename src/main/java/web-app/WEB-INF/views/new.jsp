<HTML lang="en" xmlns:th="http://www.thymeleaf.org">

<HEAd>
<link rel="stylesheet" href="style.css"th:href:"@{/css/style.css}">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<style>
/* Importing fonts from Google */
@import
	url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap')
	;

/* Reseting */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}

body {
	min-height: 100vh;
	position: relative;
	margin: 0;
	padding-bottom: 100px;
}

footer {
	position: absolute;
	bottom: 0;
	height: 80px;
	width: 100%;
}

.wrapper {
	max-width: 350px;
	min-height: 500px;
	margin: 80px auto;
	padding: 40px 30px 30px 30px;
	background-color: #ecf0f3;
	border-radius: 15px;
	box-shadow: 13px 13px 20px #cbced1, -13px -13px 20px #fff;
}

.wrapper .name {
	font-weight: 600;
	font-size: 1.4rem;
	letter-spacing: 1.3px;
	padding-left: 10px;
	color: #555;
}

.wrapper .form-field input {
	width: 100%;
	display: block;
	border: none;
	outline: none;
	background: none;
	font-size: 1.2rem;
	color: #666;
	padding: 10px 15px 10px 10px;
	/* border: 1px solid red; */
}

.wrapper .form-field {
	padding-left: 10px;
	margin-bottom: 20px;
	border-radius: 20px;
	box-shadow: inset 8px 8px 8px #cbced1, inset -8px -8px 8px #fff;
}

.wrapper .form-field .fas {
	color: #555;
}

.wrapper .btn {
	box-shadow: none;
	width: 100%;
	height: 40px;
	background-color: #03A9F4;
	color: #fff;
	border-radius: 25px;
	box-shadow: 3px 3px 3px #b1b1b1, -3px -3px 3px #fff;
	letter-spacing: 1.3px;
}

.wrapper .btn:hover {
	background-color: #039BE5;
}

.wrapper a {
	text-decoration: none;
	font-size: 0.8rem;
	color: #03A9F4;
}

.wrapper a:hover {
	color: #039BE5;
}

@media ( max-width : 380px) {
	.wrapper {
		margin: 30px 20px;
		padding: 40px 15px 15px 15px;
	}
}
</style>
</HEAd>
<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light static-top">
		<div class="container">
			<a class="navbar-brand" href="index.html"> <img
				src="hospital.jpg" alt="..." height="50">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link" href="index.html">Home</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="about.html">About
							Us</a></li>
					<li class="nav-item"><a class="nav-link" href="contact.html">Contact
							Us</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Services </a>
						<ul class="dropdown-menu dropdown-menu-end"
							aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="login.html">Patient
									Database</a></li>
							<li><a class="dropdown-item active" aria-current="page"
								href="doc.html">National Database</a></li>
							<li>
								<hr class="dropdown-divider">
							</li>
							<li><a class="dropdown-item" href="emer.html">Emergency
									Locator</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="wrapper mt-">

		<div class="text-center mt-5 name">MediLink</div>
		<form class="p-3 mt-3">
			<div class="form-field d-flex align-items-center">
				<span class="far fa-user"></span> <input type="text" name="userName"
					id="userName" placeholder="Doctor Name">
			</div>
			<div class="form-field d-flex align-items-center">
				<span class="fas fa-key"></span> <input type="password"
					name="password" id="pwd" placeholder="Password">
			</div>
			<button class="btn mt-3">Login</button>
		</form>
		<div class="text-center fs-6">
			<a href="signup.html">Sign up</a>
		</div>
	</div>
	<footer class="bg-dark text-white py-4 mb-0">
		<div class="container px-5">
			<div
				class="row align-items-center justify-content-between flex-column flex-sm-row">
				<div class="col-auto">
					<div class="small m-0">Copyright &copy; MediLink 2023</div>
				</div>
				<div class="col-auto">
					<a class="small" href="#!">Privacy</a> <span class="mx-1">&middot;</span>
					<a class="small" href="#!">Terms</a> <span class="mx-1">&middot;</span>
					<a class="small" href="#!">Contact</a>
				</div>
			</div>
		</div>
	</footer>

</body>

</HTML>