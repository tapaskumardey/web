var express = require("express");
//initilize express constructor
var app = express();
 
//port configuration
var port = process.env.PORT || 8000;

//Allow acces-controll 'cross origin support'
app.use(function(req, res, next) {
  res.header("Access-Control-Allow-Origin", "*");
  res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
  next();
});
 
//require OrderService File
require('./service/OrderService.js')(app);
 
app.listen(port);
console.log("OrderService listening on port " + port);