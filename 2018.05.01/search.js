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

var colID = "score"

var desc = function(x, y){
	return (x[colID] < y[colID]) ? 1 : -1
}

connection.connect();
 

http.createServer(function(req, res){
	
	res.writeHead(200, {'Content-Type': 'application/json'});
 
	var  sql = 'SELECT * FROM user';
	//查
 
	
	connection.query(sql,function (err, result) {
		if(err){
			console.log('[SELECT ERROR] - ',err.message);
			return;
		}
		//console.log(result);
		//res.json({result});
		
		result.sort(desc);
		
		res.end(JSON.stringify(result));
		console.log(result);
		

	});
	   

}).listen(11112);


