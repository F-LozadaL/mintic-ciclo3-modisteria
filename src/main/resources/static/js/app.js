const loadUserConfig = () => {
    const loginLi = document.getElementById("loginbtn");
    const logoutLi = document.getElementById("logoutbtn");

    const user = localStorage.getItem("loggedUser");
    if (user == undefined) {
        loginLi.style.display = 'block';
        logoutLi.style.display = 'none';
    } else {
        loginLi.style.display = 'none';
        logoutLi.style.display = 'block';

    }
};

loadUserConfig();

const logout = () => {
    localStorage.removeItem("loggedUser");

    loadUserConfig();
};

const updateCart = () => {
    let userInfo = localStorage.getItem("loggedUser");
    
    if (userInfo == undefined) {
        items = new Map();
    } else {
        items = new Map(Object.entries(JSON.parse(userInfo)));
    }
    
    
    carro=items.get('carro');
    const cartBadge = document.getElementById("cart-count");
    let total = 0;

    for (const [key, value] of Object.entries(carro)) {
        total+=value;
    }
    
    cartBadge.innerText = total;
}

updateCart();