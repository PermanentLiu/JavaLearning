var http = require('http');
var url = require('url');
var util = require('util');
var mysql  = require('mysql');  

var connection = mysql.createConnection({     
  host     : '111.230.56.68',       
  user     : '1',              
  password : 'Liu101517',       
  port: '3306',                   
  database: '1', 
}); 

connection.connect();

http.createServer(function(req, res){
	res.writeHead(200, {'Content-Type': 'text/plain'});
  
	 // 解析 url 参数
    var params = url.parse(req.url, true).query;
    res.write("name：" + params.name);
	res.write("\n");
	res.write("score: " + params.score); 
    res.end();
	
	var modSql = 'UPDATE user SET score = ? WHERE name = ?';
	var modSqlParams = [params.score, params.name];
	//改
	connection.query(modSql,modSqlParams,function (err, result) {
	   if(err){
			 console.log('[UPDATE ERROR] - ',err.message);
			 return;
	   }        
	  console.log('--------------------------UPDATE----------------------------');
	  console.log('UPDATE affectedRows',result.affectedRows);
	  console.log('-----------------------------------------------------------------\n\n');
	});
  
}).listen(11113);