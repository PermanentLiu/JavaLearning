var mysql  = require('mysql');  
var http = require('http');
var url = require('url');
var util = require('util');
 
var connection = mysql.createConnection({     
	host     : '111.230.56.68',       
	  user     : '1',              
	  password : 'Liu101517',       
	  port: '3306',                   
	  database: '1', 
	}); 
	
connection.connect();
 

http.createServer(function(req, res){
	
	res.writeHead(200, {'Content-Type': 'application/json'});
 
	var  sql = 'SELECT * FROM websites';
	//查
 
	
	connection.query(sql,function (err, result) {
		if(err){
			console.log('[SELECT ERROR] - ',err.message);
			return;
		}
		console.log(result);
		//res.json({result});
		res.end(JSON.stringify(result));

	});
	   

}).listen(11111);


