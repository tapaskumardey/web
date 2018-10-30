var express = require("express");
var appRoutes = express.Router();
var Order = require('./Order');

module.exports = function(app){
	//console.log("OrderService init");
	var orderList = [];
	var order1 = new Order();
    order1.OrderID = 2000;
	order1.UserID = '1000';
	order1.TotalPrice = 1000.89;
    orderList.push(order1);
	var order2 = new Order();
    order2.OrderID = 2001;
	order2.UserID = '1001';
	order2.TotalPrice = 350.50;
    orderList.push(order2);
	
	
	//Main Route Sample
	app.get('/', function (req, res) {
		res.send('Hello Microservice API !');
	});

	//Microservice API root /
	appRoutes.get('/:orderID', function(req, res) {
		var order = null;
		for(var i = 0; i < orderList.length; ++i) {
			if(orderList[i].OrderID == req.params.orderID){
				order = orderList[i];
			}
		}
		if(order != null){
			res.json(order);
		}else{
			res.status(422).send('Order not found.');
		}
	 });

	//Microservice Sample Method
	appRoutes.get('/dosomething', function(req, res) {
		res.json({
			message: 'Already Done !'
		});
	});
	 
	//Apply and use created appRoutes
	app.use('/orders', appRoutes);
};


