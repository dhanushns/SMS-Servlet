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
