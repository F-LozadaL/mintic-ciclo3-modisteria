
const addToCart = async (productoid) => {
    let userInfo = localStorage.getItem("loggedUser");
    if (userInfo == undefined) {
        userInfo = new Map();
    } else {
        userInfo = new Map(Object.entries(JSON.parse(userInfo)));
    }
    carro = userInfo.get('carro');


    const body = {
        "mode": "add",
        "idcliente": userInfo.get('clienteid'),
        "idproducto": productoid
    };
    console.log(productoid);
    if (productoid in carro) {
        carro[productoid] += 1;
    } else {
        carro[productoid] = 1;
    }


    userInfo.set('carro', carro);

    localStorage.setItem("loggedUser", JSON.stringify(Object.fromEntries(userInfo)));
    updateCart();
    carroDBCrud(body);    
}

const formatter = new Intl.NumberFormat('en-US');

const loadCartDetails = () => {

    console.log("metodo loadcartdetails");

    let items = localStorage.getItem("loggedUser");
    if (items == undefined) {
        console.log("no usuario");
        return;
    }

    const totalElem = document.getElementById("total");
    let total = 0;
    let detail = document.getElementById("detail");
    detail.innerText = "";
    items = new Map(Object.entries(JSON.parse(items))).get('carro');


    Object.entries(items)
        .forEach(async ([id, quantity]) => {

            let response = await fetch('/carro/' + id);
            let producto = await response.json();

            const totalPrice = producto.precio * quantity;
            total += totalPrice;

            let item2 = [
                `<tr id="producto-${producto.id}">`,
                `   <td class="align-middle"><img src=${producto.imageUrl} alt="" style="width: 50px;"> ${producto.nombre}</td>`,
                `   <td class="align-middle" id="price-${id}">${formatter.format(parseFloat(producto.precio))}</td>`,
                `   <td class="align-middle">`,
                `   <div class="input-group quantity mx-auto" style="width: 100px;">`,
                `       <div class="input-group-btn">`,
                `           <button class="btn btn-sm btn-primary btn-minus" onclick="updateInputNumber(${id},-1)" >`,
                `               <i class="fa fa-minus"></i>`,
                `           </button>`,
                `       </div>`,
                `       <input type="number" id="input-${id}" value="${quantity}" min="1" class="form-control form-control-sm bg-secondary text-center" onchange="updateTotalItem('${id}')">`,
                `       <div class="input-group-btn">`,
                `           <button class="btn btn-sm btn-primary btn-plus" onclick="updateInputNumber(${id},1)">`,
                `               <i class="fa fa-plus"></i>`,
                `           </button>`,
                `       </div>`,
                `   </div>`,
                `</td>`,
                `<td class="align-middle" id="total-${id}">${formatter.format(parseFloat(totalPrice))}</td>`,
                `<td class="align-middle"><button onclick="removeItem('${id}')" class="btn btn-sm btn-primary"><i class="fa fa-times"></i></button></td>`,
                ` </tr>`
            ].join('\n')

            detail.innerHTML = detail.innerHTML + item2;
            totalElem.innerText = formatter.format(total);
        });
};

const updateTotalItem = (key) => {

    const totalElem = document.getElementById("total");//
    let totalItemElem = document.getElementById("total-" + key);//

    let quantity = parseIntlNumber(document.getElementById("input-" + key).value, 'en-US');
    let price = parseIntlNumber(document.getElementById("price-" + key).innerText, 'en-US');
    let total = parseIntlNumber(totalElem.innerText, 'en-US');
    let totalItem = parseIntlNumber(totalItemElem.innerText, 'en-US');


    totalItemElem.innerText = formatter.format(quantity * price);

    total += quantity * price - totalItem;

    totalElem.innerText = formatter.format(total);
};

const parseIntlNumber = (stringNumber, locale) => {
    var thousandSeparator = Intl.NumberFormat(locale).format(11111).replace(/\p{Number}/gu, '');
    var decimalSeparator = Intl.NumberFormat(locale).format(1.1).replace(/\p{Number}/gu, '');

    return parseInt(stringNumber
        .replace(new RegExp('\\' + thousandSeparator, 'g'), '')
        .replace(new RegExp('\\' + decimalSeparator), '.')
    );
};

const removeItem = (idproducto) => {
    let userInfo = localStorage.getItem("loggedUser");
    userInfo = new Map(Object.entries(JSON.parse(userInfo)));

    carro = userInfo.get('carro');
    delete carro[idproducto];
    userInfo.set('carro', carro);
    localStorage.setItem("loggedUser", JSON.stringify(Object.fromEntries(userInfo)));

    const totalItemValue = parseIntlNumber(document.getElementById("total-" + idproducto).innerText, 'en-US');
    console.log(totalItemValue);
    const totalElem = document.getElementById("total");

    totalElem.innerText = formatter.format(parseIntlNumber(totalElem.innerText, 'en-US') - totalItemValue);

    const movieElm = document.getElementById("producto-" + idproducto);
    movieElm.remove();

    const body = {
        "mode": "delete",
        "idcliente": userInfo.get('clienteid'),
        "idproducto": idproducto
    };

    carroDBCrud(body);
}


const updateInputNumber = (idproducto, change) => {
    input = document.getElementById('input-' + idproducto);
    var value = parseInt(input.value, 10);
    value = isNaN(value) ? 0 : value;
    value += change;
    if (0 < value) {
        
        let userInfo = localStorage.getItem("loggedUser");
        userInfo = new Map(Object.entries(JSON.parse(userInfo)));

        let carro = userInfo.get('carro');
        carro[idproducto] += change;

        const body = {
            "idcliente": userInfo.get('clienteid'),
            "idproducto": idproducto
        };
        console.log("idcliente",body["idcliente"]);
        console.log("idproducto",body["idproducto"]);

        if(change==1){
            body["mode"]="add";
        }else{
            body["mode"]="remove";
        }


        userInfo.set('carro', carro);
        localStorage.setItem('loggedUser', JSON.stringify(Object.fromEntries(userInfo)));


        document.getElementById('input-' + idproducto).value = value;
        var event = new Event('change');
        input.dispatchEvent(event);

        carroDBCrud(body);
    }
}

const carroDBCrud = async (bodyObject)=> {
    const url = '/carro';
    const response = await fetch(url, {
        method: "POST",
        body: JSON.stringify(bodyObject),
        headers: {
            "Content-Type": "application/json"
        }
    });
}
