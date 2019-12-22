$(function() {
    $.ajax({
        url: '/api/products/all',
        type: 'get',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (product) {
            for (let i = 0; i < product.length; i++) {
                $("#forAdd").before("<tr>" +
                    "<td>" + product[i].id + "</td>" +
                    "<td>" + product[i].name + "</td>" +
                    "<td>" + product[i].price + "</td>" +
                    "<td>" + product[i].amount + "</td>" +
                    "<td>" +
                    "<button class=\"btn btn-info\" data-toggle=\"modal\" data-target=\"#edit-modal\" onclick=\"fillModal(" + product[i].id + ")\">Edit</button>" +
                    "<a class=\"btn btn-danger\" href=\"/products/deleteProduct?id=" + product[i].id + "\">Delete</a>" +
                    "</td>" +
                    "</tr>")
            }
        },
        error: function (response) {
            alert('error');
            console.log(response);
        }
    });
});

function fillModal(id) {
    alert(id);
    $.ajax({
        method: "get",
        url: "/api/products/get?id=" + id,
        contentType: "application/json; charset=utf-8",
        success: function (product) {
            $("#i-id").val(product.id);
            $("#i-name").val(product.name);
            $("#i-price").val(product.price);
            $("#i-amount").val(product.amount);
        }
    })
}

function addProducts() {
    var name = $('#name-input').val();
    var price = $('#price-input').val();
    var amount = $('#amount-input').val();

    var newProduct = {
        'name' : name,
        'price' : price,
        'amount' : amount,
    }
    $.ajax({
        method: 'post',
        url: "/api/products/add",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(newProduct),
        success: function () {
        window.location.replace("/products/all")
        },
        error: function (error) {
            alert("error");
        }
    });
}


