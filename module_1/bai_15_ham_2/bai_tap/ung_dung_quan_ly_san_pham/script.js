let listProduct = ["Iphone", "Samsung", "Oppo", "ViVo"];
display(listProduct);

function display(list) {
    let table = "<table>" +
        "        <tr>" +
        "            <td></td>" +
        "            <td><h4>Product Name</h4></td>" +
        "            <td colspan='2'><h4>Update</h4></td>" +
        "        </tr>";
    for (let i = 0; i < list.length; i++) {
        table += "<tr>" +
                "<td>" + (i+1) + "</td>" +
                "<td>" + list[i] + "</td>" +
                "<td><input id='update' onclick='editProduct(" + i + ")' type='submit' value='Edit'/></td>" +
                "<td><input id='update' onclick='deleteProduct(" + i + ")' type='submit' value='Delete'/></td>" +
            "</tr>";
    }
    table += "<table>";
    document.getElementById("showTable").innerHTML = table;
    document.getElementById("quantity").innerHTML = "&nbsp&nbsp" + list.length + " products";
}

function addProduct(list) {
    let add = document.getElementById("inputAdd").value;
    if (add != "") {
        list.push(add);
    } else {
        alert("Please enter a product!");
    }
    document.getElementById("inputAdd").value = "";
    display(listProduct)
}

function editProduct(index) {
    let newProduct = prompt("Please enter a new name");
    if (newProduct != "" && newProduct != null) {
        listProduct[index] = newProduct;
    }
    display(listProduct);
}

function deleteProduct(index) {
    let confirmDelete = confirm("Do you want to delete this product?");
    if (confirmDelete) {
        listProduct.splice(index,1);
    }
    display(listProduct);
}