$(document).ready.(function () {
    alert("loaded");
    $.ajax({
        url: '/api/products/all',
        type: 'get',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        success: function (product) {
            for (let i = 0; i < product.length; i++) {
                $("forAdd").before("<tr>" +
                    "<td>" + product[i].id + "</td>" +
                    "<td>" + product[i].name + "</td>" +
                    "<td>" + product[i].price + "</td>" +
                    "<td>" + product[i].amount + "</td>" +
                    "<td>" +
                    "<a class=\"btn btn-info\" onclick=''>Edit</a>" +
                    "<a class=\"btn btn-danger\" href=\"/products/deleteProduct?id=" + product[i].id + "\">Delete</a>" +
                    "</td>" +
                    "</tr>")
            }
        },
        error: function (response) {
            alert('error');
            console.log(response);
        }
    })


