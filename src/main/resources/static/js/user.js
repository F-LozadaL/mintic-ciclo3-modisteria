const login = (id) => {
    let response = await fetch('/api/movie/' + key);
    localStorage.setItem("loggedUserId",id);
}
 const checkLoggeduser = () => {

 }