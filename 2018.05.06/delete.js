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
    res.end();
	
	var delSql = 'DELETE FROM websites WHERE id = ?';
	var delSqlParams = [params.name];
	//改
	connection.query(delSql,delSqlParams,function (err, result) {
	   if(err){
			 console.log('[DELETE ERROR] - ',err.message);
			 return;
	   }        
	  console.log('--------------------------DELETE----------------------------');
	  console.log('DELETE affectedRows',result.affectedRows);
	  console.log('-----------------------------------------------------------------\n\n');
	});
  
}).listen(11114);

console.log("start delete!")