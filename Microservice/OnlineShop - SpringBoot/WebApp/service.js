$(document).ready(function() {
    $.ajax({
        url: "http://localhost:7172/orders"
    }).then(function(data, status, jqxhr) {
		var combo = document.getElementById("orderIDs");
		$.each(data, function( key, value ) {
		var option = document.createElement("option");
		option.text = value.orderID;
		option.value = value.orderID;
		try {
			combo.add(option, null);
		}
		catch (error) {
			combo.add(option);
		}
		});
    });
});

function changeOrderID(){
	var selectedValue = document.getElementById("orderIDs").value;
	//document.getElementById("custDetails").style.display = "block";
	if(selectedValue != ''){
		//alert(selectedValue);
		$.ajax({
			url: "http://localhost:7172/orders/"+selectedValue
		}).then(function(data, status, jqxhr) {
			//alert(data.user.firstName);
			document.getElementById("orderID").value = data.orderID;
			document.getElementById("firstName").value = data.user.firstName + ' ' +data.user.lastName;
			document.getElementById("phoneNumber").value = data.user.phoneNumber;
			document.getElementById("address").value = data.user.address;
			document.getElementById("totalPrice").value = data.totalPrice;
		});
	}else{
		//document.getElementById("custDetails").style.display = "none";
		document.getElementById("orderID").value = '-';
		document.getElementById("firstName").value = '-';
		document.getElementById("phoneNumber").value = '-';
		document.getElementById("address").value = '-';
		document.getElementById("totalPrice").value = '-';
	}
}

