// async function login(event) {
//   event.preventDefault();
//   const form = document.getElementById("loginForm");
//   const formData = new FormData(form);
//   const urlEncodedData = new URLSearchParams(formData);

//   const response = await fetch("/SMS/login", {
//     method: "POST",
// 	"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8",
//     body: urlEncodedData
//   });

//   const res = await response.text();
//   console.log(res);
//   if(!res){
// 	document.getElementById("error").classList.toggle("active");
// 	setTimeout(()=>{
// 		document.getElementById("error").classList.toggle("active");
// 	},3000);
//   }
// }

function updateStudent(event) {
	window.location.href = "./UpdateStudent.jsp?id=" + event.target.id;
}

async function deleteStudent(event) {

	const formData = new FormData();
	formData.append("id", event.target.id);
	const urlEncodedData = new URLSearchParams(formData);
	await fetch("/SMS/deleteStudent", {
		method: "POST",
		"Content-Type": "application/x-www-form-urlencoded;charset=UTF-8",
		body: urlEncodedData
	});
	alert("Student Deleted Successfully!");
	window.location.href = "./dashboard.jsp";
}

