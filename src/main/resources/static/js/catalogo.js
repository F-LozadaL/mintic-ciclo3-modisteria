const form = document.querySelector('#filtros');

form.addEventListener('submit', e => {
    e.preventDefault();
    e.currentTarget.submit();
});

const loadProductByFilter = () => {

    console.log("boton funciona");
}

const filtros = async (filtros) => {
    const url = "/api/catalogo/filter";
    const response = await fetch(url, {
        method: "POST",
        body: JSON.stringify(filtros),
        headers: {
            "Content-Type": "application/json"
        }
    });

    if (filtros.ok) {

    }


}